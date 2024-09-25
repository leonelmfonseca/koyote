package com.koyote.gather.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class BoomarkingModel extends GatherModel{
    private String name;
}
