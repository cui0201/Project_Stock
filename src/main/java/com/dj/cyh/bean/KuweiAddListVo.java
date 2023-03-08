package com.dj.cyh.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.List;

/**
 * @className: KuweiAddListVo
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/03/08 12:47
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class KuweiAddListVo {
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    List<KuweiAddVo> list;
}
