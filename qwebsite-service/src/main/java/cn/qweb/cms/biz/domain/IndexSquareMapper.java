package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.IndexSquareProvider;
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
public interface IndexSquareMapper {

    @SelectProvider(type = IndexSquareProvider.class, method = "get")
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
    IndexSquareDO get(Long id);

    @SelectProvider(type = IndexSquareProvider.class, method = "list")
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
    List<IndexSquareDO> list(IndexSquareDO bean);

    @InsertProvider(type = IndexSquareProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(IndexSquareDO bean);

    @UpdateProvider(type = IndexSquareProvider.class, method = "update")
    Integer update(IndexSquareDO bean);

    @DeleteProvider(type = IndexSquareProvider.class, method = "remove")
    Integer remove(IndexSquareDO bean);

    @DeleteProvider(type = IndexSquareProvider.class, method = "delete")
    Integer delete(Long id);
}
