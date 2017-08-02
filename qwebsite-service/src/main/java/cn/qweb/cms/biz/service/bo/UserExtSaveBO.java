package cn.qweb.cms.biz.service.bo;
import cn.qweb.cms.core.validator.RegExpConstants;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
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

public class UserExtSaveBO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields real_name:真实姓名
     */
    @Pattern(regexp = RegExpConstants.REALNAME, message = RegExpConstants.REALNAME_MESSAGE)
    @Length(min = 2, max = 40,message = RegExpConstants.REALNAME_MESSAGE)
    private String realName;

    /**
     *@Fields gender:性别
     */
    @Pattern(regexp = RegExpConstants.GENDER,message = RegExpConstants.GENDER_MESSAGE)
    private String gender;

    /**
     *@Fields birthday:出生日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     *@Fields intro:个人介绍
     */
    @Length(max = 200,message = "个人介绍最长200字符")
    private String intro;

    /**
     *@Fields comefrom:来自
     */
    @Length(max = 100,message = "来自最长100个字符")
    private String comefrom;

    /**
     *@Fields qq:QQ
     */
    @Pattern(regexp = RegExpConstants.QQ, message = RegExpConstants.QQ_MESSAGE)
    private String qq;

    /**
     *@Fields phone:电话
     */
    @Pattern(regexp = RegExpConstants.PHONE,message = RegExpConstants.PHONE_MESSAGE)
    private String phone;

    /**
     *@Fields mobile:手机
     */
    @Pattern(regexp = RegExpConstants.MOBILE,message = RegExpConstants.MOBILE_MESSAGE)
    private String mobile;

    /**
     *@Fields user_img:用户头像
     */
    private String userImg;

    /**
     *@Fields user_signature:用户个性签名
     */
    private String userSignature;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getComefrom() {
        return comefrom;
    }

    public void setComefrom(String comefrom) {
        this.comefrom = comefrom;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature;
    }

    @Override
    public String toString() {
        return "UserExtSaveBO{" +
                "realName='" + realName + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", intro='" + intro + '\'' +
                ", comefrom='" + comefrom + '\'' +
                ", qq='" + qq + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", userImg='" + userImg + '\'' +
                ", userSignature='" + userSignature + '\'' +
                '}';
    }
}