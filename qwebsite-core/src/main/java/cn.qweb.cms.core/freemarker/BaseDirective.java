package cn.qweb.cms.core.freemarker;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuebj on 2017/4/11.
 */
public class BaseDirective {
    /**
     * 默认1 表示显示
     */
    protected static final String PARAM_IS_ENABLED = "isEnabled";

    /**
     * 条数
     */
    protected static final String PARAM_SIZE = "size";

    /**
     * 父id
     */
    protected static final String PARAM_PARENT_ID = "parentId";
    /**
     * 栏目id
     */
    protected static final String PARAM_CHANNEL_ID = "channelId";

    /**
     * id
     */
    protected static final String PARAM_ID = "id";

    protected <T> void  setListVar(List<T> list, Environment env, Map params, TemplateDirectiveBody body) throws TemplateException, IOException {
        Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(
                params);
        if(null != list){
            paramWrap.put(DirectiveUtils.OUT_LIST, DefaultObjectWrapperBuilderFactory.getDefaultObjectWrapper().wrap(list));
        }
        Map<String, TemplateModel> origMap = DirectiveUtils.addParamsToVariable(env, paramWrap);
        if (body != null) {
            body.render(env.getOut());
        }
        DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);
    }

    protected <T> void setBeanVar(T bean,Environment env, Map params, TemplateDirectiveBody body) throws TemplateException, IOException {
        Map<String, TemplateModel> paramWrap = new HashMap<>(params);
        if(null != bean){
            paramWrap.put(DirectiveUtils.OUT_BEAN, DefaultObjectWrapperBuilderFactory.getDefaultObjectWrapper().wrap(bean));
        }
        Map<String, TemplateModel> origMap = DirectiveUtils.addParamsToVariable(env, paramWrap);
        if (body != null) {
            body.render(env.getOut());
        }
        DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);
    }
}
