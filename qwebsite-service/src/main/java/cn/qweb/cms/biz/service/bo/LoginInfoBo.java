package cn.qweb.cms.biz.service.bo;

/**
 * Created by xuebj on 2017/3/20.
 */
public class LoginInfoBo {

    /**
     * 用户名
     */
    private String userName;

    /**
     *@Fields last_login_ip:最后登录IP
     */
    private String lastLoginIp;


    /**
     *@Fields error_ip:登录错误IP
     */
    private String errorIp;

    /**
     *@Fields is_disabled:0 不禁用 1 禁用
     */
    private String isDisabled;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getErrorIp() {
        return errorIp;
    }

    public void setErrorIp(String errorIp) {
        this.errorIp = errorIp;
    }

    public String getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(String isDisabled) {
        this.isDisabled = isDisabled;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "userName='" + userName + '\'' +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", errorIp='" + errorIp + '\'' +
                ", isDisabled='" + isDisabled + '\'' +
                '}';
    }
}
