package cn.qweb.cms.biz.service.dto;
import cn.qweb.cms.core.dictionary.DictManager;

import java.io.Serializable;
import java.util.Date;


/*
 *  Created by xuebj - 2017/04/06.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class CertificateDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    private Long id;
    /**
     *@Fields name:名称
     */
    private String name;
    /**
     *@Fields type:
     */
    private String type;

    /**
     *@Fields type:
     */
    private String typeName;
    /**
     *@Fields img:证书
     */
    private String img;
    /**
     *@Fields txt:证书介绍
     */
    private String txt;
    /**
     *@Fields brief:简介
     */
    private String brief;
    /**
     *@Fields priority:排列顺序
     */
    private Integer priority;
    /**
     *@Fields release_date:发布时间
     */
    private Date releaseDate;
    /**
     *@Fields is_enabled:是否显示
     */
    private String isEnabled;

    /**
     * isEnabled 转义
     */
    private String isEnabledName;
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
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setImg(String img){
        this.img = img;
    }
    public String getImg(){
        return img;
    }
    public void setTxt(String txt){
        this.txt = txt;
    }
    public String getTxt(){
        return txt;
    }
    public void setBrief(String brief){
        this.brief = brief;
    }
    public String getBrief(){
        return brief;
    }
    public void setPriority(Integer priority){
        this.priority = priority;
    }
    public Integer getPriority(){
        return priority;
    }
    public void setReleaseDate(Date releaseDate){
        this.releaseDate = releaseDate;
    }
    public Date getReleaseDate(){
        return releaseDate;
    }
    public void setIsEnabled(String isEnabled){
        this.isEnabled = isEnabled;
        this.setIsEnabledName(DictManager.getItem("isShow",isEnabled));
    }
    public String getIsEnabled(){
        return isEnabled;
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

    public String getIsEnabledName() {
        return isEnabledName;
    }

    public void setIsEnabledName(String isEnabledName) {
        this.isEnabledName = isEnabledName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        this.setTypeName(DictManager.getItem("credentialType",type));
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "CertificateDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", typeName='" + typeName + '\'' +
                ", img='" + img + '\'' +
                ", txt='" + txt + '\'' +
                ", brief='" + brief + '\'' +
                ", priority=" + priority +
                ", releaseDate=" + releaseDate +
                ", isEnabled='" + isEnabled + '\'' +
                ", isEnabledName='" + isEnabledName + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}