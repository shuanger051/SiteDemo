package cn.qweb.cms.front.directive;

import cn.qweb.cms.biz.service.NavigationService;
import cn.qweb.cms.biz.service.dto.NavigationDTO;
import cn.qweb.cms.core.freemarker.BaseDirective;
import cn.qweb.cms.core.freemarker.DirectiveUtils;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Map;

/**
 * Created by xuebj on 2017/4/10.
 */
public class NavigationDirectvie extends BaseDirective implements TemplateDirectiveModel{

    /**
     * 菜单id
     */
    public static final String PARAM_ID = "id";


    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        Long id = DirectiveUtils.getLong(PARAM_ID, params);
        NavigationDTO nav = null;
        if(null != id){
            nav = navigationService.get(id);
        }
        setBeanVar(nav, env, params,body);
    }

    @Autowired
    private NavigationService navigationService;
}
