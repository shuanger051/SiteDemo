package cn.qweb.cms.core.dictionary.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by xuebj on 16/7/26.
 */
@Component
@ConfigurationProperties(prefix = "system.dictionary")
public class DictionaryProperties {
    /**
     * 当未找到数据字典时是否抛出异常,默认不抛出异常,然后一个默认的字典项
     */
    private Boolean throwExceptionWhenNotFund = Boolean.FALSE;
    /**
     * 抛出的异常信息
     */
    private String exceptionMessage ;

    /**
     * 未找到字典项是返回的默认信息
     */
    private String notFundMessage;

    public Boolean getThrowExceptionWhenNotFund() {
        return throwExceptionWhenNotFund;
    }

    public void setThrowExceptionWhenNotFund(Boolean throwExceptionWhenNotFund) {
        this.throwExceptionWhenNotFund = throwExceptionWhenNotFund;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getNotFundMessage() {
        return notFundMessage;
    }

    public void setNotFundMessage(String notFundMessage) {
        this.notFundMessage = notFundMessage;
    }
}
