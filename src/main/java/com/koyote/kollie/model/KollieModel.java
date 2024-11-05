package com.koyote.kollie.model;

import lombok.Data;

import java.util.List;

@Data
public class KollieModel {
    private String id;
    private String threadId;
    private List<String> descriptions;
}
