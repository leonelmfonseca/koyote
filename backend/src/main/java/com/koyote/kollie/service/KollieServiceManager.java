package com.koyote.kollie.service;

import com.koyote.kollie.config.ServicesConfig;
import com.koyote.kollie.model.KollieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class KollieServiceManager {


    private final Map<KollieService<KollieModel>, String> enabledProviders;

    @Autowired
    public KollieServiceManager(ServicesConfig servicesConfig) {
        this.enabledProviders = servicesConfig.getEnabledProviders();
    }


    public List<KollieModel> KollieDataFromEnabledServices(String search) {
        if (search == null || search.isEmpty()) {
            throw new IllegalArgumentException("search is null or empty");
        }

        List<KollieModel> KollieModels = new ArrayList<>();
        for (Map.Entry<KollieService<KollieModel>, String> entry : enabledProviders.entrySet()) {
            KollieService<KollieModel> service = entry.getKey();
            try {
                KollieModels.addAll(service.fetchData(search));
            } catch (GeneralSecurityException | IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return KollieModels;

    }

}