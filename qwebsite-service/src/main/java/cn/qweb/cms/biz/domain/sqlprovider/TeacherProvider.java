package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.TeacherDO;
import cn.qweb.cms.biz.domain.TeacherNextDO;
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

public class TeacherProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_teacher";

    public static final String[] Fields={"id","real_name","head_img","content_img","brief","txt","link","priority","is_enabled","release_date","author","views","gmt_create","gmt_modified","type","level"};

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

    public String getNext(final TeacherNextDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if(bean.getNext()){
                WHERE("id < #{id}");
            }else{
                WHERE("id > #{id}");
            }
            if(bean.getLevel() != null){
                WHERE("level=#{level}");
            }
            if(bean.getType() != null){
                WHERE("type=#{type}");
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
    public String list(final TeacherDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("id=#{id}");
                }
                if(bean.getRealName()!=null){
                    WHERE("real_name like CONCAT('%',#{realName},'%')");
                }
                if(bean.getHeadImg()!=null){
                    WHERE("head_img=#{headImg}");
                }
                if(bean.getContentImg()!=null){
                    WHERE("content_img=#{contentImg}");
                }
                if(bean.getBrief()!=null){
                    WHERE("brief=#{brief}");
                }
                if(bean.getTxt()!=null){
                    WHERE("txt=#{txt}");
                }
                if(bean.getLink()!=null){
                    WHERE("link=#{link}");
                }
                if(bean.getPriority()!=null){
                    WHERE("priority=#{priority}");
                }
                if(bean.getIsEnabled()!=null){
                    WHERE("is_enabled=#{isEnabled}");
                }
                if(bean.getReleaseDate()!=null){
                    WHERE("release_date=#{releaseDate}");
                }
                if(bean.getAuthor()!=null){
                    WHERE("author=#{author}");
                }
                if(bean.getViews()!=null){
                    WHERE("views=#{views}");
                }
                if(bean.getGmtCreate()!=null){
                    WHERE("gmt_create=#{gmtCreate}");
                }
                if(bean.getGmtModified()!=null){
                    WHERE("gmt_modified=#{gmtModified}");
                }
                if(bean.getType()!=null){
                    WHERE("type=#{type}");
                }
                if(bean.getLevel()!=null){
                    WHERE("level=#{level}");
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
    public String save(final TeacherDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getRealName() != null) {
                VALUES("real_name", "#{realName}");
            }
            if (bean.getHeadImg() != null) {
                VALUES("head_img", "#{headImg}");
            }
            if (bean.getContentImg() != null) {
                VALUES("content_img", "#{contentImg}");
            }
            if (bean.getBrief() != null) {
                VALUES("brief", "#{brief}");
            }
            if (bean.getTxt() != null) {
                VALUES("txt", "#{txt}");
            }
            if (bean.getLink() != null) {
                VALUES("link", "#{link}");
            }
            if (bean.getPriority() != null) {
                VALUES("priority", "#{priority}");
            }
            if (bean.getIsEnabled() != null) {
                VALUES("is_enabled", "#{isEnabled}");
            }
            if (bean.getReleaseDate() != null) {
                VALUES("release_date", "#{releaseDate}");
            }
            if (bean.getAuthor() != null) {
                VALUES("author", "#{author}");
            }
            if (bean.getViews() != null) {
                VALUES("views", "#{views}");
            }
            if (bean.getGmtCreate() != null) {
                VALUES("gmt_create", "#{gmtCreate}");
            }
            if (bean.getGmtModified() != null) {
                VALUES("gmt_modified", "#{gmtModified}");
            }
            if (bean.getType() != null) {
                VALUES("type", "#{type}");
            }
            if (bean.getType() != null) {
                VALUES("level", "#{level}");
            }
        }}.toString();
    }

    /**
     * 更新对象
     */
    public String update(final TeacherDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getRealName() != null) {
                SET("real_name=#{realName}");
            }
            if (bean.getHeadImg() != null) {
                SET("head_img=#{headImg}");
            }
            if (bean.getContentImg() != null) {
                SET("content_img=#{contentImg}");
            }
            if (bean.getBrief() != null) {
                SET("brief=#{brief}");
            }
            if (bean.getTxt() != null) {
                SET("txt=#{txt}");
            }
            if (bean.getLink() != null) {
                SET("link=#{link}");
            }
            if (bean.getPriority() != null) {
                SET("priority=#{priority}");
            }
            if (bean.getIsEnabled() != null) {
                SET("is_enabled=#{isEnabled}");
            }
            if (bean.getReleaseDate() != null) {
                SET("release_date=#{releaseDate}");
            }
            if (bean.getAuthor() != null) {
                SET("author=#{author}");
            }
            if (bean.getViews() != null) {
                SET("views=#{views}");
            }
            if (bean.getGmtCreate() != null) {
                SET("gmt_create=#{gmtCreate}");
            }
            if (bean.getGmtModified() != null) {
                SET("gmt_modified=#{gmtModified}");
            }
            if (bean.getType() != null) {
                SET("type=#{type}");
            }
            if (bean.getLevel() != null) {
                SET("level=#{level}");
            }
            WHERE("id = #{id}");
        }}.toString();
    }


    /**
     * 按条件移除对象
     */
    public String remove(final TeacherDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getRealName()!=null){
                WHERE("real_name=#{realName}");
            }
            if(bean.getHeadImg()!=null){
                WHERE("head_img=#{headImg}");
            }
            if(bean.getContentImg()!=null){
                WHERE("content_img=#{contentImg}");
            }
            if(bean.getBrief()!=null){
                WHERE("brief=#{brief}");
            }
            if(bean.getTxt()!=null){
                WHERE("txt=#{txt}");
            }
            if(bean.getLink()!=null){
                WHERE("link=#{link}");
            }
            if(bean.getPriority()!=null){
                WHERE("priority=#{priority}");
            }
            if(bean.getIsEnabled()!=null){
                WHERE("is_enabled=#{isEnabled}");
            }
            if(bean.getReleaseDate()!=null){
                WHERE("release_date=#{releaseDate}");
            }
            if(bean.getAuthor()!=null){
                WHERE("author=#{author}");
            }
            if(bean.getViews()!=null){
                WHERE("views=#{views}");
            }
            if(bean.getGmtCreate()!=null){
                WHERE("gmt_create=#{gmtCreate}");
            }
            if(bean.getGmtModified()!=null){
                WHERE("gmt_modified=#{gmtModified}");
            }
            if(bean.getType()!=null){
                WHERE("type=#{type}");
            }
            if(bean.getLevel()!=null){
                WHERE("level=#{level}");
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