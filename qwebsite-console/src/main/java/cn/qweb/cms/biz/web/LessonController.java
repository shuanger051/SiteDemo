package cn.qweb.cms.biz.web;
import cn.qweb.cms.config.SequenceFactoryConfig;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.biz.service.LessonService;
import cn.qweb.cms.biz.service.bo.LessonSaveBO;
import cn.qweb.cms.biz.service.query.LessonQUERY;
import cn.qweb.cms.biz.service.bo.LessonRemoveBO;
import cn.qweb.cms.biz.service.dto.LessonDTO;
import cn.qweb.cms.biz.service.bo.LessonUpdateBO;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.FileUtils;
import cn.qweb.cms.core.utils.UUIDUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;


@RestController
@RequestMapping("/less")
@ConfigurationProperties(prefix = "uploadresource")
public class LessonController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(LessonController.class);

    private String basePath;

    @Autowired
    private LessonService lessonService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "LessonQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<LessonDTO> getLessonList(@Valid LessonQUERY bean){
        return lessonService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public LessonDTO getLesson(Long id){
        return lessonService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "LessonSaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String postLesson(@Valid LessonSaveBO bean,@RequestParam(value = "file", required = false) MultipartFile file){

        if (null == file) {
            return FAILURE;
        }

        try {
            String fileName = file.getOriginalFilename();
            logger.info("上传的文件名为：" + fileName);
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String resFileName = UUIDUtil.get32CharsUUID() + suffixName;
            boolean flag = FileUtils.uploadFile(basePath + "lesson/" + resFileName, file);
            SequenceFactoryConfig sequenceFactoryConfig = new SequenceFactoryConfig();
            if (flag == true) {
                bean.setLessonPic("lesson/" + resFileName);
                bean.setSite(bean.getProvince() + bean.getCity() + bean.getCounty());
                bean.setLessonId(Long.parseLong(sequenceFactoryConfig.getObject()));
                bean.setStatus("1");
                lessonService.doSave(bean);
                return SUCCESS;
            } else {
                return FAILURE;
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            return FAILURE;
        }

    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "LessonUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public String putLesson(@Valid LessonUpdateBO bean){
        lessonService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="更新课程状态为审核通过")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "LessonUpdateBO")
    })
    @RequestMapping(value = "/reviewed",method = RequestMethod.PUT)
    public String reviewedLesson(@Valid LessonUpdateBO bean){
        bean.setStatus("3");
        lessonService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="更新课程状态为审核不通过")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "LessonUpdateBO")
    })
    @RequestMapping(value = "/suggestion",method = RequestMethod.PUT)
    public String suggestionLesson(@Valid LessonUpdateBO bean){
        bean.setStatus("2");
        lessonService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="更新课程状态为审核下线")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "LessonUpdateBO")
    })
    @RequestMapping(value = "/unline",method = RequestMethod.PUT)
    public String unlineLesson(@Valid LessonUpdateBO bean){
        bean.setStatus("5");
        lessonService.doUpdate(bean);
        return SUCCESS;
    }


    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteLesson(Long id) {
        lessonService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "LessonRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeLesson(LessonRemoveBO bean) {
        lessonService.doRemove(bean);
        return SUCCESS;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
}