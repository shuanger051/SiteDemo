package cn.qweb.cms.biz.web;
import cn.qweb.cms.biz.service.ChorgraphyService;
import cn.qweb.cms.biz.service.bo.*;
import cn.qweb.cms.biz.service.dto.ChorgraphyDTO;
import cn.qweb.cms.biz.service.query.ChorgraphyQUERY;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.*;


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

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "ChorgraphyQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<ChorgraphyDTO> getChorgraphyList(@Valid ChorgraphyQUERY bean){
        return chorgraphyService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ChorgraphyDTO getChorgraphy(Long id){
        return chorgraphyService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "ChorgraphySaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postChorgraphy(@Valid ChorgraphySaveBO bean,String[] attachmentName,  String[] attachmentPath){
        return chorgraphyService.doSave(bean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "ChorgraphyUpdateBO")
    })
    @RequestMapping(value = "/publish",method = RequestMethod.PUT)
    public String publishChorgraphy(Long id){
        chorgraphyService.doPublish(id);
        return SUCCESS;
    }

    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "ChorgraphyUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public String putChorgraphy(@Valid ChorgraphyUpdateBO bean,String[] attachmentName,  String[] attachmentPath){
        List<ChorgraphyAttachmentSaveBO> attachments = getContentAttachments(attachmentName,attachmentPath);
        bean.setAttachments(attachments);
        bean.setStatus(2);//已编辑
        bean.setReleaseDate(null);
        bean.setContent(StrUtil.unescapeHtml(bean.getContent()));
        chorgraphyService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteChorgraphy(Long id) {
        chorgraphyService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "ChorgraphyRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeChorgraphy(ChorgraphyRemoveBO bean) {
        chorgraphyService.doRemove(bean);
        return SUCCESS;
    }



    @ApiOperation(value="附件上传")
    @ApiImplicitParam(name = "file", value = "附件列表", required = true, dataType = "MultipartFile")
    @RequestMapping(value = {"/upload_attachment"},method = RequestMethod.POST)
    public List<Map<String,Object>> uploadAttachment(@RequestParam(name = "attachments") MultipartFile[] file){
        List<Map<String,Object>> result = new ArrayList<>();
        if(null != file && file.length > 0){
            Arrays.stream(file).forEach(f ->{
                try {
                    Map<String,Object> map = new HashMap<>();
                    String fileUrl = fileRepository.storeByExt(basePath + Constants.DANCE_BOOK_PATH, FilenameUtils.getExtension(f.getOriginalFilename()).toLowerCase(),f);
                    map.put("attachmentPath",fileUrl.replace(basePath,""));
                    map.put("attachmentName",f.getOriginalFilename());
                    result.add(map);
                } catch (IOException e) {
                    throw new BizException(ErrorBuilder.buildBizError("上传文件失败"));
                }
            });
        }
        return result;
    }

    private  List<ChorgraphyAttachmentSaveBO> getContentAttachments(String[] attachmentName, String[] attachmentPath) {
        if(attachmentPath != null && attachmentName !=null && attachmentName.length == attachmentPath.length){
            List<ChorgraphyAttachmentSaveBO> attachments = new ArrayList<>();
            for (int i = 0; i < attachmentPath.length; i++) {
                attachments.add(new ChorgraphyAttachmentSaveBO(attachmentPath[i],attachmentName[i]));
            }
            return attachments;
        }
        return null;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public void setViewPath(String viewPath) {
        this.viewPath = viewPath;
    }
}