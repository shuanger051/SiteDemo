package cn.qweb.cms.front.directive;

import cn.qweb.cms.biz.service.CooperativePartnerService;
import cn.qweb.cms.biz.service.dto.CooperativePartnerDTO;
import cn.qweb.cms.biz.service.query.CooperativePartnerQUERY;
import cn.qweb.cms.core.freemarker.BaseDirective;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by xuebj on 2017/4/11.
 */
@Component("partner_list")
public class PartnerListDirective extends BaseDirective implements TemplateDirectiveModel{
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {

        CooperativePartnerQUERY queryBean = new CooperativePartnerQUERY();
        queryBean.setPageSize(100);
        List<CooperativePartnerDTO> list =  partnerService.list(queryBean).getData();
        setListVar(list,env,params,body);
    }


    @Autowired
    private CooperativePartnerService partnerService;
}
