package cn.qweb.cms.front.directive;

import cn.qweb.cms.biz.service.FriendlinkService;
import cn.qweb.cms.biz.service.dto.FriendlinkDTO;
import cn.qweb.cms.biz.service.query.FriendlinkQUERY;
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
 * Created by xuebj on 2017/4/11.
 */
@Component("friendlink_list")
public class FriendLinkListDriective extends BaseDirective implements TemplateDirectiveModel{
    /**
     * 条数
     */
    private static final String PARAM_SIZE = "size";

    /**
     * 默认1 表示显示
     */
    private static final String PARAM_IS_ENABLED = "isEnabled";

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        String isEnabled = DirectiveUtils.getString(PARAM_IS_ENABLED,params);
        Integer size = DirectiveUtils.getInt(PARAM_SIZE,params);
        FriendlinkQUERY queryBean = new FriendlinkQUERY();
        queryBean.setIsEnabled(StringUtils.isBlank(isEnabled)? "1":null);
        queryBean.setPageSize(null == size ? 100 : size);
        List<FriendlinkDTO> list = friendlinkService.list(queryBean).getData();
        setListVar(list,env,params,body);
    }

    @Autowired
    private FriendlinkService friendlinkService;
}
