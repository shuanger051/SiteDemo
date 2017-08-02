package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.ChorgraphyProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/*
 *  Created by xuebj - 2017/05/11.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface ChorgraphyMapper {

    @SelectProvider(type = ChorgraphyProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "name", column = "name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "userId", column = "user_id", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "content", column = "content", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "authors", column = "authors", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "brief", column = "brief", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "uperMobile", column = "uper_mobile", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "uperName", column = "uper_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "uperEmail", column = "uper_email", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "votes", column = "votes", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "starts", column = "starts", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "views", column = "views", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "releaseDate", column = "release_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "level", column = "level", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "wall", column = "wall", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "count", column = "count", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "status", column = "status", jdbcType = JdbcType.TINYINT, javaType = Integer.class), 
            @Result(property = "danceType", column = "dance_type", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "upDate", column = "up_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    ChorgraphyDO get(Long id);

    @SelectProvider(type = ChorgraphyProvider.class, method = "getNext")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "name", column = "name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "userId", column = "user_id", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "content", column = "content", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class),
            @Result(property = "authors", column = "authors", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class),
            @Result(property = "brief", column = "brief", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class),
            @Result(property = "uperMobile", column = "uper_mobile", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "uperName", column = "uper_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "uperEmail", column = "uper_email", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "votes", column = "votes", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "starts", column = "starts", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "views", column = "views", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "releaseDate", column = "release_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "level", column = "level", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "wall", column = "wall", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "count", column = "count", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "status", column = "status", jdbcType = JdbcType.TINYINT, javaType = Integer.class),
            @Result(property = "danceType", column = "dance_type", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "upDate", column = "up_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    List<ChorgraphyDO> getNext(ChorgraphyNextQuery bean);

    @SelectProvider(type = ChorgraphyProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "name", column = "name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "userId", column = "user_id", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "content", column = "content", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "authors", column = "authors", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "brief", column = "brief", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "uperMobile", column = "uper_mobile", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "uperName", column = "uper_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "uperEmail", column = "uper_email", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "votes", column = "votes", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "starts", column = "starts", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "views", column = "views", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "releaseDate", column = "release_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "level", column = "level", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "wall", column = "wall", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "count", column = "count", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "status", column = "status", jdbcType = JdbcType.TINYINT, javaType = Integer.class), 
            @Result(property = "danceType", column = "dance_type", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "upDate", column = "up_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<ChorgraphyDO> list(ChorgraphyDO bean);

    @InsertProvider(type = ChorgraphyProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(ChorgraphyDO bean);

    @UpdateProvider(type = ChorgraphyProvider.class, method = "update")
    Integer update(ChorgraphyDO bean);

    @DeleteProvider(type = ChorgraphyProvider.class, method = "remove")
    Integer remove(ChorgraphyDO bean);

    @DeleteProvider(type = ChorgraphyProvider.class, method = "delete")
    Integer delete(Long id);
}
