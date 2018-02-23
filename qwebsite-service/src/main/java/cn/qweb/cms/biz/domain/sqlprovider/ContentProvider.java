package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.ContentDO;
import cn.qweb.cms.biz.domain.ContentNextQuery;
import cn.qweb.cms.biz.service.query.ContentQUERY;
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

public class ContentProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_content";

    public static final String[] Fields={"id","channel_id","sort_date","top_level","is_recommend","status","views_day","comments_day","downloads_day","ups_day","gmt_create","gmt_modified"};

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

    public String getNext(final ContentNextQuery bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if(bean.getNext()){
                WHERE("id < #{id}");
            }else{
                WHERE("id > #{id}");
            }
            if(null != bean.getStatus()){
                WHERE("status=#{status}");
            }
            if(null != bean.getChannelId()){
                WHERE("channel_id=#{channelId}");
            }
            if (bean.getNext()){
                ORDER_BY("id desc");
            }else {
                ORDER_BY("id");
            }
        }}.toString();
    }

    /**
     * 查询多个结果集
     */
    public String list(final ContentQUERY bean){
        return new SQL(){{
            SELECT(getField(Fields,"a"));
            FROM(TABLE_ALIAS + " a," + ContentExtProvider.TABLE_ALIAS+ " b");
            WHERE("a.id = b.content_id");
            if (null != bean){
                if(bean.getChannelId()!=null){
                    WHERE("a.channel_id=#{channelId}");
                }
                if(bean.getSortDateStart()!=null){
                    WHERE("b.sort_date>=#{sortDateStart}");
                }
                if(bean.getSortDateEnd() !=null ){
                    WHERE("a.sort_date<=#{sortDateEnd}");
                }
                if(bean.getReleaseDateStart() != null){
                    WHERE("b.release_date >= #{releaseDateStart}");
                }
                if(bean.getReleaseDateEnd() !=null){
                    WHERE("b.release_date <= #{releaseDateEnd}");
                }
                if(bean.getTopLevel()!=null){
                    WHERE("a.top_level=#{topLevel}");
                }
                if(bean.getRecommend() !=null){
                    WHERE("a.is_recommend=#{isRecommend}");
                }
                if(bean.getStatus()!=null){
                    WHERE("a.status=#{status}");
                }
                if(bean.getTitle() !=null){
                    WHERE("b.title like CONCAT('%',#{title},'%')");
                }
                if(bean.getAuthor()!=null){
                    WHERE("b.author like CONCAT('%',#{author},'%')");
                }
                if(bean.getSort() != null){
                    ORDER_BY(bean.getSort());
                }else{
                    ORDER_BY("b.release_date desc");
                }
            }

        }}.toString();
    }

    /**
     *  保存单个对象
     */
    public String save(final ContentDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getChannelId() != null) {
                VALUES("channel_id", "#{channelId}");
            }
            if (bean.getSortDate() != null) {
                VALUES("sort_date", "#{sortDate}");
            }
            if (bean.getTopLevel() != null) {
                VALUES("top_level", "#{topLevel}");
            }
            if (bean.getIsRecommend() != null) {
                VALUES("is_recommend", "#{isRecommend}");
            }
            if (bean.getStatus() != null) {
                VALUES("status", "#{status}");
            }
            if (bean.getViewsDay() != null) {
                VALUES("views_day", "#{viewsDay}");
            }
            if (bean.getCommentsDay() != null) {
                VALUES("comments_day", "#{commentsDay}");
            }
            if (bean.getDownloadsDay() != null) {
                VALUES("downloads_day", "#{downloadsDay}");
            }
            if (bean.getUpsDay() != null) {
                VALUES("ups_day", "#{upsDay}");
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
    public String update(final ContentDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getChannelId() != null) {
                SET("channel_id=#{channelId}");
            }
            if (bean.getSortDate() != null) {
                SET("sort_date=#{sortDate}");
            }
            if (bean.getTopLevel() != null) {
                SET("top_level=#{topLevel}");
            }
            if (bean.getIsRecommend() != null) {
                SET("is_recommend=#{isRecommend}");
            }
            if (bean.getStatus() != null) {
                SET("status=#{status}");
            }
            if (bean.getViewsDay() != null) {
                SET("views_day=#{viewsDay}");
            }
            if (bean.getCommentsDay() != null) {
                SET("comments_day=#{commentsDay}");
            }
            if (bean.getDownloadsDay() != null) {
                SET("downloads_day=#{downloadsDay}");
            }
            if (bean.getUpsDay() != null) {
                SET("ups_day=#{upsDay}");
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
    public String remove(final ContentDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getChannelId()!=null){
                WHERE("channel_id=#{channelId}");
            }
            if(bean.getSortDate()!=null){
                WHERE("sort_date=#{sortDate}");
            }
            if(bean.getTopLevel()!=null){
                WHERE("top_level=#{topLevel}");
            }
            if(bean.getIsRecommend()!=null){
                WHERE("is_recommend=#{isRecommend}");
            }
            if(bean.getStatus()!=null){
                WHERE("status=#{status}");
            }
            if(bean.getViewsDay()!=null){
                WHERE("views_day=#{viewsDay}");
            }
            if(bean.getCommentsDay()!=null){
                WHERE("comments_day=#{commentsDay}");
            }
            if(bean.getDownloadsDay()!=null){
                WHERE("downloads_day=#{downloadsDay}");
            }
            if(bean.getUpsDay()!=null){
                WHERE("ups_day=#{upsDay}");
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