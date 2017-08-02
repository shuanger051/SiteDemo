package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.SysPermissionProvider;
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
public interface SysPermissionMapper {

    @SelectProvider(type = SysPermissionProvider.class, method = "get")
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
    SysPermissionDO get(Long id);

    @SelectProvider(type = SysPermissionProvider.class, method = "list")
    @Results(value= {
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
    List<SysPermissionDO> list(SysPermissionDO bean);

    @InsertProvider(type = SysPermissionProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(SysPermissionDO bean);

    @UpdateProvider(type = SysPermissionProvider.class, method = "update")
    Integer update(SysPermissionDO bean);

    @DeleteProvider(type = SysPermissionProvider.class, method = "remove")
    Integer remove(SysPermissionDO bean);

    @DeleteProvider(type = SysPermissionProvider.class, method = "delete")
    Integer delete(Long id);
}
