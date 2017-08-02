package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.NavigationProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import java.util.List;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/*
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface NavigationMapper {

    @SelectProvider(type = NavigationProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "name", column = "name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "parentId", column = "parent_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "isDisplay", column = "is_display", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "isExpand", column = "is_expand", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "link", column = "link", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "isBlank", column = "is_blank", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "icon", column = "icon", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "style", column = "style", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "clas", column = "clas", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    NavigationDO get(Long id);

    @SelectProvider(type = NavigationProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "name", column = "name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "parentId", column = "parent_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "isDisplay", column = "is_display", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "isExpand", column = "is_expand", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "link", column = "link", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "isBlank", column = "is_blank", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "icon", column = "icon", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "style", column = "style", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "clas", column = "clas", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<NavigationDO> list(NavigationDO bean);

    @InsertProvider(type = NavigationProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(NavigationDO bean);

    @UpdateProvider(type = NavigationProvider.class, method = "update")
    Integer update(NavigationDO bean);

    @DeleteProvider(type = NavigationProvider.class, method = "remove")
    Integer remove(NavigationDO bean);

    @DeleteProvider(type = NavigationProvider.class, method = "delete")
    Integer delete(Long id);
}
