package cn.qweb.cms.shiro;

import cn.qweb.cms.constant.LoginConstant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by xuebj on 2015/12/24.
 */
public class SysUserFilter extends PathMatchingFilter {

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        request.setAttribute(LoginConstant.CURRENT_USER, user);
        return true;
    }
}
