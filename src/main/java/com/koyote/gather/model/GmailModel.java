package com.koyote.gather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GmailModel extends EmailModel{

    private String threadId;

    private List<String> labelIds;


    private String snippet;


    private PayloadModel payloadModel;


    private Integer sizeEstimate;


    private String historyId;


    private Long internalDate;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PayloadModel {

        private String partId;

        private String mimeType;

        private String filename;

        private List<HeaderModel> headerModels;

        private BodyModel bodyModel;

        private List<PartModel> partModels;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HeaderModel {

        private String name;

        private String value;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BodyModel {

        private Integer size;

        private String data;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PartModel {

        private String partId;

        private String mimeType;

        private String filename;

        private List<HeaderModel> headerModels;

        private BodyModel bodyModel;

    }
}