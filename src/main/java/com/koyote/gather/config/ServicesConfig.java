package com.koyote.gather.config;

import com.google.api.services.gmail.Gmail;
import com.koyote.gather.model.GatherModel;
import com.koyote.gather.service.GatherService;
import com.koyote.gather.common.ServiceType;
import com.koyote.gather.service.GmailServiceFactory;
import com.koyote.gather.service.ServiceFactory;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.koyote.gather.common.ServiceType.GMAIL;

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
    public Map<GatherService<GatherModel>, String> getEnabledProviders() {

        Map<GatherService<GatherModel>, String> gatherServices = new HashMap<>();
        Map<String, String> enabledServices = ServiceType.getEnabledServices();

        enabledServices.forEach(
                (name, category)->{
                    this.serviceFactory = getServiceFactory();
                    if (serviceFactory != null) {
                        gatherServices.put(serviceFactory.createService(), category);
                    }
                }
        );

        return gatherServices;
    }
}