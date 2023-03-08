package com.dj.kuqu.service;

import com.dj.kuqu.model.AddArea;
import com.dj.kuqu.model.AreaVo;
import com.dj.kuqu.model.ModifyStatus;
import com.dj.kuqu.model.UpdateArea;
import com.dj.kuqu.util.ResultVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AreaService {
    ResultVo queryPage(AreaVo areaVo);

    ResultVo addArea(AddArea addArea);

    ResultVo updateArea(UpdateArea updateArea);

    ResultVo getKqSx();

    ResultVo getKuFang();

    ResultVo updateStatus(ModifyStatus modifyStatus);

    ResultVo getSee(Integer id);

    ResultVo importFile(MultipartFile file) throws IOException;
}
