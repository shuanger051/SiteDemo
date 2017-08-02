package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.UserExtDO;
import org.apache.ibatis.jdbc.SQL;
import cn.qweb.cms.core.base.BaseDynaSqlProvider;

/*
 *  Created by xuebj - 2017/03/20.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class UserExtProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_user_ext";

    public static final String[] Fields={"id","user_id","real_name","gender","birthday","intro","comefrom","qq","msn","phone","mobile","user_img","user_signature","gmt_create","gmt_modified"};

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
     * 获取单个结果集
     */
    public String getByUserId(final Long id){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            WHERE("user_id=#{param1}");
        }}.toString();
    }

    /**
     * 查询多个结果集
     */
    public String list(final UserExtDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("id=#{id}");
                }
                if(bean.getUserId()!=null){
                    WHERE("user_id=#{userId}");
                }
                if(bean.getRealName()!=null){
                    WHERE("real_name=#{realName}");
                }
                if(bean.getGender()!=null){
                    WHERE("gender=#{gender}");
                }
                if(bean.getBirthday()!=null){
                    WHERE("birthday=#{birthday}");
                }
                if(bean.getIntro()!=null){
                    WHERE("intro=#{intro}");
                }
                if(bean.getComefrom()!=null){
                    WHERE("comefrom=#{comefrom}");
                }
                if(bean.getQq()!=null){
                    WHERE("qq=#{qq}");
                }
                if(bean.getMsn()!=null){
                    WHERE("msn=#{msn}");
                }
                if(bean.getPhone()!=null){
                    WHERE("phone=#{phone}");
                }
                if(bean.getMobile()!=null){
                    WHERE("mobile=#{mobile}");
                }
                if(bean.getUserImg()!=null){
                    WHERE("user_img=#{userImg}");
                }
                if(bean.getUserSignature()!=null){
                    WHERE("user_signature=#{userSignature}");
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
    public String save(final UserExtDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getUserId() != null) {
                VALUES("user_id", "#{userId}");
            }
            if (bean.getRealName() != null) {
                VALUES("real_name", "#{realName}");
            }
            if (bean.getGender() != null) {
                VALUES("gender", "#{gender}");
            }
            if (bean.getBirthday() != null) {
                VALUES("birthday", "#{birthday}");
            }
            if (bean.getIntro() != null) {
                VALUES("intro", "#{intro}");
            }
            if (bean.getComefrom() != null) {
                VALUES("comefrom", "#{comefrom}");
            }
            if (bean.getQq() != null) {
                VALUES("qq", "#{qq}");
            }
            if (bean.getMsn() != null) {
                VALUES("msn", "#{msn}");
            }
            if (bean.getPhone() != null) {
                VALUES("phone", "#{phone}");
            }
            if (bean.getMobile() != null) {
                VALUES("mobile", "#{mobile}");
            }
            if (bean.getUserImg() != null) {
                VALUES("user_img", "#{userImg}");
            }
            if (bean.getUserSignature() != null) {
                VALUES("user_signature", "#{userSignature}");
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
    public String update(final UserExtDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getRealName() != null) {
                SET("real_name=#{realName}");
            }
            if (bean.getGender() != null) {
                SET("gender=#{gender}");
            }
            if (bean.getBirthday() != null) {
                SET("birthday=#{birthday}");
            }
            if (bean.getIntro() != null) {
                SET("intro=#{intro}");
            }
            if (bean.getComefrom() != null) {
                SET("comefrom=#{comefrom}");
            }
            if (bean.getQq() != null) {
                SET("qq=#{qq}");
            }
            if (bean.getMsn() != null) {
                SET("msn=#{msn}");
            }
            if (bean.getPhone() != null) {
                SET("phone=#{phone}");
            }
            if (bean.getMobile() != null) {
                SET("mobile=#{mobile}");
            }
            if (bean.getUserImg() != null) {
                SET("user_img=#{userImg}");
            }
            if (bean.getUserSignature() != null) {
                SET("user_signature=#{userSignature}");
            }
            if (bean.getGmtCreate() != null) {
                SET("gmt_create=#{gmtCreate}");
            }
            if (bean.getGmtModified() != null) {
                SET("gmt_modified=#{gmtModified}");
            }
            WHERE("user_id = #{userId}");
        }}.toString();
    }


    /**
     * 按条件移除对象
     */
    public String remove(final UserExtDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getUserId()!=null){
                WHERE("user_id=#{userId}");
            }
            if(bean.getRealName()!=null){
                WHERE("real_name=#{realName}");
            }
            if(bean.getGender()!=null){
                WHERE("gender=#{gender}");
            }
            if(bean.getBirthday()!=null){
                WHERE("birthday=#{birthday}");
            }
            if(bean.getIntro()!=null){
                WHERE("intro=#{intro}");
            }
            if(bean.getComefrom()!=null){
                WHERE("comefrom=#{comefrom}");
            }
            if(bean.getQq()!=null){
                WHERE("qq=#{qq}");
            }
            if(bean.getMsn()!=null){
                WHERE("msn=#{msn}");
            }
            if(bean.getPhone()!=null){
                WHERE("phone=#{phone}");
            }
            if(bean.getMobile()!=null){
                WHERE("mobile=#{mobile}");
            }
            if(bean.getUserImg()!=null){
                WHERE("user_img=#{userImg}");
            }
            if(bean.getUserSignature()!=null){
                WHERE("user_signature=#{userSignature}");
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