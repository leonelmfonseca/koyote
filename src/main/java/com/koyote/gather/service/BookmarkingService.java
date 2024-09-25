package com.koyote.gather.service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.koyote.gather.model.BoomarkingModel;
import com.koyote.gather.model.EmailModel;
import com.koyote.gather.model.GatherModel;
import com.koyote.gather.model.GmailModel;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public abstract class BookmarkingService<T extends BoomarkingModel> implements GatherService<T>{

    protected boolean enabled;

    public abstract Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException;
    public abstract List<T> getBookmarks() throws GeneralSecurityException, IOException;

    @Override
    public List<T> fetchData(String search) throws GeneralSecurityException, IOException {
        return getBookmarks();
    }
}
