package cn.qweb.cms.biz.web;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.biz.service.CooperativePartnerService;
import cn.qweb.cms.biz.service.bo.CooperativePartnerSaveBO;
import cn.qweb.cms.biz.service.query.CooperativePartnerQUERY;
import cn.qweb.cms.biz.service.bo.CooperativePartnerRemoveBO;
import cn.qweb.cms.biz.service.dto.CooperativePartnerDTO;
import cn.qweb.cms.biz.service.bo.CooperativePartnerUpdateBO;
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
import java.util.Date;


@RestController
@RequestMapping("/partner")
@ConfigurationProperties(prefix = "uploadresource")
public class CooperativePartnerController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(CooperativePartnerController.class);

    private String basePath;

    @Autowired
    private CooperativePartnerService cooperativePartnerService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "CooperativePartnerQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<CooperativePartnerDTO> getCooperativePartnerList(@Valid CooperativePartnerQUERY bean){
        return cooperativePartnerService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public CooperativePartnerDTO getCooperativePartner(Long id){
        return cooperativePartnerService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "CooperativePartnerSaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String postCooperativePartner(@Valid CooperativePartnerSaveBO bean,@RequestParam(value = "file", required = false) MultipartFile file){

        if (null == file) {
            return FAILURE;
        }

        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String resFileName = UUIDUtil.get32CharsUUID() + suffixName;
        boolean flag = FileUtils.uploadFile(basePath + "partner/" + resFileName,file);

        //添加用户操作
        if (flag == true){
            bean.setLogo("partner/" + resFileName);
            cooperativePartnerService.doSave(bean);
            return SUCCESS;
        }else {
            return FAILURE;
        }

    }

    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "CooperativePartnerUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String putCooperativePartner(@Valid CooperativePartnerUpdateBO bean,@RequestParam(value = "file", required = false) MultipartFile file){
        if (null == file) {
            cooperativePartnerService.doUpdate(bean);
            return SUCCESS;
        }else{
            String[] fileNameArr = bean.getOldLogoUrl().split("/");
            String oldFileName = fileNameArr[fileNameArr.length-1];
            boolean flag = FileUtils.uploadFile(basePath + "partner/"  + oldFileName,file);
            if(flag == true){
                //添加合作伙伴操作
                bean.setLogo("partner/" + oldFileName);
                cooperativePartnerService.doUpdate(bean);
                return SUCCESS;
            }else {
                return FAILURE;
            }
        }
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteCooperativePartner(Long id,String fileName) {
        boolean flag = FileUtils.delFile(basePath +fileName);
        if (flag == false){
            return FAILURE;
        }else{
            cooperativePartnerService.doRemove(id);
            return SUCCESS;
        }
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "CooperativePartnerRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeCooperativePartner(CooperativePartnerRemoveBO bean) {
        cooperativePartnerService.doRemove(bean);
        return SUCCESS;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
}