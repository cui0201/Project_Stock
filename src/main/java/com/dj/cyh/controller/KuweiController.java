package com.dj.cyh.controller;

import com.dj.cyh.bean.*;
import com.dj.cyh.bean.status.StatusUpdate;
import com.dj.cyh.service.KuweiService;
import com.dj.cyh.util.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @className: KuweiController
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/03/07 20:50
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@RestController
@CrossOrigin
@Api(tags = "库存库位")
public class KuweiController {
    @Autowired
    private KuweiService kuweiService;

    @ApiOperation(value = "状态下拉框")
    @PostMapping("/iwm/getPullDownList")
    public ResultVo getPullDownList(){
        return kuweiService.getPullDownList();
    }
    @ApiOperation(value = "分页查询")
    @PostMapping("StorageBin/queryPage")
    public ResultVo queryPage(@RequestBody KuweiQueryPageVo kuweiQueryPageVo){
        return kuweiService.queryPage(kuweiQueryPageVo);
    }
    @ApiOperation(value = "修改状态")
    @PostMapping("/StorageBin/updateStatus")
    public ResultVo queryPage(@RequestBody StatusUpdate statusUpdate){
        return kuweiService.statusUpdate(statusUpdate);
    }

    @ApiOperation(value = "新增库存库位")
    @PostMapping("StorageBin/add")
    public ResultVo queryPage(@RequestBody KuweiAddListVo list){
        return kuweiService.add(list);
    }
    @ApiOperation(value = "新增弹窗库房信息")
    @GetMapping("storageSection/queryWareHouse")
    public ResultVo queryWareHouse(){
        return kuweiService.queryWareHouse();
    }
    @ApiOperation(value = "新增弹窗库区信息")
    @GetMapping("StorageBin/queryStorageSection")
    public ResultVo queryStorageSection(@RequestParam Integer id){
        return kuweiService.queryStorageSection(id);
    }

    @ApiOperation(value = "新增弹窗库位列表")
    @PostMapping("StorageBin/queryStorageBin")
    public ResultVo queryStorageBin(@RequestBody QueryStorageBinVo queryStorageBinVo){
        return kuweiService.queryStorageBin(queryStorageBinVo);
    }
    @ApiOperation(value = "修改保存")
    @PostMapping("StorageBin/update")
    public ResultVo update(@RequestBody KuweiUpdate kuweiUpdate){
        return kuweiService.updateKuwei(kuweiUpdate);
    }



}
