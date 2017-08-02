package cn.qweb.cms.core.exception.builder;


import cn.qweb.cms.core.exception.ExceptionProperties;
import cn.qweb.cms.core.exception.domain.ErrorInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * 错误信息对象构建类
 * Created by xuebojie on 16/5/6.
 */
@Component
@EnableConfigurationProperties(ExceptionProperties.class)
public final class ErrorBuilder {

    private static ExceptionProperties properties;
    /**
     * 构建错误信息
     * @param message       错误信息
     * @return          {@link ErrorInfo}
     */
    public static ErrorInfo buildBizError(String message){
        return buildBizError(HttpStatus.OK.value(),properties.getDefaultErrorCode(),message,"");
    }

    /**
     * 构建错误信息
     * @param code          错误码
     * @param message       错误信息
     * @return      {@link ErrorInfo}
     */
    public static ErrorInfo buildBizError (String code, String message){
        return buildBizError(HttpStatus.OK.value(),code,message);
    }

    /**
     * 基础信息构造器1
     * @param status        状态码
     * @param code          错误码
     * @param message       错误信息
     * @return {@link ErrorInfo}
     */
    public static ErrorInfo buildBizError(Integer status, String code, String message) {
        return buildBizError(status,code,message,"");
    }

    /**
     * 基础构造器2
     * @param status    状态码
     * @param code      错误码
     * @param message   错误信息
     * @param developerMessage      开发者错误信息
     * @return {@link ErrorInfo}
     */
    public static ErrorInfo buildBizError(Integer status, String code, String message, String developerMessage) {
        if(status == null){
            status = HttpStatus.OK.value();
        }
        return build(status,properties.getBizExceptionPrefix() + code,message,developerMessage,"","");
    }
    /**
     * 构建错误信息
     * @param message       错误信息
     * @return          {@link ErrorInfo}
     */
    public static ErrorInfo buildBindError(String message){
        return buildBindError(HttpStatus.BAD_REQUEST.value(),properties.getDefaultErrorCode(),message,"");
    }

    /**
     * 构建错误信息
     * @param message           错误信息
     * @param developerMessage  堆栈信息
     * @return      {@link ErrorInfo}
     */
    public static ErrorInfo buildBindError (String message, String developerMessage){
        return buildBindError(HttpStatus.BAD_REQUEST.value(),properties.getDefaultErrorCode(),message,developerMessage);
    }

    /**
     * 基础信息构造器1
     * @param status        状态码
     * @param code          错误码
     * @param message       错误信息
     * @return {@link ErrorInfo}
     */
    public static ErrorInfo buildBindError(Integer status, String code, String message) {
        return buildBindError(status,code,message,"");
    }

    /**
     * 基础构造器2
     * @param status    状态码
     * @param code      错误码
     * @param message   错误信息
     * @param developerMessage      开发者错误信息
     * @return {@link ErrorInfo}
     */
    public static ErrorInfo buildBindError(Integer status, String code, String message, String developerMessage) {
        if(status == null){
            status = HttpStatus.BAD_REQUEST.value();
        }
        return build(status,properties.getBindExceptionPrefix() + code,message,developerMessage,"","");
    }
    /**
     * 构建错误信息
     * @param message       错误信息
     * @return          {@link ErrorInfo}
     */
    public static ErrorInfo buildSystemError(String message){
        return buildSystemError(properties.getDefaultStatus(),properties.getDefaultErrorCode(),message,"");
    }

    /**
     * 构建错误信息
     * @param message           错误信息
     * @param developerMessage  堆栈信息
     * @return      {@link ErrorInfo}
     */
    public static ErrorInfo buildSystemError (String message, String developerMessage){
        return buildSystemError(properties.getDefaultStatus(),properties.getDefaultErrorCode(),message,developerMessage);
    }

    /**
     * 基础信息构造器1
     * @param status        状态码
     * @param code          错误码
     * @param message       错误信息
     * @return {@link ErrorInfo}
     */
    public static ErrorInfo buildSystemError(Integer status, String code, String message) {
        return buildSystemError(status,code,message,"");
    }

    /**
     * 基础构造器2
     * @param status    状态码
     * @param code      错误码
     * @param message   错误信息
     * @param developerMessage      开发者错误信息
     * @return {@link ErrorInfo}
     */
    public static ErrorInfo buildSystemError(Integer status, String code, String message, String developerMessage) {
        if(status == null){
            status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        }
        return build(status,properties.getSystemExceptionPrefix() + code,message,developerMessage,"","");
    }


    /**
     * 完整构造器
     * @param status            状态码
     * @param code              错误码
     * @param message           错误信息
     * @param developerMessage  开发者错误信息
     * @param moreInfo          url地址
     * @param requestId         请求id号
     * @return {@link ErrorInfo}
     */
    public static ErrorInfo build(Integer status, String code, String message, String developerMessage, String moreInfo, String requestId) {
        if(StringUtils.isBlank(code)){
            code = properties.getDefaultErrorCode();
        }
        if(status == null){
           status = properties.getDefaultStatus();
        }
        return new ErrorInfo(status,code,message,developerMessage,moreInfo,requestId);

    }

    @Autowired
    public  void setProperties(ExceptionProperties properties) {
        ErrorBuilder.properties = properties;
    }
}
