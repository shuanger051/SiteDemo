package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.SysRoleProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import java.util.List;
import java.util.Date;
import java.util.Set;

/*
 *  Created by xuebj - 2017/03/14.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface SysRoleMapper {

    @SelectProvider(type = SysRoleProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "roleName", column = "role_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "isSuper", column = "is_super", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    SysRoleDO get(Long id);

    @SelectProvider(type = SysRoleProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "roleName", column = "role_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "isSuper", column = "is_super", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<SysRoleDO> list(SysRoleDO bean);

    @SelectProvider(type = SysRoleProvider.class, method = "listByIds")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "roleName", column = "role_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "isSuper", column = "is_super", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    List<SysRoleDO> listByIds(@Param("ids") Set<Long> ids);

    @InsertProvider(type = SysRoleProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(SysRoleDO bean);

    @UpdateProvider(type = SysRoleProvider.class, method = "update")
    Integer update(SysRoleDO bean);

    @DeleteProvider(type = SysRoleProvider.class, method = "remove")
    Integer remove(SysRoleDO bean);

    @DeleteProvider(type = SysRoleProvider.class, method = "delete")
    Integer delete(Long id);
}
