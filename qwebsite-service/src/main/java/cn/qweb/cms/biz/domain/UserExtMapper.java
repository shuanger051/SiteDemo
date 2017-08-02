package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.UserExtProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/*
 *  Created by xuebj - 2017/03/20.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface UserExtMapper {

    @SelectProvider(type = UserExtProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "userId", column = "user_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "realName", column = "real_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gender", column = "gender", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "birthday", column = "birthday", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "intro", column = "intro", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "comefrom", column = "comefrom", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "qq", column = "qq", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "msn", column = "msn", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "phone", column = "phone", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "mobile", column = "mobile", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "userImg", column = "user_img", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "userSignature", column = "user_signature", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    UserExtDO get(Long id);

    @SelectProvider(type = UserExtProvider.class, method = "getByUserId")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "userId", column = "user_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "realName", column = "real_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "gender", column = "gender", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "birthday", column = "birthday", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "intro", column = "intro", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "comefrom", column = "comefrom", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "qq", column = "qq", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "msn", column = "msn", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "phone", column = "phone", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "mobile", column = "mobile", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "userImg", column = "user_img", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "userSignature", column = "user_signature", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    UserExtDO getByUserId(Long id);

    @SelectProvider(type = UserExtProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "userId", column = "user_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "realName", column = "real_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gender", column = "gender", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "birthday", column = "birthday", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "intro", column = "intro", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "comefrom", column = "comefrom", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "qq", column = "qq", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "msn", column = "msn", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "phone", column = "phone", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "mobile", column = "mobile", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "userImg", column = "user_img", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "userSignature", column = "user_signature", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<UserExtDO> list(UserExtDO bean);

    @InsertProvider(type = UserExtProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(UserExtDO bean);

    @UpdateProvider(type = UserExtProvider.class, method = "update")
    Integer update(UserExtDO bean);

    @DeleteProvider(type = UserExtProvider.class, method = "remove")
    Integer remove(UserExtDO bean);

    @DeleteProvider(type = UserExtProvider.class, method = "delete")
    Integer delete(Long id);
}
