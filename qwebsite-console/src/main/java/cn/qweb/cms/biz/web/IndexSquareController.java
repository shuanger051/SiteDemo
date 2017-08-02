package cn.qweb.cms.biz.web;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.biz.service.IndexSquareService;
import cn.qweb.cms.biz.service.bo.IndexSquareSaveBO;
import cn.qweb.cms.biz.service.query.IndexSquareQUERY;
import cn.qweb.cms.biz.service.bo.IndexSquareRemoveBO;
import cn.qweb.cms.biz.service.dto.IndexSquareDTO;
import cn.qweb.cms.biz.service.bo.IndexSquareUpdateBO;
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
@RequestMapping("/index_square")
@ConfigurationProperties(prefix = "uploadresource")
public class IndexSquareController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(IndexSquareController.class);

    private String basePath;

    @Autowired
    private IndexSquareService indexSquareService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "IndexSquareQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<IndexSquareDTO> getIndexSquareList(@Valid IndexSquareQUERY bean){
        return indexSquareService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public IndexSquareDTO getIndexSquare(Long id){
        return indexSquareService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "IndexSquareSaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String postIndexSquare(@Valid IndexSquareSaveBO bean,@RequestParam(value = "file", required = false) MultipartFile file){

        if (null == file) {
            return FAILURE;
        }

        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String resFileName = UUIDUtil.get32CharsUUID() + suffixName;
        boolean flag = FileUtils.uploadFile(basePath + "index_square/" + resFileName,file);

        if (flag == true){
            bean.setLogo("index_square/" + resFileName);
            indexSquareService.doSave(bean);
            return SUCCESS;
        }else {
            return FAILURE;
        }

    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "IndexSquareUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String putIndexSquare(@Valid IndexSquareUpdateBO bean,@RequestParam(value = "file", required = false) MultipartFile file){

        //判断文件是否存在
        if (null == file) {
            indexSquareService.doUpdate(bean);
            return SUCCESS;
        }else{

            String[] fileNameArr = bean.getOldLogoUrl().split("/");
            String oldFileName = fileNameArr[fileNameArr.length-1];
            boolean flag = FileUtils.uploadFile(basePath + "index_square/" + oldFileName,file);

            if(flag == true){
                bean.setLogo("index_square/" + oldFileName);
                indexSquareService.doUpdate(bean);
                return SUCCESS;
            }else {
                return FAILURE;
            }

        }


    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteIndexSquare(Long id,String fileName) {

        boolean flag = FileUtils.delFile(basePath + fileName);
        if (flag == false){
            return FAILURE;
        }else{
            indexSquareService.doRemove(id);
            return SUCCESS;
        }

    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "IndexSquareRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeIndexSquare(IndexSquareRemoveBO bean) {
        indexSquareService.doRemove(bean);
        return SUCCESS;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

}