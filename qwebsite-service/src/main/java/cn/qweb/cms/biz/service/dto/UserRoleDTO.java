package cn.qweb.cms.biz.service.dto;

import cn.qweb.cms.core.dictionary.DictManager;

/**
 * Created by xuebj on 2017/3/26.
 */
public class UserRoleDTO {
    /**
     *@Fields id:
     */
    private Long id;
    /**
     *@Fields user_name:用户名
     */
    private String userName;
    /**
     *@Fields email:电子邮箱
     */
    private String email;

    /**
     *@Fields is_admin:是否管理员
     */
    private String isAdmin;

    /**
     * isAdmin 转义
     */
    private String isAdminName;

    /**
     * isDisabled 转义
     */
    private String isDisabledName;
    /**
     *@Fields is_disabled:0 不禁用 1 禁用
     */
    private String isDisabled;

    /**
     * 角色ID
     */

    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
        this.setIsAdminName(DictManager.getItem("isAdmin",isAdmin));
    }

    public String getIsAdminName() {
        return isAdminName;
    }

    public void setIsAdminName(String isAdminName) {
        this.isAdminName = isAdminName;
    }

    public String getIsDisabledName() {
        return isDisabledName;
    }

    public void setIsDisabledName(String isDisabledName) {
        this.isDisabledName = isDisabledName;
    }

    public String getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(String isDisabled) {
        this.isDisabled = isDisabled;
        this.setIsDisabledName(DictManager.getItem("isDisabled",isDisabled));
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRoleDTO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin='" + isAdmin + '\'' +
                ", isAdminName='" + isAdminName + '\'' +
                ", isDisabledName='" + isDisabledName + '\'' +
                ", isDisabled='" + isDisabled + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
