package com.dj.kuqushuxing.model;

import lombok.Data;

@Data
public class QueryPageVo {

    private String code;

    private String name;
    private Boolean status;
    private String remark;

    private Integer offSize;

    private Integer pageSize;

    private Integer pageIndex;


}
