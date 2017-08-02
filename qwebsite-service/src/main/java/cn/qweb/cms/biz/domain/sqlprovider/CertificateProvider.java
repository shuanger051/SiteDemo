package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.CertificateDO;
import org.apache.ibatis.jdbc.SQL;
import cn.qweb.cms.core.base.BaseDynaSqlProvider;

/*
 *  Created by xuebj - 2017/04/06.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class CertificateProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_certificate";

    public static final String[] Fields={"id","name","type","img","txt","brief","priority","release_date","is_enabled","gmt_create","gmt_modified"};


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
    public String list(final CertificateDO bean){
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
                if(bean.getType()!=null){
                    WHERE("type=#{type}");
                }
                if(bean.getImg()!=null){
                    WHERE("img=#{img}");
                }
                if(bean.getTxt()!=null){
                    WHERE("txt=#{txt}");
                }
                if(bean.getBrief()!=null){
                    WHERE("brief=#{brief}");
                }
                if(bean.getPriority()!=null){
                    WHERE("priority=#{priority}");
                }
                if(bean.getReleaseDate()!=null){
                    WHERE("release_date=#{releaseDate}");
                }
                if(bean.getIsEnabled()!=null){
                    WHERE("is_enabled=#{isEnabled}");
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
                    ORDER_BY("priority asc , release_date desc");
                }
            }

        }}.toString();
    }

    /**
     *  保存单个对象
     */
    public String save(final CertificateDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getName() != null) {
                VALUES("name", "#{name}");
            }
            if (bean.getType() != null) {
                VALUES("type", "#{type}");
            }
            if (bean.getImg() != null) {
                VALUES("img", "#{img}");
            }
            if (bean.getTxt() != null) {
                VALUES("txt", "#{txt}");
            }
            if (bean.getBrief() != null) {
                VALUES("brief", "#{brief}");
            }
            if (bean.getPriority() != null) {
                VALUES("priority", "#{priority}");
            }
            if (bean.getReleaseDate() != null) {
                VALUES("release_date", "#{releaseDate}");
            }
            if (bean.getIsEnabled() != null) {
                VALUES("is_enabled", "#{isEnabled}");
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
    public String update(final CertificateDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getName() != null) {
                SET("name=#{name}");
            }
            if (bean.getType() != null) {
                SET("type=#{type}");
            }
            if (bean.getImg() != null) {
                SET("img=#{img}");
            }
            if (bean.getTxt() != null) {
                SET("txt=#{txt}");
            }
            if (bean.getBrief() != null) {
                SET("brief=#{brief}");
            }
            if (bean.getPriority() != null) {
                SET("priority=#{priority}");
            }
            if (bean.getReleaseDate() != null) {
                SET("release_date=#{releaseDate}");
            }
            if (bean.getIsEnabled() != null) {
                SET("is_enabled=#{isEnabled}");
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
    public String remove(final CertificateDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getName()!=null){
                WHERE("name=#{name}");
            }
            if(bean.getType()!=null){
                WHERE("type=#{type}");
            }
            if(bean.getImg()!=null){
                WHERE("img=#{img}");
            }
            if(bean.getTxt()!=null){
                WHERE("txt=#{txt}");
            }
            if(bean.getBrief()!=null){
                WHERE("brief=#{brief}");
            }
            if(bean.getPriority()!=null){
                WHERE("priority=#{priority}");
            }
            if(bean.getReleaseDate()!=null){
                WHERE("release_date=#{releaseDate}");
            }
            if(bean.getIsEnabled()!=null){
                WHERE("is_enabled=#{isEnabled}");
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