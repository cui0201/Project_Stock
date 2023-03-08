package com.dj.kuqushuxing.model;

import lombok.Data;

import java.util.Date;

@Data
public class ShuXingVo {
    private Integer id;
    private String code;
    private String name;
    private Boolean status;
    private String statusName;
    private String remark;
    private Date createTime;

    private String createPre;

    private Date  updateTime;

    private String updatePre;
}
