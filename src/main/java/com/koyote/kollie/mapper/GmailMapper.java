package com.koyote.kollie.mapper;

import com.google.api.services.gmail.model.Message;
import com.koyote.kollie.dto.GmailDTO;
import com.koyote.kollie.model.GmailModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GmailMapper {

    GmailDTO messageToGmailDTO(Message message);

    GmailModel mapDtoToModel(GmailDTO gmailDTO);
}