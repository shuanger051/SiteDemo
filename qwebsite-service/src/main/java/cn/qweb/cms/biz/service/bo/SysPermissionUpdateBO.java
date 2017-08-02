package cn.qweb.cms.biz.service.bo;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;

/*
 *  Created by xuebj - 2017/03/15.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class SysPermissionUpdateBO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    @NotNull(message = "唯一键不能为空")
    private Long id;
    /**
     *@Fields parent_id:父节点
     */
    private Integer parentId;
    /**
     *@Fields name:权限名称
     */
    private String name;
    /**
     *@Fields uri:权限
     */
    private String uri;
    /**
     *@Fields icon:图标字符
     */
    private String icon;
    /**
     *@Fields menu_class:菜单样式
     */
    private String menuClass;
    /**
     *@Fields spread_flag:菜单是否默认展开 1展开 0 不展开
     */
    private String spreadFlag;
    /**
     *@Fields icon_flag:是否系统图标 1 是 0 否
     */
    private String iconFlag;
    /**
     *@Fields is_menu:菜单还是功能 1 菜单 0 功能
     */
    private String isMenu;
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
    public void setParentId(Integer parentId){
        this.parentId = parentId;
    }
    public Integer getParentId(){
        return parentId;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setUri(String uri){
        this.uri = uri;
    }
    public String getUri(){
        return uri;
    }
    public void setIcon(String icon){
        this.icon = icon;
    }
    public String getIcon(){
        return icon;
    }
    public void setMenuClass(String menuClass){
        this.menuClass = menuClass;
    }
    public String getMenuClass(){
        return menuClass;
    }
    public void setSpreadFlag(String spreadFlag){
        this.spreadFlag = spreadFlag;
    }
    public String getSpreadFlag(){
        return spreadFlag;
    }
    public void setIconFlag(String iconFlag){
        this.iconFlag = iconFlag;
    }
    public String getIconFlag(){
        return iconFlag;
    }
    public void setIsMenu(String isMenu){
        this.isMenu = isMenu;
    }
    public String getIsMenu(){
        return isMenu;
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
        return "SysPermission{" +
                    "id='" + id + "\'," +
                    "parentId='" + parentId + "\'," +
                    "name='" + name + "\'," +
                    "uri='" + uri + "\'," +
                    "icon='" + icon + "\'," +
                    "menuClass='" + menuClass + "\'," +
                    "spreadFlag='" + spreadFlag + "\'," +
                    "iconFlag='" + iconFlag + "\'," +
                    "isMenu='" + isMenu + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
        }