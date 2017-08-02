package cn.qweb.cms.front.jwt;


import cn.qweb.cms.core.entity.JsonResult;
import cn.qweb.cms.core.exception.builder.ErrorBuilder;
import cn.qweb.cms.core.utils.JacksonUtils;
import cn.qweb.cms.core.utils.RequestUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xuebj on 2015/12/25.
 */
public class AJAXUtils {

    /**
     * 是否是ajax请求
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request){
        return RequestUtil.isAjaxRequest(request);
    }

    /**
     * 写入到response中
     * @param response
     * @param status
     * @param errorInfo
     */
    public static void print(HttpServletResponse response, boolean success, int status, String errorInfo){
        //设置内容格式
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(status);
        JsonResult jsonObject = new JsonResult(ErrorBuilder.buildBizError(status,"",errorInfo));
        jsonObject.setSuccess(success);
        try {
            PrintWriter writer = response.getWriter();
            String jsonStr = JacksonUtils.toJsonString(jsonObject);
            if (StringUtils.isNotBlank(jsonStr)) {
                writer.write(jsonStr);
            }
            writer.flush();
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
    /**
     * 写入到response中
     * @param response
     * @param status
     * @param errorInfo
     */
    public static void print(HttpServletResponse response, int status, String errorInfo){
       print(response,false,status,errorInfo);
    }
}
