package com.dj.cyh.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.cyh.bean.*;
import com.dj.cyh.bean.status.Status;
import com.dj.cyh.bean.status.StatusUpdate;
import com.dj.cyh.mapper.KufangshezhiMapper;
import com.dj.cyh.mapper.KuquMapper;
import com.dj.cyh.service.KuweiService;
import com.dj.cyh.mapper.KuweiMapper;
import com.dj.cyh.util.PageInfo;
import com.dj.cyh.util.ResultVo;
import com.dj.cyh.util.ResultVoBuild;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
* @author cuiyuhua
* @description 针对表【kuwei】的数据库操作Service实现
* @createDate 2023-03-07 20:42:25
*/
@Service
public class KuweiServiceImpl extends ServiceImpl<KuweiMapper, Kuwei>
    implements KuweiService{

    @Resource
    private KuweiMapper kuweiMapper;
    @Resource
    private KufangshezhiMapper kufangshezhiMapper;
    @Resource
    private KuquMapper kuquMapper;
    @Override
    public ResultVo getPullDownList() {
        List<Status> list = new ArrayList<>();
        Status status =new Status(true,"启用");
        Status status1 =new Status(false,"禁用");
        Status status2 =new Status(null,"全部");
        list.add(status);
        list.add(status1);
        list.add(status2);
        return ResultVoBuild.success(list);
    }

    @Override
    public ResultVo queryPage(KuweiQueryPageVo kuweiQueryPageVo) {
        Integer totalNum = kuweiMapper.totalNumByCondition(kuweiQueryPageVo);
        Integer startNum = (kuweiQueryPageVo.getPageIndex()-1)* kuweiQueryPageVo.getPageSize();
        kuweiQueryPageVo.setStartNum(startNum);
        List<KuWeiQueryPageForVo> list=kuweiMapper.queryPageForKuWei(kuweiQueryPageVo);
        for (KuWeiQueryPageForVo a:list) {
            if(a.getStatus()){
                a.setStatusName("启用");
            }else {
                a.setStatusName("禁用");
            }
        }
        PageInfo<KuWeiQueryPageForVo> pageForVoPageInfo = new PageInfo<>();
        pageForVoPageInfo.setCurrentPage(kuweiQueryPageVo.getPageIndex());
        pageForVoPageInfo.setTotalSize(totalNum);
        pageForVoPageInfo.setDataList(list);
        return ResultVoBuild.success(pageForVoPageInfo);
    }

    @Override
    public ResultVo statusUpdate(StatusUpdate statusUpdate) {
        UpdateWrapper<Kuwei> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",statusUpdate.getId());
        Kuwei kuwei = new Kuwei();
        kuwei.setStatus(statusUpdate.getStatus());
        kuweiMapper.update(kuwei,updateWrapper);
        return ResultVoBuild.success();
    }

    @Override
    public ResultVo queryWareHouse() {
        QueryWrapper<Kufangshezhi> wrapper = new QueryWrapper<>();
        List<Kufangshezhi> kufangshezhis = kufangshezhiMapper.selectList(wrapper);
        return ResultVoBuild.success(kufangshezhis);
    }

    @Override
    public ResultVo queryStorageSection(Integer wareHouseId) {
        QueryWrapper<Kuqu> queryWrapper = new QueryWrapper<>();
        Kufangshezhi kufangshezhi = kufangshezhiMapper.selectById(wareHouseId);
        String code = kufangshezhi.getCode();
        queryWrapper.eq("kufang_code",code);
        List<Kuqu> kuqus = kuquMapper.selectList(queryWrapper);
        return ResultVoBuild.success(kuqus);
    }

    @Override
    public ResultVo queryStorageBin(QueryStorageBinVo queryStorageBinVo) {
        Kuqu kuqu = kuquMapper.selectById(queryStorageBinVo.getStorageSectionId());
        String code = kuqu.getCode();
        QueryWrapper<Kuwei> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("kuqu_code",code);
        List<Kuwei> kuweis = kuweiMapper.selectList(queryWrapper);
        return ResultVoBuild.success(kuweis);
    }

    @Override
    public ResultVo updateKuwei(KuweiUpdate kuweiUpdate) {
        UpdateWrapper<Kuwei> wrapper =new UpdateWrapper();
        wrapper.eq("id",kuweiUpdate.getId());
        Kuwei kuwei =new Kuwei();
        kuwei.setName(kuweiUpdate.getName());
        update(kuwei,wrapper);
        return ResultVoBuild.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVo add(KuweiAddListVo list) {
        List<KuweiAddVo> list1 = list.getList();
        for (KuweiAddVo a:list1
             ) {
            a.setCreatePer("创建人");
            a.setUpdatePer("修改人");
        }
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("kuqu_code",list1.get(1).getStorageSectionCode());
        kuweiMapper.delete(wrapper);
        kuweiMapper.insertList(list1);
        return ResultVoBuild.success();
    }

    @Override
    public ResultVo importKuWei(MultipartFile multipartFile) {
        if(!multipartFile.getOriginalFilename().endsWith(".xlsx")){
            return ResultVoBuild.defeated("文件错误！！");
        }

        return null;
    }
}




