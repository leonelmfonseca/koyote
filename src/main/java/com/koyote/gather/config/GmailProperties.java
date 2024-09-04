package com.koyote.gather.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "gmail")
@Getter
@Setter
@NoArgsConstructor
public class GmailProperties {

    private String clientId;
    private String projectId;
    private String authUri;
    private String tokenUri;
    private String authProviderX509CertUrl;
    private String clientSecret;
    private List<String> redirectUris;
    private String me;
}
