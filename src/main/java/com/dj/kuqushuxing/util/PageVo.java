package com.dj.kuqushuxing.util;

import lombok.Data;

import java.util.List;

@Data
public class PageVo<T> {
    private List<T> dataList;

    private Integer pageIndex;//当前页

    private Integer totalNumber;//总条数

    private Integer totalPage;//总页数

    private Integer pageSize;//每页的条数

}
