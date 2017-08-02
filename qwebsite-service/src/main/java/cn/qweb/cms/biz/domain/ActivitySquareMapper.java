package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.ActivityProvider;
import cn.qweb.cms.biz.domain.sqlprovider.ActivitySquareProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/*
 *  Created by xuebj - 2017/05/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface ActivitySquareMapper {

    @SelectProvider(type = ActivitySquareProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "content", column = "content", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "status", column = "status", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "province", column = "province", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "gmtBegin", column = "gmt_begin", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtEnd", column = "gmt_end", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    ActivitySquareDO get(Long id);

    @SelectProvider(type = ActivitySquareProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "content", column = "content", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "status", column = "status", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "province", column = "province", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "gmtBegin", column = "gmt_begin", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtEnd", column = "gmt_end", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<ActivitySquareDO> list(ActivitySquareDO bean);

    @SelectProvider(type = ActivityProvider.class, method = "queryIndexList")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "content", column = "content", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class),
            @Result(property = "status", column = "status", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "province", column = "province", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "gmtBegin", column = "gmt_begin", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtEnd", column = "gmt_end", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    List<ActivitySquareDO> queryIndexList(ActivitySquareDO bean);

    @SelectProvider(type = ActivitySquareProvider.class, method = "queryUnIndexList")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "content", column = "content", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class),
            @Result(property = "status", column = "status", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "province", column = "province", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "gmtBegin", column = "gmt_begin", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtEnd", column = "gmt_end", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    List<ActivitySquareDO> queryUnIndexList(ActivitySquareDO bean);

    @InsertProvider(type = ActivitySquareProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(ActivitySquareDO bean);

    @UpdateProvider(type = ActivitySquareProvider.class, method = "update")
    Integer update(ActivitySquareDO bean);

    @DeleteProvider(type = ActivitySquareProvider.class, method = "remove")
    Integer remove(ActivitySquareDO bean);

    @DeleteProvider(type = ActivitySquareProvider.class, method = "delete")
    Integer delete(Long id);

    @SelectProvider(type = ActivitySquareProvider.class, method = "queryUnIndexTotalNum")
    Integer queryUnIndexTotalNum();

    @SelectProvider(type = ActivitySquareProvider.class, method = "queryIndexTotalNum")
    Integer queryIndexTotalNum();

    @UpdateProvider(type = ActivitySquareProvider.class, method = "updateIndexTime")
    Integer updateIndexTime(ActivitySquareDO bean);
}
