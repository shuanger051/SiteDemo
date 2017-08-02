package cn.qweb.cms.shiro;

import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by xuebj on 2015/12/25.
 */
public class ShiroUserFilter extends UserFilter {

    /**
     * This default implementation simply calls
     * {@link #saveRequestAndRedirectToLogin(ServletRequest, ServletResponse) saveRequestAndRedirectToLogin}
     * and then immediately returns <code>false</code>, thereby preventing the chain from continuing so the redirect may
     * execute.
     *
     * @param request
     * @param response
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if(AJAXUtils.isAjax(WebUtils.toHttp(request))){
            AJAXUtils.print(WebUtils.toHttp(response),401,"未登录或者登录已过期");
            return false;
        }
        return super.onAccessDenied(request, response);
    }
}
