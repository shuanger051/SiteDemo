package cn.qweb.cms.biz.service.dto;
import cn.qweb.cms.core.dictionary.DictManager;

import java.io.Serializable;
import java.util.Date;


/*
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class NavigationDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    private Long id;
    /**
     *@Fields name:导航名称
     */
    private String name;
    /**
     *@Fields parent_id:父导航
     */
    private Long parentId;
    /**
     *@Fields is_display:是否显示
     */
    private String isDisplay;

    /**
     * is_display 转义
     */
    private String isDisplayName;
    /**
     *@Fields is_expand:是否展开
     */
    private String isExpand;

    /**
     * is_expand 专义
     */
    private String isExpandName;
    /**
     *@Fields link:连接
     */
    private String link;
    /**
     *@Fields is_blank:新窗口打开
     */
    private String isBlank;
    /**
     *@Fields icon:图标
     */
    private String icon;
    /**
     *@Fields priority:排列顺序
     */
    private Integer priority;
    /**
     *@Fields style:样式
     */
    private String style;
    /**
     *@Fields clas:样式名
     */
    private String clas;
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
    public void setParentId(Long parentId){
        this.parentId = parentId;
    }
    public Long getParentId(){
        return parentId;
    }
    public void setIsDisplay(String isDisplay){
        this.isDisplay = isDisplay;
        this.setIsDisplayName(DictManager.getItem("isDisplay",isDisplay));
    }
    public String getIsDisplay(){
        return isDisplay;
    }
    public void setIsExpand(String isExpand){
        this.isExpand = isExpand;
        this.setIsExpandName(DictManager.getItem("isExpand",isExpand));
    }
    public String getIsExpand(){
        return isExpand;
    }
    public void setLink(String link){
        this.link = link;
    }
    public String getLink(){
        return link;
    }
    public void setIsBlank(String isBlank){
        this.isBlank = isBlank;
    }
    public String getIsBlank(){
        return isBlank;
    }
    public void setIcon(String icon){
        this.icon = icon;
    }
    public String getIcon(){
        return icon;
    }
    public void setPriority(Integer priority){
        this.priority = priority;
    }
    public Integer getPriority(){
        return priority;
    }
    public void setStyle(String style){
        this.style = style;
    }
    public String getStyle(){
        return style;
    }
    public void setClas(String clas){
        this.clas = clas;
    }
    public String getClas(){
        return clas;
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

    public String getIsDisplayName() {
        return isDisplayName;
    }

    public void setIsDisplayName(String isDisplayName) {
        this.isDisplayName = isDisplayName;
    }

    public String getIsExpandName() {
        return isExpandName;
    }

    public void setIsExpandName(String isExpandName) {
        this.isExpandName = isExpandName;
    }

    @Override
    public String toString() {
        return "NavigationDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", isDisplay='" + isDisplay + '\'' +
                ", isDisplayName='" + isDisplayName + '\'' +
                ", isExpand='" + isExpand + '\'' +
                ", isExpandName='" + isExpandName + '\'' +
                ", link='" + link + '\'' +
                ", isBlank='" + isBlank + '\'' +
                ", icon='" + icon + '\'' +
                ", priority=" + priority +
                ", style='" + style + '\'' +
                ", clas='" + clas + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}