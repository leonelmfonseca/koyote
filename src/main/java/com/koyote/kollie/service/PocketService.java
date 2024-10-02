package com.koyote.kollie.service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.koyote.kollie.model.PocketModel;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PocketService extends BookmarkingService {

    public static final String SERVICES_BOOKMARKING_POCKET = "services.bookmarking.pocket";

    public PocketService(Properties props) {
        super.enabled = Boolean.parseBoolean(props.getProperty(SERVICES_BOOKMARKING_POCKET, "false"));
    }


    @Override
    public Credential getCredentials(NetHttpTransport HTTP_TRANSPORT) throws IOException {
        return null;
    }

    @Override
    public List getBookmarks() throws GeneralSecurityException, IOException {
        return List.of();
    }

    @Override
    public List<PocketModel> fetchData(String search){
        return new ArrayList<PocketModel>() {{
            add(new PocketModel());
        }};

    }

    // Other bookmarking-specific methods (e.g., save bookmarks, get bookmarks)
}
