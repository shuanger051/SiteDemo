package cn.qweb.cms.front.directive;

import cn.qweb.cms.biz.service.IndexSquareService;
import cn.qweb.cms.biz.service.dto.IndexSquareDTO;
import cn.qweb.cms.biz.service.query.IndexSquareQUERY;
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
@Component("index_square_list")
public class IndexSquareListDirective extends BaseDirective implements TemplateDirectiveModel{
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        String isEnable = DirectiveUtils.getString(PARAM_IS_ENABLED,params);
        IndexSquareQUERY queryBean = new IndexSquareQUERY();
        queryBean.setPageSize(100);
        if(null == isEnable){
            queryBean.setIsEnabled("1");
        }else{
            queryBean.setIsEnabled(isEnable);
        }
        List<IndexSquareDTO> list = squareService.list(queryBean).getData();
        setListVar(list,env,params,body);
    }

    @Autowired
    private IndexSquareService squareService;
}
