package cn.qweb.cms.front.biz.manager.bo;

import java.io.Serializable;

/**
 * Created by xuebj on 2017/5/9.
 */
public class BaseBO<T> implements Serializable{

    private static final long serialVersionUID = 1L;

    protected String account;

    protected String signature;

    protected String method;

    protected T param;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }
}
