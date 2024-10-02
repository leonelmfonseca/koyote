package com.koyote.kollie.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class KollieDTO {
    private Long id;
    private List<String> descriptions = new ArrayList<>();

    public KollieDTO(Long id) {
        this.id = id;
    }
}
