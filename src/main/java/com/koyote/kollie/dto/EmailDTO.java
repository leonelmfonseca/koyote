package com.koyote.kollie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDTO {
    private String id;
    private String sender;
    private String recipient;
    private String subject;
    private String body;
}
