package com.koyote.gather.service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;
import com.koyote.gather.config.GmailConfig;
import com.koyote.gather.dto.GmailDTO;
import com.koyote.gather.mapper.GmailMapper;
import com.koyote.gather.model.GmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GmailService extends EmailService<GmailModel>{

    public static final int PORT = 8888;
    /**
     * Application name.
     */
    private static final String APPLICATION_NAME = "Gmail API Java Quickstart";
    /**
     * Global instance of the JSON factory.
     */
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    /**
     *
     *
     * Directory to store authorization tokens for this application.
     */
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */


    private static final List<String> SCOPES = Collections.singletonList(GmailScopes.GMAIL_READONLY);
    private final GmailConfig gmailConfig;
    private final GmailMapper gmailMapper;

    @Autowired
    public GmailService(GmailConfig gmailConfig, GmailMapper gmailMapper) {
        this.gmailConfig = gmailConfig;
        this.gmailMapper = gmailMapper;
    }



    public List<Message> getMessages(String search) throws IOException, GeneralSecurityException {

        Gmail authorizedGmailApiClientService = getAuthorizedGmailApiClientService();
        String user = this.gmailConfig.getMe();

        ListMessagesResponse listResponse = authorizedGmailApiClientService.users().messages().list(user).setQ(search).execute();

        return listResponse.getMessages();
    }

    // TODO: Singleton Pattern(Encapsulate Gmail ?)
    private Gmail getAuthorizedGmailApiClientService() throws GeneralSecurityException, IOException {

        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        HttpRequestInitializer initializer = request -> {
            getCredentials(HTTP_TRANSPORT).initialize(request);
            request.setLoggingEnabled(true);
            request.setResponseInterceptor(response -> System.out.println("Response received with status code: " + response.getStatusCode()));
        };


        return new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, initializer)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    @Override
    public Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.

        GoogleClientSecrets clientSecrets = new GoogleClientSecrets().setInstalled(
                new GoogleClientSecrets.Details()
                        .setClientId(gmailConfig.getClientId())
                        .setClientSecret(gmailConfig.getClientSecret())
                        .setAuthUri(gmailConfig.getAuthUri())
                        .setTokenUri(gmailConfig.getTokenUri())
                        .setRedirectUris(gmailConfig.getRedirectUris()));


        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();

        //
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(PORT).build();

        //returns an authorized Credential object.
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }


    @Override
    public List<GmailModel> getEmails(String search) throws GeneralSecurityException, IOException {

        return this.getGmailData(search);
    }

    @Override
    public List<String> getEmailSubjects(String id) throws GeneralSecurityException, IOException {

        getMessage(id);
        return List.of();
    }

    private List<Message> getMessageSet(List<GmailModel> gmailModels){

        if(gmailModels == null || gmailModels.isEmpty()){
            return Collections.emptyList();
        }

        List<Message> messageSet = new ArrayList<>();

        gmailModels.forEach(
                model-> {
                    try {
                        messageSet.add(getMessage(model.getId()));

                    } catch (GeneralSecurityException | IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

        return messageSet;
    }

    private Message getMessage(String id) throws GeneralSecurityException, IOException {
        Gmail authorizedGmailApiClientService = getAuthorizedGmailApiClientService();
        String user = this.gmailConfig.getMe();
        return authorizedGmailApiClientService.users().messages().get(user, id).execute();
    }

    // TODO: can this migrate to super classes ?
    private List<GmailModel> getGmailData(String search) throws GeneralSecurityException, IOException {

        List<Message> messages = this.getMessages(search);


        return getGmailModels(messages);
    }

    private List<GmailModel> getGmailModels(List<Message> messages) {
        List<GmailDTO> dtoList = messages.stream()
                .map(this.gmailMapper::messageToGmailDTO)
                .toList();


        return dtoList.stream()
                .map(this.gmailMapper::mapDtoToModel)
                .toList();
    }

    @Override
    public List<GmailModel> fetchData(String search) throws GeneralSecurityException, IOException {

        List<GmailModel> emails = this.getEmails(search);

        List<Message> messages = getMessageSet(emails);

        return getGmailModels(messages);

    }
}
