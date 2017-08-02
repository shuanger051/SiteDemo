package cn.qweb.cms.front.biz.web;

import cn.qweb.cms.biz.service.ChorgraphyService;
import cn.qweb.cms.biz.service.bo.ChorgraphyAttachmentSaveBO;
import cn.qweb.cms.biz.service.bo.ChorgraphySaveBO;
import cn.qweb.cms.biz.service.dto.ChorgraphyDTO;
import cn.qweb.cms.biz.service.query.ChorgraphyQUERY;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.constants.Constants;
import cn.qweb.cms.core.exception.BizException;
import cn.qweb.cms.core.exception.builder.ErrorBuilder;
import cn.qweb.cms.core.upload.FileRepository;
import cn.qweb.cms.front.biz.web.entity.SessionUser;
import cn.qweb.cms.front.constant.LoginConstant;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

/**
 * Created by xuebj on 2017/5/11.
 */
@RestController
@RequestMapping("/chorgraphy")
@ConfigurationProperties(prefix = "uploadresource")
public class ChorgraphyController extends BaseController{

    @Autowired
    private ChorgraphyService chorgraphyService;

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

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "ChorgraphySaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postChorgraphy(@Valid ChorgraphySaveBO bean, @RequestParam("attachment") MultipartFile[] files, HttpServletRequest request){
        SessionUser user = (SessionUser) request.getSession().getAttribute(LoginConstant.CURRENT_USER);
        //TODO 实现文件上传功能
        List<ChorgraphyAttachmentSaveBO> attachments = new ArrayList<>();
        Arrays.stream(files).forEach(f ->{
            try {
                String fileUrl = fileRepository.storeByExt(basePath + Constants.DANCE_BOOK_PATH, FilenameUtils.getExtension(f.getOriginalFilename()).toLowerCase(), f);
                attachments.add(new ChorgraphyAttachmentSaveBO(fileUrl.replace(basePath, ""),f.getOriginalFilename()));
            } catch (IOException e) {
                throw new BizException(ErrorBuilder.buildBizError("上传文件失败"));
            }
        });
        bean.setAttachments(attachments);
        bean.setUserId(user.getUserId());
        bean.setStatus(1);//待编辑状态
        return chorgraphyService.doSave(bean);
    }


    /**
     * 查询舞谱列表
     * @param bean
     * @return
     */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public Pagination<ChorgraphyDTO> page(@Valid ChorgraphyQUERY bean){
        bean.setStatus(3);//已发布
        return chorgraphyService.list(bean);
    }

    @ApiOperation(value = "内容浏览次统计")
    @ApiImplicitParam(name = "内容id", value = "id", dataType = "java.lang.Long")
    @RequestMapping(value = "/view",method = RequestMethod.GET)
    public String view(@Valid Long id){
        chorgraphyService.doViewUpdate(id);
        return SUCCESS;
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
