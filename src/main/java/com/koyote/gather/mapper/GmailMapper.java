package com.koyote.gather.mapper;

import com.google.api.services.gmail.model.Message;
import com.google.api.services.gmail.model.MessagePart;
import com.google.api.services.gmail.model.MessagePartHeader;
import com.koyote.gather.dto.GmailDTO;
import com.koyote.gather.dto.MessagePartDTO;
import com.koyote.gather.dto.MessagePartHeaderDTO;
import com.koyote.gather.model.GmailModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GmailMapper {

    GmailDTO messageToGmailDTO(Message message);

    GmailModel mapDtoToModel(GmailDTO gmailDTO);
}