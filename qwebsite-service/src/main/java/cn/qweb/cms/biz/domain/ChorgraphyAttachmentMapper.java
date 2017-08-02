package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.ChorgraphyAttachmentProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import java.util.List;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/*
 *  Created by xuebj - 2017/05/11.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface ChorgraphyAttachmentMapper {

    @SelectProvider(type = ChorgraphyAttachmentProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "chorgraphyId", column = "chorgraphy_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "attachmentPath", column = "attachment_path", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "attachmentName", column = "attachment_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "filename", column = "filename", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "type", column = "type", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    ChorgraphyAttachmentDO get(Long id);

    @SelectProvider(type = ChorgraphyAttachmentProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "chorgraphyId", column = "chorgraphy_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "attachmentPath", column = "attachment_path", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "attachmentName", column = "attachment_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "filename", column = "filename", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "type", column = "type", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<ChorgraphyAttachmentDO> list(ChorgraphyAttachmentDO bean);

    @InsertProvider(type = ChorgraphyAttachmentProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(ChorgraphyAttachmentDO bean);

    @UpdateProvider(type = ChorgraphyAttachmentProvider.class, method = "update")
    Integer update(ChorgraphyAttachmentDO bean);

    @DeleteProvider(type = ChorgraphyAttachmentProvider.class, method = "remove")
    Integer remove(ChorgraphyAttachmentDO bean);

    @DeleteProvider(type = ChorgraphyAttachmentProvider.class, method = "delete")
    Integer delete(Long id);
}
