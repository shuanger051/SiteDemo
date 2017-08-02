package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.SysDictEntryProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/*
 *  Created by xuebj - 2017/03/15.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface SysDictEntryMapper {

    @SelectProvider(type = SysDictEntryProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "entryCode", column = "entry_code", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "entryName", column = "entry_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "remark", column = "remark", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    SysDictEntryDO get(Long id);

    @SelectProvider(type = SysDictEntryProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "entryCode", column = "entry_code", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "entryName", column = "entry_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "remark", column = "remark", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<SysDictEntryDO> list(SysDictEntryDO bean);

    @InsertProvider(type = SysDictEntryProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(SysDictEntryDO bean);

    @UpdateProvider(type = SysDictEntryProvider.class, method = "update")
    Integer update(SysDictEntryDO bean);

    @DeleteProvider(type = SysDictEntryProvider.class, method = "remove")
    Integer remove(SysDictEntryDO bean);

    @DeleteProvider(type = SysDictEntryProvider.class, method = "delete")
    Integer delete(Long id);
}
