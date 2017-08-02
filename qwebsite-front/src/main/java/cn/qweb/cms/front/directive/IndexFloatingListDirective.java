package cn.qweb.cms.front.directive;

import cn.qweb.cms.biz.service.IndexFloatingService;
import cn.qweb.cms.biz.service.dto.IndexFloatingDTO;
import cn.qweb.cms.biz.service.query.IndexFloatingQUERY;
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
 * Created by xuebj on 2017/4/10.
 */
@Component("index_floating")
public class IndexFloatingListDirective extends BaseDirective implements TemplateDirectiveModel{

    /**
     * 位置
     */
    private final String PARAM_POSITION = "position";

    /**
     * 是否显示
     */
    private final String PARAM_IS_ENABLED = "isEnabled";

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        String position = DirectiveUtils.getString(PARAM_POSITION,params);
        String isEnabled = DirectiveUtils.getString(PARAM_IS_ENABLED,params);
        IndexFloatingQUERY queryBean = new IndexFloatingQUERY();
        queryBean.setPage(1);
        queryBean.setPageSize(100);
        if(StringUtils.isBlank(isEnabled)){
            isEnabled = "1"; //默认获取显示状态
        }
        queryBean.setIsEnabled(isEnabled);
        List<IndexFloatingDTO> floatings;
        if(StringUtils.isNotBlank(position)){
            queryBean.setFloatingPosition(position);
        }
        floatings =  indexFloatingService.list(queryBean).getData();
        setListVar(floatings,env,params,body);
    }

    @Autowired
    private IndexFloatingService indexFloatingService;
}
