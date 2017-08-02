package cn.qweb.cms.core.mvc;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuebj on 16/7/26.
 */
@Component
@ConfigurationProperties(prefix = "biz")
public class BizProperties {

    private Map<String,String> site = new HashMap<>();


    public Map<String, String> getSite() {
        return site;
    }
}
