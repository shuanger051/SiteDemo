package cn.qweb.cms.biz.service.dto;
import cn.qweb.cms.core.dictionary.DictManager;
import org.wuwz.poi.annotation.ExportConfig;

import java.io.Serializable;
import java.util.Date;


/*
 *  Created by xuebj - 2017/05/05.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class CredentialsDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields id:主键ID
     */
    private Long id;

    /**
     *@Fields name:姓名
     */
    @ExportConfig(value = "姓名", width = 150)
    private String name;

    /**
     *@Fields credentials_id:证书编号
     */
    @ExportConfig(value = "证书编号", width = 150)
    private String credentialsId;
    /**
     *@Fields credentials_type:证书类型
     */
    private String credentialsType;

    @ExportConfig(value = "证书类型", width = 150)
    private String credentialsTypeName;

    /**
     *@Fields credentials_level:证书等级
     */
    private String credentialsLevel;

    @ExportConfig(value = "证书等级", width = 150)
    private String credentialsLevelName;

    /**
     *@Fields person_no:人员编号
     */
    private String personNo;
    /**
     *@Fields card_no:身份证号
     */
    @ExportConfig(value = "身份证号", width = 150)
    private String cardNo;
    /**
     *@Fields work_unit:工作单位
     */
    private String workUnit;
    /**
     *@Fields person_pic:人员照片
     */
    private String personPic;
    /**
     *@Fields trainer_type:人员类型
     */
    private String trainerType;

    @ExportConfig(value = "人员类型", width = 150)
    private String trainerTypeName;
    /**
     *@Fields gmt_create:创建时间
     */
    private Date gmtCreate;
    /**
     *@Fields gmt_modified:更新时间
     */
    private Date gmtModified;

    /**
     *@Fields credentials_date:发证日期
     */
    private Date credentialsDate;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setCredentialsId(String credentialsId){
        this.credentialsId = credentialsId;
    }
    public String getCredentialsId(){
        return credentialsId;
    }
    public void setCredentialsType(String credentialsType){
        this.credentialsType = credentialsType;
        this.credentialsTypeName = DictManager.getItem("credentialType",credentialsType);
    }
    public String getCredentialsType(){
        return credentialsType;
    }
    public void setCredentialsLevel(String credentialsLevel){
        this.credentialsLevel = credentialsLevel;
        this.credentialsLevelName = DictManager.getItem("credentialLevel",credentialsLevel);
    }
    public String getCredentialsLevel(){
        return credentialsLevel;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setPersonNo(String personNo){
        this.personNo = personNo;
    }
    public String getPersonNo(){
        return personNo;
    }
    public void setCardNo(String cardNo){
        this.cardNo = cardNo;
    }
    public String getCardNo(){
        return cardNo;
    }
    public void setWorkUnit(String workUnit){
        this.workUnit = workUnit;
    }
    public String getWorkUnit(){
        return workUnit;
    }
    public void setPersonPic(String personPic){
        this.personPic = personPic;
    }
    public String getPersonPic(){
        return personPic;
    }
    public void setTrainerType(String trainerType){
        this.trainerType = trainerType;
        this.trainerTypeName = DictManager.getItem("trainerType",trainerType);
    }
    public String getTrainerType(){
        return trainerType;
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
    public String getCredentialsTypeName() {
        return credentialsTypeName;
    }
    public void setCredentialsTypeName(String credentialsTypeName) {
        this.credentialsTypeName = credentialsTypeName;
    }
    public String getCredentialsLevelName() {
        return credentialsLevelName;
    }
    public void setCredentialsLevelName(String credentialsLevelName) {
        this.credentialsLevelName = credentialsLevelName;
    }
    public String getTrainerTypeName() {
        return trainerTypeName;
    }
    public void setTrainerTypeName(String trainerTypeName) {
        this.trainerTypeName = trainerTypeName;
    }

    public Date getCredentialsDate() {
        return credentialsDate;
    }

    public void setCredentialsDate(Date credentialsDate) {
        this.credentialsDate = credentialsDate;
    }

    @Override
    public String toString() {
        return "CredentialsDTO{" +
                "id=" + id +
                ", credentialsId=" + credentialsId +
                ", credentialsType='" + credentialsType + '\'' +
                ", credentialsTypeName='" + credentialsTypeName + '\'' +
                ", credentialsLevel='" + credentialsLevel + '\'' +
                ", credentialsLevelName='" + credentialsLevelName + '\'' +
                ", name='" + name + '\'' +
                ", personNo='" + personNo + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", workUnit='" + workUnit + '\'' +
                ", personPic='" + personPic + '\'' +
                ", trainerType='" + trainerType + '\'' +
                ", trainerTypeName='" + trainerTypeName + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", credentialsDate=" + credentialsDate +
                '}';
    }
}