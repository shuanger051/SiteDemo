package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.ActivitySquareDO;
import cn.qweb.cms.core.base.BaseDynaSqlProvider;
import org.apache.ibatis.jdbc.SQL;

/*
 *  Created by xuebj - 2017/05/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class ActivitySquareProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_activity_square";

    public static final String[] Fields={"id","title","content","status","province","gmt_begin","gmt_end","gmt_create","gmt_modified","gmt_index"};
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
    public String list(final ActivitySquareDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("id=#{id}");
                }
                if(bean.getTitle()!=null && !bean.getTitle().equals("%null%")){
                    WHERE("title like #{title}");
                }
                if(bean.getContent()!=null){
                    WHERE("content=#{content}");
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
                if (bean.getGmtIndex()!= null){
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
    public String save(final ActivitySquareDO bean){
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
    public String update(final ActivitySquareDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getTitle() != null) {
                SET("title=#{title}");
            }
            if (bean.getContent() != null) {
                SET("content=#{content}");
            }
            if(bean.getStatus() != null){
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
    public String remove(final ActivitySquareDO bean){
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

    /**
     * 查询未索引总条数
     * @return
     */
    public String queryUnIndexTotalNum(){
        return new SQL(){{
            SELECT(" count(*) ");
            FROM(TABLE_ALIAS);
            WHERE("gmt_index is null");
        }}.toString();
    }

    /**
     * 查询已索引总条数
     * @return
     */
    public String queryIndexTotalNum(){
        return new SQL(){{
            SELECT(" count(*) ");
            FROM(TABLE_ALIAS);
            WHERE("gmt_index is not null");
        }}.toString();
    }

    /**
     * 查询多个结果集
     */
    public String queryIndexList(final ActivitySquareDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            WHERE("gmt_index is not null");
            if(bean.getSort() != null){
                ORDER_BY(bean.getSort());
            }
        }}.toString();
    }

    /**
     * 查询多个结果集
     */
    public String queryUnIndexList(final ActivitySquareDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            WHERE("gmt_index is null");
            if(bean.getSort() != null){
                ORDER_BY(bean.getSort());
            }
        }}.toString();
    }

    /**
     * 删除索引时将索引置为空
     * @param bean
     * @return
     */
    public String updateIndexTime(final ActivitySquareDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            SET("gmt_index = null");
            WHERE("id = #{id}");
        }}.toString();
    }


}