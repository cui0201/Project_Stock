package com.dj.kuqu.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api(tags = "库房")
public class KuFang {
    @ApiModelProperty(value = "库房id")
    private Integer id;
    @ApiModelProperty(value = "库房编码")
    private String code;
    @ApiModelProperty(value = "库房名称")
    private String name;
}
