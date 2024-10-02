package com.koyote.kollie.service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.koyote.kollie.model.BoomarkingModel;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public abstract class BookmarkingService<T extends BoomarkingModel> implements KollieService<T>{

    protected boolean enabled;

    public abstract Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException;
    public abstract List<T> getBookmarks() throws GeneralSecurityException, IOException;

    @Override
    public List<T> fetchData(String search) throws GeneralSecurityException, IOException {
        return getBookmarks();
    }
}
