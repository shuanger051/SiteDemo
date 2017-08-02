package cn.qweb.cms.biz.domain;

/**
 * Created by xuebj on 2017/3/26.
 */
public class UserRoleDO {
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
    }

    public String getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(String isDisabled) {
        this.isDisabled = isDisabled;
    }


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }


    @Override
    public String toString() {
        return "UserRoleDO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin='" + isAdmin + '\'' +
                ", isDisabled='" + isDisabled + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}


