package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.ContentPictureProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/*
 *  Created by xuebj - 2017/03/29.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface ContentPictureMapper {

    @SelectProvider(type = ContentPictureProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "imgPath", column = "img_path", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "description", column = "description", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    ContentPictureDO get(Long id);

    @SelectProvider(type = ContentPictureProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "imgPath", column = "img_path", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "description", column = "description", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<ContentPictureDO> list(ContentPictureDO bean);

    @SelectProvider(type = ContentPictureProvider.class, method = "listByContentId")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "imgPath", column = "img_path", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "description", column = "description", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    List<ContentPictureDO> listByContentId(Long contentId);


    @InsertProvider(type = ContentPictureProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(ContentPictureDO bean);

    @UpdateProvider(type = ContentPictureProvider.class, method = "update")
    Integer update(ContentPictureDO bean);

    @DeleteProvider(type = ContentPictureProvider.class, method = "remove")
    Integer remove(ContentPictureDO bean);

    @DeleteProvider(type = ContentPictureProvider.class, method = "delete")
    Integer delete(Long id);
}
