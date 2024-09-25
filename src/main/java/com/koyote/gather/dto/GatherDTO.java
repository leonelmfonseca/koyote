package com.koyote.gather.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class GatherDTO {
    private Long id;
    private List<String> descriptions = new ArrayList<>();

    public GatherDTO(Long id) {
        this.id = id;
    }
}
