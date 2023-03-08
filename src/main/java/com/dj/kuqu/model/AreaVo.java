package com.dj.kuqu.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "库区分页查询")
public class AreaVo{

    @ApiModelProperty(value = "库房编码")
    private String wareHouseCode;
    @ApiModelProperty(value = "库房名称")
    private String wareHouseName;
    @ApiModelProperty(value = "库区编码")
    private String code;
    @ApiModelProperty(value = "库区名称")
    private String name;
    @ApiModelProperty(value = "库区状态")
    private Boolean status;
    @ApiModelProperty(value = "库区状态值")
    private String statusName;
    @ApiModelProperty(value = "当前页")
    private Integer pageIndex;
    @ApiModelProperty(value = "每页几条")
    private Integer pageSize;
    @ApiModelProperty(value = "分页查询第一个参数")
    private Integer offSize;

}
