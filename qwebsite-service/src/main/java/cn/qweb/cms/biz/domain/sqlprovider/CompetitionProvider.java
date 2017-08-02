package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.CompetitionDO;
import org.apache.ibatis.jdbc.SQL;
import cn.qweb.cms.core.base.BaseDynaSqlProvider;

/*
 *  Created by xuebj - 2017/05/24.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class CompetitionProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_competition";

    public static final String[] Fields={"id","title","content","division","status","province","gmt_begin","gmt_end","gmt_create","gmt_modified","gmt_index"};

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
    public String list(final CompetitionDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("id=#{id}");
                }
                if(bean.getTitle()!=null){
                    WHERE("title like concat ('%',#{title},'%')");
                }
                if(bean.getContent()!=null){
                    WHERE("content=#{content}");
                }
                if(bean.getDivision()!= null){
                    WHERE("division=#{division}");
                }
                if(bean.getStatus()!=null){
                    WHERE("status=#{status}");
                }
                if(bean.getProvince()!=null){
                    WHERE("province=#{province}");
                }
                if(bean.getGmtBegin()!=null){
                    WHERE("gmt_begin <= #{gmtBegin}");
                }
                if(bean.getGmtEnd()!=null){
                    WHERE("gmt_end >= #{gmtEnd}");
                }
                if(bean.getGmtCreate()!=null){
                    WHERE("gmt_create=#{gmtCreate}");
                }
                if(bean.getGmtModified()!=null){
                    WHERE("gmt_modified=#{gmtModified}");
                }
                if(bean.getGmtIndex()!=null){
                    WHERE("gmt_index=#{gmtIndex}");
                }
                if(bean.getSort() != null){
                    ORDER_BY(bean.getSort());
                }else{
                    ORDER_BY("gmt_create desc");
                }
            }

        }}.toString();
    }

    /**
     *  保存单个对象
     */
    public String save(final CompetitionDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getTitle() != null) {
                VALUES("title", "#{title}");
            }
            if (bean.getContent() != null) {
                VALUES("content", "#{content}");
            }
            if (bean.getStatus() != null) {
                VALUES("status", "#{status}");
            }
            if (bean.getDivision() != null) {
                VALUES("division", "#{division}");
            }
            if(bean.getProvince() != null){
                VALUES("province", "#{province}");
            }
            if(bean.getGmtBegin() != null){
                VALUES("gmt_begin", "#{gmtBegin}");
            }
            if(bean.getGmtEnd() != null){
                VALUES("gmt_end", "#{gmtEnd}");
            }
            if (bean.getGmtCreate() != null) {
                VALUES("gmt_create", "#{gmtCreate}");
            }
            if (bean.getGmtModified() != null) {
                VALUES("gmt_modified", "#{gmtModified}");
            }
            if (bean.getGmtIndex() != null) {
                VALUES("gmt_index", "#{gmtIndex}");
            }
        }}.toString();
    }

    /**
     * 更新对象
     */
    public String update(final CompetitionDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getTitle() != null) {
                SET("title=#{title}");
            }
            if (bean.getContent() != null) {
                SET("content=#{content}");
            }
            if (bean.getDivision() != null) {
                SET("division=#{division}");
            }
            if (bean.getStatus() != null) {
                SET("status=#{status}");
            }
            if(bean.getProvince() != null){
                SET("province=#{province}");
            }
            if(bean.getGmtBegin() != null){
                SET("gmt_begin=#{gmtBegin}");
            }
            if(bean.getGmtEnd() != null){
                SET("gmt_end=#{gmtEnd}");
            }
            if (bean.getGmtCreate() != null) {
                SET("gmt_create=#{gmtCreate}");
            }
            if (bean.getGmtModified() != null) {
                SET("gmt_modified=#{gmtModified}");
            }
            if (bean.getGmtIndex() != null) {
                SET("gmt_index=#{gmtIndex}");
            }
            WHERE("id = #{id}");
        }}.toString();
    }


    /**
     * 按条件移除对象
     */
    public String remove(final CompetitionDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getTitle()!=null){
                WHERE("title=#{title}");
            }
            if(bean.getContent()!=null){
                WHERE("content=#{content}");
            }
            if(bean.getDivision()!=null){
                WHERE("division=#{division}");
            }
            if(bean.getStatus()!=null){
                WHERE("status=#{status}");
            }
            if(bean.getProvince()!=null){
                WHERE("province=#{province}");
            }
            if(bean.getGmtBegin()!=null){
                WHERE("gmt_begin=#{gmtBegin}");
            }
            if(bean.getGmtEnd()!=null){
                WHERE("gmt_end=#{gmtEnd}");
            }
            if(bean.getGmtCreate()!=null){
                WHERE("gmt_create=#{gmtCreate}");
            }
            if(bean.getGmtModified()!=null){
                WHERE("gmt_modified=#{gmtModified}");
            }
            if(bean.getGmtIndex()!=null){
                WHERE("gmt_index=#{gmtIndex}");
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