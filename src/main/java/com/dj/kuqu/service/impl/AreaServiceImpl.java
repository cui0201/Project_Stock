package com.dj.kuqu.service.impl;

import com.dj.kuqu.common.ExceptionWarn;
import com.dj.kuqu.common.StatusEnumList;
import com.dj.kuqu.mapper.AreaMapper;
import com.dj.kuqu.model.*;
import com.dj.kuqu.service.AreaService;
import com.dj.kuqu.util.PageVo;
import com.dj.kuqu.util.ResultBuildVo;
import com.dj.kuqu.util.ResultVo;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;
    @Override
    public ResultVo queryPage(AreaVo areaVo) {
        //计算分页查询第一个数
        Integer offSize = (areaVo.getPageIndex()-1)*areaVo.getPageSize();
        areaVo.setOffSize(offSize);
        //查询数据
        List<Area> areaList = areaMapper.selectArea(areaVo);
        for (Area area : areaList) {
            area.setStatusName(StatusEnumList.getLabel(area.getStatus() ? 1 : 0));
        }
        //查询总条数
        Integer count = areaMapper.selectCountArea(areaVo);
        PageVo pageVo = new PageVo();
        pageVo.setPageIndex(areaVo.getPageIndex());
        pageVo.setPageSize(areaVo.getPageSize());
        pageVo.setTotalNumber(count);
        Integer totalPage = count%areaVo.getPageSize() == 0?count/areaVo.getPageSize():count/areaVo.getPageSize()+1;
        pageVo.setTotalPage(totalPage);
        pageVo.setDataList(areaList);
        return ResultBuildVo.success(pageVo);
    }

    @Override
    @Transactional
    public ResultVo addArea(AddArea addArea) {
        //验证库区编码是否存在
        Integer countCode = areaMapper.selectAreaByAreaCode(addArea.getCode());
        if(countCode > 0){
            return ResultBuildVo.error("库区编码已存在");
        }
        //添加库区信息
        addArea.setCreatePre("张三");
        addArea.setUpdatePre("李四");
        areaMapper.addKuqu(addArea);
        //添加库区，库区属性中间表信息
        areaMapper.addKksx(addArea.getId(),addArea.getBusinessAttribute());
        return ResultBuildVo.success();
    }

    @Override
    @Transactional
    public ResultVo updateArea(UpdateArea updateArea) {
        //修改库区信息
        areaMapper.updateKuqu(updateArea);
        //删除库区，库区属性中间表信息
        areaMapper.deleteKksx(updateArea.getId());
        //添加库区，库区属性中间表信息
        areaMapper.addKksx(updateArea.getId(),updateArea.getBusinessAttribute());
        return ResultBuildVo.success();
    }

    @Override
    public ResultVo getKqSx() {
        List<KqSx> kqSxList = areaMapper.selectKqSx();
        return ResultBuildVo.success(kqSxList);
    }

    @Override
    public ResultVo getKuFang() {
    List<KuFang> kuFangList = areaMapper.selectKuFang();
    return ResultBuildVo.success(kuFangList);
    }

    @Override
    public ResultVo updateStatus(ModifyStatus modifyStatus) {
        areaMapper.updateStatus(modifyStatus);
        return ResultBuildVo.success();
    }

    @Override
    public ResultVo getSee(Integer id) {
        Area area = areaMapper.selectSeeOne(id);
        return ResultBuildVo.success(area);
    }

    @Override
    @Transactional
    public ResultVo importFile(MultipartFile file) throws IOException {
        //使用POI读取里面的内容
        XSSFWorkbook wb = new XSSFWorkbook(file.getInputStream());
        //获取单元格中的信息at0是获取sheet中的数据
        XSSFSheet sheet = wb.getSheetAt(0);
        //验证文件格式是否正确，文件标题是否正确
        ResultVo resultVo = fileMethod(sheet,file);
        if (!resultVo.getSuccess()){
            return resultVo;
        }
        //获取文件中的数据，返回到data集合
        ResultVo<List<ArFile>> data = getDateList(sheet);
        if (!data.getSuccess()){
            return data;
        }
        //转换数据库格式，判空，拿出重复的编码和名称分别放到集合中，长度是否符合要求
        ResultVo<List<ArFile>> result = areaListMethod(data.getData());
        if (!result.getSuccess()){
            return result;
        }
        //唯一性验证，编码  名称,是否存在
        ResultVo resultt = databaseYanZheng(result);
        if (!resultt.getSuccess()){
            return resultt;
        }
    return null;
    }

    private ResultVo databaseYanZheng(ResultVo<List<ArFile>> result) {
        List<ArFile> ar = result.getData();
        List<ArFile> databaseCostList = areaMapper.selectAll();
        List<String> kuFangList = areaMapper.selectKf();
        List<String> codeList = new ArrayList<String>();
        List<String> lowCodeCost = new ArrayList<>();
        //遍历数据库原始数据，判断文件中的数据是否在数据库存在，如果存在则给出提示，不存在则添加数据库
        for (ArFile arFile : databaseCostList) {
                codeList.add(arFile.getWareHouseCode());
            for (ArFile arFile1 : ar) {
                if (arFile.getCode().equals(arFile1.getCode())){
                    lowCodeCost.add(arFile1.getCode());
                }
            }
        }

        if (lowCodeCost.size() > 0){
            return ResultBuildVo.error(ExceptionWarn.FILE_COST_CODE_EXIST+lowCodeCost);
        }
        kuFangList.removeAll(codeList);
        if (!kuFangList.isEmpty()){
        return ResultBuildVo.error(ExceptionWarn.THE_ENCODING_DOES_NOT_EXIST+kuFangList);
        }
        areaMapper.insertAreaFile(ar);
        return ResultBuildVo.success();
    }

    private ResultVo<List<ArFile>> areaListMethod(List<ArFile> areaFileList) {
        List<ArFile> areaList = new ArrayList<ArFile>();
        for (ArFile arFile : areaFileList){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (StringUtils.isEmpty(arFile.getCode()) && StringUtils.isEmpty(arFile.getName())){
                break;
            }
            arFile.setStatus(arFile.getStatusName().equals("启用"));
        }
        BeanUtils.copyProperties(areaFileList,areaList);
        List<String> chongFuCode = areaList.stream().collect(Collectors.groupingBy(ArFile::getCode,Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
        if (!chongFuCode.isEmpty()){
            return ResultBuildVo.error(ExceptionWarn.CHONG_FU_CODE+chongFuCode);
        }
        List<String> chongFuName = areaList.stream().collect(Collectors.groupingBy(ArFile::getName,Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
        if (!chongFuName.isEmpty()){
            return ResultBuildVo.error(ExceptionWarn.CHONG_FU_NAME+chongFuName);
        }
        List<ArFile> langCode = areaList.stream().filter(s -> s.getCode().getBytes().length > 50).collect(Collectors.toList());
        if (!langCode.isEmpty()){
            return ResultBuildVo.error(ExceptionWarn.LANG_CODE+langCode);
        }
        List<ArFile> langName = areaList.stream().filter(s -> s.getName().getBytes().length > 50).collect(Collectors.toList());
        if (!langName.isEmpty()){
            return ResultBuildVo.error(ExceptionWarn.LANG_NAME+langName);
        }
        return ResultBuildVo.success(areaList);
    }

    private ResultVo fileMethod(XSSFSheet sheet,MultipartFile file) throws IOException {
        //验证传入的文件格式是否正确
        if (!Objects.requireNonNull(file.getOriginalFilename()).contains(".xlsx")){
            return ResultBuildVo.error(ExceptionWarn.FILE_FORM_WARN);
        }
        XSSFCell cell = sheet.getRow(0).getCell(0);
        if (!cell.getStringCellValue().equals(ExceptionWarn.FILE_COST)){
            return ResultBuildVo.error(ExceptionWarn.FILE_IMPORT_FROMWORK_WARN);
        }
        return ResultBuildVo.success();
    }
    private ResultVo getDateList(XSSFSheet sheet) {
        List<ArFile> arFileList = new ArrayList<>();
        for (int i = 3; i < sheet.getLastRowNum(); i++) {
            ArFile arFile = new ArFile();
            arFile.setCode(sheet.getRow(i).getCell(1).getStringCellValue());
            arFile.setName(sheet.getRow(i).getCell(2).getStringCellValue());
            arFile.setRemark(sheet.getRow(i).getCell(3).getStringCellValue());
            arFile.setStatusName(sheet.getRow(i).getCell(4).getStringCellValue());
            arFile.setWareHouseCode(sheet.getRow(i).getCell(5).getStringCellValue());
            arFileList.add(arFile);
        }
        return ResultBuildVo.success(arFileList);
    }
}
