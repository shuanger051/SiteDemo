package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.ContentTxtProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/*
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface ContentTxtMapper {

    @SelectProvider(type = ContentTxtProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "txt", column = "txt", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "txt1", column = "txt1", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "txt2", column = "txt2", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "txt3", column = "txt3", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    ContentTxtDO get(Long id);

    @SelectProvider(type = ContentTxtProvider.class, method = "getByContentId")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "txt", column = "txt", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class),
            @Result(property = "txt1", column = "txt1", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class),
            @Result(property = "txt2", column = "txt2", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class),
            @Result(property = "txt3", column = "txt3", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    ContentTxtDO getByContentId(Long contentId);

    @SelectProvider(type = ContentTxtProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "txt", column = "txt", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "txt1", column = "txt1", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "txt2", column = "txt2", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "txt3", column = "txt3", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<ContentTxtDO> list(ContentTxtDO bean);

    @SelectProvider(type = ContentTxtProvider.class, method = "queryUnIndexList")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "txt", column = "txt", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class),
            @Result(property = "txt1", column = "txt1", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class),
            @Result(property = "txt2", column = "txt2", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class),
            @Result(property = "txt3", column = "txt3", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    List<ContentTxtDO> queryUnIndexList(ContentTxtDO bean);

    @InsertProvider(type = ContentTxtProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(ContentTxtDO bean);

    @UpdateProvider(type = ContentTxtProvider.class, method = "update")
    Integer update(ContentTxtDO bean);

    @DeleteProvider(type = ContentTxtProvider.class, method = "remove")
    Integer remove(ContentTxtDO bean);

    @DeleteProvider(type = ContentTxtProvider.class, method = "delete")
    Integer delete(Long id);

    @SelectProvider(type = ContentTxtProvider.class, method = "queryUnIndexTotalNum")
    Integer queryUnIndexTotalNum();
}
