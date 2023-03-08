package com.dj.kuqushuxing.util;

import lombok.Data;

@Data
public class Vo<T> {

    private Boolean success;

    private String errorMessage;
    //成功之后返回的数据
    private T data;

}
