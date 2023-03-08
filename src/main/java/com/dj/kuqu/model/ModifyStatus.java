package com.dj.kuqu.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Api(tags = "状态修改")
public class ModifyStatus {
    @ApiModelProperty(value = "库区id")
    @NotNull(message = "id不能为空")
    private Integer id;
    @ApiModelProperty(value = "库区状态")
    @NotNull(message = "状态不能为空")
    private Boolean status;
}
