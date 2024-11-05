package com.koyote.kollie.config;

import com.koyote.kollie.common.ServiceType;
import com.koyote.kollie.model.KollieModel;
import com.koyote.kollie.model.KollieModel;
import com.koyote.kollie.service.KollieService;
import com.koyote.kollie.service.ServiceFactory;
import com.koyote.kollie.service.KollieService;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Getter
@ConfigurationProperties(prefix = "services")
@Data
@Configuration
public class ServicesConfig {

    ServiceFactory serviceFactory;

    private Map<String, Map<String, Boolean>> services = new HashMap<>();

    @Autowired
    public ServicesConfig(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    // Method to get enabled providers as a Map
    public Map<KollieService<KollieModel>, String> getEnabledProviders() {

        Map<KollieService<KollieModel>, String> KollieServices = new HashMap<>();
        Map<String, String> enabledServices = ServiceType.getEnabledServices();

        enabledServices.forEach(
                (name, category)->{
                    this.serviceFactory = getServiceFactory();
                    if (serviceFactory != null) {
                        KollieServices.put(serviceFactory.createService(), category);
                    }
                }
        );

        return KollieServices;
    }
}