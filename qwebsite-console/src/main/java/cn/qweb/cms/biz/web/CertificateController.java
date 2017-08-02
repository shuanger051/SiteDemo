package cn.qweb.cms.biz.web;
import cn.qweb.cms.biz.service.CertificateService;
import cn.qweb.cms.biz.service.bo.CertificateRemoveBO;
import cn.qweb.cms.biz.service.bo.CertificateSaveBO;
import cn.qweb.cms.biz.service.bo.CertificateUpdateBO;
import cn.qweb.cms.biz.service.dto.CertificateDTO;
import cn.qweb.cms.biz.service.query.CertificateQUERY;
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


@RestController
@RequestMapping("/certificate")
@ConfigurationProperties(prefix = "uploadresource")
public class CertificateController extends BaseController{

    @Autowired
    private CertificateService certificateService;

    @Autowired
    private FileRepository fileRepository;

    /**
     * 文件存储路径
     */
    private String basePath;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "CertificateQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<CertificateDTO> getCertificateList(@Valid CertificateQUERY bean){
        return certificateService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public CertificateDTO getCertificate(Long id){
        return certificateService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "CertificateSaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postCertificate(@Valid CertificateSaveBO bean,@RequestParam(value = "file") MultipartFile file){
        bean.setImg(saveImg(file));
        bean.setTxt(StrUtil.unescapeHtml(bean.getTxt()));
        return certificateService.doSave(bean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "CertificateUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String putCertificate(@Valid CertificateUpdateBO bean,@RequestParam(value = "file", required = false) MultipartFile file){
        bean.setImg(saveImg(file));
        bean.setTxt(StrUtil.unescapeHtml(bean.getTxt()));
        certificateService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteCertificate(Long id) {
        certificateService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "CertificateRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeCertificate(CertificateRemoveBO bean) {
        certificateService.doRemove(bean);
        return SUCCESS;
    }

    /**
     * 保存头像 并返回 地址
     * @param file
     * @return
     */
    private String saveImg(MultipartFile file) {
        if (null != file) {
            //保存头像
            try {
                String fileUrl = fileRepository.storeByExt(basePath + Constants.CERTIFICATE_IMG_PATH,
                        FilenameUtils.getExtension(file.getOriginalFilename()).toLowerCase(), file);
                return fileUrl.replace(basePath, "");
            } catch (IOException e) {
                throw new BizException(ErrorBuilder.buildBizError("保存证书失败"));
            }
        }
        return null;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
}