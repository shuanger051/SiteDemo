package cn.qweb.cms.core.exception;


import cn.qweb.cms.core.exception.domain.ErrorInfo;

/**
 * 系统性异常基类
 * Created by xuebojie on 16/5/6.
 */
public class SystemException extends BaseRuntimeException{
    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     *
     * @param error
     */
    public SystemException(ErrorInfo error) {
        super(error);
    }

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public SystemException() {
    }
}
