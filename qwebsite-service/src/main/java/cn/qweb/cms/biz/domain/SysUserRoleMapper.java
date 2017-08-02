package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.SysUserRoleProvider;
import cn.qweb.cms.biz.service.query.UserRoleQUERY;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/*
 *  Created by xuebj - 2017/03/14.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface SysUserRoleMapper {

    @SelectProvider(type = SysUserRoleProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "userId", column = "user_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "roleId", column = "role_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "remark", column = "remark", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    SysUserRoleDO get(Long id);

    @SelectProvider(type = SysUserRoleProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "userId", column = "user_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "roleId", column = "role_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "remark", column = "remark", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<SysUserRoleDO> list(SysUserRoleDO bean);

    @SelectProvider(type = SysUserRoleProvider.class, method = "listUserWithRole")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "userName", column = "user_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "email", column = "email", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "isAdmin", column = "is_admin", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "isDisabled", column = "is_disabled", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "roleId", column = "role_id", jdbcType = JdbcType.BIGINT, javaType = Long.class)
    })
    List<UserRoleDO> listUser(UserRoleQUERY bean);

    @SelectProvider(type = SysUserRoleProvider.class, method = "searchUser")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "userName", column = "user_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "email", column = "email", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "isAdmin", column = "is_admin", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "isDisabled", column = "is_disabled", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "roleId", column = "role_id", jdbcType = JdbcType.BIGINT, javaType = Long.class)
    })
    List<UserRoleDO> searchUser(UserRoleQUERY bean);

    @InsertProvider(type = SysUserRoleProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(SysUserRoleDO bean);

    @UpdateProvider(type = SysUserRoleProvider.class, method = "update")
    Integer update(SysUserRoleDO bean);

    @DeleteProvider(type = SysUserRoleProvider.class, method = "remove")
    Integer remove(SysUserRoleDO bean);

    @DeleteProvider(type = SysUserRoleProvider.class, method = "delete")
    Integer delete(Long id);
}
