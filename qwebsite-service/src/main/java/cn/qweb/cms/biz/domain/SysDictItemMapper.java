package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.SysDictItemProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import java.util.List;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/*
 *  Created by xuebj - 2017/03/16.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface SysDictItemMapper {

    @SelectProvider(type = SysDictItemProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "itemCode", column = "item_code", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "itemName", column = "item_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "entryCode", column = "entry_code", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "entryId", column = "entry_id", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "itemOrder", column = "item_order", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "remark", column = "remark", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    SysDictItemDO get(Long id);

    @SelectProvider(type = SysDictItemProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "itemCode", column = "item_code", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "itemName", column = "item_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "entryCode", column = "entry_code", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "entryId", column = "entry_id", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "itemOrder", column = "item_order", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "remark", column = "remark", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<SysDictItemDO> list(SysDictItemDO bean);

    @InsertProvider(type = SysDictItemProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(SysDictItemDO bean);

    @UpdateProvider(type = SysDictItemProvider.class, method = "update")
    Integer update(SysDictItemDO bean);

    @DeleteProvider(type = SysDictItemProvider.class, method = "remove")
    Integer remove(SysDictItemDO bean);

    @DeleteProvider(type = SysDictItemProvider.class, method = "delete")
    Integer delete(Long id);
}
