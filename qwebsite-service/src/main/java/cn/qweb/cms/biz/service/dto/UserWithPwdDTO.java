package cn.qweb.cms.biz.service.dto;

/**
 * Created by xuebj on 2017/3/23.
 */
public class UserWithPwdDTO extends UserDTO{
    /**
     *@Fields password:密码
     */
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
