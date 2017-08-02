package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.ContentAttrProvider;
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
public interface ContentAttrMapper {

    @SelectProvider(type = ContentAttrProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "attrName", column = "attr_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "attrValue", column = "attr_value", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    ContentAttrDO get(Long id);

    @SelectProvider(type = ContentAttrProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "attrName", column = "attr_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "attrValue", column = "attr_value", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<ContentAttrDO> list(ContentAttrDO bean);

    @SelectProvider(type = ContentAttrProvider.class, method = "listByContentId")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "attrName", column = "attr_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "attrValue", column = "attr_value", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    List<ContentAttachmentDO> listByContentId(Long contentId);


    @InsertProvider(type = ContentAttrProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(ContentAttrDO bean);

    @UpdateProvider(type = ContentAttrProvider.class, method = "update")
    Integer update(ContentAttrDO bean);

    @DeleteProvider(type = ContentAttrProvider.class, method = "remove")
    Integer remove(ContentAttrDO bean);

    @DeleteProvider(type = ContentAttrProvider.class, method = "delete")
    Integer delete(Long id);
}
