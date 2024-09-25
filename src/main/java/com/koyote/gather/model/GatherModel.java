package com.koyote.gather.model;

import lombok.Data;

import java.util.List;

@Data
public class GatherModel {
    private String id;
    private String threadId;
    private List<String> descriptions;
}
