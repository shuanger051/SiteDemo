package cn.qweb.cms.biz.web;

import cn.qweb.cms.biz.constant.ContentConstant;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.biz.service.CredentialsService;
import cn.qweb.cms.biz.service.bo.CredentialsSaveBO;
import cn.qweb.cms.biz.service.query.CredentialsQUERY;
import cn.qweb.cms.biz.service.bo.CredentialsRemoveBO;
import cn.qweb.cms.biz.service.dto.CredentialsDTO;
import cn.qweb.cms.biz.service.bo.CredentialsUpdateBO;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.exception.BizException;
import cn.qweb.cms.core.exception.builder.ErrorBuilder;
import cn.qweb.cms.core.utils.PersonCardCheckUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.wuwz.poi.ExcelKit;
import org.wuwz.poi.hanlder.ReadHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


@RestController
@RequestMapping("/credential")
public class CredentialsController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(CredentialsController.class);

    @Autowired
    private CredentialsService credentialsService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "CredentialsQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<CredentialsDTO> getCredentialsList(@Valid CredentialsQUERY bean){
        return credentialsService.list(bean);
    }

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "ActivityApplyQUERY")
    @RequestMapping(value = "/queryList",method = RequestMethod.GET)
    public Pagination<CredentialsDTO> getActivityApplyListByLike(@Valid CredentialsQUERY bean){
        bean.setName("%"+bean.getName()+"%");
        bean.setWorkUnit("%"+bean.getWorkUnit()+"%");
        return credentialsService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public CredentialsDTO getCredentials(Long id){
        return credentialsService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "CredentialsSaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postCredentials(@Valid CredentialsSaveBO bean){
        return credentialsService.doSave(bean);
    }

    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "CredentialsUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String putCredentials(@Valid CredentialsUpdateBO bean){
        credentialsService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteCredentials(Long id) {
        credentialsService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="批量删除", notes="根据url的ids来指定删除对象")
    @RequestMapping(value="/delSelectedBox", method=RequestMethod.DELETE)
    public String deleteActivityApply(String ids) {
        try {
            if (null != ids && !"".equals(ids.trim())){
                String[] idArr = ids.split(",");
                for(int i=0;i<idArr.length;i++){
                    credentialsService.doRemove(Long.valueOf(idArr[i]));
                }
            }
            return SUCCESS;
        }catch (Exception e){
            logger.error("批量删除活动报名信息失败"+e.getMessage());
            return FAILURE;
        }
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "CredentialsRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeCredentials(CredentialsRemoveBO bean) {
        credentialsService.doRemove(bean);
        return SUCCESS;
    }

    @ApiOperation(value="导入", notes="根据条件导入EXCEL")
    @RequestMapping(value = "/import",method = RequestMethod.POST)
    public String importExcel(HttpServletRequest request, @RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile) throws Exception {
        if (null == uploadFile) {
            return FAILURE;
        }
        try {

            String uploadPath = request.getServletContext().getRealPath("./") + File.separator + "excel_upload";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String fileName = uploadFile.getOriginalFilename();
            String filePath = uploadPath + File.separator + fileName;

            File file = new File(filePath);
            uploadFile.transferTo(file);
            importExcel(file);
            file.deleteOnExit();
            return SUCCESS;
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * @info 导入Excel 工具函数
     * @param file
     * @throws BizException
     */
    public void importExcel(File file) throws BizException{

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        PersonCardCheckUtil idCheck = new PersonCardCheckUtil();
        try {

            // 执行excel文件导入
            ExcelKit.$Import().readExcel(file, new ReadHandler() {
                @Override
                public void handler(int sheetIndex, int rowIndex, List<String> row) throws BizException{
                    if(rowIndex != 0) { //排除第一行

                        CredentialsSaveBO bean = new CredentialsSaveBO();
                        bean.setCredentialsId(row.get(0).trim());
                        bean.setCredentialsType(row.get(1).trim());
                        bean.setCredentialsLevel(row.get(2).trim());
                        try {
                            bean.setCredentialsDate(format.parse(row.get(3).trim()));
                        }catch (Exception e){
                            throw new BizException(ErrorBuilder.buildBizError("导入Excel异常"));
                        }
                        bean.setName(row.get(4).trim());
                        bean.setPersonNo(row.get(5).trim());
                        if (idCheck.isValidatedAllIdcard(row.get(6).trim())) {
                            bean.setCardNo(row.get(6).trim());
                        } else {
                            throw new BizException(ErrorBuilder.buildBizError(" 第 " + (rowIndex + 1) + " 行，身份证错误, 本次导入 "+(rowIndex-1)+" 条"));
                        }
                        bean.setWorkUnit(row.get(7).trim());
                        bean.setTrainerType(row.get(8).trim());
                        credentialsService.doSave(bean);
                    }
                }
            });
        }catch (Exception e){
            throw (BizException)e;
        }
    }

    @ApiOperation(value="导出", notes="根据条件导出EXCEL")
    @RequestMapping(value = "/export",method = RequestMethod.GET)
    public void exportExcel(HttpServletRequest request, HttpServletResponse response){

        String name = request.getParameter("name");
        String workUnit = request.getParameter("workUnit");


        CredentialsQUERY bean = new CredentialsQUERY();
        if(null != name && !"".equals(name.trim())){
            bean.setName("%"+name+"%");
        }
        if(null != workUnit && !"".equals(workUnit.trim())){
            bean.setWorkUnit("%"+workUnit+"%");
        }
        bean.setPageSize(ContentConstant.MAX_EXPORT_COUNT);
        List<CredentialsDTO> list = credentialsService.queryList(bean);
        try{
            // 生成Excel并使用浏览器下载
            ExcelKit.$Export(CredentialsDTO.class, response).toExcel(list, "资质信息表");
        }catch (Exception e){
            logger.error("导出excel失败"+e.getMessage());
        }

    }

    @ApiOperation(value="检查导出条数", notes="检查需要导出的数据总条数，大于5000条，则不能执行导出操作")
    @RequestMapping(value = "/checkExport",method = RequestMethod.GET)
    public String checkExport(HttpServletRequest request, HttpServletResponse response, CredentialsQUERY bean){
        if(null != bean.getWorkUnit() && !"".equals(bean.getWorkUnit().trim())){
            bean.setWorkUnit("%"+bean.getWorkUnit()+"%");
        }
        Integer count = credentialsService.checkExport(bean);
        if(count != null && count < ContentConstant.MAX_EXPORT_COUNT){
            return SUCCESS;
        }else{
            return FAILURE;
        }
    }

}