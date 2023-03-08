package com.dj.kuqushuxing.util;

import lombok.Data;

@Data
public class BuildVo<T> {

    public static Vo error(String message){
        Vo vo=new Vo();
      vo.setSuccess(false);
      vo.setErrorMessage(message);
      return vo;
    }

    public static<T> Vo succsee(T data){
        Vo vo=new Vo();
        vo.setSuccess(true);
        vo.setData(data);
        return vo;
    }
    public static Vo succsee(){
        Vo vo=new Vo();
        vo.setSuccess(true);
        return vo;
    }

}
