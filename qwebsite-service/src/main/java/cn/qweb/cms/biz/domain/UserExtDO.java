package cn.qweb.cms.biz.domain;
import cn.qweb.cms.core.base.BaseQueryEntity;

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

public class UserExtDO extends BaseQueryEntity implements Serializable {

private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    private Long id;
    /**
     *@Fields user_id:
     */
    private Long userId;
    /**
     *@Fields real_name:真实姓名
     */
    private String realName;
    /**
     *@Fields gender:性别
     */
    private String gender;
    /**
     *@Fields birthday:出生日期
     */
    private Date birthday;
    /**
     *@Fields intro:个人介绍
     */
    private String intro;
    /**
     *@Fields comefrom:来自
     */
    private String comefrom;
    /**
     *@Fields qq:QQ
     */
    private String qq;
    /**
     *@Fields msn:MSN
     */
    private String msn;
    /**
     *@Fields phone:电话
     */
    private String phone;
    /**
     *@Fields mobile:手机
     */
    private String mobile;
    /**
     *@Fields user_img:用户头像
     */
    private String userImg;
    /**
     *@Fields user_signature:用户个性签名
     */
    private String userSignature;
    /**
     *@Fields gmt_create:
     */
    private Date gmtCreate;
    /**
     *@Fields gmt_modified:
     */
    private Date gmtModified;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }
    public Long getUserId(){
        return userId;
    }
    public void setRealName(String realName){
        this.realName = realName;
    }
    public String getRealName(){
        return realName;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return gender;
    }
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }
    public Date getBirthday(){
        return birthday;
    }
    public void setIntro(String intro){
        this.intro = intro;
    }
    public String getIntro(){
        return intro;
    }
    public void setComefrom(String comefrom){
        this.comefrom = comefrom;
    }
    public String getComefrom(){
        return comefrom;
    }
    public void setQq(String qq){
        this.qq = qq;
    }
    public String getQq(){
        return qq;
    }
    public void setMsn(String msn){
        this.msn = msn;
    }
    public String getMsn(){
        return msn;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return phone;
    }
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    public String getMobile(){
        return mobile;
    }
    public void setUserImg(String userImg){
        this.userImg = userImg;
    }
    public String getUserImg(){
        return userImg;
    }
    public void setUserSignature(String userSignature){
        this.userSignature = userSignature;
    }
    public String getUserSignature(){
        return userSignature;
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
        return "UserExtDO{" +
                    "id='" + id + "\'," +
                    "userId='" + userId + "\'," +
                    "realName='" + realName + "\'," +
                    "gender='" + gender + "\'," +
                    "birthday='" + birthday + "\'," +
                    "intro='" + intro + "\'," +
                    "comefrom='" + comefrom + "\'," +
                    "qq='" + qq + "\'," +
                    "msn='" + msn + "\'," +
                    "phone='" + phone + "\'," +
                    "mobile='" + mobile + "\'," +
                    "userImg='" + userImg + "\'," +
                    "userSignature='" + userSignature + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
		}