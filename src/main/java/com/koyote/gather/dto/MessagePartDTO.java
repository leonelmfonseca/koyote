package com.koyote.gather.dto;

import com.google.api.client.util.Key;
import com.google.api.services.gmail.model.MessagePart;
import com.google.api.services.gmail.model.MessagePartBody;
import com.google.api.services.gmail.model.MessagePartHeader;
import lombok.Data;

import java.util.List;

@Data
public class MessagePartDTO {

    private MessagePartBody body;
    private String filename;
    private List<MessagePartHeader> headers;
    private String mimeType;
    private String partId;
    private List<MessagePart> parts;

}
