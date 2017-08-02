package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.ChorgraphyDO;
import cn.qweb.cms.biz.domain.ChorgraphyNextQuery;
import org.apache.ibatis.jdbc.SQL;
import cn.qweb.cms.core.base.BaseDynaSqlProvider;

/*
 *  Created by xuebj - 2017/05/11.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class ChorgraphyProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_chorgraphy";

    public static final String[] Fields={"id","name","user_id","content","authors","brief","uper_mobile","uper_name","uper_email","votes","starts","views","release_date","level","wall","count","status","dance_type","up_date","gmt_create","gmt_modified"};

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

    public String getNext(final ChorgraphyNextQuery bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if(bean.getNext()){
                WHERE("id > #{id}");
            }else{
                WHERE("id < #{id}");
            }
            if(null != bean.getStatus()){
                WHERE("status=#{status}");
            }
            ORDER_BY("id desc");
        }}.toString();
    }

    /**
     * 查询多个结果集
     */
    public String list(final ChorgraphyDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("id=#{id}");
                }
                if(bean.getName()!=null){
                    WHERE("name like CONCAT('%',#{name},'%')");
                }
                if(bean.getUserId()!=null){
                    WHERE("user_id=#{userId}");
                }
                if(bean.getContent()!=null){
                    WHERE("content=#{content}");
                }
                if(bean.getAuthors()!=null){
                    WHERE("authors=#{authors}");
                }
                if(bean.getBrief()!=null){
                    WHERE("brief=#{brief}");
                }
                if(bean.getUperMobile()!=null){
                    WHERE("uper_mobile=#{uperMobile}");
                }
                if(bean.getUperName()!=null){
                    WHERE("uper_name=#{uperName}");
                }
                if(bean.getUperEmail()!=null){
                    WHERE("uper_email=#{uperEmail}");
                }
                if(bean.getVotes()!=null){
                    WHERE("votes=#{votes}");
                }
                if(bean.getStarts()!=null){
                    WHERE("starts=#{starts}");
                }
                if(bean.getViews()!=null){
                    WHERE("views=#{views}");
                }
                if(bean.getReleaseDate()!=null){
                    WHERE("release_date=#{releaseDate}");
                }
                if(bean.getLevel()!=null){
                    WHERE("level=#{level}");
                }
                if(bean.getWall()!=null){
                    WHERE("wall=#{wall}");
                }
                if(bean.getCount()!=null){
                    WHERE("count=#{count}");
                }
                if(bean.getStatus()!=null){
                    WHERE("status=#{status}");
                }
                if(bean.getDanceType()!=null){
                    WHERE("dance_type=#{danceType}");
                }
                if(bean.getUpDate()!=null){
                    WHERE("up_date=#{upDate}");
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
    public String save(final ChorgraphyDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getName() != null) {
                VALUES("name", "#{name}");
            }
            if (bean.getUserId() != null) {
                VALUES("user_id", "#{userId}");
            }
            if (bean.getContent() != null) {
                VALUES("content", "#{content}");
            }
            if (bean.getAuthors() != null) {
                VALUES("authors", "#{authors}");
            }
            if (bean.getBrief() != null) {
                VALUES("brief", "#{brief}");
            }
            if (bean.getUperMobile() != null) {
                VALUES("uper_mobile", "#{uperMobile}");
            }
            if (bean.getUperName() != null) {
                VALUES("uper_name", "#{uperName}");
            }
            if (bean.getUperEmail() != null) {
                VALUES("uper_email", "#{uperEmail}");
            }
            if (bean.getVotes() != null) {
                VALUES("votes", "#{votes}");
            }
            if (bean.getStarts() != null) {
                VALUES("starts", "#{starts}");
            }
            if (bean.getViews() != null) {
                VALUES("views", "#{views}");
            }
            if (bean.getReleaseDate() != null) {
                VALUES("release_date", "#{releaseDate}");
            }
            if (bean.getLevel() != null) {
                VALUES("level", "#{level}");
            }
            if (bean.getWall() != null) {
                VALUES("wall", "#{wall}");
            }
            if (bean.getCount() != null) {
                VALUES("count", "#{count}");
            }
            if (bean.getStatus() != null) {
                VALUES("status", "#{status}");
            }
            if (bean.getDanceType() != null) {
                VALUES("dance_type", "#{danceType}");
            }
            if (bean.getUpDate() != null) {
                VALUES("up_date", "#{upDate}");
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
    public String update(final ChorgraphyDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getName() != null) {
                SET("name=#{name}");
            }
            if (bean.getUserId() != null) {
                SET("user_id=#{userId}");
            }
            if (bean.getContent() != null) {
                SET("content=#{content}");
            }
            if (bean.getAuthors() != null) {
                SET("authors=#{authors}");
            }
            if (bean.getBrief() != null) {
                SET("brief=#{brief}");
            }
            if (bean.getUperMobile() != null) {
                SET("uper_mobile=#{uperMobile}");
            }
            if (bean.getUperName() != null) {
                SET("uper_name=#{uperName}");
            }
            if (bean.getUperEmail() != null) {
                SET("uper_email=#{uperEmail}");
            }
            if (bean.getVotes() != null) {
                SET("votes=#{votes}");
            }
            if (bean.getStarts() != null) {
                SET("starts=#{starts}");
            }
            if (bean.getViews() != null) {
                SET("views=#{views}");
            }
            if (bean.getReleaseDate() != null) {
                SET("release_date=#{releaseDate}");
            }
            if (bean.getLevel() != null) {
                SET("level=#{level}");
            }
            if (bean.getWall() != null) {
                SET("wall=#{wall}");
            }
            if (bean.getCount() != null) {
                SET("count=#{count}");
            }
            if (bean.getStatus() != null) {
                SET("status=#{status}");
            }
            if (bean.getDanceType() != null) {
                SET("dance_type=#{danceType}");
            }
            if (bean.getUpDate() != null) {
                SET("up_date=#{upDate}");
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
    public String remove(final ChorgraphyDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getName()!=null){
                WHERE("name=#{name}");
            }
            if(bean.getUserId()!=null){
                WHERE("user_id=#{userId}");
            }
            if(bean.getContent()!=null){
                WHERE("content=#{content}");
            }
            if(bean.getAuthors()!=null){
                WHERE("authors=#{authors}");
            }
            if(bean.getBrief()!=null){
                WHERE("brief=#{brief}");
            }
            if(bean.getUperMobile()!=null){
                WHERE("uper_mobile=#{uperMobile}");
            }
            if(bean.getUperName()!=null){
                WHERE("uper_name=#{uperName}");
            }
            if(bean.getUperEmail()!=null){
                WHERE("uper_email=#{uperEmail}");
            }
            if(bean.getVotes()!=null){
                WHERE("votes=#{votes}");
            }
            if(bean.getStarts()!=null){
                WHERE("starts=#{starts}");
            }
            if(bean.getViews()!=null){
                WHERE("views=#{views}");
            }
            if(bean.getReleaseDate()!=null){
                WHERE("release_date=#{releaseDate}");
            }
            if(bean.getLevel()!=null){
                WHERE("level=#{level}");
            }
            if(bean.getWall()!=null){
                WHERE("wall=#{wall}");
            }
            if(bean.getCount()!=null){
                WHERE("count=#{count}");
            }
            if(bean.getStatus()!=null){
                WHERE("status=#{status}");
            }
            if(bean.getDanceType()!=null){
                WHERE("dance_type=#{danceType}");
            }
            if(bean.getUpDate()!=null){
                WHERE("up_date=#{upDate}");
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