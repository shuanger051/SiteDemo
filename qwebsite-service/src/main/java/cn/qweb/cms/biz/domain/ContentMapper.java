package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.ContentProvider;
import cn.qweb.cms.biz.service.query.ContentQUERY;
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
public interface ContentMapper {

    @SelectProvider(type = ContentProvider.class, method = "get")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "channelId", column = "channel_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "sortDate", column = "sort_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "topLevel", column = "top_level", jdbcType = JdbcType.TINYINT, javaType = Integer.class),
            @Result(property = "isRecommend", column = "is_recommend", jdbcType = JdbcType.BIT, javaType = Boolean.class),
            @Result(property = "status", column = "status", jdbcType = JdbcType.TINYINT, javaType = Integer.class),
            @Result(property = "viewsDay", column = "views_day", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "commentsDay", column = "comments_day", jdbcType = JdbcType.SMALLINT, javaType = Integer.class),
            @Result(property = "downloadsDay", column = "downloads_day", jdbcType = JdbcType.SMALLINT, javaType = Integer.class),
            @Result(property = "upsDay", column = "ups_day", jdbcType = JdbcType.SMALLINT, javaType = Integer.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "channel",column = "channel_id", one = @One(select = "cn.qweb.cms.biz.domain.ChannelMapper.get")),
            @Result(property = "contentTxt",column = "id", one=@One(select="cn.qweb.cms.biz.domain.ContentTxtMapper.getByContentId")),
            @Result(property = "contentExt", column = "id", one = @One(select = "cn.qweb.cms.biz.domain.ContentExtMapper.getByContentId")),
            @Result(property = "contentCheck", column = "id", one = @One(select = "cn.qweb.cms.biz.domain.ContentCheckMapper.getByContentId")),
            @Result(property = "contentAttrs", column = "id", many = @Many(select = "cn.qweb.cms.biz.domain.ContentAttrMapper.listByContentId")),
            @Result(property = "contentPictures", column = "id", many = @Many(select = "cn.qweb.cms.biz.domain.ContentPictureMapper.listByContentId")),
            @Result(property = "contentAttachments", column = "id", many = @Many(select = "cn.qweb.cms.biz.domain.ContentAttachmentMapper.listByContentId"))
    })
    ContentDO get(Long id);

    @SelectProvider(type = ContentProvider.class, method = "getNext")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "channelId", column = "channel_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "sortDate", column = "sort_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "topLevel", column = "top_level", jdbcType = JdbcType.TINYINT, javaType = Integer.class),
            @Result(property = "isRecommend", column = "is_recommend", jdbcType = JdbcType.BIT, javaType = Boolean.class),
            @Result(property = "status", column = "status", jdbcType = JdbcType.TINYINT, javaType = Integer.class),
            @Result(property = "viewsDay", column = "views_day", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "commentsDay", column = "comments_day", jdbcType = JdbcType.SMALLINT, javaType = Integer.class),
            @Result(property = "downloadsDay", column = "downloads_day", jdbcType = JdbcType.SMALLINT, javaType = Integer.class),
            @Result(property = "upsDay", column = "ups_day", jdbcType = JdbcType.SMALLINT, javaType = Integer.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "channel",column = "channel_id", one = @One(select = "cn.qweb.cms.biz.domain.ChannelMapper.get")),
            @Result(property = "contentTxt",column = "id", one=@One(select="cn.qweb.cms.biz.domain.ContentTxtMapper.getByContentId")),
            @Result(property = "contentExt", column = "id", one = @One(select = "cn.qweb.cms.biz.domain.ContentExtMapper.getByContentId")),
            @Result(property = "contentCheck", column = "id", one = @One(select = "cn.qweb.cms.biz.domain.ContentCheckMapper.getByContentId")),
            @Result(property = "contentAttrs", column = "id", many = @Many(select = "cn.qweb.cms.biz.domain.ContentAttrMapper.listByContentId")),
            @Result(property = "contentPictures", column = "id", many = @Many(select = "cn.qweb.cms.biz.domain.ContentPictureMapper.listByContentId")),
            @Result(property = "contentAttachments", column = "id", many = @Many(select = "cn.qweb.cms.biz.domain.ContentAttachmentMapper.listByContentId"))
    })
    List<ContentDO>  getNext(ContentNextQuery bean);

    @SelectProvider(type = ContentProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "channelId", column = "channel_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "sortDate", column = "sort_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "topLevel", column = "top_level", jdbcType = JdbcType.TINYINT, javaType = Integer.class), 
            @Result(property = "isRecommend", column = "is_recommend", jdbcType = JdbcType.BIT, javaType = Boolean.class), 
            @Result(property = "status", column = "status", jdbcType = JdbcType.TINYINT, javaType = Integer.class), 
            @Result(property = "viewsDay", column = "views_day", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "commentsDay", column = "comments_day", jdbcType = JdbcType.SMALLINT, javaType = Integer.class), 
            @Result(property = "downloadsDay", column = "downloads_day", jdbcType = JdbcType.SMALLINT, javaType = Integer.class), 
            @Result(property = "upsDay", column = "ups_day", jdbcType = JdbcType.SMALLINT, javaType = Integer.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "channel",column = "channel_id", one = @One(select = "cn.qweb.cms.biz.domain.ChannelMapper.get")),
            @Result(property = "contentTxt",column = "id", one=@One(select="cn.qweb.cms.biz.domain.ContentTxtMapper.getByContentId")),
            @Result(property = "contentExt", column = "id", one = @One(select = "cn.qweb.cms.biz.domain.ContentExtMapper.getByContentId")),
            @Result(property = "contentCheck", column = "id", one = @One(select = "cn.qweb.cms.biz.domain.ContentCheckMapper.getByContentId")),
            @Result(property = "contentAttrs", column = "id", many = @Many(select = "cn.qweb.cms.biz.domain.ContentAttrMapper.listByContentId")),
            @Result(property = "contentPictures", column = "id", many = @Many(select = "cn.qweb.cms.biz.domain.ContentPictureMapper.listByContentId")),
            @Result(property = "contentAttachments", column = "id", many = @Many(select = "cn.qweb.cms.biz.domain.ContentAttachmentMapper.listByContentId"))
            })
    List<ContentDO> list(ContentQUERY bean);

    @InsertProvider(type = ContentProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(ContentDO bean);

    @UpdateProvider(type = ContentProvider.class, method = "update")
    Integer update(ContentDO bean);

    @DeleteProvider(type = ContentProvider.class, method = "remove")
    Integer remove(ContentDO bean);

    @DeleteProvider(type = ContentProvider.class, method = "delete")
    Integer delete(Long id);
}
