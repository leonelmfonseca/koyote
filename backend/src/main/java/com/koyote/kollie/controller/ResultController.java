package com.koyote.kollie.controller;

import com.koyote.kollie.model.KollieModel;
import com.koyote.kollie.service.KollieServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
public class ResultController {


    private final KollieServiceManager KollieServiceManager;
    @Autowired
    public ResultController( KollieServiceManager KollieServiceManager) {
        this.KollieServiceManager = KollieServiceManager;
    }

    @GetMapping("/results")
    List<String> search(@RequestParam String search) throws GeneralSecurityException, IOException {
        List<KollieModel> results = KollieServiceManager.KollieDataFromEnabledServices(search);
        return results.stream().map(String::valueOf).toList();
    }
}
