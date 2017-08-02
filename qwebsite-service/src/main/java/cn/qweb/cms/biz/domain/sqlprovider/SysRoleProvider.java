package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.SysRoleDO;
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

public class SysRoleProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_sys_role";

    public static final String[] Fields={"id","role_name","priority","is_super","gmt_create","gmt_modified"};

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
    public String list(final SysRoleDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("id=#{id}");
                }
                if(bean.getRoleName()!=null){
                    WHERE("role_name=#{roleName}");
                }
                if(bean.getPriority()!=null){
                    WHERE("priority=#{priority}");
                }
                if(bean.getIsSuper()!=null){
                    WHERE("is_super=#{isSuper}");
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

    public String listByIds(final Map<String,Object> map){
        Set<Long> ids = (Set<Long>) map.get("ids");
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            WHERE("id in (" + StringUtils.substringBetween(ids.toString(),"[","]") +")");

        }}.toString();
    }


    /**
     *  保存单个对象
     */
    public String save(final SysRoleDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getRoleName() != null) {
                VALUES("role_name", "#{roleName}");
            }
            if (bean.getPriority() != null) {
                VALUES("priority", "#{priority}");
            }
            if (bean.getIsSuper() != null) {
                VALUES("is_super", "#{isSuper}");
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
    public String update(final SysRoleDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getRoleName() != null) {
                SET("role_name=#{roleName}");
            }
            if (bean.getPriority() != null) {
                SET("priority=#{priority}");
            }
            if (bean.getIsSuper() != null) {
                SET("is_super=#{isSuper}");
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
    public String remove(final SysRoleDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getRoleName()!=null){
                WHERE("role_name=#{roleName}");
            }
            if(bean.getPriority()!=null){
                WHERE("priority=#{priority}");
            }
            if(bean.getIsSuper()!=null){
                WHERE("is_super=#{isSuper}");
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