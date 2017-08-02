package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.ContentTxtDO;
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

public class ContentTxtProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_content_txt";

    public static final String[] Fields={"id","content_id","txt","txt1","txt2","txt3","gmt_create","gmt_modified","gmt_index"};

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

    public String getByContentId(final Long contentId){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            WHERE("content_id=#{contentId}");
        }}.toString();
    }

    /**
     * 查询多个结果集
     */
    public String list(final ContentTxtDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("id=#{id}");
                }
                if(bean.getContentId()!=null){
                    WHERE("content_id=#{contentId}");
                }
                if(bean.getTxt()!=null){
                    WHERE("txt=#{txt}");
                }
                if(bean.getTxt1()!=null){
                    WHERE("txt1=#{txt1}");
                }
                if(bean.getTxt2()!=null){
                    WHERE("txt2=#{txt2}");
                }
                if(bean.getTxt3()!=null){
                    WHERE("txt3=#{txt3}");
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
                }
            }

        }}.toString();
    }

    /**
     *  保存单个对象
     */
    public String save(final ContentTxtDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getContentId() != null) {
                VALUES("content_id", "#{contentId}");
            }
            if (bean.getTxt() != null) {
                VALUES("txt", "#{txt}");
            }
            if (bean.getTxt1() != null) {
                VALUES("txt1", "#{txt1}");
            }
            if (bean.getTxt2() != null) {
                VALUES("txt2", "#{txt2}");
            }
            if (bean.getTxt3() != null) {
                VALUES("txt3", "#{txt3}");
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
    public String update(final ContentTxtDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getTxt() != null) {
                SET("txt=#{txt}");
            }
            if (bean.getTxt1() != null) {
                SET("txt1=#{txt1}");
            }
            if (bean.getTxt2() != null) {
                SET("txt2=#{txt2}");
            }
            if (bean.getTxt3() != null) {
                SET("txt3=#{txt3}");
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
            WHERE("content_id=#{contentId}");
        }}.toString();
    }


    /**
     * 按条件移除对象
     */
    public String remove(final ContentTxtDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getContentId()!=null){
                WHERE("content_id=#{contentId}");
            }
            if(bean.getTxt()!=null){
                WHERE("txt=#{txt}");
            }
            if(bean.getTxt1()!=null){
                WHERE("txt1=#{txt1}");
            }
            if(bean.getTxt2()!=null){
                WHERE("txt2=#{txt2}");
            }
            if(bean.getTxt3()!=null){
                WHERE("txt3=#{txt3}");
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
     * 查询多个结果集
     */
    public String queryUnIndexList(final ContentTxtDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            WHERE("gmt_index is null");
            if(bean.getSort() != null){
                ORDER_BY(bean.getSort());
            }
        }}.toString();
    }


}