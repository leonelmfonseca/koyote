package com.koyote.gather.controller;

import com.koyote.gather.client.ApiClient;
import com.koyote.gather.dto.GatherDTO;
import com.koyote.gather.model.GatherModel;
import com.koyote.gather.service.GatherService;
import com.koyote.gather.service.GatherServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
public class ResultController {


    private final GatherServiceManager gatherServiceManager;
    @Autowired
    public ResultController( GatherServiceManager gatherServiceManager) {
        this.gatherServiceManager = gatherServiceManager;
    }

    @GetMapping("/results/")
    List<String> search(@RequestParam String search) throws GeneralSecurityException, IOException {
        List<GatherModel> results = gatherServiceManager.gatherDataFromEnabledServices(search);
        return results.stream().map(String::valueOf).toList();
    }
}
