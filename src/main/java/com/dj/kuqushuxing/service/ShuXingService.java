package com.dj.kuqushuxing.service;

import com.dj.kuqushuxing.model.AddShuXingVo;
import com.dj.kuqushuxing.model.QueryPageVo;
import com.dj.kuqushuxing.model.StatusModifyVo;
import com.dj.kuqushuxing.model.UpdateShuXingVo;
import com.dj.kuqushuxing.util.Vo;

public interface ShuXingService {
    Vo queryPage(QueryPageVo queryPageVo);

    Vo modifyStatus(StatusModifyVo statusModifyVo);

    Vo updateShuXing(UpdateShuXingVo updateShuXing);

    Vo addShuXing(AddShuXingVo addShuXingVo);
}
