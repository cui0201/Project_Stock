package com.dj.cyh.bean;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @className: QueryStorageBinVo
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/03/08 09:50
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class QueryStorageBinVo {
    /**
     * 库房id
     */
    private Integer wareHouseId;
    /**
     * 库区id
     */
    private Integer storageSectionId;
}
