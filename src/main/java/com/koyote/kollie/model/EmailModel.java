package com.koyote.kollie.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class EmailModel extends KollieModel {
    private String sender;
    private String recipient;
    private String subject;
    private String body;
}
