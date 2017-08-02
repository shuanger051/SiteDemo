package cn.qweb.cms.shiro;

import cn.qweb.cms.biz.service.bo.LoginInfoBo;
import cn.qweb.cms.core.crypto.RSACryptoHelper;
import cn.qweb.cms.core.utils.IpUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xuebj on 2015/12/16.
 */
public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {

    private Boolean alwaysToSuccessUrl=Boolean.FALSE;

    private IShiroUserService userService;

    /**
     * Determines whether the current subject should be allowed to make the current request.
     * <p/>
     * The default implementation returns <code>true</code> if the user is authenticated.  Will also return
     * <code>true</code> if the {@link #isLoginRequest} returns false and the &quot;permissive&quot; flag is set.
     *
     * @param request
     * @param response
     * @param mappedValue
     * @return <code>true</code> if request should be allowed access
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        Subject subject = getSubject(request, response);

        if(subject.isAuthenticated()){//已经登录
            if(isLoginRequest(request, response)){//登录请求，允许用户在同一会话期间重复登录
                return false;
            }
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        ShiroUser user = ShiroUserUtils.toUser(subject.getPrincipal());
        //更新用户登录信息
        LoginInfoBo bean = new LoginInfoBo();
        bean.setUserName(String.valueOf(token.getPrincipal()));
        bean.setLastLoginIp(IpUtil.getRemoteAddr((HttpServletRequest) request));
        userService.updateUserLoginInfo(bean);
        if(AJAXUtils.isAjax(WebUtils.toHttp(request))){//ajax
            AJAXUtils.print(WebUtils.toHttp(response), Boolean.TRUE,200,user.getUserName());
            return false;
        }
        if(alwaysToSuccessUrl){
            String successUrl = this.getSuccessUrl();
            if (successUrl == null) {
                throw new IllegalStateException("Success URL not available via saved request or via the " +
                        "successUrlFallback method parameter. One of these must be non-null for " +
                        "issueSuccessRedirect() to work.");
            }
            WebUtils.issueRedirect(request, response, successUrl, null, true);
            return  false;
        }else{
            return super.onLoginSuccess(token, subject, request, response);
        }
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        //更新用户登录信息
        LoginInfoBo bean = new LoginInfoBo();
        bean.setUserName(String.valueOf(token.getPrincipal()));
        bean.setErrorIp(IpUtil.getRemoteAddr((HttpServletRequest) request));
        userService.updateUserLoginInfo(bean);
        String msg;
        if(!(e instanceof ForbiddenException)){
            msg = "用户名或者密码错误";
        }else{
            msg = e.getMessage();
        }
        if(AJAXUtils.isAjax((HttpServletRequest) request)){//ajax
            AJAXUtils.print((HttpServletResponse) response,401,msg);
            return false;
        }else{
            request.setAttribute(getFailureKeyAttribute(), msg);
            return true;
        }
    }



    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if(request.getAttribute(getFailureKeyAttribute()) !=null) {
            return true;
        }
        return super.onAccessDenied(request, response);
    }

    /**
     * 登录成功之后是否总是跳转到成功页
     * @param alwaysToSuccessUrl
     */
    public void setAlwaysToSuccessUrl(Boolean alwaysToSuccessUrl) {
        this.alwaysToSuccessUrl = alwaysToSuccessUrl;
    }


    @Override
    protected String getPassword(ServletRequest request) {
        String password = super.getPassword(request);
        return RSACryptoHelper.decrypt(password);
    }

    public IShiroUserService getUserService() {
        return userService;
    }

    public void setUserService(IShiroUserService userService) {
        this.userService = userService;
    }
}
