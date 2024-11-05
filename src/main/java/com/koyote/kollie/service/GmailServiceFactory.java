package com.koyote.kollie.service;

import com.koyote.kollie.config.GmailConfig;
import com.koyote.kollie.mapper.GmailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GmailServiceFactory implements ServiceFactory {
    private final GmailConfig gmailConfig;
    private final GmailMapper gmailMapper;

    @Autowired
    public GmailServiceFactory(GmailConfig gmailConfig, GmailMapper gmailMapper) {
        this.gmailConfig = gmailConfig;
        this.gmailMapper = gmailMapper;
    }

    @Override
    public GmailService createService() {
        // Use the injected dependencies to create the KollieService instance
        return new GmailService(gmailConfig, gmailMapper);
    }
}
