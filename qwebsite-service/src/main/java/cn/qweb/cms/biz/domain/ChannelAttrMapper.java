package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.ChannelAttrProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import java.util.List;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/*
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface ChannelAttrMapper {

    @SelectProvider(type = ChannelAttrProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "channelId", column = "channel_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "attrName", column = "attr_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "attrValue", column = "attr_value", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    ChannelAttrDO get(Long id);

    @SelectProvider(type = ChannelAttrProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "channelId", column = "channel_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "attrName", column = "attr_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "attrValue", column = "attr_value", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<ChannelAttrDO> list(ChannelAttrDO bean);

    @InsertProvider(type = ChannelAttrProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(ChannelAttrDO bean);

    @UpdateProvider(type = ChannelAttrProvider.class, method = "update")
    Integer update(ChannelAttrDO bean);

    @DeleteProvider(type = ChannelAttrProvider.class, method = "remove")
    Integer remove(ChannelAttrDO bean);

    @DeleteProvider(type = ChannelAttrProvider.class, method = "delete")
    Integer delete(Long id);
}
