package cn.qweb.cms.biz.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import cn.qweb.cms.biz.constant.ContentConstant;
import cn.qweb.cms.biz.service.ActivityApplyService;
import cn.qweb.cms.biz.service.bo.ActivityApplyRemoveBO;
import cn.qweb.cms.biz.service.bo.ActivityApplySaveBO;
import cn.qweb.cms.biz.service.bo.ActivityApplyUpdateBO;
import cn.qweb.cms.biz.service.dto.ActivityApplyDTO;
import cn.qweb.cms.biz.service.query.ActivityApplyQUERY;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.core.base.Pagination;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.wuwz.poi.ExcelKit;
import org.wuwz.poi.hanlder.ReadHandler;


@RestController
@RequestMapping("/activity_apply")
public class ActivityApplyController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ActivityApplyController.class);

    @Autowired
    private ActivityApplyService activityApplyService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "ActivityApplyQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<ActivityApplyDTO> getActivityApplyList(@Valid ActivityApplyQUERY bean){
        return activityApplyService.list(bean);
    }

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "ActivityApplyQUERY")
    @RequestMapping(value = "/queryList",method = RequestMethod.GET)
    public Pagination<ActivityApplyDTO> getActivityApplyListByLike(@Valid ActivityApplyQUERY bean){
        bean.setRealName("%"+bean.getRealName()+"%");
        return activityApplyService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ActivityApplyDTO getActivityApply(Long id){
        return activityApplyService.get(id);
    }

    @ApiOperation(value = "根据idNo获取对象")
    @RequestMapping(value = "/getInfoByIdNo",method = RequestMethod.GET)
    public boolean getActivityApply(@Valid ActivityApplyQUERY bean){
        List<ActivityApplyDTO> list = activityApplyService.queryList(bean);
        boolean flag = false;
        if (null != list && list.size() != 0){
            flag = true;
        }
        return flag;
    }


    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "ActivityApplySaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postActivityApply(@Valid ActivityApplySaveBO bean){
        return activityApplyService.doSave(bean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "ActivityApplyUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String putActivityApply(@Valid ActivityApplyUpdateBO bean){
        activityApplyService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteActivityApply(Long id) {
        activityApplyService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="批量删除", notes="根据url的ids来指定删除对象")
    @RequestMapping(value="/delSelectedBox", method=RequestMethod.DELETE)
    public String deleteActivityApply(String ids) {
        try {
            if (null != ids && !"".equals(ids.trim())){
                String[] idArr = ids.split(",");
                for(int i=0;i<idArr.length;i++){
                    activityApplyService.doRemove(Long.valueOf(idArr[i]));
                }
            }
            return SUCCESS;
        }catch (Exception e){
            logger.error("批量删除活动报名信息失败"+e.getMessage());
            return FAILURE;
        }
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "ActivityApplyRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeActivityApply(ActivityApplyRemoveBO bean) {
        activityApplyService.doRemove(bean);
        return SUCCESS;
    }

    @ApiOperation(value="导出", notes="根据条件导出EXCEL")
    @RequestMapping(value = "/export",method = RequestMethod.GET)
    public void exportExcel(HttpServletRequest request, HttpServletResponse response){

        String realName = request.getParameter("realName");
        String sex = request.getParameter("sex");
        String readFlag = request.getParameter("readFlag");

        ActivityApplyQUERY bean = new ActivityApplyQUERY();
        if(null != realName && !"".equals(realName.trim())){
            bean.setRealName("%"+realName+"%");
        }
        if(null != sex && !"".equals(sex.trim())){
            bean.setSex(sex);
        }
        if(null != readFlag && !"".equals(readFlag.trim())){
            bean.setReadFlag(readFlag);
        }

        List<ActivityApplyDTO> list = activityApplyService.queryList(bean);
        try{
            // 生成Excel并使用浏览器下载
            ExcelKit.$Export(ActivityApplyDTO.class, response).toExcel(list, "活动报名列表");
        }catch (Exception e){
            logger.error("导出excel失败"+e.getMessage());
        }

    }

    @ApiOperation(value="导入", notes="根据条件导入EXCEL")
    @RequestMapping(value = "/import",method = RequestMethod.POST)
    public String importExcel(HttpServletRequest request, @RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile) throws IOException{
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
            // 执行excel文件导入
            ExcelKit.$Import().readExcel(file, new ReadHandler() {
                @Override
                public void handler(int sheetIndex, int rowIndex, List<String> row) {
                    if(rowIndex != 0) { //排除第一行
                        ActivityApplySaveBO bean = new ActivityApplySaveBO();
                        bean.setChannelId(Long.parseLong(row.get(0)));
                        bean.setContentId(Long.parseLong(row.get(1)));
                        bean.setRealName(row.get(2));
                        bean.setSex(row.get(3));
                        bean.setIdNo(row.get(4));
                        bean.setIdKind(row.get(5));
                        bean.setMobile(row.get(6));
                        bean.setEmail(row.get(7));
                        bean.setQq(row.get(8));
                        bean.setHeight(row.get(9));
                        bean.setReadFlag(row.get(10));
                        activityApplyService.doSave(bean);
                    }
                }
            });
            file.deleteOnExit();
            return SUCCESS;
        } catch (Exception ex) {
            return FAILURE;
        }
    }


    @ApiOperation(value="导出", notes="检查需要导出的数据总条数，大于5000条，则不能执行导出操作")
    @RequestMapping(value = "/checkExport",method = RequestMethod.GET)
    public String checkExport(HttpServletRequest request, HttpServletResponse response,ActivityApplyQUERY bean){
        Integer count = activityApplyService.checkExport(bean);
        if(count != null && count < ContentConstant.MAX_EXPORT_COUNT){
            return SUCCESS;
        }else{
            return FAILURE;
        }
    }

}