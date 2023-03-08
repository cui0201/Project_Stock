package com.dj.kuqu.util;

import lombok.Data;

import java.util.List;

@Data
public class PageVo<T> {

    //当前页
    private Integer pageIndex;

    //总页数
    private Integer totalPage;

    //总条数
    private Integer totalNumber;

    //每页条数
    private Integer pageSize;

    private List<T> dataList;





}
