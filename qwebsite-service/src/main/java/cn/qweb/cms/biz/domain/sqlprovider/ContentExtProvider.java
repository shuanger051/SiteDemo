package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.ContentExtDO;
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

public class ContentExtProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_content_ext";

    public static final String[] Fields={"id","content_id","title","short_title","author","origin","origin_url","release_date","media_path","media_type","title_img","content_img","type_img","link","need_regenerate","description","gmt_create","gmt_modified","gmt_index"};

    /**
     * 获取单个结果集
     */
    public String get(final Long id){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            WHERE("id=#{id}");
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
    public String list(final ContentExtDO bean){
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
                if(bean.getTitle()!=null){
                    WHERE("title=#{title}");
                }
                if(bean.getShortTitle()!=null){
                    WHERE("short_title=#{shortTitle}");
                }
                if(bean.getAuthor()!=null){
                    WHERE("author=#{author}");
                }
                if(bean.getOrigin()!=null){
                    WHERE("origin=#{origin}");
                }
                if(bean.getOriginUrl()!=null){
                    WHERE("origin_url=#{originUrl}");
                }
                if(bean.getReleaseDate()!=null){
                    WHERE("release_date=#{releaseDate}");
                }
                if(bean.getMediaPath()!=null){
                    WHERE("media_path=#{mediaPath}");
                }
                if(bean.getMediaType()!=null){
                    WHERE("media_type=#{mediaType}");
                }
                if(bean.getTitleImg()!=null){
                    WHERE("title_img=#{titleImg}");
                }
                if(bean.getContentImg()!=null){
                    WHERE("content_img=#{contentImg}");
                }
                if(bean.getTypeImg()!=null){
                    WHERE("type_img=#{typeImg}");
                }
                if(bean.getLink()!=null){
                    WHERE("link=#{link}");
                }
                if(bean.getNeedRegenerate()!=null){
                    WHERE("need_regenerate=#{needRegenerate}");
                }
                if(bean.getDescription()!=null){
                    WHERE("description=#{description}");
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
    public String save(final ContentExtDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getContentId() != null) {
                VALUES("content_id", "#{contentId}");
            }
            if (bean.getTitle() != null) {
                VALUES("title", "#{title}");
            }
            if (bean.getShortTitle() != null) {
                VALUES("short_title", "#{shortTitle}");
            }
            if (bean.getAuthor() != null) {
                VALUES("author", "#{author}");
            }
            if (bean.getOrigin() != null) {
                VALUES("origin", "#{origin}");
            }
            if (bean.getOriginUrl() != null) {
                VALUES("origin_url", "#{originUrl}");
            }
            if (bean.getReleaseDate() != null) {
                VALUES("release_date", "#{releaseDate}");
            }
            if (bean.getMediaPath() != null) {
                VALUES("media_path", "#{mediaPath}");
            }
            if (bean.getMediaType() != null) {
                VALUES("media_type", "#{mediaType}");
            }
            if (bean.getTitleImg() != null) {
                VALUES("title_img", "#{titleImg}");
            }
            if (bean.getContentImg() != null) {
                VALUES("content_img", "#{contentImg}");
            }
            if (bean.getTypeImg() != null) {
                VALUES("type_img", "#{typeImg}");
            }
            if (bean.getLink() != null) {
                VALUES("link", "#{link}");
            }
            if (bean.getNeedRegenerate() != null) {
                VALUES("need_regenerate", "#{needRegenerate}");
            }
            if (bean.getDescription() != null) {
                VALUES("description", "#{description}");
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
    public String update(final ContentExtDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getTitle() != null) {
                SET("title=#{title}");
            }
            if (bean.getShortTitle() != null) {
                SET("short_title=#{shortTitle}");
            }
            if (bean.getAuthor() != null) {
                SET("author=#{author}");
            }
            if (bean.getOrigin() != null) {
                SET("origin=#{origin}");
            }
            if (bean.getOriginUrl() != null) {
                SET("origin_url=#{originUrl}");
            }
            if (bean.getReleaseDate() != null) {
                SET("release_date=#{releaseDate}");
            }
            if (bean.getMediaPath() != null) {
                SET("media_path=#{mediaPath}");
            }
            if (bean.getMediaType() != null) {
                SET("media_type=#{mediaType}");
            }
            if (bean.getTitleImg() != null) {
                SET("title_img=#{titleImg}");
            }
            if (bean.getContentImg() != null) {
                SET("content_img=#{contentImg}");
            }
            if (bean.getTypeImg() != null) {
                SET("type_img=#{typeImg}");
            }
            if (bean.getLink() != null) {
                SET("link=#{link}");
            }
            if (bean.getNeedRegenerate() != null) {
                SET("need_regenerate=#{needRegenerate}");
            }
            if (bean.getDescription() != null) {
                SET("description=#{description}");
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
    public String remove(final ContentExtDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getContentId()!=null){
                WHERE("content_id=#{contentId}");
            }
            if(bean.getTitle()!=null){
                WHERE("title=#{title}");
            }
            if(bean.getShortTitle()!=null){
                WHERE("short_title=#{shortTitle}");
            }
            if(bean.getAuthor()!=null){
                WHERE("author=#{author}");
            }
            if(bean.getOrigin()!=null){
                WHERE("origin=#{origin}");
            }
            if(bean.getOriginUrl()!=null){
                WHERE("origin_url=#{originUrl}");
            }
            if(bean.getReleaseDate()!=null){
                WHERE("release_date=#{releaseDate}");
            }
            if(bean.getMediaPath()!=null){
                WHERE("media_path=#{mediaPath}");
            }
            if(bean.getMediaType()!=null){
                WHERE("media_type=#{mediaType}");
            }
            if(bean.getTitleImg()!=null){
                WHERE("title_img=#{titleImg}");
            }
            if(bean.getContentImg()!=null){
                WHERE("content_img=#{contentImg}");
            }
            if(bean.getTypeImg()!=null){
                WHERE("type_img=#{typeImg}");
            }
            if(bean.getLink()!=null){
                WHERE("link=#{link}");
            }
            if(bean.getNeedRegenerate()!=null){
                WHERE("need_regenerate=#{needRegenerate}");
            }
            if(bean.getDescription()!=null){
                WHERE("description=#{description}");
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
    public String queryUnIndexList(final ContentExtDO bean){
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
    public String queryIndexList(final ContentExtDO bean){
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
     * 删除索引时将索引置为空
     * @param bean
     * @return
     */
    public String updateIndexTime(final ContentExtDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            SET("gmt_index = null");
            WHERE("id = #{id}");
        }}.toString();
    }

    /**
     * 根据contentID 查询所属栏目
     * @param bean
     * @return
     */
    public String queryChannelByContentID(final ContentExtDO bean){
        return new SQL(){{
            SELECT(" tc.channel_path ");
            FROM(" t_content_ext e, t_content c, t_channel tc ");
            SET("gmt_index = null");
            WHERE(" e.content_id = c.id AND c.channel_id = tc.id AND e.content_id = #{contentId}");
        }}.toString();
    }


}