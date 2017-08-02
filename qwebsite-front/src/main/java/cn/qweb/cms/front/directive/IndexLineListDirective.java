package cn.qweb.cms.front.directive;

import cn.qweb.cms.biz.service.IndexLineService;
import cn.qweb.cms.biz.service.dto.IndexLineDTO;
import cn.qweb.cms.biz.service.query.IndexLineQUERY;
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
 * Created by xuebj on 2017/4/14.
 */
@Component("index_line_list")
public class IndexLineListDirective extends BaseDirective implements TemplateDirectiveModel{
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        String isEnable = DirectiveUtils.getString(PARAM_IS_ENABLED,params);
        IndexLineQUERY queryBean = new IndexLineQUERY();
        queryBean.setPageSize(100);
        if(null == isEnable){
            queryBean.setIsEnabled("1");
        }else{
            queryBean.setIsEnabled(isEnable);
        }
        List<IndexLineDTO> list = lineService.list(queryBean).getData();
        setListVar(list,env,params,body);
    }

    @Autowired
    private IndexLineService lineService;
}
