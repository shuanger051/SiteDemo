package cn.qweb.cms.core.exception;

import cn.qweb.cms.core.exception.domain.ErrorInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

/**
 * 基础异常类
 * @example
 *
 *  1:new BaseRuntimeException().setError(ErrorBuilder.build(....))
 *  2:new BaseRuntimeException(ErrorBuilder.build(....))
 * Created by xuebojie on 16/5/6.
 */
public class BaseRuntimeException extends RuntimeException {
    /**
     * 错误信息类
     */
    private ErrorInfo error;

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public BaseRuntimeException(ErrorInfo error) {
        this.error = error;
    }

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public BaseRuntimeException() {
    }

    /**
     * Returns the detail message string of this throwable.
     *
     * @return the detail message string of this {@code Throwable} instance
     * (which may be {@code null}).
     */
    @Override
    public String getMessage() {
        if(ObjectUtils.nullSafeEquals(null,error)){
            return super.getMessage();
        }else{
            return StringUtils.isNotBlank(error.getMessage()) ? error.getMessage():super.getMessage();
        }
    }

    public ErrorInfo getError() {
        return error;
    }

    /**
     * 设置异常类
     * @param error
     * @return
     */
    public BaseRuntimeException setError(ErrorInfo error) {
        this.error = error;
        return this;
    }
}
