package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.NavigationDO;
import org.apache.ibatis.jdbc.SQL;
import cn.qweb.cms.core.base.BaseDynaSqlProvider;

/*
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class NavigationProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_navigation";

    public static final String[] Fields={"id","name","parent_id","is_display","is_expand","link","is_blank","icon","priority","style","clas","gmt_create","gmt_modified"};

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
    public String list(final NavigationDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("id=#{id}");
                }
                if(bean.getName()!=null){
                    WHERE("name=#{name}");
                }
                if(bean.getParentId()!=null){
                    WHERE("parent_id=#{parentId}");
                }
                if(bean.getIsDisplay()!=null){
                    WHERE("is_display=#{isDisplay}");
                }
                if(bean.getIsExpand()!=null){
                    WHERE("is_expand=#{isExpand}");
                }
                if(bean.getLink()!=null){
                    WHERE("link=#{link}");
                }
                if(bean.getIsBlank()!=null){
                    WHERE("is_blank=#{isBlank}");
                }
                if(bean.getIcon()!=null){
                    WHERE("icon=#{icon}");
                }
                if(bean.getPriority()!=null){
                    WHERE("priority=#{priority}");
                }
                if(bean.getStyle()!=null){
                    WHERE("style=#{style}");
                }
                if(bean.getClas()!=null){
                    WHERE("clas=#{clas}");
                }
                if(bean.getGmtCreate()!=null){
                    WHERE("gmt_create=#{gmtCreate}");
                }
                if(bean.getGmtModified()!=null){
                    WHERE("gmt_modified=#{gmtModified}");
                }
                if(bean.getSort() != null){
                    ORDER_BY(bean.getSort());
                }else {
                    ORDER_BY("priority asc");
                }
            }

        }}.toString();
    }

    /**
     *  保存单个对象
     */
    public String save(final NavigationDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getName() != null) {
                VALUES("name", "#{name}");
            }
            if (bean.getParentId() != null) {
                VALUES("parent_id", "#{parentId}");
            }
            if (bean.getIsDisplay() != null) {
                VALUES("is_display", "#{isDisplay}");
            }
            if (bean.getIsExpand() != null) {
                VALUES("is_expand", "#{isExpand}");
            }
            if (bean.getLink() != null) {
                VALUES("link", "#{link}");
            }
            if (bean.getIsBlank() != null) {
                VALUES("is_blank", "#{isBlank}");
            }
            if (bean.getIcon() != null) {
                VALUES("icon", "#{icon}");
            }
            if (bean.getPriority() != null) {
                VALUES("priority", "#{priority}");
            }
            if (bean.getStyle() != null) {
                VALUES("style", "#{style}");
            }
            if (bean.getClas() != null) {
                VALUES("clas", "#{clas}");
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
    public String update(final NavigationDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getName() != null) {
                SET("name=#{name}");
            }
            if (bean.getParentId() != null) {
                SET("parent_id=#{parentId}");
            }
            if (bean.getIsDisplay() != null) {
                SET("is_display=#{isDisplay}");
            }
            if (bean.getIsExpand() != null) {
                SET("is_expand=#{isExpand}");
            }
            if (bean.getLink() != null) {
                SET("link=#{link}");
            }
            if (bean.getIsBlank() != null) {
                SET("is_blank=#{isBlank}");
            }
            if (bean.getIcon() != null) {
                SET("icon=#{icon}");
            }
            if (bean.getPriority() != null) {
                SET("priority=#{priority}");
            }
            if (bean.getStyle() != null) {
                SET("style=#{style}");
            }
            if (bean.getClas() != null) {
                SET("clas=#{clas}");
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
    public String remove(final NavigationDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getName()!=null){
                WHERE("name=#{name}");
            }
            if(bean.getParentId()!=null){
                WHERE("parent_id=#{parentId}");
            }
            if(bean.getIsDisplay()!=null){
                WHERE("is_display=#{isDisplay}");
            }
            if(bean.getIsExpand()!=null){
                WHERE("is_expand=#{isExpand}");
            }
            if(bean.getLink()!=null){
                WHERE("link=#{link}");
            }
            if(bean.getIsBlank()!=null){
                WHERE("is_blank=#{isBlank}");
            }
            if(bean.getIcon()!=null){
                WHERE("icon=#{icon}");
            }
            if(bean.getPriority()!=null){
                WHERE("priority=#{priority}");
            }
            if(bean.getStyle()!=null){
                WHERE("style=#{style}");
            }
            if(bean.getClas()!=null){
                WHERE("clas=#{clas}");
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