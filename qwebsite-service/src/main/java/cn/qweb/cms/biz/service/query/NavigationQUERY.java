package cn.qweb.cms.biz.service.query;
import cn.qweb.cms.core.base.BaseQueryEntity;
import org.springframework.format.annotation.DateTimeFormat;

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

public class NavigationQUERY extends BaseQueryEntity implements Serializable{
    private static final long serialVersionUID = 1L;


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
     *@Fields is_expand:是否展开
     */
    private String isExpand;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    /**
     *@Fields gmt_modified:
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;


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
    }
    public String getIsDisplay(){
        return isDisplay;
    }
    public void setIsExpand(String isExpand){
        this.isExpand = isExpand;
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
    @Override
    public String toString(){
        return "Navigation{" +
                    "name='" + name + "\'," +
                    "parentId='" + parentId + "\'," +
                    "isDisplay='" + isDisplay + "\'," +
                    "isExpand='" + isExpand + "\'," +
                    "link='" + link + "\'," +
                    "isBlank='" + isBlank + "\'," +
                    "icon='" + icon + "\'," +
                    "priority='" + priority + "\'," +
                    "style='" + style + "\'," +
                    "clas='" + clas + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
}