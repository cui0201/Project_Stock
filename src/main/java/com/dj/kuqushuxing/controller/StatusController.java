package com.dj.kuqushuxing.controller;

import com.dj.kuqushuxing.model.StatusVo;
import com.dj.kuqushuxing.util.BuildVo;
import com.dj.kuqushuxing.util.Vo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("iwm")
public class StatusController {

    @PostMapping("/getPullDownList")
    public Vo getdownlist(){
        List<StatusVo> statusList=new ArrayList<>();
        statusList.add(new StatusVo("启用",1));
        statusList.add(new StatusVo("禁用",0));
        statusList.add(new StatusVo("全部",null));

        return BuildVo.succsee(statusList);
    }
}
