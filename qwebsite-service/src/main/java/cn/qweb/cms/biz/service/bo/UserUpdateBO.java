package cn.qweb.cms.biz.service.bo;
import cn.qweb.cms.core.validator.RegExpConstants;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/*
 *  Created by xuebj - 2017/03/20.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class UserUpdateBO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    @NotNull(message = "唯一键不能为空")
    private Long id;

    /**
     *@Fields email:电子邮箱
     */
    @Pattern(regexp = RegExpConstants.EMAIL,message = RegExpConstants.EMAIL_MESSAGE)
    private String email;
    /**
     *@Fields password:密码
     */
    private String password;
    /**
     *@Fields is_admin:是否管理员
     */
    private String isAdmin;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(String isDisabled) {
        this.isDisabled = isDisabled;
    }

    @Override
    public String toString() {
        return "UserUpdateBO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin='" + isAdmin + '\'' +
                ", isDisabled='" + isDisabled + '\'' +
                '}';
    }
}