package cn.qweb.cms.biz.service.query;

import cn.qweb.cms.core.base.BaseQueryEntity;

/**
 * Created by xuebj on 2017/3/26.
 */
public class UserRoleQUERY extends BaseQueryEntity {
    /**
     * 角色id
     */
//    @NotNull(message = "角色ID不能为空")
    private Long roleId;
    /**
     * 用户名
     */
    private String userName;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
