package cn.qweb.cms.front.biz.web;

import cn.qweb.cms.core.mvc.BaseForwardController;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  站点切换
 * Created by xuebj on 2017/4/14.
 */
@ControllerAdvice(assignableTypes = {BaseForwardController.class})
public class FrontSiteIntercept implements Ordered{

    private static List<String> sites = new ArrayList<>();

    static {
        sites.add("line");
        sites.add("square");
    }

    @ModelAttribute("s")
    public Map<String,Object> root(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> root = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        if(cookies != null){
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equalsIgnoreCase("site")) { //获取键
                    cookie = cookies[i];
                }
            }
        }
        if (cookie != null && sites.contains(cookie.getValue())) {
            root.put("site", cookie.getValue());
        } else {
            cookie = new Cookie("site","line");
            cookie.setPath(request.getContextPath());
            cookie.setMaxAge(3600*24*7);
            cookie.setPath(request.getContextPath().equals("")?"/":request.getContextPath());
            response.addCookie(cookie);
            root.put("site", "line");//默认排舞
        }
        return root;
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
