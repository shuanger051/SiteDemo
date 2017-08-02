package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.CompetitionSquareProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import java.util.List;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/*
 *  Created by xuebj - 2017/05/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface CompetitionSquareMapper {

    @SelectProvider(type = CompetitionSquareProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "content", column = "content", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "division", column = "division", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "status", column = "status", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "province", column = "province", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "gmtBegin", column = "gmt_begin", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtEnd", column = "gmt_end", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    CompetitionSquareDO get(Long id);

    @SelectProvider(type = CompetitionSquareProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "content", column = "content", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "division", column = "division", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "status", column = "status", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "province", column = "province", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "gmtBegin", column = "gmt_begin", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtEnd", column = "gmt_end", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<CompetitionSquareDO> list(CompetitionSquareDO bean);

    @InsertProvider(type = CompetitionSquareProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(CompetitionSquareDO bean);

    @UpdateProvider(type = CompetitionSquareProvider.class, method = "update")
    Integer update(CompetitionSquareDO bean);

    @DeleteProvider(type = CompetitionSquareProvider.class, method = "remove")
    Integer remove(CompetitionSquareDO bean);

    @DeleteProvider(type = CompetitionSquareProvider.class, method = "delete")
    Integer delete(Long id);
}
