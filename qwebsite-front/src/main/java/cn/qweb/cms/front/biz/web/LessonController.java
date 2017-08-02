package cn.qweb.cms.front.biz.web;

import cn.qweb.cms.biz.service.LessonService;
import cn.qweb.cms.biz.service.bo.LessonSaveBO;
import cn.qweb.cms.biz.service.dto.LessonDTO;
import cn.qweb.cms.biz.service.dto.LessonNumberDTO;
import cn.qweb.cms.biz.service.query.LessonQUERY;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.exception.BizException;
import cn.qweb.cms.core.exception.builder.ErrorBuilder;
import cn.qweb.cms.core.upload.FileRepository;
import cn.qweb.cms.core.utils.FileUtils;
import cn.qweb.cms.core.utils.StrUtil;
import cn.qweb.cms.core.utils.UUIDUtil;
import cn.qweb.cms.front.biz.web.entity.SessionUser;
import cn.qweb.cms.front.constant.LoginConstant;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by xuebj on 2017/5/15.
 */
@RestController
@RequestMapping("/lesson")
@ConfigurationProperties(prefix = "uploadresource")
public class LessonController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(LessonController.class);

    @Autowired
    private LessonService lessonService;

    @Autowired
    private FileRepository fileRepository;
    /**
     * 文件存储路径
     */
    private String basePath;

    /**
     * 文件访问路径
     */
    private String viewPath;

    @ApiOperation("查询课程列表")
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public Pagination<LessonDTO> page(LessonQUERY bean, HttpServletRequest request){
        SessionUser user = (SessionUser) request.getSession().getAttribute(LoginConstant.CURRENT_USER);
        bean.setTeacherId(user.getUserId());
        return lessonService.list(bean);
    }

    @ApiOperation("查询课程数量")
    @RequestMapping(value = "/number",method = RequestMethod.GET)
    public LessonNumberDTO number(LessonQUERY bean, HttpServletRequest request){
        SessionUser user = (SessionUser) request.getSession().getAttribute(LoginConstant.CURRENT_USER);
        bean.setTeacherId(user.getUserId());
        return lessonService.queryLessonNumber(bean);
    }

    @ApiOperation("保存课程")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String postLesson(@Valid LessonSaveBO bean, @RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request){
        if (null == file) {
            throw new BizException(ErrorBuilder.buildBizError("未上传封面"));
        }
        if(StringUtils.isNotBlank(bean.getContent())){
            bean.setContent(StrUtil.unescapeHtml(bean.getContent()));
        }
        SessionUser user = (SessionUser) request.getSession().getAttribute(LoginConstant.CURRENT_USER);
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String resFileName = UUIDUtil.get32CharsUUID() + suffixName;
        boolean flag = FileUtils.uploadFile(basePath + "lesson/" + resFileName, file);
//            SequenceFactoryConfig sequenceFactoryConfig = new SequenceFactoryConfig();
        if (flag == true) {
            bean.setLessonPic("lesson/" + resFileName);
            bean.setSite(bean.getProvince() + bean.getCity() + bean.getCounty());
            bean.setLessonId(UUIDUtil.getUUID());
            bean.setStatus("1");
            bean.setTeacherId(user.getUserId());
            bean.setTeacherName(user.getRealName());
            lessonService.doSave(bean);
            return SUCCESS;
        } else {
            return FAILURE;
        }
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getViewPath() {
        return viewPath;
    }

    public void setViewPath(String viewPath) {
        this.viewPath = viewPath;
    }
}
