package cn.qweb.cms.biz.service.bo;
import cn.qweb.cms.core.validator.RegExpConstants;

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

public class UserSaveBO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields user_name:用户名
     */
    @Pattern(regexp = RegExpConstants.USERNAME, message = RegExpConstants.USERNAME_MESSAGE)
    private String userName;

    /**
     *@Fields email:电子邮箱
     */
    @Pattern(regexp = RegExpConstants.EMAIL,message = RegExpConstants.EMAIL_MESSAGE)
    private String email;

    /**
     *@Fields password:密码
     */
//    @Pattern(regexp = RegExpConstants.PASSWORD,message = RegExpConstants.PASSWORD_MESSAGE)
    private String password;

    /**
     *@Fields register_ip:注册IP
     */
    private String registerIp;

    /**
     *@Fields is_admin:是否管理员
     */
    private String isAdmin;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }
}