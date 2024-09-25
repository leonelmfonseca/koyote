package com.koyote.gather.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class EmailModel extends GatherModel {
    private String sender;
    private String recipient;
    private String subject;
    private String body;
}
