package cn.qweb.cms.config;

import cn.qweb.cms.core.mvc.ShiroPasswordService;
import cn.qweb.cms.jcaptcha.JCaptchaValidateFilter;
import cn.qweb.cms.shiro.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.ServletContainerSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by xuebj on 2017/1/13.
 */
@Configuration
public class ShiroConfig {

    private static final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

    @Bean
    public MemoryConstrainedCacheManager memoryConstrainedCacheManager(){
        return new MemoryConstrainedCacheManager();
    }

    @Bean
    public RetryLimitHashedCredentialsMatcher credentialsMatcher(@Autowired MemoryConstrainedCacheManager cacheManager){
        RetryLimitHashedCredentialsMatcher credentialsMatcher = new RetryLimitHashedCredentialsMatcher(cacheManager);
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(2);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }

    @Bean
    public ShiroPasswordService shiroPasswordService(){
        return new ShiroPasswordService();
    }

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Bean
    public ShiroDBRealm shiroDBRealm(CredentialsMatcher credentialsMatcher, ShiroPasswordService passwordService, IShiroUserService shiroUserService){
        ShiroDBRealm realm = new ShiroDBRealm();
        realm.setCredentialsMatcher(credentialsMatcher);
        realm.setCachingEnabled(false);
        realm.setShiroPasswordService(passwordService);
        realm.setShiroUserService(shiroUserService);
        return realm;
    }

    @Bean
    public ServletContainerSessionManager sessionManager(){
        return new ServletContainerSessionManager();
    }

    @Bean
    public SecurityManager securityManager(ShiroDBRealm shiroDBRealm, SessionManager sessionManager){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager(shiroDBRealm);
        manager.setSessionManager(sessionManager);
        return manager;
    }

    @Bean
    public MethodInvokingFactoryBean methodInvokingFactoryBean(SecurityManager securityManager){
        MethodInvokingFactoryBean bean = new MethodInvokingFactoryBean();
        bean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        bean.setArguments(new Object[]{securityManager});
        return bean;
    }

    public ShiroFormAuthenticationFilter shiroFormAuthenticationFilter(IShiroUserService shiroUserService){
        ShiroFormAuthenticationFilter shiroFormAuthenticationFilter = new ShiroFormAuthenticationFilter();
        shiroFormAuthenticationFilter.setUsernameParam("username");
        shiroFormAuthenticationFilter.setPasswordParam("password");
        shiroFormAuthenticationFilter.setAlwaysToSuccessUrl(Boolean.TRUE);
        shiroFormAuthenticationFilter.setUserService(shiroUserService);
        return shiroFormAuthenticationFilter;
    }

    public ShiroPermissionsAuthorizationFilter authorizationFilter(){
        return new ShiroPermissionsAuthorizationFilter();
    }


    //    @Bean
    public SysUserFilter sysUserFilter(){
        return new SysUserFilter();
    }

    //    @Bean
    public ShiroUserFilter shiroUserFilter(){
        return new ShiroUserFilter();
    }


    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager,IShiroUserService shiroUserService){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        factoryBean.setLoginUrl("/login");
        factoryBean.setSuccessUrl("/index.htm");
        factoryBean.setUnauthorizedUrl("/403.htm");
        Map<String,Filter> filters = new HashMap<>();
        filters.put("authc", shiroFormAuthenticationFilter(shiroUserService));
        filters.put("perm", authorizationFilter());
        filters.put("sysUser", sysUserFilter());
        filters.put("user", shiroUserFilter());
        filters.put("captcha",new JCaptchaValidateFilter());
        factoryBean.setFilters(filters);

        Map<String,String> chainMap = new LinkedHashMap<>();
        chainMap.put("/login", "captcha,authc");//anon    authc
        chainMap.put("/logout", "logout");
        chainMap.put("/crypto/**", "anon");//加密类
        chainMap.put("/jcaptcha.jpeg","anon");//验证码拦截器
        chainMap.put("/helper/**","anon");
        chainMap.put("/index", "anon");
        chainMap.put("/login.htm", "anon");
        chainMap.put("/403.htm", "anon");
        chainMap.put("/404.htm", "anon");
        chainMap.put("/css/**","anon");
        chainMap.put("/images/**","anon");
        chainMap.put("/js/**","anon");
        chainMap.put("/upload/**","anon");
        chainMap.put("/sys/user/modify_pwd.htm","user,sysUser");
        chainMap.put("/sys/user/account/modify/pwd","user,sysUser");
        chainMap.put("/index.htm","user,sysUser");
        chainMap.put("/left.htm","user,sysUser");
        chainMap.put("/top.htm","user,sysUser");
        chainMap.put("/footer.htm","user,sysUser");
        chainMap.put("/main.htm","user,sysUser");
        chainMap.put("/welcome.htm","user,sysUser");
        chainMap.put("/**", "user,sysUser,perm");
        factoryBean.setFilterChainDefinitionMap(chainMap);
        return factoryBean;
    }


    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

}
