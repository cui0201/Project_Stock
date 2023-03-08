package com.dj.cyh.bean;


import lombok.Data;

/**
 * @className: KuweiAddVo
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/03/08 10:06
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class KuweiAddVo {
    /**
      *  库房id
      */
    private Integer wareHouseId;
    /**
      *  库房code
      */
    private String wareHouseCode;
    /**
     *  库房name
     */
    private String wareHouseName;
    /**
     *  库区id
     */
    private Integer storageSectionId;
    /**
     *  库区编码
     */
    private String storageSectionCode;
    /**
     *  库区名称
     */
    private String storageSectionName;
    /**
     *  库位名称
     */
    private String name;
    /**
     *  库位编码
     */
    private String code;
    /**
     *  库位状态
     */
    private Boolean status;
    /**
      *  创建人
      */
    private String createPer;
    /**
      *  修改人
      */
    private String updatePer;

}
