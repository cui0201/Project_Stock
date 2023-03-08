package com.dj.kuqu.controller;

import com.dj.kuqu.common.StatusEnumList;
import com.dj.kuqu.common.StatusVo;
import com.dj.kuqu.service.AreaService;
import com.dj.kuqu.util.ResultBuildVo;
import com.dj.kuqu.util.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@Api(tags = "下拉框")
public class UnderController {
    @Autowired
    private AreaService areaService;

    @PostMapping(value ="iwm/getPullDownList")
    @ApiOperation(value = "状态下拉")
    public ResultVo getPullDownList(){
        List<StatusVo> statusList = new ArrayList<>();
        for (StatusEnumList statusEnum : StatusEnumList.values()) {
            statusList.add(new StatusVo(statusEnum.getLabel(), statusEnum.getValue()));
        }
        return ResultBuildVo.success(statusList);
    }

    @GetMapping(value ="storageSection/queryBusinessAttribute")
    @ApiOperation(value = "库房业务属性下拉")
    public ResultVo getKqSx(){
        return areaService.getKqSx();
    }
    @GetMapping(value ="storageSection/queryWareHouse")
    @ApiOperation(value = "新增弹窗库房信息下拉列表")
    public ResultVo getKuFang(){
        return areaService.getKuFang();
    }
    @GetMapping(value ="storageSection/queryStorageSectionById")
    @ApiOperation(value = "查看取值")
    public ResultVo getSee(Integer id){
        return areaService.getSee(id);
    }




}
