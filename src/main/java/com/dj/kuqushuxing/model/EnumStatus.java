package com.dj.kuqushuxing.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum EnumStatus {
    JINYONG(0,"禁用"),QIYONG(1,"启用"),QUANBU(null,"全部");
    @Getter
    private Integer value;
    @Getter
    private String label;
public static String getValue(Integer value){
    for (EnumStatus enumStatus : EnumStatus.values()){
        if (enumStatus.getValue() == value){
            return enumStatus.getLabel();
        }
    }
    return null;
}
}
