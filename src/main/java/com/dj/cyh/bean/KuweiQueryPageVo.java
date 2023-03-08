package com.dj.cyh.bean;

import lombok.Data;

import java.util.PrimitiveIterator;

/**
 * @className: KuweiQueryPageVo
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/03/07 21:42
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class KuweiQueryPageVo {
    /**
     * 库位编码
     */
    private String code;

    /**
     * 库位名称
     */
    private String name;

    /**
     * 库位状态
     */
    private Boolean status;
    /**
     * 当前页
     */
    private Integer pageIndex;
    /**
     * 页大小
     */
    private Integer pageSize;
    /**
      *  展示开始条数
      */
    private Integer startNum;
    /**
     * 库区编码
     */
    private String storageSectionCode;
    /**
     * 库区名称
     */
    private String storageSectionName;
    /**
     * 库房编码
     */
    private String wareHouseCode;
    /**
     * 库房名称
     */
    private String wareHouseName;


}
