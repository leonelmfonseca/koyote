package com.koyote.gather.service;

import com.koyote.gather.config.GmailConfig;
import com.koyote.gather.config.ServicesConfig;
import com.koyote.gather.mapper.GmailMapper;
import com.koyote.gather.model.GatherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GatherServiceManager {


    private final Map<GatherService<GatherModel>, String> enabledProviders;

    @Autowired
    public GatherServiceManager(ServicesConfig servicesConfig) {
        this.enabledProviders = servicesConfig.getEnabledProviders();
    }


    public List<GatherModel> gatherDataFromEnabledServices(String search) {
        if (search == null || search.isEmpty()) {
            throw new IllegalArgumentException("search is null or empty");
        }

        List<GatherModel> gatherModels = new ArrayList<>();
        for (Map.Entry<GatherService<GatherModel>, String> entry : enabledProviders.entrySet()) {
            GatherService<GatherModel> service = entry.getKey();
            try {
                gatherModels.addAll(service.fetchData(search));
            } catch (GeneralSecurityException | IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return gatherModels;

    }

}