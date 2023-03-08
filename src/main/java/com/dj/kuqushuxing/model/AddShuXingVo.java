package com.dj.kuqushuxing.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


import java.util.Date;

@Data
public class AddShuXingVo {
    private Integer id;
    @NotBlank(message = "库区属性编码不能为空")
    private String code;
    @NotBlank(message = "库区属性名称不能为空")
    private String name;
    private Boolean status;
    private String remark;
    private Date createTime;

    private String createPre;

    private Date  updateTime;

    private String updatePre;
}
