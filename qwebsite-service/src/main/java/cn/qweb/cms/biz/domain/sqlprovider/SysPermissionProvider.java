package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.SysPermissionDO;
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

public class SysPermissionProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_sys_permission";

    public static final String[] Fields={"id","parent_id","name","uri","icon","menu_class","spread_flag","icon_flag","is_menu","gmt_create","gmt_modified"};

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
    public String list(final SysPermissionDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("id=#{id}");
                }
                if(bean.getParentId()!=null){
                    WHERE("parent_id=#{parentId}");
                }
                if(bean.getName()!=null){
                    WHERE("name=#{name}");
                }
                if(bean.getUri()!=null){
                    WHERE("uri=#{uri}");
                }
                if(bean.getIcon()!=null){
                    WHERE("icon=#{icon}");
                }
                if(bean.getMenuClass()!=null){
                    WHERE("menu_class=#{menuClass}");
                }
                if(bean.getSpreadFlag()!=null){
                    WHERE("spread_flag=#{spreadFlag}");
                }
                if(bean.getIconFlag()!=null){
                    WHERE("icon_flag=#{iconFlag}");
                }
                if(bean.getIsMenu()!=null){
                    WHERE("is_menu=#{isMenu}");
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
    public String save(final SysPermissionDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getParentId() != null) {
                VALUES("parent_id", "#{parentId}");
            }
            if (bean.getName() != null) {
                VALUES("name", "#{name}");
            }
            if (bean.getUri() != null) {
                VALUES("uri", "#{uri}");
            }
            if (bean.getIcon() != null) {
                VALUES("icon", "#{icon}");
            }
            if (bean.getMenuClass() != null) {
                VALUES("menu_class", "#{menuClass}");
            }
            if (bean.getSpreadFlag() != null) {
                VALUES("spread_flag", "#{spreadFlag}");
            }
            if (bean.getIconFlag() != null) {
                VALUES("icon_flag", "#{iconFlag}");
            }
            if (bean.getIsMenu() != null) {
                VALUES("is_menu", "#{isMenu}");
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
    public String update(final SysPermissionDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getParentId() != null) {
                SET("parent_id=#{parentId}");
            }
            if (bean.getName() != null) {
                SET("name=#{name}");
            }
            if (bean.getUri() != null) {
                SET("uri=#{uri}");
            }
            if (bean.getIcon() != null) {
                SET("icon=#{icon}");
            }
            if (bean.getMenuClass() != null) {
                SET("menu_class=#{menuClass}");
            }
            if (bean.getSpreadFlag() != null) {
                SET("spread_flag=#{spreadFlag}");
            }
            if (bean.getIconFlag() != null) {
                SET("icon_flag=#{iconFlag}");
            }
            if (bean.getIsMenu() != null) {
                SET("is_menu=#{isMenu}");
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
    public String remove(final SysPermissionDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getParentId()!=null){
                WHERE("parent_id=#{parentId}");
            }
            if(bean.getName()!=null){
                WHERE("name=#{name}");
            }
            if(bean.getUri()!=null){
                WHERE("uri=#{uri}");
            }
            if(bean.getIcon()!=null){
                WHERE("icon=#{icon}");
            }
            if(bean.getMenuClass()!=null){
                WHERE("menu_class=#{menuClass}");
            }
            if(bean.getSpreadFlag()!=null){
                WHERE("spread_flag=#{spreadFlag}");
            }
            if(bean.getIconFlag()!=null){
                WHERE("icon_flag=#{iconFlag}");
            }
            if(bean.getIsMenu()!=null){
                WHERE("is_menu=#{isMenu}");
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