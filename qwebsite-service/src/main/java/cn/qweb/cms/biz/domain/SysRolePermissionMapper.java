package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.SysRolePermissionProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;
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
public interface SysRolePermissionMapper {

    @SelectProvider(type = SysRolePermissionProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "roleId", column = "role_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "permissionId", column = "permission_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    SysRolePermissionDO get(Long id);

    @SelectProvider(type = SysRolePermissionProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "roleId", column = "role_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "permissionId", column = "permission_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<SysRolePermissionDO> list(SysRolePermissionDO bean);

    @InsertProvider(type = SysRolePermissionProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(SysRolePermissionDO bean);

    @UpdateProvider(type = SysRolePermissionProvider.class, method = "update")
    Integer update(SysRolePermissionDO bean);

    @DeleteProvider(type = SysRolePermissionProvider.class, method = "remove")
    Integer remove(SysRolePermissionDO bean);

    @DeleteProvider(type = SysRolePermissionProvider.class, method = "delete")
    Integer delete(Long id);


    @SelectProvider(type = SysRolePermissionProvider.class, method = "listPermissionByRoles")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "parentId", column = "parent_id", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "name", column = "name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "uri", column = "uri", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "icon", column = "icon", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "menuClass", column = "menu_class", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "spreadFlag", column = "spread_flag", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "iconFlag", column = "icon_flag", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "isMenu", column = "is_menu", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    SysPermissionDO listPermissionByRoles(@Param("roles") Set<String> roles);
}
