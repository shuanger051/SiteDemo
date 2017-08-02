package cn.qweb.cms.biz.service.dto;
import java.io.Serializable;
import java.util.Date;


/*
 *  Created by xuebj - 2017/03/14.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class SysRoleDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    private Long id;
    /**
     *@Fields role_name:角色名称
     */
    private String roleName;
    /**
     *@Fields priority:排列顺序
     */
    private Integer priority;
    /**
     *@Fields is_super:拥有所有权限
     */
    private String isSuper;
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
    public void setRoleName(String roleName){
        this.roleName = roleName;
    }
    public String getRoleName(){
        return roleName;
    }
    public void setPriority(Integer priority){
        this.priority = priority;
    }
    public Integer getPriority(){
        return priority;
    }
    public void setIsSuper(String isSuper){
        this.isSuper = isSuper;
    }
    public String getIsSuper(){
        return isSuper;
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
        return "SysRole{" +
                    "id='" + id + "\'," +
                    "roleName='" + roleName + "\'," +
                    "priority='" + priority + "\'," +
                    "isSuper='" + isSuper + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
        }