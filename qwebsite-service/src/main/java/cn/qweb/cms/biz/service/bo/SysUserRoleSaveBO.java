package cn.qweb.cms.biz.service.bo;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/*
 *  Created by xuebj - 2017/03/15.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class SysUserRoleSaveBO implements Serializable{
    private static final long serialVersionUID = 1L;


    /**
     *@Fields user_id:用户主键id
     */
    @NotNull(message = "用户id不能为空")
    private Long userId;

    /**
     *@Fields role_id:角色ID
     */
    @NotNull(message = "角色id不能为空")
    private Long roleId;

    /**
     *@Fields remark:说明
     */
    private String remark;


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

    @Override
    public String toString() {
        return "SysUserRoleSaveBO{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                ", remark='" + remark + '\'' +
                '}';
    }
}