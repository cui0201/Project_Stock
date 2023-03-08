package com.dj.kuqu.model;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api(tags = "库区属性")
public class KqSx {
    @ApiModelProperty(value = "库区属性id")
    private Integer id;
    @ApiModelProperty(value = "库区属性编码")
    private String code;
    @ApiModelProperty(value = "库区属性名称")
    private String name;
}
