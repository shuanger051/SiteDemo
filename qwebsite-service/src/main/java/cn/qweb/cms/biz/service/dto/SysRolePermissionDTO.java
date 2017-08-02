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

public class SysRolePermissionDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    private Long id;
    /**
     *@Fields role_id:角色id
     */
    private Long roleId;
    /**
     *@Fields permission_id:菜单ID
     */
    private Long permissionId;
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
    public void setRoleId(Long roleId){
        this.roleId = roleId;
    }
    public Long getRoleId(){
        return roleId;
    }
    public void setPermissionId(Long permissionId){
        this.permissionId = permissionId;
    }
    public Long getPermissionId(){
        return permissionId;
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
        return "SysRolePermission{" +
                    "id='" + id + "\'," +
                    "roleId='" + roleId + "\'," +
                    "permissionId='" + permissionId + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
        }