package cn.qweb.cms.biz.service.query;
import cn.qweb.cms.core.base.BaseQueryEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/*
 *  Created by xuebj - 2017/03/20.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class UserQUERY extends BaseQueryEntity implements Serializable{
    private static final long serialVersionUID = 1L;


    /**
     *@Fields user_name:用户名
     */
    private String userName;

    /**
     *@Fields email:电子邮箱
     */
    private String email;

    /**
     *@Fields password:密码
     */
    private String password;

    /**
     *@Fields register_time:注册时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerTime;

    /**
     *@Fields register_ip:注册IP
     */
    private String registerIp;

    /**
     *@Fields last_login_time:最后登录时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;

    /**
     *@Fields last_login_ip:最后登录IP
     */
    private String lastLoginIp;

    /**
     *@Fields login_count:
     */
    private Integer loginCount;

    /**
     *@Fields error_time:登录错误时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date errorTime;

    /**
     *@Fields error_count:登录错误次数
     */
    private Integer errorCount;

    /**
     *@Fields error_ip:登录错误IP
     */
    private String errorIp;

    /**
     *@Fields reset_key:重置密码KEY
     */
    private String resetKey;

    /**
     *@Fields reset_pwd:重置密码VALUE
     */
    private String resetPwd;

    /**
     *@Fields activation:激活状态
     */
    private Boolean activation;

    /**
     *@Fields activation_code:激活码
     */
    private String activationCode;

    /**
     *@Fields is_admin:是否管理员
     */
    private String isAdmin;

    /**
     *@Fields is_disabled:0 不禁用 1 禁用
     */
    private String isDisabled;

    /**
     *@Fields gmt_create:
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    /**
     *@Fields gmt_modified:
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;


    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return userName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public void setRegisterTime(Date registerTime){
        this.registerTime = registerTime;
    }
    public Date getRegisterTime(){
        return registerTime;
    }
    public void setRegisterIp(String registerIp){
        this.registerIp = registerIp;
    }
    public String getRegisterIp(){
        return registerIp;
    }
    public void setLastLoginTime(Date lastLoginTime){
        this.lastLoginTime = lastLoginTime;
    }
    public Date getLastLoginTime(){
        return lastLoginTime;
    }
    public void setLastLoginIp(String lastLoginIp){
        this.lastLoginIp = lastLoginIp;
    }
    public String getLastLoginIp(){
        return lastLoginIp;
    }
    public void setLoginCount(Integer loginCount){
        this.loginCount = loginCount;
    }
    public Integer getLoginCount(){
        return loginCount;
    }
    public void setErrorTime(Date errorTime){
        this.errorTime = errorTime;
    }
    public Date getErrorTime(){
        return errorTime;
    }
    public void setErrorCount(Integer errorCount){
        this.errorCount = errorCount;
    }
    public Integer getErrorCount(){
        return errorCount;
    }
    public void setErrorIp(String errorIp){
        this.errorIp = errorIp;
    }
    public String getErrorIp(){
        return errorIp;
    }
    public void setResetKey(String resetKey){
        this.resetKey = resetKey;
    }
    public String getResetKey(){
        return resetKey;
    }
    public void setResetPwd(String resetPwd){
        this.resetPwd = resetPwd;
    }
    public String getResetPwd(){
        return resetPwd;
    }
    public void setActivation(Boolean activation){
        this.activation = activation;
    }
    public Boolean getActivation(){
        return activation;
    }
    public void setActivationCode(String activationCode){
        this.activationCode = activationCode;
    }
    public String getActivationCode(){
        return activationCode;
    }
    public void setIsAdmin(String isAdmin){
        this.isAdmin = isAdmin;
    }
    public String getIsAdmin(){
        return isAdmin;
    }
    public void setIsDisabled(String isDisabled){
        this.isDisabled = isDisabled;
    }
    public String getIsDisabled(){
        return isDisabled;
    }
    public void setGmtCreate(Date gmtCreate){
        this.gmtCreate = gmtCreate;
    }
    public Date getGmtCreate(){
        return gmtCreate;
    }
    public void setGmtModified(Date gmtModified){
        this.gmtModified = gmtModified;
    }
    public Date getGmtModified(){
        return gmtModified;
    }
    @Override
    public String toString(){
        return "User{" +
                    "userName='" + userName + "\'," +
                    "email='" + email + "\'," +
                    "password='" + password + "\'," +
                    "registerTime='" + registerTime + "\'," +
                    "registerIp='" + registerIp + "\'," +
                    "lastLoginTime='" + lastLoginTime + "\'," +
                    "lastLoginIp='" + lastLoginIp + "\'," +
                    "loginCount='" + loginCount + "\'," +
                    "errorTime='" + errorTime + "\'," +
                    "errorCount='" + errorCount + "\'," +
                    "errorIp='" + errorIp + "\'," +
                    "resetKey='" + resetKey + "\'," +
                    "resetPwd='" + resetPwd + "\'," +
                    "activation='" + activation + "\'," +
                    "activationCode='" + activationCode + "\'," +
                    "isAdmin='" + isAdmin + "\'," +
                    "isDisabled='" + isDisabled + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
}