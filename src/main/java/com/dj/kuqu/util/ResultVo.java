package com.dj.kuqu.util;

import lombok.Data;


@Data
public class ResultVo<T> {

    //true：成功，false：失败
    private Boolean success;

    //错误信息
    private String errorMessage;

    //成功之后返回的数据
    private T data;


}
