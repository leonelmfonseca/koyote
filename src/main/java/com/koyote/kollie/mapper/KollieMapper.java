package com.koyote.kollie.mapper;

import com.koyote.kollie.model.EmailModel;
import com.koyote.kollie.model.KollieModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KollieMapper{
    KollieModel map(EmailModel emailModel);
}
