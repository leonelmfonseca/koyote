package com.koyote.gather.service;

import com.google.api.services.gmail.Gmail;
import com.koyote.gather.config.GmailConfig;
import com.koyote.gather.mapper.GmailMapper;
import com.koyote.gather.model.GatherModel;
import com.koyote.gather.model.GmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;

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
        // Use the injected dependencies to create the GatherService instance
        return new GmailService(gmailConfig, gmailMapper);
    }
}
