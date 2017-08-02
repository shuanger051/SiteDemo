package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.UserProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import java.util.List;
import java.util.Date;

/*
 *  Created by xuebj - 2017/03/14.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface UserMapper {

    @SelectProvider(type = UserProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "userName", column = "user_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "email", column = "email", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "password", column = "password", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "registerTime", column = "register_time", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "registerIp", column = "register_ip", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "lastLoginTime", column = "last_login_time", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "lastLoginIp", column = "last_login_ip", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "loginCount", column = "login_count", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "errorTime", column = "error_time", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "errorCount", column = "error_count", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "errorIp", column = "error_ip", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "resetKey", column = "reset_key", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "resetPwd", column = "reset_pwd", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "activation", column = "activation", jdbcType = JdbcType.BIT, javaType = Boolean.class), 
            @Result(property = "activationCode", column = "activation_code", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "isAdmin", column = "is_admin", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "isDisabled", column = "is_disabled", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    UserDO get(Long id);

    @SelectProvider(type = UserProvider.class, method = "getByUserName")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "userName", column = "user_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "email", column = "email", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "password", column = "password", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "registerTime", column = "register_time", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "registerIp", column = "register_ip", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "lastLoginTime", column = "last_login_time", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "lastLoginIp", column = "last_login_ip", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "loginCount", column = "login_count", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "errorTime", column = "error_time", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "errorCount", column = "error_count", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "errorIp", column = "error_ip", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "resetKey", column = "reset_key", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "resetPwd", column = "reset_pwd", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "activation", column = "activation", jdbcType = JdbcType.BIT, javaType = Boolean.class),
            @Result(property = "activationCode", column = "activation_code", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "isAdmin", column = "is_admin", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "isDisabled", column = "is_disabled", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    UserDO getByUserName(String userName);

    @SelectProvider(type = UserProvider.class, method = "getByEmail")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "userName", column = "user_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "email", column = "email", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "password", column = "password", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "registerTime", column = "register_time", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "registerIp", column = "register_ip", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "lastLoginTime", column = "last_login_time", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "lastLoginIp", column = "last_login_ip", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "loginCount", column = "login_count", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "errorTime", column = "error_time", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "errorCount", column = "error_count", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "errorIp", column = "error_ip", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "resetKey", column = "reset_key", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "resetPwd", column = "reset_pwd", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "activation", column = "activation", jdbcType = JdbcType.BIT, javaType = Boolean.class),
            @Result(property = "activationCode", column = "activation_code", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "isAdmin", column = "is_admin", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "isDisabled", column = "is_disabled", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    UserDO getByEmail(String email);

    @SelectProvider(type = UserProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "userName", column = "user_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "email", column = "email", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "password", column = "password", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "registerTime", column = "register_time", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "registerIp", column = "register_ip", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "lastLoginTime", column = "last_login_time", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "lastLoginIp", column = "last_login_ip", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "loginCount", column = "login_count", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "errorTime", column = "error_time", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "errorCount", column = "error_count", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "errorIp", column = "error_ip", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "resetKey", column = "reset_key", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "resetPwd", column = "reset_pwd", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "activation", column = "activation", jdbcType = JdbcType.BIT, javaType = Boolean.class), 
            @Result(property = "activationCode", column = "activation_code", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "isAdmin", column = "is_admin", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "isDisabled", column = "is_disabled", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<UserDO> list(UserDO bean);



    @InsertProvider(type = UserProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(UserDO bean);

    @UpdateProvider(type = UserProvider.class, method = "update")
    Integer update(UserDO bean);

    @DeleteProvider(type = UserProvider.class, method = "remove")
    Integer remove(UserDO bean);

    @DeleteProvider(type = UserProvider.class, method = "delete")
    Integer delete(Long id);
}
