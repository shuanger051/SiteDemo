package cn.qweb.cms.shiro;

import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by xuebj on 2015/12/16.
 */
public class ShiroPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter {

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        return super.isAccessAllowed(request, response, buildPermissions(request));
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        //处理异步请求
        if(AJAXUtils.isAjax(WebUtils.toHttp(request))){
            AJAXUtils.print(WebUtils.toHttp(response),403,"无权限");
            return false;
        }
        return super.onAccessDenied(request, response);
    }

    /**
     * 根据请求URL产生权限字符串，这里只产生，而比对的事交给Realm
     * @param request
     * @return
     */
    protected String[] buildPermissions(ServletRequest request) {
        String[] perms = new String[1];
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getServletPath();
        if(path.indexOf("?") != -1){
            path = path.substring(0,path.indexOf("?"));
        }
        perms[0] = path;//path直接作为权限字符串

        /*String regex = "/(.*?)/(.*?)\\.(.*)";
        if(url.matches(regex)){
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(url);
            String controller =  matcher.group(1);
            String action = matcher.group(2);

        }*/
        return perms;
    }
}
