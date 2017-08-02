package cn.qweb.cms.front.biz.web;

import cn.qweb.cms.biz.service.CredentialsService;
import cn.qweb.cms.biz.service.dto.CredentialsDTO;
import cn.qweb.cms.biz.service.query.CredentialsQUERY;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.core.base.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuebj on 2017/5/10.
 */
@RestController
@RequestMapping("/credential")
public class CredentialsController extends BaseController{

    @Autowired
    private CredentialsService credentialsService;


    /**
     * 查询证书
     * @param bean
     * @return
     */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public Pagination<CredentialsDTO> page(CredentialsQUERY bean){
        return credentialsService.list(bean);
    }
}
