package com.dj.kuqushuxing.service;

import com.dj.kuqushuxing.mapper.ShuXingMapper;
import com.dj.kuqushuxing.model.*;
import com.dj.kuqushuxing.util.BuildVo;
import com.dj.kuqushuxing.util.PageUtil;
import com.dj.kuqushuxing.util.PageVo;
import com.dj.kuqushuxing.util.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShuXingServiceImpl implements ShuXingService{

    @Autowired
    private ShuXingMapper shuXingMapper;
    @Override
    public Vo queryPage(QueryPageVo queryPageVo) {
        //计算分页用的参数值
        Integer offSize=(queryPageVo.getPageIndex()-1)* PageUtil.PAGE_COUNT;
        queryPageVo.setOffSize(offSize);
        queryPageVo.setPageSize(PageUtil.PAGE_COUNT);
        //查询出的数据
        List<ShuXingVo> list=shuXingMapper.queryPage(queryPageVo);
        for(ShuXingVo shuXing:list){
            int i = shuXing.getStatus() ? 1 : 0;
            shuXing.setStatusName(EnumStatus.getValue(i));
        }
        //查询总条数
        Integer totalcount=shuXingMapper.queryCount(queryPageVo);
        //计算
        PageVo pageVo=new PageVo();
        pageVo.setPageIndex(queryPageVo.getPageIndex());
        pageVo.setPageSize(PageUtil.PAGE_COUNT);
        pageVo.setTotalNumber(totalcount);
        Integer totalPage=totalcount%PageUtil.PAGE_COUNT==0?totalcount/PageUtil.PAGE_COUNT:totalcount/PageUtil.PAGE_COUNT+1;
        pageVo.setTotalPage(totalPage);
        pageVo.setDataList(list);
        //赋值

        return BuildVo.succsee(pageVo);
    }

    @Override
    public Vo modifyStatus(StatusModifyVo statusModifyVo) {
        int count=shuXingMapper.modifyStatus(statusModifyVo);
        if (count>1){
            return BuildVo.error("状态修改失败");
        }
        return BuildVo.succsee();
    }

    @Override
    public Vo updateShuXing(UpdateShuXingVo updateShuXing) {
        int count=shuXingMapper.getShuXingByIdAndName(updateShuXing.getId(),updateShuXing.getName());
        if (count>0){
            return BuildVo.error("名称重复，请重新修改");
        }else {
            updateShuXing.setUpdatePre("小明w");
            shuXingMapper.updateShuXing(updateShuXing);
        }
        return BuildVo.succsee();
    }

    @Override
    public Vo addShuXing(AddShuXingVo addShuXingVo) {

        int count=shuXingMapper.getByCode(addShuXingVo.getCode());
        if (count>0){
            return BuildVo.error("编码存在,请重新添加");
        }
        int namecount=shuXingMapper.getByName(addShuXingVo.getName());
        if (namecount>0){
            return BuildVo.error("名称存在,请重新添加");
        }
        addShuXingVo.setCreatePre("小明");
        Date date=new Date();
        addShuXingVo.setCreateTime(date);
        addShuXingVo.setUpdatePre("小明");
        addShuXingVo.setUpdateTime(date);
        shuXingMapper.addShuXing(addShuXingVo);
        return BuildVo.succsee();
    }
}
