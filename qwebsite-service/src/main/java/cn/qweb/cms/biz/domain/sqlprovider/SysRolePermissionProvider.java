package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.SysRolePermissionDO;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import cn.qweb.cms.core.base.BaseDynaSqlProvider;

import java.util.Map;
import java.util.Set;

/*
 *  Created by xuebj - 2017/03/14.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class SysRolePermissionProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_sys_role_permission";

    public static final String[] Fields={"id","role_id","permission_id","gmt_create","gmt_modified"};

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
    public String list(final SysRolePermissionDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("id=#{id}");
                }
                if(bean.getRoleId()!=null){
                    WHERE("role_id=#{roleId}");
                }
                if(bean.getPermissionId()!=null){
                    WHERE("permission_id=#{permissionId}");
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

    /**
     *  保存单个对象
     */
    public String save(final SysRolePermissionDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getRoleId() != null) {
                VALUES("role_id", "#{roleId}");
            }
            if (bean.getPermissionId() != null) {
                VALUES("permission_id", "#{permissionId}");
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
    public String update(final SysRolePermissionDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getRoleId() != null) {
                SET("role_id=#{roleId}");
            }
            if (bean.getPermissionId() != null) {
                SET("permission_id=#{permissionId}");
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
    public String remove(final SysRolePermissionDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getRoleId()!=null){
                WHERE("role_id=#{roleId}");
            }
            if(bean.getPermissionId()!=null){
                WHERE("permission_id=#{permissionId}");
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


    public String listPermissionByRoles(final Map<String,Object> map){
        Set<String> roles = (Set<String>) map.get("roles");
        return new SQL(){{
            SELECT(getField(SysPermissionProvider.Fields,"m"));
            FROM(TABLE_ALIAS + " r" , SysPermissionProvider.TABLE_ALIAS + " m");
            WHERE("r.permission_id = m.id");
            WHERE("r.role_id in (" + getRoleStr(roles) + ") ");
        }}.toString();
    }

    private String getRoleStr(Set<String> roles){
        return StringUtils.substringBetween(roles.toString(),"[","]");
    }



}