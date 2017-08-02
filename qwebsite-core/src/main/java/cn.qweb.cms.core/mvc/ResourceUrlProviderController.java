package cn.qweb.cms.core.mvc;

import cn.qweb.cms.core.constants.SymbolConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 资源文件MD5码增加方式。拦截器,只在页面跳转的controller中增加,其它controller 不需要
 * 在controller之前增加资源路径解析器到request上下文中,获取正确的资源文件路径
 * Created by xuebj on 16/7/21.
 */
@ControllerAdvice(assignableTypes = {BaseForwardController.class})
@ConfigurationProperties(prefix = "uploadresource")
public class ResourceUrlProviderController {

    @Autowired
    private UrlPathHelper urlPathHelper;

    @Autowired
    private BizProperties bizProperties;

    private String viewPath;

    /**
     * 相对路径转换工作,找出资源文件相对当前url的相对路径,供html 资源文件引入
     * @param request
     * @return
     */
    @ModelAttribute("root")
    public Map<String,Object> root(HttpServletRequest request){
        Map<String,Object> root = new HashMap<>();
        root.put("path",getRelativePath(urlPathHelper.getOriginatingServletPath(request)));
        root.put("site",bizProperties.getSite());
        root.put("viewPath",viewPath);
        return root;
    }

    /**
     * 根据当前URL获取到资源文件相对本URL的路径
     * 举例:
 *          /home.html -> .
     *      /user/home.html -> ..
     *      /user/pay/home.html -> ../..
     * @param url
     * @return  转换之后的相对路径
     */
    private String getRelativePath(String url){
        String [] paths = url.split(SymbolConstants.SLASH);
        if(paths.length < 3){//小于3的认为是根路径
            return SymbolConstants.SPOT;
        }else {//多级路径
            StringBuilder relativePath = new StringBuilder();
            for (int i = 1; i < paths.length-1;i++){
                relativePath.append(RELATIVE_PATH);
            }
            relativePath.deleteCharAt(relativePath.length()-1);
            return relativePath.toString();
        }
    }

    /**
     * 相对路径表示 ../
     */
    private static final String RELATIVE_PATH = SymbolConstants.SPOT_TWO + SymbolConstants.SLASH;

    public void setViewPath(String viewPath) {
        this.viewPath = viewPath;
    }
}
