package com.use.demo.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopNoteCondition {
    private String noteType;
    private String note;
    private Integer page;
    private Integer size;
}
