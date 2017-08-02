package cn.qweb.cms.front.directive;

import cn.qweb.cms.biz.service.NavigationService;
import cn.qweb.cms.biz.service.dto.NavigationDTO;
import cn.qweb.cms.biz.service.query.NavigationQUERY;
import cn.qweb.cms.core.freemarker.BaseDirective;
import cn.qweb.cms.core.freemarker.DirectiveUtils;
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
 * 导航菜单查询标签
 * Created by xuebj on 2017/4/10.
 */
@Component("nav_list")
public class NavigationListDirectvie extends BaseDirective implements TemplateDirectiveModel{

    /**
     * 菜单id
     */
    public static final String PARAM_PARENT_ID = "parentId";


    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        Long parentId = DirectiveUtils.getLong(PARAM_PARENT_ID, params);
        List<NavigationDTO> nav = null;
        if(null != parentId){
            NavigationQUERY queryBean = new NavigationQUERY();
            queryBean.setPageSize(100);
            queryBean.setPage(1);
            queryBean.setParentId(parentId);
            nav = navigationService.list(queryBean).getData();
        }
        setListVar(nav,env,params,body);
    }

    @Autowired
    private NavigationService navigationService;
}
