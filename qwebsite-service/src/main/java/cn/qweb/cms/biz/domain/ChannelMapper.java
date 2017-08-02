package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.ChannelProvider;
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
public interface ChannelMapper {

    @SelectProvider(type = ChannelProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "modelId", column = "model_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "parentId", column = "parent_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "name", column = "name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "isDisplay", column = "is_display", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "keywords", column = "keywords", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "description", column = "description", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "finalStep", column = "final_step", jdbcType = JdbcType.TINYINT, javaType = Integer.class), 
            @Result(property = "afterCheck", column = "after_check", jdbcType = JdbcType.TINYINT, javaType = Integer.class), 
            @Result(property = "link", column = "link", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "isBlank", column = "is_blank", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "channelPath", column = "channel_path", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "tplContent", column = "tpl_content", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "tplChannel", column = "tpl_channel", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "tplModel", column = "tpl_model", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "commentControl", column = "comment_control", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "allowUpdown", column = "allow_updown", jdbcType = JdbcType.BIT, javaType = Boolean.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    ChannelDO get(Long id);

    @SelectProvider(type = ChannelProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "modelId", column = "model_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "parentId", column = "parent_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "name", column = "name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "isDisplay", column = "is_display", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "keywords", column = "keywords", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "description", column = "description", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "finalStep", column = "final_step", jdbcType = JdbcType.TINYINT, javaType = Integer.class), 
            @Result(property = "afterCheck", column = "after_check", jdbcType = JdbcType.TINYINT, javaType = Integer.class), 
            @Result(property = "link", column = "link", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "isBlank", column = "is_blank", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "channelPath", column = "channel_path", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "tplContent", column = "tpl_content", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "tplChannel", column = "tpl_channel", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "tplModel", column = "tpl_model", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "commentControl", column = "comment_control", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "allowUpdown", column = "allow_updown", jdbcType = JdbcType.BIT, javaType = Boolean.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<ChannelDO> list(ChannelDO bean);

    @InsertProvider(type = ChannelProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(ChannelDO bean);

    @UpdateProvider(type = ChannelProvider.class, method = "update")
    Integer update(ChannelDO bean);

    @DeleteProvider(type = ChannelProvider.class, method = "remove")
    Integer remove(ChannelDO bean);

    @DeleteProvider(type = ChannelProvider.class, method = "delete")
    Integer delete(Long id);
}
