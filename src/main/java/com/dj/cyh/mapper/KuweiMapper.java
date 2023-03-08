package com.dj.cyh.mapper;

import com.dj.cyh.bean.KuWeiQueryPageForVo;
import com.dj.cyh.bean.Kuwei;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dj.cyh.bean.KuweiAddVo;
import com.dj.cyh.bean.KuweiQueryPageVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author cuiyuhua
* @description 针对表【kuwei】的数据库操作Mapper
* @createDate 2023-03-07 20:42:25
* @Entity com.dj.cyh.bean.Kuwei
*/
@Mapper
public interface KuweiMapper extends BaseMapper<Kuwei> {

    /**
     * 条件查询全部条数
     * @param kuweiQueryPageVo
     * @return
     */
    Integer totalNumByCondition(KuweiQueryPageVo kuweiQueryPageVo);

    /**
     * 分页查询
     * @param kuweiQueryPageVo
     * @return List<KuWeiQueryPageForVo>
     */
    List<KuWeiQueryPageForVo> queryPageForKuWei(KuweiQueryPageVo kuweiQueryPageVo);

    /**
     * 批量添加
     * @param list1
     */
    void insertList(List<KuweiAddVo> list1);

}




