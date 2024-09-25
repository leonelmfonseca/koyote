package com.koyote.gather.service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.koyote.gather.model.EmailModel;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;


public abstract class EmailService<T extends EmailModel> implements GatherService<T> {

    // TODO: isEnabled field goes to superclass, and same for other classes that extends
    //  from GatherServices
    protected boolean isEnabled;
    public abstract Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException;
    public abstract List<T> getEmails(String search) throws GeneralSecurityException, IOException;

    public abstract List<String> getEmailSubjects(String id) throws GeneralSecurityException, IOException;

    @Override
    public List<T> fetchData(String search) throws GeneralSecurityException, IOException {
        return getEmails(search);
    }
}
