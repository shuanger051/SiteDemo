package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.SysUserRoleDO;
import cn.qweb.cms.biz.service.query.UserRoleQUERY;
import org.apache.ibatis.jdbc.SQL;
import cn.qweb.cms.core.base.BaseDynaSqlProvider;

/*
 *  Created by xuebj - 2017/03/14.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class SysUserRoleProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_sys_user_role";

    public static final String[] Fields={"id","user_id","role_id","remark","gmt_create","gmt_modified"};

    public static final String[] userFields={"id","user_name","email","is_admin","is_disabled"};

    /**
     * 获取单个结果集
     */
    public String get(final Long id){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            WHERE("id="+id);
        }}.toString();
    }

    /**
     * 查询多个结果集
     */
    public String list(final SysUserRoleDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("id=#{id}");
                }
                if(bean.getUserId()!=null){
                    WHERE("user_id=#{userId}");
                }
                if(bean.getRoleId()!=null){
                    WHERE("role_id=#{roleId}");
                }
                if(bean.getRemark()!=null){
                    WHERE("remark=#{remark}");
                }
                if(bean.getGmtCreate()!=null){
                    WHERE("gmt_create=#{gmtCreate}");
                }
                if(bean.getGmtModified()!=null){
                    WHERE("gmt_modified=#{gmtModified}");
                }
                if(bean.getSort() != null){
                    ORDER_BY(bean.getSort());
                }
            }

        }}.toString();
    }

    public String listUserWithRole(final UserRoleQUERY bean){
        return new SQL(){{
            SELECT(getField(userFields,"user"),"role.role_id as role_id");
            FROM(UserProvider.TABLE_ALIAS + " user, " + TABLE_ALIAS + " role");
            WHERE("user.id = role.user_id");
            if(bean.getUserName() != null){
                WHERE("user.user_name=#{userName}");
            }
            if(bean.getRoleId() != null){
                WHERE("role.role_id= #{roleId}");
            }
        }}.toString();
    }

    public String searchUser(final UserRoleQUERY bean){
        return new SQL(){{
            SELECT(getField(userFields,"user"),"role.role_id as role_id");
            FROM(UserProvider.TABLE_ALIAS + " user");
            LEFT_OUTER_JOIN(TABLE_ALIAS + " role ON user.id = role.user_id");
            if(bean.getUserName() != null){
                WHERE("user.user_name like CONCAT('%',#{userName},'%')");
            }
            if(bean.getRoleId() != null){
                WHERE("role.role_id= #{roleId}");
            }
        }}.toString();
    }

    /**
     *  保存单个对象
     */
    public String save(final SysUserRoleDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getUserId() != null) {
                VALUES("user_id", "#{userId}");
            }
            if (bean.getRoleId() != null) {
                VALUES("role_id", "#{roleId}");
            }
            if (bean.getRemark() != null) {
                VALUES("remark", "#{remark}");
            }
            if (bean.getGmtCreate() != null) {
                VALUES("gmt_create", "#{gmtCreate}");
            }
            if (bean.getGmtModified() != null) {
                VALUES("gmt_modified", "#{gmtModified}");
            }
        }}.toString();
    }

    /**
     * 更新对象
     */
    public String update(final SysUserRoleDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getUserId() != null) {
                SET("user_id=#{userId}");
            }
            if (bean.getRoleId() != null) {
                SET("role_id=#{roleId}");
            }
            if (bean.getRemark() != null) {
                SET("remark=#{remark}");
            }
            if (bean.getGmtCreate() != null) {
                SET("gmt_create=#{gmtCreate}");
            }
            if (bean.getGmtModified() != null) {
                SET("gmt_modified=#{gmtModified}");
            }
            WHERE("id = #{id}");
        }}.toString();
    }


    /**
     * 按条件移除对象
     */
    public String remove(final SysUserRoleDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getUserId()!=null){
                WHERE("user_id=#{userId}");
            }
            if(bean.getRoleId()!=null){
                WHERE("role_id=#{roleId}");
            }
            if(bean.getRemark()!=null){
                WHERE("remark=#{remark}");
            }
            if(bean.getGmtCreate()!=null){
                WHERE("gmt_create=#{gmtCreate}");
            }
            if(bean.getGmtModified()!=null){
                WHERE("gmt_modified=#{gmtModified}");
            }
            }}.toString();
    }

    /**
     * 删除单个对象
     */
    public String delete(final Long id){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            WHERE("id=" + id);
        }}.toString();
    }


}