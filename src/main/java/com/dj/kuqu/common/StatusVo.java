package com.dj.kuqu.common;

import lombok.Data;

@Data
public class StatusVo {
    private String label;

    //状态值
    private Integer value;

    public StatusVo(String label,Integer value){
        this.label=label;
        this.value=value;
    }
}
