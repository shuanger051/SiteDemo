package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.ContentCheckProvider;
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
public interface ContentCheckMapper {

    @SelectProvider(type = ContentCheckProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "checkStep", column = "check_step", jdbcType = JdbcType.TINYINT, javaType = Integer.class), 
            @Result(property = "checkOpinion", column = "check_opinion", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "isRejected", column = "is_rejected", jdbcType = JdbcType.BIT, javaType = Boolean.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    ContentCheckDO get(Long id);

    @SelectProvider(type = ContentCheckProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "checkStep", column = "check_step", jdbcType = JdbcType.TINYINT, javaType = Integer.class), 
            @Result(property = "checkOpinion", column = "check_opinion", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "isRejected", column = "is_rejected", jdbcType = JdbcType.BIT, javaType = Boolean.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<ContentCheckDO> list(ContentCheckDO bean);

    @SelectProvider(type = ContentCheckProvider.class, method = "getByContentId")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "checkStep", column = "check_step", jdbcType = JdbcType.TINYINT, javaType = Integer.class),
            @Result(property = "checkOpinion", column = "check_opinion", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "isRejected", column = "is_rejected", jdbcType = JdbcType.BIT, javaType = Boolean.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    ContentCheckDO getByContentId(Long contentId);


    @InsertProvider(type = ContentCheckProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(ContentCheckDO bean);

    @UpdateProvider(type = ContentCheckProvider.class, method = "update")
    Integer update(ContentCheckDO bean);

    @DeleteProvider(type = ContentCheckProvider.class, method = "remove")
    Integer remove(ContentCheckDO bean);

    @DeleteProvider(type = ContentCheckProvider.class, method = "delete")
    Integer delete(Long id);
}
