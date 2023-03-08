package com.dj.kuqushuxing.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


import java.util.Date;

@Data
public class UpdateShuXingVo {
    private Integer id;
    private String code;
    @NotBlank(message = "库房名称不能为空")
    private String name;
    private String remark;

    private Date  updateTime;

    private String updatePre;
}
