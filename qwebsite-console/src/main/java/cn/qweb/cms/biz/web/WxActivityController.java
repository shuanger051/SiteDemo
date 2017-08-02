package cn.qweb.cms.biz.web;
import cn.qweb.cms.config.SequenceFactoryConfig;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.biz.service.WxActivityService;
import cn.qweb.cms.biz.service.bo.WxActivitySaveBO;
import cn.qweb.cms.biz.service.query.WxActivityQUERY;
import cn.qweb.cms.biz.service.bo.WxActivityRemoveBO;
import cn.qweb.cms.biz.service.dto.WxActivityDTO;
import cn.qweb.cms.biz.service.bo.WxActivityUpdateBO;
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
@RequestMapping("/wx_activity")
@ConfigurationProperties(prefix = "uploadresource")
public class WxActivityController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(WxActivityController.class);

    private String basePath;

    @Autowired
    private WxActivityService wxActivityService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "WxActivityQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<WxActivityDTO> getWxActivityList(@Valid WxActivityQUERY bean){
        return wxActivityService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public WxActivityDTO getWxActivity(Long id){
        return wxActivityService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "WxActivitySaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String postWxActivity(@Valid WxActivitySaveBO bean,@RequestParam(value = "file", required = false) MultipartFile file){

        if (null == file) {
            return FAILURE;
        }

        try {
            String fileName = file.getOriginalFilename();
            logger.info("上传的文件名为：" + fileName);
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String resFileName = UUIDUtil.get32CharsUUID() + suffixName;
            boolean flag = FileUtils.uploadFile(basePath + "wxactivity/" + resFileName, file);
            SequenceFactoryConfig sequenceFactoryConfig = new SequenceFactoryConfig();
            if (flag == true) {
                bean.setActivityPic("wxactivity/" + resFileName);
                bean.setSite(bean.getProvince() + bean.getCity() + bean.getCounty());
                bean.setActivityId(Long.parseLong(sequenceFactoryConfig.getObject()));
                bean.setStatus("1");
                wxActivityService.doSave(bean);
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
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "WxActivityUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public String putWxActivity(@Valid WxActivityUpdateBO bean){
        wxActivityService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="更新课程状态为审核通过")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "LessonUpdateBO")
    })
    @RequestMapping(value = "/reviewed",method = RequestMethod.PUT)
    public String reviewedLesson(@Valid WxActivityUpdateBO bean){
        bean.setStatus("3");
        wxActivityService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="更新课程状态为审核不通过")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "LessonUpdateBO")
    })
    @RequestMapping(value = "/suggestion",method = RequestMethod.PUT)
    public String suggestionLesson(@Valid WxActivityUpdateBO bean){
        bean.setStatus("2");
        wxActivityService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="更新课程状态为审核下线")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "LessonUpdateBO")
    })
    @RequestMapping(value = "/unline",method = RequestMethod.PUT)
    public String unlineLesson(@Valid WxActivityUpdateBO bean){
        bean.setStatus("5");
        wxActivityService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteWxActivity(Long id) {
        wxActivityService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "WxActivityRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeWxActivity(WxActivityRemoveBO bean) {
        wxActivityService.doRemove(bean);
        return SUCCESS;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
}