package cn.qweb.cms.biz.web;
import cn.qweb.cms.biz.service.TeacherService;
import cn.qweb.cms.biz.service.bo.TeacherRemoveBO;
import cn.qweb.cms.biz.service.bo.TeacherSaveBO;
import cn.qweb.cms.biz.service.bo.TeacherUpdateBO;
import cn.qweb.cms.biz.service.dto.TeacherDTO;
import cn.qweb.cms.biz.service.query.TeacherQUERY;
import cn.qweb.cms.core.constants.Constants;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.exception.BizException;
import cn.qweb.cms.core.exception.builder.ErrorBuilder;
import cn.qweb.cms.core.upload.FileRepository;
import cn.qweb.cms.core.utils.StrUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.wuwz.poi.ExcelKit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/teacher")
@ConfigurationProperties(prefix = "uploadresource")
public class TeacherController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private FileRepository fileRepository;

    /**
     * 文件存储路径
     */
    private String basePath;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "TeacherQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<TeacherDTO> getTeacherList(@Valid TeacherQUERY bean){
        return teacherService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public TeacherDTO getTeacher(Long id){
        return teacherService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "TeacherSaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postTeacher(@Valid TeacherSaveBO bean, @RequestParam(value = "file") MultipartFile file){
        bean.setHeadImg(saveHeadImg(file));
        bean.setTxt(StrUtil.unescapeHtml(bean.getTxt()));
        return teacherService.doSave(bean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "TeacherUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String putTeacher(@Valid TeacherUpdateBO bean,@RequestParam(value = "file", required = false) MultipartFile file){
        bean.setHeadImg(saveHeadImg(file));
        bean.setTxt(StrUtil.unescapeHtml(bean.getTxt()));
        teacherService.doUpdate(bean);
        return SUCCESS;
    }

    /**
     * 保存头像 并返回 地址
     * @param file
     * @return
     */
    private String saveHeadImg(MultipartFile file) {
        if (null != file) {
            //保存头像
            try {
                String fileUrl = fileRepository.storeByExt(basePath + Constants.TEACHER_HEADE_IMG_PATH,
                        FilenameUtils.getExtension(file.getOriginalFilename()).toLowerCase(), file);
                return fileUrl.replace(basePath, "");
            } catch (IOException e) {
                throw new BizException(ErrorBuilder.buildBizError("保存头像失败"));
            }
        }
        return null;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteTeacher(Long id) {
        teacherService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "TeacherRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeTeacher(TeacherRemoveBO bean) {
        teacherService.doRemove(bean);
        return SUCCESS;
    }

    @ApiOperation(value="导出", notes="根据条件导出EXCEL")
    @RequestMapping(value = "/export",method = RequestMethod.GET)
    public void exportExcel(HttpServletRequest request, HttpServletResponse response,TeacherQUERY bean){

        String realName = request.getParameter("realName");
        String sex = request.getParameter("sex");
        String readFlag = request.getParameter("readFlag");



        List<TeacherDTO> list = teacherService.queryList(bean);
        try{
            // 生成Excel并使用浏览器下载
            ExcelKit.$Export(TeacherDTO.class, response).toExcel(list, "名师列表");
        }catch (Exception e){
            logger.error("导出excel失败"+e.getMessage());
        }

    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
}