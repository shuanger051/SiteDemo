package cn.qweb.cms.front.biz.web;

import cn.qweb.cms.core.entity.JsonResult;
import cn.qweb.cms.core.utils.JacksonUtils;
import cn.qweb.cms.core.utils.RequestUtil;
import cn.qweb.cms.front.biz.web.entity.SessionUser;
import cn.qweb.cms.front.constant.LoginConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xuebj on 2017/5/17.
 */
public class UserFilter extends OncePerRequestFilter{
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        SessionUser user = (SessionUser) request.getSession().getAttribute(LoginConstant.CURRENT_USER);
        if(null == user){
            if(RequestUtil.isAjaxRequest(request)){
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter out = null;
                try {
                    out = response.getWriter();
                    JsonResult result = new JsonResult(Boolean.FALSE,"您未登陆或者已过期");
                    String str = JacksonUtils.toJsonString(result);
                    if(StringUtils.isNotBlank(str)){
                        out.write(str);
                    }
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(out != null){
                        out.close();
                    }
                }
            }else{
                response.sendRedirect("/index.htm");
            }
        }else{
            filterChain.doFilter(request,response);
        }
    }
}
