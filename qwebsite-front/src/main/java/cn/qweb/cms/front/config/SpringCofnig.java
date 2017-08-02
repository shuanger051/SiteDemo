package cn.qweb.cms.front.config;

import cn.qweb.cms.core.mvc.ShiroPasswordService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xuebj on 2017/4/18.
 */
@Configuration
public class SpringCofnig {

    @Bean
    public ShiroPasswordService passwordService(){
        return new ShiroPasswordService();
    }
}
