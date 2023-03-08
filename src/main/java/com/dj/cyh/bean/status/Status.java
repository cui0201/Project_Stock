package com.dj.cyh.bean.status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: Status
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/03/07 21:12
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status {
    /**
     * 状态
     */
    private Boolean status;
    /**
     * 状态名称
     */
    private String statusName;
}
