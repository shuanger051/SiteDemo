package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.IndexLineProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import java.util.List;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/*
 *  Created by xuebj - 2017/04/05.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface IndexLineMapper {

    @SelectProvider(type = IndexLineProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "siteName", column = "site_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "siteLink", column = "site_link", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "logo", column = "logo", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "description", column = "description", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "views", column = "views", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "isEnabled", column = "is_enabled", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    IndexLineDO get(Long id);

    @SelectProvider(type = IndexLineProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "siteName", column = "site_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "siteLink", column = "site_link", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "logo", column = "logo", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "description", column = "description", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "views", column = "views", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "isEnabled", column = "is_enabled", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<IndexLineDO> list(IndexLineDO bean);

    @InsertProvider(type = IndexLineProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(IndexLineDO bean);

    @UpdateProvider(type = IndexLineProvider.class, method = "update")
    Integer update(IndexLineDO bean);

    @DeleteProvider(type = IndexLineProvider.class, method = "remove")
    Integer remove(IndexLineDO bean);

    @DeleteProvider(type = IndexLineProvider.class, method = "delete")
    Integer delete(Long id);
}
