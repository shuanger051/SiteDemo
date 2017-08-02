package cn.qweb.cms.shiro;

import java.io.Serializable;

/**
 * 会话对象
 * Created by xuebj on 2015/12/15.
 */
public class ShiroUser implements Serializable {

    private static final long serialVersionUID = -3267529922242658370L;

    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     *@Fields activation:激活状态
     */
    private Boolean activation;

    /**
     *@Fields is_disabled:0 不禁用 1 禁用
     */
    private String isDisabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivation() {
        return activation;
    }

    public void setActivation(Boolean activation) {
        this.activation = activation;
    }

    public String getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(String isDisabled) {
        this.isDisabled = isDisabled;
    }

    @Override
    public String toString() {
        return "ShiroUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", activation=" + activation +
                ", isDisabled='" + isDisabled + '\'' +
                '}';
    }
}
