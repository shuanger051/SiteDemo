package cn.qweb.cms.core.mvc;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 404错误页配置,spring boot 默认错误配置在/error,
 * 进入spring mvc之后错误有spring mvc处理
 * 实现ErrorController 接口,代替springboot 默认的错误控制器
 * Created by xuebj on 16/5/24.
 */
@Controller
public class MainsiteErrorController extends BaseForwardController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @RequestMapping(value = ERROR_PATH,method = {RequestMethod.POST,RequestMethod.GET})
    public String e404(){
        return "404";
    }

    /**
     * 设置错误路径
     * @return
     */
    @Override
    public String getErrorPath() {
        return "";
    }
}
