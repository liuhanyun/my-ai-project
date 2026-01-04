package com.use.demo.client.co;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopNoteCO {
    private Integer id;
    private Long corporationId;
    private Long brandId;
    private Long shopId;
    private String noteUid;
    private String previousNoteUid;
    private String ownerNoteUid;
    private String note;
    private String noteType;
    private Boolean isArchived;
    private Boolean isActive;
    private Integer displaySequence;
    private Integer sourceType;
    private Integer createType;
    private String dataId;
    private String subTypes;
    private String appliedChannels;
}
