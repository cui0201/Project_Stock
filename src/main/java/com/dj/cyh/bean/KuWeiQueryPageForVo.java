package com.dj.cyh.bean;

import lombok.Data;

/**
 * @className: KuWeiQueryPageForVo
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/03/07 22:37
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class KuWeiQueryPageForVo {
    /**
      *  库位id
      */
    private String id;
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
      *  状态名称
      */
    private String statusName;
    /**
     * 库区编码
     */
    private String storageSectionCode;
    /**
     * 库区名称
     */
    private String storageSectionName;
    /**
      *  库区描述
      */
    private String storageSectionRemark;
    /**
     * 库房编码
     */
    private String wareHouseCode;
    /**
     * 库房名称
     */
    private String wareHouseName;
    /**
     * 库房描述
     */
    private String wareHouseRemark;
}
