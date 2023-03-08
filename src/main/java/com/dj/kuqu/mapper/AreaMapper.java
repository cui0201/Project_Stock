package com.dj.kuqu.mapper;

import com.dj.kuqu.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AreaMapper {
    List<Area> selectArea(AreaVo areaVo);

    Integer selectCountArea(AreaVo areaVo);

    Integer selectAreaByAreaCode(String code);

    void addKuqu(AddArea addArea);

    void addKksx(@Param("id") Integer id,@Param("businessAttribute") List<Integer> businessAttribute);

    void updateKuqu(UpdateArea updateArea);

    void deleteKksx(Integer id);

    List<KqSx> selectKqSx();

    List<KuFang> selectKuFang();

    void updateStatus(ModifyStatus modifyStatus);

    Area selectSeeOne(Integer id);

    List<ArFile> selectAll();

    void insertAreaFile(List<ArFile> ar);

    List<String> selectKf();
}
