package cn.qweb.cms.front.config;

import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created by xuebj on 2017/4/10.
 */
@Configuration
public class FreemarkerConfig {

    private static final Logger log = LoggerFactory.getLogger(FreemarkerConfig.class);

    @Autowired
    private freemarker.template.Configuration configuration;

    private final ApplicationContext applicationContext;

    public FreemarkerConfig(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void setSharedVariable() throws TemplateModelException {
        Map<String,TemplateDirectiveModel> directives = applicationContext.getBeansOfType(TemplateDirectiveModel.class);
        for (String key : directives.keySet()) {
            Object obj = directives.get(key);
            if (obj != null && obj instanceof TemplateDirectiveModel) {
                configuration.setSharedVariable(key, obj);
                log.info("初始化标签 " + key);
            }
        }
    }

}
