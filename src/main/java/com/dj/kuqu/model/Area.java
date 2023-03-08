package com.dj.kuqu.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "库区信息")
public class Area {
    @ApiModelProperty(value = "库区id")
    private Integer id;
    @ApiModelProperty(value = "库区编码")
    private String code;
    @ApiModelProperty(value = "库区名称")
    private String name;
    @ApiModelProperty(value = "库区描述")
    private String remark;
    @ApiModelProperty(value = "库区状态")
    private Boolean status;
    @ApiModelProperty(value = "库区状态值")
    private String statusName;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "创建人")
    private String createPre;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    @ApiModelProperty(value = "更新人")
    private String updatePre;
    @ApiModelProperty(value = "版本号")
    private Integer version;
    @ApiModelProperty(value = "库房编码")
    private String wareHouseCode;
    @ApiModelProperty(value = "库房名称")
    private String wareHouseName;
    @ApiModelProperty(value = "库房描述")
    private String wareHouseRemark;
    @ApiModelProperty(value = "实行库位管理")
    private Boolean warehouseManagement;
    @ApiModelProperty(value = "与WMS集成")
    private Boolean wmsIntegrate;
    @ApiModelProperty(value = "VIP库区")
    private Boolean vipStorageSection;

    @ApiModelProperty(value = "选中的业务库区属性")
    private List<Integer> businessAttribute;

}
