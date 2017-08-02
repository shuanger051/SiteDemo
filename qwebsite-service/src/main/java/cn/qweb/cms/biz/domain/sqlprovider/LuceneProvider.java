package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.LuceneDO;
import org.apache.ibatis.jdbc.SQL;
import cn.qweb.cms.core.base.BaseDynaSqlProvider;

/*
 *  Created by xuebj - 2017/04/07.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class LuceneProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_lucene";

    public static final String[] Fields={"id","title","content","pic","video","status","gmt_add","gmt_create","gmt_modified"};

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
    public String list(final LuceneDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("id=#{id}");
                }
                if(bean.getTitle()!=null){
                    WHERE("title=#{title}");
                }
                if(bean.getContent()!=null){
                    WHERE("content=#{content}");
                }
                if(bean.getPic()!=null){
                    WHERE("pic=#{pic}");
                }
                if(bean.getVideo()!=null){
                    WHERE("video=#{video}");
                }
                if(bean.getStatus()!=null){
                    WHERE("status=#{status}");
                }
                if(bean.getGmtAdd()!=null){
                    WHERE("gmt_add=#{gmtAdd}");
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
    public String save(final LuceneDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getTitle() != null) {
                VALUES("title", "#{title}");
            }
            if (bean.getContent() != null) {
                VALUES("content", "#{content}");
            }
            if (bean.getPic() != null) {
                VALUES("pic", "#{pic}");
            }
            if (bean.getVideo() != null) {
                VALUES("video", "#{video}");
            }
            if (bean.getStatus() != null) {
                VALUES("status", "#{status}");
            }
            if (bean.getGmtAdd() != null) {
                VALUES("gmt_add", "#{gmtAdd}");
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
    public String update(final LuceneDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getTitle() != null) {
                SET("title=#{title}");
            }
            if (bean.getContent() != null) {
                SET("content=#{content}");
            }
            if (bean.getPic() != null) {
                SET("pic=#{pic}");
            }
            if (bean.getVideo() != null) {
                SET("video=#{video}");
            }
            if (bean.getStatus() != null) {
                SET("status=#{status}");
            }
            if (bean.getGmtAdd() != null) {
                SET("gmt_add=#{gmtAdd}");
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
    public String remove(final LuceneDO bean){
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
            if(bean.getPic()!=null){
                WHERE("pic=#{pic}");
            }
            if(bean.getVideo()!=null){
                WHERE("video=#{video}");
            }
            if(bean.getStatus()!=null){
                WHERE("status=#{status}");
            }
            if(bean.getGmtAdd()!=null){
                WHERE("gmt_add=#{gmtAdd}");
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