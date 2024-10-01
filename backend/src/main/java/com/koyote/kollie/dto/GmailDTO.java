package com.koyote.kollie.dto;

import com.google.api.services.gmail.model.MessagePart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GmailDTO {
        private BigInteger historyId;
        private String id;
        private Long internalDate;
        private List<String> labelIds;
        private MessagePart payload;
        private String raw;
        private Integer sizeEstimate;
        private String snippet;
        private String threadId;


}
