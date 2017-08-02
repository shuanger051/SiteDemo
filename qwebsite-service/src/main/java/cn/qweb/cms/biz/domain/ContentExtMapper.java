package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.ContentExtProvider;
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
public interface ContentExtMapper {

    @SelectProvider(type = ContentExtProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "shortTitle", column = "short_title", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "author", column = "author", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "origin", column = "origin", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "originUrl", column = "origin_url", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "releaseDate", column = "release_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "mediaPath", column = "media_path", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "mediaType", column = "media_type", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "titleImg", column = "title_img", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "contentImg", column = "content_img", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "typeImg", column = "type_img", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "link", column = "link", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "needRegenerate", column = "need_regenerate", jdbcType = JdbcType.BIT, javaType = Boolean.class), 
            @Result(property = "description", column = "description", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    ContentExtDO get(Long id);

    @SelectProvider(type = ContentExtProvider.class, method = "getByContentId")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "shortTitle", column = "short_title", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "author", column = "author", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "origin", column = "origin", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "originUrl", column = "origin_url", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "releaseDate", column = "release_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "mediaPath", column = "media_path", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "mediaType", column = "media_type", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "titleImg", column = "title_img", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "contentImg", column = "content_img", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "typeImg", column = "type_img", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "link", column = "link", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "needRegenerate", column = "need_regenerate", jdbcType = JdbcType.BIT, javaType = Boolean.class),
            @Result(property = "description", column = "description", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    ContentExtDO getByContentId(Long contentId);

    @SelectProvider(type = ContentExtProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "shortTitle", column = "short_title", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "author", column = "author", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "origin", column = "origin", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "originUrl", column = "origin_url", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "releaseDate", column = "release_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "mediaPath", column = "media_path", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "mediaType", column = "media_type", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "titleImg", column = "title_img", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "contentImg", column = "content_img", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "typeImg", column = "type_img", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "link", column = "link", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "needRegenerate", column = "need_regenerate", jdbcType = JdbcType.BIT, javaType = Boolean.class), 
            @Result(property = "description", column = "description", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<ContentExtDO> list(ContentExtDO bean);

    @SelectProvider(type = ContentExtProvider.class, method = "queryUnIndexList")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "shortTitle", column = "short_title", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "author", column = "author", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "origin", column = "origin", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "originUrl", column = "origin_url", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "releaseDate", column = "release_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "mediaPath", column = "media_path", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "mediaType", column = "media_type", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "titleImg", column = "title_img", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "contentImg", column = "content_img", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "typeImg", column = "type_img", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "link", column = "link", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "needRegenerate", column = "need_regenerate", jdbcType = JdbcType.BIT, javaType = Boolean.class),
            @Result(property = "description", column = "description", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    List<ContentExtDO> queryUnIndexList(ContentExtDO bean);

    @SelectProvider(type = ContentExtProvider.class, method = "queryIndexList")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "shortTitle", column = "short_title", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "author", column = "author", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "origin", column = "origin", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "originUrl", column = "origin_url", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "releaseDate", column = "release_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "mediaPath", column = "media_path", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "mediaType", column = "media_type", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "titleImg", column = "title_img", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "contentImg", column = "content_img", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "typeImg", column = "type_img", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "link", column = "link", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "needRegenerate", column = "need_regenerate", jdbcType = JdbcType.BIT, javaType = Boolean.class),
            @Result(property = "description", column = "description", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    List<ContentExtDO> queryIndexList(ContentExtDO bean);

    @InsertProvider(type = ContentExtProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(ContentExtDO bean);

    @UpdateProvider(type = ContentExtProvider.class, method = "update")
    Integer update(ContentExtDO bean);

    @DeleteProvider(type = ContentExtProvider.class, method = "remove")
    Integer remove(ContentExtDO bean);

    @DeleteProvider(type = ContentExtProvider.class, method = "delete")
    Integer delete(Long id);

    @SelectProvider(type = ContentExtProvider.class, method = "queryUnIndexTotalNum")
    Integer queryUnIndexTotalNum();

    @SelectProvider(type = ContentExtProvider.class, method = "queryIndexTotalNum")
    Integer queryIndexTotalNum();

    @UpdateProvider(type = ContentExtProvider.class, method = "updateIndexTime")
    Integer updateIndexTime(ContentExtDO bean);

    @SelectProvider(type = ContentExtProvider.class, method = "queryChannelByContentID")
    String queryChannelByContentID(ContentExtDO bean);

}
