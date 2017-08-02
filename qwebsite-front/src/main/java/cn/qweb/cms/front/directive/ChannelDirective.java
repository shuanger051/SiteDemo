package cn.qweb.cms.front.directive;

import cn.qweb.cms.biz.service.ChannelService;
import cn.qweb.cms.biz.service.dto.ChannelDTO;
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
 * Created by xuebj on 2017/4/17.
 */
@Component("channel_bean")
public class ChannelDirective extends BaseDirective implements TemplateDirectiveModel{
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        Long id = DirectiveUtils.getLong(PARAM_ID,params);
        ChannelDTO channel = null;
        if(null != id){
            channel = channelService.get(id);
        }
        setBeanVar(channel,env,params,body);
    }


    @Autowired
    private ChannelService  channelService;
}
