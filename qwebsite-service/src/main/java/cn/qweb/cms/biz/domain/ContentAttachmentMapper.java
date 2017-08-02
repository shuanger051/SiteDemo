package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.ContentAttachmentProvider;
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
public interface ContentAttachmentMapper {

    @SelectProvider(type = ContentAttachmentProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "attachmentPath", column = "attachment_path", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "attachmentName", column = "attachment_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "filename", column = "filename", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "downloadCount", column = "download_count", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    ContentAttachmentDO get(Long id);

    @SelectProvider(type = ContentAttachmentProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "attachmentPath", column = "attachment_path", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "attachmentName", column = "attachment_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "filename", column = "filename", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "downloadCount", column = "download_count", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<ContentAttachmentDO> list(ContentAttachmentDO bean);

    @SelectProvider(type = ContentAttachmentProvider.class, method = "listByContentId")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "attachmentPath", column = "attachment_path", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "attachmentName", column = "attachment_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "filename", column = "filename", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "downloadCount", column = "download_count", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    List<ContentAttachmentDO> listByContentId(Long contentId);


    @InsertProvider(type = ContentAttachmentProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(ContentAttachmentDO bean);

    @UpdateProvider(type = ContentAttachmentProvider.class, method = "update")
    Integer update(ContentAttachmentDO bean);

    @DeleteProvider(type = ContentAttachmentProvider.class, method = "remove")
    Integer remove(ContentAttachmentDO bean);

    @DeleteProvider(type = ContentAttachmentProvider.class, method = "delete")
    Integer delete(Long id);
}
