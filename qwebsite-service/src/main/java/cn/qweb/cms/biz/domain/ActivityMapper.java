package cn.qweb.cms.biz.domain;

import cn.qweb.cms.biz.domain.sqlprovider.ActivityProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import java.util.List;
import java.util.Date;

/*
 *  Created by xuebj - 2017/03/31.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface ActivityMapper {

    @SelectProvider(type = ActivityProvider.class, method = "get")
    @Results(value = {
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
    ActivityDO get(Long id);

    @SelectProvider(type = ActivityProvider.class, method = "list")
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
    List<ActivityDO> list(ActivityDO bean);

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
    List<ActivityDO> queryIndexList(ActivityDO bean);

    @SelectProvider(type = ActivityProvider.class, method = "queryUnIndexList")
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
    List<ActivityDO> queryUnIndexList(ActivityDO bean);

    @InsertProvider(type = ActivityProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(ActivityDO bean);

    @UpdateProvider(type = ActivityProvider.class, method = "update")
    Integer update(ActivityDO bean);

    @DeleteProvider(type = ActivityProvider.class, method = "remove")
    Integer remove(ActivityDO bean);

    @DeleteProvider(type = ActivityProvider.class, method = "delete")
    Integer delete(Long id);

    @SelectProvider(type = ActivityProvider.class, method = "queryUnIndexTotalNum")
    Integer queryUnIndexTotalNum();

    @SelectProvider(type = ActivityProvider.class, method = "queryIndexTotalNum")
    Integer queryIndexTotalNum();

    @UpdateProvider(type = ActivityProvider.class, method = "updateIndexTime")
    Integer updateIndexTime(ActivityDO bean);
}
