package cn.qweb.cms.biz.web;
import cn.qweb.cms.biz.service.ContentCheckService;
import cn.qweb.cms.biz.service.ContentService;
import cn.qweb.cms.biz.service.bo.*;
import cn.qweb.cms.biz.service.dto.ContentDTO;
import cn.qweb.cms.biz.service.query.ContentQUERY;
import cn.qweb.cms.core.constants.Constants;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.exception.BizException;
import cn.qweb.cms.core.exception.builder.ErrorBuilder;
import cn.qweb.cms.core.upload.FileRepository;
import cn.qweb.cms.core.utils.PdfBoxUtils;
import cn.qweb.cms.core.utils.StrUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/content")
@ConfigurationProperties(prefix = "uploadresource")
public class ContentController extends BaseController{

    @Autowired
    private ContentService contentService;

    @Autowired
    private ContentCheckService contentCheckService;

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
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "ContentQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<ContentDTO> getContentList(@Valid ContentQUERY bean){
        return contentService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ContentDTO getContent(Long id){
        return contentService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "ContentSaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postContent(@Valid ContentSaveBO bean,String[] attachmentName, String[] attachmentPath,
                            String[] imgPath, String[] picDescription, @Valid ContentExtSaveBO contentExt,
                            @Valid ContentTxtSaveBO contentTxt, @Valid ContentCheckSaveBO checkSave){
        bean.setContentAttachment(getContentAttachments(attachmentName, attachmentPath));
        bean.setContentPicture(getContentPictures(imgPath, picDescription));
        bean.setContentExt(contentExt);
        //需要把正文内容从xssCode 转成原始状态
        contentTxt.setTxt(StrUtil.unescapeHtml(contentTxt.getTxt()));
        contentTxt.setTxt1(StrUtil.unescapeHtml(contentTxt.getTxt1()));
        contentTxt.setTxt2(StrUtil.unescapeHtml(contentTxt.getTxt2()));
        contentTxt.setTxt2(StrUtil.unescapeHtml(contentTxt.getTxt3()));
        bean.setContentTxt(contentTxt);
        bean.setContentCheck(checkSave);
        return contentService.doSave(bean);
    }

    @ApiOperation(value="附件上传")
    @ApiImplicitParam(name = "file", value = "附件列表", required = true, dataType = "MultipartFile")
    @RequestMapping(value = {"/upload_attachment"},method = RequestMethod.POST)
    public List<Map<String,Object>> uploadAttachment(@RequestParam(name = "attachments") MultipartFile[] file,boolean transfer){
        List<Map<String,Object>> result = new ArrayList<>();
        if(null != file && file.length > 0){
            Arrays.stream(file).forEach(f ->{
                try {
                    Map<String,Object> map = new HashMap<>();
                    String fileUrl = fileRepository.storeByExt(basePath + Constants.CONTENT_RESOURCES_PATH, FilenameUtils.getExtension(f.getOriginalFilename()).toLowerCase(),f);
                    File newFile = new File(fileUrl);
                    if (transfer && FilenameUtils.isExtension(f.getOriginalFilename(),"pdf")){//如果需要把pdf转换成图片，并且是pdf
                        List<String> urls = PdfBoxUtils.transfer2Img(newFile, FilenameUtils.getFullPath(newFile.getAbsolutePath()),FilenameUtils.getBaseName(newFile.getAbsolutePath()), PdfBoxUtils.IMG_TYPE_JPG,1500);
                        map.put("urls",urls.stream().map(url-> viewPath +  url.replace(basePath,"")).collect(Collectors.toList()));
                    }
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

    @ApiOperation(value="附件上传")
    @ApiImplicitParam(name = "file", value = "附件列表", required = true, dataType = "MultipartFile")
    @RequestMapping(value = {"/upload_picture"},method = RequestMethod.POST)
    public List<Map<String,String>> uploadPicture(@RequestParam(name = "pictures") MultipartFile[] file){
        List<Map<String,String>> result = new ArrayList<>();
        if(null != file && file.length > 0){
            Arrays.stream(file).forEach(f ->{
                try {
                    String fileUrl = fileRepository.storeByExt(basePath + Constants.CONTENT_RESOURCES_PATH, FilenameUtils.getExtension(f.getOriginalFilename()).toLowerCase(),f);
                    result.add(new HashMap(){{
                        put("imgPath",fileUrl.replace(basePath,""));
                        put("viewPath",viewPath);
                    }});
                } catch (IOException e) {
                    throw new BizException(ErrorBuilder.buildBizError("上传文件失败"));
                }
            });
        }
        return result;
    }

    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "ContentUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public String putContent(@Valid ContentUpdateBO bean,String[] attachmentName,  String[] attachmentPath,
                             String[] imgPath,String[] picDescription,@Valid ContentExtUpdateBO contentExt,
                             @Valid ContentTxtUpdateBO contentTxt){
        bean.setContentAttachment(getContentAttachments(attachmentName, attachmentPath));
        bean.setContentPicture(getContentPictures(imgPath, picDescription));
        getContentPictures(imgPath, picDescription);
        if(StringUtils.isBlank(contentExt.getTitleImg())){
            contentExt.setTitleImg("");
        }
        bean.setContentExt(contentExt);
        //需要把正文内容从xssCode 转成原始状态
        contentTxt.setTxt(StrUtil.unescapeHtml(contentTxt.getTxt()));
        contentTxt.setTxt1(StrUtil.unescapeHtml(contentTxt.getTxt1()));
        contentTxt.setTxt2(StrUtil.unescapeHtml(contentTxt.getTxt2()));
        contentTxt.setTxt3(StrUtil.unescapeHtml(contentTxt.getTxt3()));
        bean.setContentTxt(contentTxt);
        contentService.doUpdate(bean);
        return SUCCESS;
    }

    private List<ContentPictureSaveBO>  getContentPictures(String[] imgPath, String[] picDescription) {
        if(imgPath != null && picDescription != null) {
            //当只有一个参数时，并且值为空的时候 数组长度为0，手动new 一个值 TODO 未探究原因，后续研究
            if(imgPath.length == 1 && imgPath.length != picDescription.length){
                picDescription = new String[1];
                picDescription[0] = "";
            }
            List<ContentPictureSaveBO> pictures = new ArrayList<>();
            for (int i = 0; i < imgPath.length; i++) {
                pictures.add(new ContentPictureSaveBO(imgPath[i],picDescription[i]));
            }
            return pictures;
        }
        return null;
    }

    private  List<ContentAttachmentSaveBO> getContentAttachments(String[] attachmentName, String[] attachmentPath) {
        if(attachmentPath != null && attachmentName !=null && attachmentName.length == attachmentPath.length){
            List<ContentAttachmentSaveBO> attachments = new ArrayList<>();
            for (int i = 0; i < attachmentPath.length; i++) {
                attachments.add(new ContentAttachmentSaveBO(attachmentPath[i],attachmentName[i]));
            }
            return attachments;
        }
        return null;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteContent(Long id) {
        contentService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value = "审核",notes = "审核内容")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value = "/audit", method = RequestMethod.PUT)
    public String audit(@Valid ContentCheckUpdateBO checkUpdateBO){
        contentCheckService.doUpdate(checkUpdateBO);
        return SUCCESS;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public void setViewPath(String viewPath) {
        this.viewPath = viewPath;
    }
}