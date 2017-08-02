package cn.qweb.cms.biz.service.bo;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;

/*
 *  Created by xuebj - 2017/03/23.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class CooperativePartnerUpdateBO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    @NotNull(message = "唯一键不能为空")
    private Long id;
    /**
     *@Fields site_name:网站名称
     */
    private String siteName;
    /**
     *@Fields site_link:网站地址
     */
    private String siteLink;
    /**
     *@Fields friendlinkctg_id:友情链接类别
     */
    private Long friendlinkctgId;
    /**
     *@Fields logo:图标
     */
    private String logo;
    private String oldLogoUrl;
    /**
     *@Fields email:站长邮箱
     */
    private String email;
    /**
     *@Fields description:描述
     */
    private String description;
    /**
     *@Fields views:点击次数
     */
    private Integer views;
    /**
     *@Fields is_enabled:是否显示
     */
    private String isEnabled;
    /**
     *@Fields priority:排列顺序
     */
    private Integer priority;
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

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setSiteName(String siteName){
        this.siteName = siteName;
    }
    public String getSiteName(){
        return siteName;
    }
    public void setSiteLink(String siteLink){
        this.siteLink = siteLink;
    }
    public String getSiteLink(){
        return siteLink;
    }
    public void setFriendlinkctgId(Long friendlinkctgId){
        this.friendlinkctgId = friendlinkctgId;
    }
    public Long getFriendlinkctgId(){
        return friendlinkctgId;
    }
    public void setLogo(String logo){
        this.logo = logo;
        this.oldLogoUrl = logo;
    }
    public String getLogo(){
        return logo;
    }

    public String getOldLogoUrl() {
        return oldLogoUrl;
    }

    public void setOldLogoUrl(String oldLogoUrl) {
        this.oldLogoUrl = oldLogoUrl;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
    public void setViews(Integer views){
        this.views = views;
    }
    public Integer getViews(){
        return views;
    }
    public void setIsEnabled(String isEnabled){
        this.isEnabled = isEnabled;
    }
    public String getIsEnabled(){
        return isEnabled;
    }
    public void setPriority(Integer priority){
        this.priority = priority;
    }
    public Integer getPriority(){
        return priority;
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
        return "CooperativePartner{" +
                    "id='" + id + "\'," +
                    "siteName='" + siteName + "\'," +
                    "siteLink='" + siteLink + "\'," +
                    "friendlinkctgId='" + friendlinkctgId + "\'," +
                    "logo='" + logo + "\'," +
                    "email='" + email + "\'," +
                    "description='" + description + "\'," +
                    "views='" + views + "\'," +
                    "isEnabled='" + isEnabled + "\'," +
                    "priority='" + priority + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
        }