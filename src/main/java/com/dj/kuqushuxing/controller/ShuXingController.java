package com.dj.kuqushuxing.controller;

import com.dj.kuqushuxing.model.AddShuXingVo;
import com.dj.kuqushuxing.model.QueryPageVo;
import com.dj.kuqushuxing.model.StatusModifyVo;
import com.dj.kuqushuxing.model.UpdateShuXingVo;
import com.dj.kuqushuxing.service.ShuXingService;
import com.dj.kuqushuxing.util.BuildVo;
import com.dj.kuqushuxing.util.Vo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin
@RequestMapping("pickingArea")
public class ShuXingController {
    @Autowired
    private ShuXingService shuXingService;
    @PostMapping(value = "/queryPage")
    public Vo queryPage(@RequestBody QueryPageVo queryPageVo){

        return shuXingService.queryPage(queryPageVo);
    }

    @PostMapping("/updateStatus")
    public Vo modifyStatus(@RequestBody StatusModifyVo statusModifyVo){

        return shuXingService.modifyStatus(statusModifyVo);
    }
    @PostMapping("update")
    public Vo updateShuXing(@RequestBody @Valid UpdateShuXingVo updateShuXing, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return BuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return shuXingService.updateShuXing(updateShuXing);
    }

    @PostMapping("add")
    public Vo addShuXing(@RequestBody @Valid AddShuXingVo addShuXingVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return BuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return shuXingService.addShuXing(addShuXingVo);
    }
}
