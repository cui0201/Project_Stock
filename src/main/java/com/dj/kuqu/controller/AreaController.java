package com.dj.kuqu.controller;

import com.dj.kuqu.model.AddArea;
import com.dj.kuqu.model.AreaVo;
import com.dj.kuqu.model.ModifyStatus;
import com.dj.kuqu.model.UpdateArea;
import com.dj.kuqu.service.AreaService;
import com.dj.kuqu.util.ResultBuildVo;
import com.dj.kuqu.util.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping(value = "storageSection")
@Api(tags = "库房库区")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @PostMapping(value = "queryPage")
    @ApiOperation(value = "库房库区分页")
    public ResultVo queryPage(@RequestBody AreaVo areaVo) {
        return areaService.queryPage(areaVo);
    }

    @PostMapping(value = "add")
    @ApiOperation(value = "新增库房库区")
    public ResultVo addArea(@RequestBody @Valid AddArea addArea, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return areaService.addArea(addArea);
    }

    @PostMapping(value = "update")
    @ApiOperation(value = "修改库房库区")
    public ResultVo updateArea(@RequestBody @Valid UpdateArea updateArea, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return areaService.updateArea(updateArea);
    }

    @PostMapping(value = "updateStatus")
    @ApiOperation(value = "修改库房库区状态")
    public ResultVo updateStatus(@RequestBody @Valid ModifyStatus modifyStatus, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return areaService.updateStatus(modifyStatus);
    }

    @PostMapping(value = "import")
    @ApiOperation(value = "导入")
    public ResultVo importFile(MultipartFile file) throws IOException {
        return areaService.importFile(file);
    }

}
