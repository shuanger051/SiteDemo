package cn.qweb.cms.core.mvc;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xuebj on 16/7/21.
 */
@Controller
public class ForwardController extends BaseForwardController{

    @Autowired
    private UrlPathHelper urlPathHelper;

    @RequestMapping("/**/*.htm")
    public String forward(HttpServletRequest request){
        String url = urlPathHelper.getOriginatingServletPath(request);
        url = StringUtils.replaceOnce(url,"/","");
        url = StringUtils.remove(url,".htm");
        return url;
    }


    @RequestMapping("/**.htm")
    public String forward2(HttpServletRequest request){
        String url = urlPathHelper.getOriginatingServletPath(request);
        url = StringUtils.replaceOnce(url,"/","");
        url = StringUtils.remove(url,".htm");
        return url;
    }

    /**
     * TODO 解决登录失败之后调整页面，协助shiro完善功能，也可以在shiro中做，后期再完善
     * @return
     */
    @RequestMapping(value = "/login",method = {RequestMethod.POST,RequestMethod.GET})
    public String login(){
        return "login";
    }

}
