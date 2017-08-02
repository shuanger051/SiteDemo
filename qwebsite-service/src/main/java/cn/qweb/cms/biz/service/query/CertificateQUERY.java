package cn.qweb.cms.biz.service.query;
import cn.qweb.cms.core.base.BaseQueryEntity;
import org.springframework.format.annotation.DateTimeFormat;

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

public class CertificateQUERY extends BaseQueryEntity implements Serializable{
    private static final long serialVersionUID = 1L;


    /**
     *@Fields name:名称
     */
    private String name;

    /**
     *@Fields type:
     */
    private String type;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date releaseDate;

    /**
     *@Fields is_enabled:是否显示
     */
    private String isEnabled;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    }
    public String getIsEnabled(){
        return isEnabled;
    }

    @Override
    public String toString() {
        return "CertificateQUERY{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", img='" + img + '\'' +
                ", txt='" + txt + '\'' +
                ", brief='" + brief + '\'' +
                ", priority=" + priority +
                ", releaseDate=" + releaseDate +
                ", isEnabled='" + isEnabled + '\'' +
                '}';
    }
}