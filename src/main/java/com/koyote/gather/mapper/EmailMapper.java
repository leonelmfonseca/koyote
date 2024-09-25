package com.koyote.gather.mapper;

import com.google.api.services.gmail.model.Message;
import com.koyote.gather.dto.EmailDTO;
import org.mapstruct.Mapper;

@Mapper
public interface EmailMapper{

    EmailDTO map(Message message);
}
