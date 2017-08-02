package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.IndexLineDO;
import org.apache.ibatis.jdbc.SQL;
import cn.qweb.cms.core.base.BaseDynaSqlProvider;

/*
 *  Created by xuebj - 2017/04/05.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class IndexLineProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_index_line";

    public static final String[] Fields={"id","site_name","site_link","logo","description","views","is_enabled","priority","gmt_create","gmt_modified"};

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
    public String list(final IndexLineDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("id=#{id}");
                }
                if(bean.getSiteName()!=null){
                    WHERE("site_name=#{siteName}");
                }
                if(bean.getSiteLink()!=null){
                    WHERE("site_link=#{siteLink}");
                }
                if(bean.getLogo()!=null){
                    WHERE("logo=#{logo}");
                }
                if(bean.getDescription()!=null){
                    WHERE("description=#{description}");
                }
                if(bean.getViews()!=null){
                    WHERE("views=#{views}");
                }
                if(bean.getIsEnabled()!=null){
                    WHERE("is_enabled=#{isEnabled}");
                }
                if(bean.getPriority()!=null){
                    WHERE("priority=#{priority}");
                }
                if(bean.getGmtCreate()!=null){
                    WHERE("gmt_create=#{gmtCreate}");
                }
                if(bean.getGmtModified()!=null){
                    WHERE("gmt_modified=#{gmtModified}");
                }
                if(bean.getSort() != null){
                    ORDER_BY(bean.getSort());
                }else{
                    ORDER_BY("priority");
                }
            }

        }}.toString();
    }

    /**
     *  保存单个对象
     */
    public String save(final IndexLineDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getSiteName() != null) {
                VALUES("site_name", "#{siteName}");
            }
            if (bean.getSiteLink() != null) {
                VALUES("site_link", "#{siteLink}");
            }
            if (bean.getLogo() != null) {
                VALUES("logo", "#{logo}");
            }
            if (bean.getDescription() != null) {
                VALUES("description", "#{description}");
            }
            if (bean.getViews() != null) {
                VALUES("views", "#{views}");
            }
            if (bean.getIsEnabled() != null) {
                VALUES("is_enabled", "#{isEnabled}");
            }
            if (bean.getPriority() != null) {
                VALUES("priority", "#{priority}");
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
    public String update(final IndexLineDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getSiteName() != null) {
                SET("site_name=#{siteName}");
            }
            if (bean.getSiteLink() != null) {
                SET("site_link=#{siteLink}");
            }
            if (bean.getLogo() != null) {
                SET("logo=#{logo}");
            }
            if (bean.getDescription() != null) {
                SET("description=#{description}");
            }
            if (bean.getViews() != null) {
                SET("views=#{views}");
            }
            if (bean.getIsEnabled() != null) {
                SET("is_enabled=#{isEnabled}");
            }
            if (bean.getPriority() != null) {
                SET("priority=#{priority}");
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
    public String remove(final IndexLineDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getSiteName()!=null){
                WHERE("site_name=#{siteName}");
            }
            if(bean.getSiteLink()!=null){
                WHERE("site_link=#{siteLink}");
            }
            if(bean.getLogo()!=null){
                WHERE("logo=#{logo}");
            }
            if(bean.getDescription()!=null){
                WHERE("description=#{description}");
            }
            if(bean.getViews()!=null){
                WHERE("views=#{views}");
            }
            if(bean.getIsEnabled()!=null){
                WHERE("is_enabled=#{isEnabled}");
            }
            if(bean.getPriority()!=null){
                WHERE("priority=#{priority}");
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