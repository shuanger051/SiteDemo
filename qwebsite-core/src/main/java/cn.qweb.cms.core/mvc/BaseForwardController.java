package cn.qweb.cms.core.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by xuebj on 2017/4/12.
 */
public class BaseForwardController {

    public void setRequest(HttpServletRequest request, HttpServletResponse response, Map<String, Object> root, Boolean isSquare){
//        Cookie cookie = null;
        if(isSquare){//广场舞 square
//            cookie = new Cookie("site","square");
            root.put("site","square");
        }else{ //排舞 line
            root.put("site","line");
//            cookie = new Cookie("site","line");
        }
//        cookie.setPath(request.getContextPath());
//        cookie.setMaxAge(3600*24*7);
//        cookie.setPath(request.getContextPath().equals("")?"/":request.getContextPath());
//        response.addCookie(cookie);
    }

}
