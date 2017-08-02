package cn.qweb.cms.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

/**
 * Created by xuebj on 16/8/8.
 */
@ConfigurationProperties(prefix = "system.pagehelper")
public class PageHelperProperties {

    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
