package cn.qweb.cms.core.exception.domain;


/**
 * 错误信息实体,用于封装异常错误信息
 * Created by xuebojie on 16/5/6.
 */
public class ErrorInfo {

    /**
     * 错误状态
     */
    private Integer status;

    /**
     * 错误吗
     */
    private String code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 开发者使用的错误信息,如 堆栈信息,排除 第三方类库的错误,只保留自己代码的信息
     */
    private String developerMessage;

    /**
     * 给定一个URL,此错误的详细信息,产生原因,解决办法等等
     */
    private String moreInfo;

    /**
     * 请求的ID号,后台可以根据此ID号 查到所有相关日志
     */
    private String requestId;

    /**
     * 完整构造器
     * @param status            状态码
     * @param code              错误码
     * @param message           错误信息
     * @param developerMessage  开发者错误信息
     * @param moreInfo          url地址
     * @param requestId         请求id号
     */
    public ErrorInfo(Integer status, String code, String message, String developerMessage, String moreInfo, String requestId) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.developerMessage = developerMessage;
        this.moreInfo = moreInfo;
        this.requestId = requestId;
    }

    /**
     * 基础信息构造器1
     * @param status        状态码
     * @param code          错误码
     * @param message       错误信息
     */
    public ErrorInfo(Integer status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    /**
     * 基础构造器2
     * @param status    状态码
     * @param code      错误码
     * @param message   错误信息
     * @param developerMessage      开发者错误信息
     */
    public ErrorInfo(Integer status, String code, String message, String developerMessage) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.developerMessage = developerMessage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

}
