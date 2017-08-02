package cn.qweb.cms.front.directive;

import cn.qweb.cms.biz.service.ChannelService;
import cn.qweb.cms.biz.service.ContentService;
import cn.qweb.cms.biz.service.dto.ChannelDTO;
import cn.qweb.cms.biz.service.dto.ContentDTO;
import cn.qweb.cms.biz.service.query.ContentQUERY;
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
 * Created by xuebj on 2017/4/11.
 */
@Component("content_list")
public class ContentListDirective extends BaseDirective implements TemplateDirectiveModel {

    private static final String PARAM_IS_FINAL = "isFinal";

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        Long channelId = DirectiveUtils.getLong(PARAM_CHANNEL_ID, params);
        Integer size = DirectiveUtils.getInt(PARAM_SIZE,params);
        ContentQUERY queryBean  = new ContentQUERY();
        queryBean.setPage(1);
        queryBean.setPageSize(null == size? 100: size);
        List<ContentDTO> contents;
        if(null != channelId){
            Boolean isFinal = DirectiveUtils.getBool(PARAM_IS_FINAL,params);
            if(isFinal == null){
                ChannelDTO channel = channelService.get(channelId);
                queryBean.setStatus(channel.getFinalStep());
            }
            queryBean.setChannelId(channelId);
        }
        contents = contentService.list(queryBean).getData();
        setListVar(contents,env,params,body);
    }

    @Autowired
    private ContentService contentService;

    @Autowired
    private ChannelService channelService;
}
