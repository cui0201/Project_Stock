package com.dj.kuqushuxing.model;

import lombok.Data;

@Data
public class StatusVo {

    private String label;

    private Integer value;

    public StatusVo(String label,Integer value){
        this.label=label;
        this.value=value;
    }


}
