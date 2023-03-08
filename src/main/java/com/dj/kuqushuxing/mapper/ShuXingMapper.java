package com.dj.kuqushuxing.mapper;

import com.dj.kuqushuxing.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShuXingMapper {
    List<ShuXingVo> queryPage(QueryPageVo queryPageVo);

    Integer queryCount(QueryPageVo queryPageVo);

    int modifyStatus(StatusModifyVo statusModifyVo);

    int getShuXingByIdAndName(@Param("id") Integer id,@Param("name") String name);

    void updateShuXing(UpdateShuXingVo updateShuXing);

    int getByCode(String code);

    int getByName(String name);

    void addShuXing(AddShuXingVo addShuXingVo);
}
