package cn.qweb.cms.biz.service.bo;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;


/*
 *  Created by xuebj - 2017/03/15.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class SysRolePermissionRemoveBO implements Serializable{
    private static final long serialVersionUID = 1L;


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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    /**
     *@Fields gmt_modified:
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;


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
                    "roleId='" + roleId + "\'," +
                    "permissionId='" + permissionId + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
}