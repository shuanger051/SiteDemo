package cn.qweb.cms.front.directive;

import cn.qweb.cms.core.dictionary.DictManager;
import cn.qweb.cms.core.dictionary.Item;
import cn.qweb.cms.core.freemarker.BaseDirective;
import cn.qweb.cms.core.freemarker.DirectiveUtils;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by xuebj on 2017/4/19.
 */
@Component("dict")
public class DictDirective extends BaseDirective implements TemplateDirectiveModel{

    private static final String PARAM_ENTRY = "entry";

//    private static final String PARAM_ITEM = "item";

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        String entry = DirectiveUtils.getString(PARAM_ENTRY, params);
        if(StringUtils.isNotBlank(entry)){
            List<Item> items = DictManager.getEntry(entry);
            setListVar(items,env,params,body);
        }
    }
}
