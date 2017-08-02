package cn.qweb.cms.biz.domain;
import cn.qweb.cms.core.base.BaseQueryEntity;

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

public class SysUserRoleDO extends BaseQueryEntity implements Serializable {

private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    private Long id;
    /**
     *@Fields user_id:用户主键id
     */
    private Long userId;
    /**
     *@Fields role_id:角色ID
     */
    private Long roleId;
    /**
     *@Fields remark:说明
     */
    private String remark;
    /**
     *@Fields gmt_create:
     */
    private Date gmtCreate;
    /**
     *@Fields gmt_modified:
     */
    private Date gmtModified;

    public SysUserRoleDO() {
    }

    public SysUserRoleDO(Long userId) {
        this.userId = userId;
    }

    public SysUserRoleDO(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }
    public Long getUserId(){
        return userId;
    }
    public void setRoleId(Long roleId){
        this.roleId = roleId;
    }
    public Long getRoleId(){
        return roleId;
    }
    public void setRemark(String remark){
        this.remark = remark;
    }
    public String getRemark(){
        return remark;
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
        return "SysUserRoleDO{" +
                    "id='" + id + "\'," +
                    "userId='" + userId + "\'," +
                    "roleId='" + roleId + "\'," +
                    "remark='" + remark + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
		}