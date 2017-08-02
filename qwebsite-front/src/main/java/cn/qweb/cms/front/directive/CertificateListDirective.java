package cn.qweb.cms.front.directive;

import cn.qweb.cms.biz.service.CertificateService;
import cn.qweb.cms.biz.service.dto.CertificateDTO;
import cn.qweb.cms.biz.service.query.CertificateQUERY;
import cn.qweb.cms.core.freemarker.BaseDirective;
import cn.qweb.cms.core.freemarker.DirectiveUtils;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by xuebj on 2017/4/11.
 */
@Component("certificate_list")
public class CertificateListDirective extends BaseDirective implements TemplateDirectiveModel{

    private static final String PARAM_SIZE = "size";

    private static final String PARAM_TYPE = "type";

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        Integer size = DirectiveUtils.getInt(PARAM_SIZE, params);
        String type = DirectiveUtils.getString(PARAM_TYPE,params);
        String isEnabled = DirectiveUtils.getString("isEnabled",params);
        CertificateQUERY queryBean = new CertificateQUERY();
        queryBean.setPageSize(null == size ? 8 : size);
        if(StringUtils.isNotBlank(type)){
            queryBean.setType(type);
        }
        if(StringUtils.isNotEmpty(isEnabled)){
            queryBean.setIsEnabled(isEnabled);
        }else{
            queryBean.setIsEnabled("1");
        }
        List<CertificateDTO> certificates = certificateService.list(queryBean).getData();
        setListVar(certificates,env,params,body);
    }

    @Autowired
    private CertificateService certificateService;
}
