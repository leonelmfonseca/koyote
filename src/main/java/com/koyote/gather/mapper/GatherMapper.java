package com.koyote.gather.mapper;

import com.koyote.gather.model.EmailModel;
import com.koyote.gather.model.GatherModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GatherMapper{
    GatherModel map(EmailModel emailModel);
}
