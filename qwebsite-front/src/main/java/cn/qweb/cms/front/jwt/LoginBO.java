package cn.qweb.cms.front.jwt;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by xuebj on 2017/5/17.
 */
public class LoginBO {

    @NotEmpty(message = "账号不能为空")
    private String account;

    @NotEmpty(message = "密码不能为空")
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginBO{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
