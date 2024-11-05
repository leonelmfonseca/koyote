package com.koyote.kollie.common;


import java.util.HashMap;
import java.util.Map;


public enum ServiceType {

    // Enum constants representing services
    GMAIL("gmail","email", true),
    OUTLOOK("outlook","email", false),
    FACEBOOK("facebook","social-network", false),
    X("x","social-network", false),
    RAINDROP("raindrop","bookmarking", false),
    POCKET("pocket","bookmarking", false);

    private final String category;
    private final boolean enabled;
    private final String name;

    // Constructor for the enum
    ServiceType(String name, String category, boolean enabled) {
        this.category = category;
        this.enabled = enabled;
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getName() {
        return name;
    }

    // Static method to get enabled services
    public static Map<String, String> getEnabledServices() {
        Map<String, String> enabledServices = new HashMap<>();

        for (ServiceType service : ServiceType.values()) {
            if (service.isEnabled()) {
                enabledServices.put(service.getName(), service.getCategory());
            }
        }

        return enabledServices;
    }
}
