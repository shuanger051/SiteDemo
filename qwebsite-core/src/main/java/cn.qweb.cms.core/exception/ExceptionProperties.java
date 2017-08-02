package cn.qweb.cms.core.exception;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by xuebj on 16/7/21.
 */
@ConfigurationProperties(prefix = "system.exception")
public class ExceptionProperties {

    /**
     * 默认错误号
     */
    private String defaultErrorCode;

    /**
     * 默认错误信息
     */
    private String defaultErrorInfo;

    /**
     * 默认错误状态码
     */
    private Integer defaultStatus;

    /**
     * 系统异常扫描路径
     */
    private String basePackages;

    /**
     * 3类异常前缀
     */
    private String bindExceptionPrefix;
    private String bizExceptionPrefix;
    private String systemExceptionPrefix;


    public String getDefaultErrorCode() {
        return defaultErrorCode;
    }

    public void setDefaultErrorCode(String defaultErrorCode) {
        this.defaultErrorCode = defaultErrorCode;
    }

    public String getDefaultErrorInfo() {
        return defaultErrorInfo;
    }

    public void setDefaultErrorInfo(String defaultErrorInfo) {
        this.defaultErrorInfo = defaultErrorInfo;
    }

    public Integer getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public String getBasePackages() {
        return basePackages;
    }

    public void setBasePackages(String basePackages) {
        this.basePackages = basePackages;
    }

    public String getBindExceptionPrefix() {
        return bindExceptionPrefix;
    }

    public void setBindExceptionPrefix(String bindExceptionPrefix) {
        this.bindExceptionPrefix = bindExceptionPrefix;
    }

    public String getBizExceptionPrefix() {
        return bizExceptionPrefix;
    }

    public void setBizExceptionPrefix(String bizExceptionPrefix) {
        this.bizExceptionPrefix = bizExceptionPrefix;
    }

    public String getSystemExceptionPrefix() {
        return systemExceptionPrefix;
    }

    public void setSystemExceptionPrefix(String systemExceptionPrefix) {
        this.systemExceptionPrefix = systemExceptionPrefix;
    }
}
