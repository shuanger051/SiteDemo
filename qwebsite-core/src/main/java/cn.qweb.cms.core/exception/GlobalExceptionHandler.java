package cn.qweb.cms.core.exception;

import cn.qweb.cms.core.entity.JsonResult;
import cn.qweb.cms.core.exception.builder.ErrorBuilder;
import cn.qweb.cms.core.utils.JacksonUtils;
import cn.qweb.cms.core.utils.RequestUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuebj on 2017/2/19.
 */
@ControllerAdvice
@EnableConfigurationProperties(ExceptionProperties.class)
public class GlobalExceptionHandler {

    @Autowired
    private ExceptionProperties exceptionProperties;

    public static final String DEFAULT_ERROR_VIEW = "500";

    /**
     * 异常信息包扫描路径,如果有多个用,分隔
     */
    private String[] basePackages;

    @ExceptionHandler(value = Exception.class)
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        e.printStackTrace();
        BaseRuntimeException exception = WapException(e);
        setResponse(response,exception);
        if(RequestUtil.isAjaxRequest(request)){
            return resolveAjax(response,exception);
        }
        return resolveView(request, response, exception);
    }

    public ModelAndView resolveView(HttpServletRequest request, HttpServletResponse response,Exception e){
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    /**
     * 处理ajax情况
     * @param response
     * @param ex            异常对象
     */
    public ModelAndView resolveAjax(HttpServletResponse response, BaseRuntimeException ex){
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            JsonResult result = new JsonResult(Boolean.FALSE,ex.getError());
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
        return new ModelAndView();
    }


    /**
     * 设置response 公用属性
     * @param response
     * @param ex            异常对象
     */
    public void setResponse(HttpServletResponse response, BaseRuntimeException ex){
        response.setCharacterEncoding("utf-8");
        response.setStatus(ex.getError().getStatus());
    }


    /**
     * 包装异常,返回 BaseRuntimeException
     * @param ex
     * @return
     */
    private BaseRuntimeException WapException(Exception ex){
        if(ex instanceof BaseRuntimeException){
            return (BaseRuntimeException) ex;
        }else if(ex instanceof BindException){//数据绑定异常,格式校验错误
            return wapBindException((BindException) ex);
        }else if(ex instanceof ServletRequestBindingException){//参数获取错误,@RequestParam,和 @RequestPathVariable
            return wapServletBindException((ServletRequestBindingException) ex);
        }else {//体系之外的异常,此时需要抓取堆栈信息
            return wapOtherException(ex);
        }
    }

    /**
     * 转换bindException到 BaseRuntimeException 异常类错误信息
     * @param ex    异常对象
     * @return      {@link BaseRuntimeException }
     */
    private BaseRuntimeException wapBindException(BindException ex){
        List<Map<String,String>> list = new ArrayList<>();
        ex.getFieldErrors().stream().forEach(e->{
            Map<String,String> field = new HashMap<>();
            field.put("field",e.getField());
            field.put("message",e.getDefaultMessage());
            list.add(field);
        });
        return new BizException().setError(ErrorBuilder.buildBindError(JacksonUtils.toJsonString(list)));
    }

    /**ß
     * 转换 servlet绑定参数异常
     * @param ex    异常对象
     * @return
     */
    private BaseRuntimeException wapServletBindException(ServletRequestBindingException ex){
        Map<String,String> field = new HashMap<>();
        if(ex instanceof MissingServletRequestParameterException){
            MissingServletRequestParameterException e = (MissingServletRequestParameterException)ex;
            field.put("field",e.getParameterName());
            field.put("message","参数未传");
        }else if(ex instanceof MissingPathVariableException){
            MissingPathVariableException e = (MissingPathVariableException)ex;
            field.put("field",e.getVariableName());
            field.put("message","参数未传");
        }else{
            return wapOtherException(ex);
        }
        return new BizException().setError(ErrorBuilder.buildBindError(JacksonUtils.toJsonString(field)));
    }

    /**
     * 转换 体系之外的异常信息到 SystemException 异常信息类
     * @param e     异常对象
     * @return       {@link BaseRuntimeException }
     */
    private BaseRuntimeException wapOtherException(Throwable e){
        return new SystemException().setError(ErrorBuilder.buildSystemError(exceptionProperties.getDefaultErrorInfo(),getStackMsg(e)));
    }

    /**
     * 获取堆栈信息
     * @param e 异常类
     * @return  堆栈信息
     */
    private String getStackMsg(Throwable e){
        String classCause = "";
        StackTraceElement el = e.getStackTrace()[0];
        for (String basePackage: basePackages) {
            if(el.getClassName().indexOf(basePackage) > -1){
                classCause += getCauseInfoBySTElement(el);
                break;
            }
        }
        Throwable cause = e.getCause();
        if(cause != null){
            classCause += getStackMsg(cause);
        }
        return  classCause;
    }

    private String getCauseInfoBySTElement(StackTraceElement el){
        String lineNum = el.getLineNumber() < 0 ?"原始方法":el.getFileName() + ":" + el.getLineNumber();
        return el.getClassName()+"." + el.getMethodName() + "(" + lineNum + ")";
    }


    @PostConstruct
    public void setBasePackages() {
        this.basePackages = exceptionProperties.getBasePackages().split(",");
    }


}
