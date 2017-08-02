package cn.qweb.cms.biz.service.dto;

import cn.qweb.cms.core.dictionary.DictManager;
import org.wuwz.poi.annotation.ExportConfig;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


/*
 *  Created by xuebj - 2017/03/29.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class TrainSquareApplyDTO implements Serializable{
    private static final long serialVersionUID = 1L;


    /**
     * 培训标题
     */
    @ExportConfig(value = "培训标题", width = 150)
    private String title;

    /**
     *@Fields id:
     */
    @ExportConfig(value = "编号", width = 150)
    private Long id;
    /**
     *@Fields channel_id:栏目号
     */
    private Long channelId;
    /**
     *@Fields content_id:活动ID
     */
    private Long contentId;
    /**
     *@Fields real_name:真是姓名
     */
    @ExportConfig(value = "姓名", width = 150)
    private String realName;
    /**
     *@Fields sex:性别
     */
    private String sex;

    @ExportConfig(value = "性别", width = 150)
    private String sexName;
    /**
     *@Fields id_no:身份证号
     */
    @ExportConfig(value = "身份证号", width = 150)
    private String idNo;
    /**
     *@Fields id_kind:证件类型，默认身份证
     */
    private String idKind;
    /**
     *@Fields read_flag:是否查阅
     */
    private String readFlag;
    private String readFlagName;
    /**
     *@Fields trainer_type:报名类型
     */
    private String trainerType;
    @ExportConfig(value = "报名项目", width = 150)
    private String trainerTypeName;
    /**
     *@Fields mobile:联系方式
     */
    @ExportConfig(value = "联系方式", width = 150)
    private String mobile;
    /**
     *@Fields email:邮箱
     */
    @ExportConfig(value = "邮箱", width = 150)
    private String email;
    /**
     *@Fields qq:qq号
     */
    @ExportConfig(value = "QQ号", width = 150)
    private String qq;
    /**
     *@Fields height:身高，单位厘米
     */
    @ExportConfig(value = "身高(CM)", width = 150)
    private String height;
    /**
     *@Fields gmt_create:
     */
    private Date gmtCreate;
    @ExportConfig(value = "报名时间", width = 150)
    private String gmtCreateFormat;

    /**
     *@Fields gmt_modified:
     */
    private Date gmtModified;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setChannelId(Long channelId){
        this.channelId = channelId;
    }
    public Long getChannelId(){
        return channelId;
    }
    public void setContentId(Long contentId){
        this.contentId = contentId;
    }
    public Long getContentId(){
        return contentId;
    }
    public void setRealName(String realName){
        this.realName = realName;
    }
    public String getRealName(){
        return realName;
    }
    public void setSex(String sex){
        this.sex = sex;
        this.sexName = DictManager.getItem("gender",sex);
    }
    public String getSex(){
        return sex;
    }
    public void setIdNo(String idNo){
        this.idNo = idNo;
    }
    public String getIdNo(){
        return idNo;
    }
    public void setIdKind(String idKind){
        this.idKind = idKind;
    }
    public String getIdKind(){
        return idKind;
    }
    public void setReadFlag(String readFlag){
        this.readFlag = readFlag;
        this.readFlagName = DictManager.getItem("isRead",readFlag);
    }
    public String getReadFlag(){
        return readFlag;
    }
    public void setTrainerType(String trainerType){
        this.trainerType = trainerType;
        this.trainerTypeName = DictManager.getItem("trainerType",trainerType);
    }
    public String getTrainerType(){
        return trainerType;
    }
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    public String getMobile(){
        return mobile;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setQq(String qq){
        this.qq = qq;
    }
    public String getQq(){
        return qq;
    }
    public void setHeight(String height){
        this.height = height;
    }
    public String getHeight(){
        return height;
    }
    public void setGmtCreate(Date gmtCreate){
        this.gmtCreate = gmtCreate;
        this.gmtCreateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(gmtCreate);
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

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public String getTrainerTypeName() {
        return trainerTypeName;
    }

    public void setTrainerTypeName(String trainerTypeName) {
        this.trainerTypeName = trainerTypeName;
    }

    public String getGmtCreateFormat() {
        return gmtCreateFormat;
    }

    public void setGmtCreateFormat(String gmtCreateFormat) {
        this.gmtCreateFormat = gmtCreateFormat;
    }

    public String getReadFlagName() {
        return readFlagName;
    }

    public void setReadFlagName(String readFlagName) {
        this.readFlagName = readFlagName;
    }

    @Override
    public String toString(){
        return "TrainApply{" +
                    "title='" + title + "\'," +
                    "id='" + id + "\'," +
                    "channelId='" + channelId + "\'," +
                    "contentId='" + contentId + "\'," +
                    "realName='" + realName + "\'," +
                    "sex='" + sex + "\'," +
                    "idNo='" + idNo + "\'," +
                    "idKind='" + idKind + "\'," +
                    "readFlag='" + readFlag + "\'," +
                    "trainerType='" + trainerType + "\'," +
                    "mobile='" + mobile + "\'," +
                    "email='" + email + "\'," +
                    "qq='" + qq + "\'," +
                    "height='" + height + "\'," +
                    "sexName='" + sexName + "\'," +
                    "trainerTypeName='" + trainerTypeName + "\'," +
                    "gmtCreateFormat='" + gmtCreateFormat + "\'," +
                    "readFlagName='" + readFlagName + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
        }