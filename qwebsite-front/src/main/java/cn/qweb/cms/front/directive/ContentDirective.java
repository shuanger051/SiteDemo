package cn.qweb.cms.front.directive;

import cn.qweb.cms.biz.service.ContentService;
import cn.qweb.cms.biz.service.dto.ContentDTO;
import cn.qweb.cms.core.exception.BizException;
import cn.qweb.cms.core.exception.builder.ErrorBuilder;
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
 * Created by xuebj on 2017/4/11.
 */
@Component("content_bean")
public class ContentDirective extends BaseDirective implements TemplateDirectiveModel{

    private static final String PARAM_ID = "id";

    /**
     * 输入参数，下一篇。
     */
    private static final String PARAM_NEXT = "next";


    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        Long id = DirectiveUtils.getLong(PARAM_ID,params);
        Boolean next = DirectiveUtils.getBool(PARAM_NEXT, params);
        ContentDTO content = null;
        if(next == null){
            if(null != id){
                content = contentService.get(id);
            }else{
                throw new BizException(ErrorBuilder.buildBizError(PARAM_ID + "参数不能为空"));
            }
        }else{
            Long channelId = DirectiveUtils.getLong(PARAM_CHANNEL_ID,params);
            content = contentService.getNext(id,channelId,next);
        }
        setBeanVar(content, env, params,body);
    }

    @Autowired
    private ContentService contentService;
}
