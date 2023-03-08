package com.dj.kuqu.util;

import lombok.Data;


@Data
public class ResultBuildVo <T> {

    public static ResultVo error(String errorMessage){
        ResultVo resultVo = new ResultVo();
        resultVo.setSuccess(false);
        resultVo.setErrorMessage(errorMessage);
        return resultVo;
    }

    public static ResultVo success(){
        ResultVo resultVo = new ResultVo();
        resultVo.setSuccess(true);
        return resultVo;
    }

    public static<T> ResultVo success(T data){
        ResultVo resultVo = new ResultVo();
        resultVo.setSuccess(true);
        resultVo.setData(data);
        return resultVo;
    }


}
