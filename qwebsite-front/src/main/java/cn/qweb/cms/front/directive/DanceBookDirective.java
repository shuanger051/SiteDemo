package cn.qweb.cms.front.directive;

import cn.qweb.cms.biz.service.ChorgraphyService;
import cn.qweb.cms.biz.service.dto.ChorgraphyDTO;
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
import java.util.Map;

/**
 * Created by xuebj on 2017/5/12.
 */
@Component("dance_book_next")
public class DanceBookDirective extends BaseDirective implements TemplateDirectiveModel {


    private static final String PARAM_ID = "id";

    /**
     * 输入参数，下一篇。
     */
    private static final String PARAM_NEXT = "next";

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        Long id = DirectiveUtils.getLong(PARAM_ID,params);
        Boolean next = DirectiveUtils.getBool(PARAM_NEXT, params);
        Long channelId = DirectiveUtils.getLong(PARAM_CHANNEL_ID,params);
        ChorgraphyDTO content = chorgraphyService.getNext(id,3,next);//已发布状态
        setBeanVar(content, env, params,body);
    }

    @Autowired
    private ChorgraphyService chorgraphyService;
}
