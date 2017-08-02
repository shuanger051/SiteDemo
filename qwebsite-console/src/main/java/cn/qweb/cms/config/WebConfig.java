package cn.qweb.cms.config;

import cn.qweb.cms.core.filter.XssFilter;
import cn.qweb.cms.core.mvc.SystemHttpMessageConverter;
import cn.qweb.cms.jcaptcha.JCaptchaFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.DispatcherType;
import javax.servlet.MultipartConfigElement;
import java.util.List;

/**
 * Created by xuebj on 2017/2/27.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * 设置系统级别的转换器,统一转成json格式
     * @return 返回自定义的转换器
     */
    @Bean
    public SystemHttpMessageConverter httpMessageConverter(){
        return new SystemHttpMessageConverter();
    }

    @Bean
    public FilterRegistrationBean jCaptchaFilter(){
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new JCaptchaFilter());
        filterRegistration.setAsyncSupported(true);
        filterRegistration.addUrlPatterns("/jcaptcha.jpeg");
        filterRegistration.setDispatcherTypes(DispatcherType.REQUEST);
        filterRegistration.setOrder(11);
        return filterRegistration;

    }

    @Bean
    public FilterRegistrationBean shiroRegistrationFilter(){
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
        filterRegistration.setAsyncSupported(true);
        filterRegistration.addInitParameter("targetFilterLifecycle","true");
        filterRegistration.addUrlPatterns("/*");
        filterRegistration.setDispatcherTypes(DispatcherType.REQUEST);
        filterRegistration.setOrder(10);
        return filterRegistration;

    }

    @Bean
    public FilterRegistrationBean xssFilter(){
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean(new XssFilter());
        filterRegistration.addUrlPatterns("/*");
        filterRegistration.setOrder(0);
        return filterRegistration;
    }

    /**
     * {@inheritDoc}
     * <p>This implementation is empty.
     *
     * @param converters    转换器结合,有框架自生成
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.clear();
        converters.add(httpMessageConverter());
//        converters.add(new FormHttpMessageConverter());
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();

        factory.setMaxFileSize("200MB"); //KB,MB

        /// 设置总上传数据总大小

        factory.setMaxRequestSize("2000MB");

        //Sets the directory location wherefiles will be stored.

        //factory.setLocation("路径地址");

        return factory.createMultipartConfig();
    }


//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
//        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
//        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/");
//        registry.addResourceHandler("/upload/**").addResourceLocations("classpath:/static/upload/");
//        super.addResourceHandlers(registry);
//    }
}
