package cn.qweb.cms.shiro;

import org.apache.shiro.authc.AuthenticationException;

/**
 * Created by xuebj on 2016/1/20.
 */
public class ForbiddenException extends AuthenticationException {
    public ForbiddenException() {
    }

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(Throwable cause) {
        super(cause);
    }

    public ForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }
}
