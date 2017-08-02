package cn.qweb.cms.front.config;

import com.github.pagehelper.PageHelper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xuebj on 2017/2/23.
 */
@Configuration
@EnableConfigurationProperties(PageHelperProperties.class)
public class MybatisPluginConfig {


    @Bean
    public PageHelper pageHelper(PageHelperProperties pageHelperProperties){
        //分页插件
        PageHelper pageHelper = new PageHelper();
        pageHelper.setProperties(pageHelperProperties.getProperties());
        return pageHelper;
    }
}
