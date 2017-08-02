package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.UserDO;
import org.apache.ibatis.jdbc.SQL;
import cn.qweb.cms.core.base.BaseDynaSqlProvider;

/*
 *  Created by xuebj - 2017/03/14.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class UserProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_user";

    public static final String[] Fields={"id","user_name","email","password","register_time","register_ip","last_login_time","last_login_ip","login_count","error_time","error_count","error_ip","reset_key","reset_pwd","activation","activation_code","is_admin","is_disabled","gmt_create","gmt_modified"};


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


    public String getByUserName(final String userName){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            WHERE("user_name=#{param1}");
        }}.toString();
    }

    public String getByEmail(final String email){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            WHERE("email=#{param1}");
        }}.toString();
    }


    /**
     * 查询多个结果集
     */
    public String list(final UserDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("id=#{id}");
                }
                if(bean.getUserName()!=null){
                    WHERE("user_name like CONCAT('%',#{userName},'%')");
                }
                if(bean.getEmail()!=null){
                    WHERE("email like CONCAT('%',#{email},'%')");
                }
                if(bean.getPassword()!=null){
                    WHERE("password=#{password}");
                }
                if(bean.getRegisterTime()!=null){
                    WHERE("register_time=#{registerTime}");
                }
                if(bean.getRegisterIp()!=null){
                    WHERE("register_ip=#{registerIp}");
                }
                if(bean.getLastLoginTime()!=null){
                    WHERE("last_login_time=#{lastLoginTime}");
                }
                if(bean.getLastLoginIp()!=null){
                    WHERE("last_login_ip=#{lastLoginIp}");
                }
                if(bean.getLoginCount()!=null){
                    WHERE("login_count=#{loginCount}");
                }
                if(bean.getErrorTime()!=null){
                    WHERE("error_time=#{errorTime}");
                }
                if(bean.getErrorCount()!=null){
                    WHERE("error_count=#{errorCount}");
                }
                if(bean.getErrorIp()!=null){
                    WHERE("error_ip=#{errorIp}");
                }
                if(bean.getResetKey()!=null){
                    WHERE("reset_key=#{resetKey}");
                }
                if(bean.getResetPwd()!=null){
                    WHERE("reset_pwd=#{resetPwd}");
                }
                if(bean.getActivation()!=null){
                    WHERE("activation=#{activation}");
                }
                if(bean.getActivationCode()!=null){
                    WHERE("activation_code=#{activationCode}");
                }
                if(bean.getIsAdmin()!=null){
                    WHERE("is_admin=#{isAdmin}");
                }
                if(bean.getIsDisabled()!=null){
                    WHERE("is_disabled=#{isDisabled}");
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
    public String save(final UserDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getUserName() != null) {
                VALUES("user_name", "#{userName}");
            }
            if (bean.getEmail() != null) {
                VALUES("email", "#{email}");
            }
            if (bean.getPassword() != null) {
                VALUES("password", "#{password}");
            }
            if (bean.getRegisterTime() != null) {
                VALUES("register_time", "#{registerTime}");
            }
            if (bean.getRegisterIp() != null) {
                VALUES("register_ip", "#{registerIp}");
            }
            if (bean.getLastLoginTime() != null) {
                VALUES("last_login_time", "#{lastLoginTime}");
            }
            if (bean.getLastLoginIp() != null) {
                VALUES("last_login_ip", "#{lastLoginIp}");
            }
            if (bean.getLoginCount() != null) {
                VALUES("login_count", "#{loginCount}");
            }
            if (bean.getErrorTime() != null) {
                VALUES("error_time", "#{errorTime}");
            }
            if (bean.getErrorCount() != null) {
                VALUES("error_count", "#{errorCount}");
            }
            if (bean.getErrorIp() != null) {
                VALUES("error_ip", "#{errorIp}");
            }
            if (bean.getResetKey() != null) {
                VALUES("reset_key", "#{resetKey}");
            }
            if (bean.getResetPwd() != null) {
                VALUES("reset_pwd", "#{resetPwd}");
            }
            if (bean.getActivation() != null) {
                VALUES("activation", "#{activation}");
            }
            if (bean.getActivationCode() != null) {
                VALUES("activation_code", "#{activationCode}");
            }
            if(bean.getIsAdmin()!=null){
                VALUES("is_admin","#{isAdmin}");
            }
            if(bean.getIsDisabled()!=null){
                VALUES("is_disabled","#{isDisabled}");
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
    public String update(final UserDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getUserName() != null) {
                SET("user_name=#{userName}");
            }
            if (bean.getEmail() != null) {
                SET("email=#{email}");
            }
            if (bean.getPassword() != null) {
                SET("password=#{password}");
            }
            if (bean.getRegisterTime() != null) {
                SET("register_time=#{registerTime}");
            }
            if (bean.getRegisterIp() != null) {
                SET("register_ip=#{registerIp}");
            }
            if (bean.getLastLoginTime() != null) {
                SET("last_login_time=#{lastLoginTime}");
            }
            if (bean.getLastLoginIp() != null) {
                SET("last_login_ip=#{lastLoginIp}");
            }
            if (bean.getLoginCount() != null) {
                SET("login_count=#{loginCount}");
            }
            if (bean.getErrorTime() != null) {
                SET("error_time=#{errorTime}");
            }
            if (bean.getErrorCount() != null) {
                SET("error_count=#{errorCount}");
            }
            if (bean.getErrorIp() != null) {
                SET("error_ip=#{errorIp}");
            }
            if (bean.getResetKey() != null) {
                SET("reset_key=#{resetKey}");
            }
            if (bean.getResetPwd() != null) {
                SET("reset_pwd=#{resetPwd}");
            }
            if (bean.getActivation() != null) {
                SET("activation=#{activation}");
            }
            if (bean.getActivationCode() != null) {
                SET("activation_code=#{activationCode}");
            }
            if(bean.getIsAdmin()!=null){
                SET("is_admin=#{isAdmin}");
            }
            if(bean.getIsDisabled()!=null){
                SET("is_disabled=#{isDisabled}");
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
    public String remove(final UserDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getUserName()!=null){
                WHERE("user_name=#{userName}");
            }
            if(bean.getEmail()!=null){
                WHERE("email=#{email}");
            }
            if(bean.getPassword()!=null){
                WHERE("password=#{password}");
            }
            if(bean.getRegisterTime()!=null){
                WHERE("register_time=#{registerTime}");
            }
            if(bean.getRegisterIp()!=null){
                WHERE("register_ip=#{registerIp}");
            }
            if(bean.getLastLoginTime()!=null){
                WHERE("last_login_time=#{lastLoginTime}");
            }
            if(bean.getLastLoginIp()!=null){
                WHERE("last_login_ip=#{lastLoginIp}");
            }
            if(bean.getLoginCount()!=null){
                WHERE("login_count=#{loginCount}");
            }
            if(bean.getErrorTime()!=null){
                WHERE("error_time=#{errorTime}");
            }
            if(bean.getErrorCount()!=null){
                WHERE("error_count=#{errorCount}");
            }
            if(bean.getErrorIp()!=null){
                WHERE("error_ip=#{errorIp}");
            }
            if(bean.getResetKey()!=null){
                WHERE("reset_key=#{resetKey}");
            }
            if(bean.getResetPwd()!=null){
                WHERE("reset_pwd=#{resetPwd}");
            }
            if(bean.getActivation()!=null){
                WHERE("activation=#{activation}");
            }
            if(bean.getActivationCode()!=null){
                WHERE("activation_code=#{activationCode}");
            }
            if(bean.getIsAdmin()!=null){
                WHERE("is_admin=#{isAdmin}");
            }
            if(bean.getIsDisabled()!=null){
                WHERE("is_disabled=#{isDisabled}");
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