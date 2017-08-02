package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.ActivitySquareApplyProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/*
 *  Created by xuebj - 2017/05/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface ActivitySquareApplyMapper {

    @SelectProvider(type = ActivitySquareApplyProvider.class, method = "get")
    @Results(value = {
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "channelId", column = "channel_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "realName", column = "real_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "sex", column = "sex", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "idNo", column = "id_no", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "idKind", column = "id_kind", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "mobile", column = "mobile", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "email", column = "email", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "qq", column = "qq", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "height", column = "height", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "readFlag", column = "read_flag", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    ActivitySquareApplyDO get(Long id);

    @SelectProvider(type = ActivitySquareApplyProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "channelId", column = "channel_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "realName", column = "real_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "sex", column = "sex", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "idNo", column = "id_no", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "idKind", column = "id_kind", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "mobile", column = "mobile", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "email", column = "email", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "qq", column = "qq", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "height", column = "height", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "readFlag", column = "read_flag", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<ActivitySquareApplyDO> list(ActivitySquareApplyDO bean);

    @InsertProvider(type = ActivitySquareApplyProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(ActivitySquareApplyDO bean);

    @UpdateProvider(type = ActivitySquareApplyProvider.class, method = "update")
    Integer update(ActivitySquareApplyDO bean);

    @DeleteProvider(type = ActivitySquareApplyProvider.class, method = "remove")
    Integer remove(ActivitySquareApplyDO bean);

    @DeleteProvider(type = ActivitySquareApplyProvider.class, method = "delete")
    Integer delete(Long id);

    @SelectProvider(type = ActivitySquareApplyProvider.class, method = "checkExport")
    Integer checkExport(ActivitySquareApplyDO bean);
}
