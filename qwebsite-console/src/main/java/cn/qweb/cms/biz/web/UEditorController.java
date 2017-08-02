package cn.qweb.cms.biz.web;

import cn.qweb.cms.core.constants.Constants;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.core.entity.UEditeUploadResult;
import cn.qweb.cms.core.upload.FileRepository;
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

import java.io.IOException;

/**
 * Created by xuebj on 2017/3/30.
 */
@RestController
@RequestMapping("/ueditor")
@ConfigurationProperties(prefix = "uploadresource")
public class UEditorController extends BaseController{

    @Autowired
    private FileRepository fileRepository;

    private String basePath;

    private String viewPath;

    @ApiOperation("ueditor文件上传功能")
    @ApiImplicitParams({
            @ApiImplicitParam(name="file", value = "上传文件",required = true, dataType = "MultipartFile"),
            @ApiImplicitParam(name = "action", value = "上传文件类型", required = true, dataType = "String")
    })
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public UEditeUploadResult upload(@RequestParam("upfile") MultipartFile file, String action){
        UEditeUploadResult result = new UEditeUploadResult();
        if(null != file){
            String original = file.getOriginalFilename();
            try {
                String fileUrl = fileRepository.storeByExt(basePath + Constants.CONTENT_RESOURCES_PATH, FilenameUtils.getExtension(original).toLowerCase(),file);
                result.setState(SUCCESS.toUpperCase());
                result.setOriginal(original);
                result.setTitle(original);
                result.setUrl(viewPath + fileUrl.replace(basePath,""));
                return result;
            } catch (IOException e) {
                e.printStackTrace();
                result.setState("上传文件失败");
            }
        }
        return result;
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
