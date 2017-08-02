package cn.qweb.cms.biz.web;

import cn.qweb.cms.biz.service.IndexFloatingService;
import cn.qweb.cms.biz.service.bo.IndexFloatingRemoveBO;
import cn.qweb.cms.biz.service.bo.IndexFloatingSaveBO;
import cn.qweb.cms.biz.service.bo.IndexFloatingUpdateBO;
import cn.qweb.cms.biz.service.dto.IndexFloatingDTO;
import cn.qweb.cms.biz.service.query.IndexFloatingQUERY;
import cn.qweb.cms.core.base.BaseController;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Date;


@RestController
@RequestMapping("/index_floating")
@ConfigurationProperties(prefix = "uploadresource")
public class IndexFloatingController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(IndexFloatingController.class);

    private String basePath;

    @Autowired
    private IndexFloatingService indexFloatingService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "IndexFloatingQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<IndexFloatingDTO> getIndexFloatingList(@Valid IndexFloatingQUERY bean){
        return indexFloatingService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public IndexFloatingDTO getIndexFloating(Long id){
        return indexFloatingService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "IndexFloatingSaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String postIndexFloating(@Valid IndexFloatingSaveBO bean,@RequestParam(value = "file", required = false) MultipartFile file){

        if (null == file) {
            return FAILURE;
        }

        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String resFileName = UUIDUtil.get32CharsUUID() + suffixName;
        boolean flag = FileUtils.uploadFile(basePath + "index_floating/" + resFileName,file);

        //添加首页浮窗操作
        if (flag == true){
            bean.setLogo("index_floating/" + resFileName);
            indexFloatingService.doSave(bean);
            return SUCCESS;
        }else {
            return FAILURE;
        }

    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "IndexFloatingUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String putIndexFloating(@Valid IndexFloatingUpdateBO bean,@RequestParam(value = "file", required = false) MultipartFile file){
        //判断文件是否存在
        if (null == file) {
            indexFloatingService.doUpdate(bean);
            return SUCCESS;
        }else{

            String[] fileNameArr = bean.getOldLogoUrl().split("/");
            String oldFileName = fileNameArr[fileNameArr.length-1];
            boolean flag = FileUtils.uploadFile(basePath + "index_floating/" + oldFileName,file);

            if(flag == true){
                bean.setLogo("index_floating/" + oldFileName);
                indexFloatingService.doUpdate(bean);
                return SUCCESS;
            }else {
                return FAILURE;
            }

        }
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteIndexFloating(Long id,String fileName) {

        boolean flag = FileUtils.delFile(basePath + fileName);
        if (flag == false){
            return FAILURE;
        }else{
            indexFloatingService.doRemove(id);
            return SUCCESS;
        }
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "IndexFloatingRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeIndexFloating(IndexFloatingRemoveBO bean) {
        indexFloatingService.doRemove(bean);
        return SUCCESS;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
}