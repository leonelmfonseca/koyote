package com.koyote.kollie.mapper;

import com.google.api.services.gmail.model.Message;
import com.koyote.kollie.dto.EmailDTO;
import org.mapstruct.Mapper;

@Mapper
public interface EmailMapper{

    EmailDTO map(Message message);
}
