package com.dj.cyh.service;

import com.dj.cyh.bean.*;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dj.cyh.bean.status.StatusUpdate;
import com.dj.cyh.util.ResultVo;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
* @author cuiyuhua
* @description 针对表【kuwei】的数据库操作Service
* @createDate 2023-03-07 20:42:25
*/
public interface KuweiService extends IService<Kuwei> {

    /**
     * 库房库位状态下拉框
     * @return ResultVo
     */
    ResultVo getPullDownList();

    /**
     * 库房库位分页查询
     * @param kuweiQueryPageVo
     * @return
     */
    ResultVo queryPage(KuweiQueryPageVo kuweiQueryPageVo);

    /**
     * 修改状态
     * @param statusUpdate
     * @return
     */
    ResultVo statusUpdate(StatusUpdate statusUpdate);

    /**
     * 新增弹出样库存信息
     * @return
     */
    ResultVo queryWareHouse();

    /**
     * 新增弹窗库区信息
     * @param wareHouseId
     * @return
     */
    ResultVo queryStorageSection(Integer wareHouseId);

    /**
     * 新增弹窗库位列表
     * @param queryStorageBinVo
     * @return
     */
    ResultVo queryStorageBin(QueryStorageBinVo queryStorageBinVo);

    /**
     * 修改保存修改库位名称
     * @param kuweiUpdate
     * @return
     */
    ResultVo updateKuwei(KuweiUpdate kuweiUpdate);

    /**
     * 添加库位
     * @param list
     * @return
     */
    ResultVo add(KuweiAddListVo list);

    /**
     * 导入文件
     * @param multipartFile
     * @return
     */
    ResultVo importKuWei(@Param("multipartFile") MultipartFile multipartFile);
}
