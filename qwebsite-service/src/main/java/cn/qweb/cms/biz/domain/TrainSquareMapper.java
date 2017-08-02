package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.TrainSquareProvider;
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
public interface TrainSquareMapper {

    @SelectProvider(type = TrainSquareProvider.class, method = "get")
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
    TrainSquareDO get(Long id);

    @SelectProvider(type = TrainSquareProvider.class, method = "list")
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
    List<TrainSquareDO> list(TrainSquareDO bean);


    @SelectProvider(type = TrainSquareProvider.class, method = "queryUnIndexList")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "content", column = "content", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class),
            @Result(property = "province", column = "province", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "gmtBegin", column = "gmt_begin", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtEnd", column = "gmt_end", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    List<TrainSquareDO> queryUnIndexList(TrainSquareDO bean);

    @SelectProvider(type = TrainSquareProvider.class, method = "queryIndexList")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "content", column = "content", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class),
            @Result(property = "province", column = "province", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "gmtBegin", column = "gmt_begin", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtEnd", column = "gmt_end", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    List<TrainSquareDO> queryIndexList(TrainSquareDO bean);

    @InsertProvider(type = TrainSquareProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(TrainSquareDO bean);

    @UpdateProvider(type = TrainSquareProvider.class, method = "update")
    Integer update(TrainSquareDO bean);

    @DeleteProvider(type = TrainSquareProvider.class, method = "remove")
    Integer remove(TrainSquareDO bean);

    @DeleteProvider(type = TrainSquareProvider.class, method = "delete")
    Integer delete(Long id);

    @UpdateProvider(type = TrainSquareProvider.class, method = "updateIndexTime")
    Integer updateIndexTime(TrainSquareDO bean);

    @SelectProvider(type = TrainSquareProvider.class, method = "queryUnIndexTotalNum")
    Integer queryUnIndexTotalNum();

    @SelectProvider(type = TrainSquareProvider.class, method = "queryIndexTotalNum")
    Integer queryIndexTotalNum();
}
