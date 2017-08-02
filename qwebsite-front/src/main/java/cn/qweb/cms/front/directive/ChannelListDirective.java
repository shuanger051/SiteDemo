package cn.qweb.cms.front.directive;

import cn.qweb.cms.biz.service.ChannelService;
import cn.qweb.cms.biz.service.dto.ChannelDTO;
import cn.qweb.cms.biz.service.query.ChannelQUERY;
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
 * Created by xuebj on 2017/4/12.
 */
@Component("channel_list")
public class ChannelListDirective extends BaseDirective implements TemplateDirectiveModel{

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        Long parentId = DirectiveUtils.getLong(PARAM_PARENT_ID,params);
        String isEnabled = DirectiveUtils.getString(PARAM_IS_ENABLED,params);
        if(StringUtils.isBlank(isEnabled)){
            isEnabled = "1";
        }
        ChannelQUERY queryBean = new ChannelQUERY();
        queryBean.setPageSize(100);
        queryBean.setIsDisplay(isEnabled);
        if(parentId != null){
            queryBean.setParentId(parentId);
        }
        List<ChannelDTO> channels = channelService.list(queryBean).getData();
        setListVar(channels,env,params,body);

    }

    @Autowired
    private ChannelService channelService;
}
