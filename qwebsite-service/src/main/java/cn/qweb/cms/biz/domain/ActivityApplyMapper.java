package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.ActivityApplyProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import java.util.List;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/*
 *  Created by xuebj - 2017/03/20.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface ActivityApplyMapper {

    @SelectProvider(type = ActivityApplyProvider.class, method = "get")
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
            @Result(property = "readFlag", column = "read_flag", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    ActivityApplyDO get(Long id);

    @SelectProvider(type = ActivityApplyProvider.class, method = "list")
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
            @Result(property = "readFlag", column = "read_flag", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<ActivityApplyDO> list(ActivityApplyDO bean);

    @InsertProvider(type = ActivityApplyProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(ActivityApplyDO bean);

    @UpdateProvider(type = ActivityApplyProvider.class, method = "update")
    Integer update(ActivityApplyDO bean);

    @DeleteProvider(type = ActivityApplyProvider.class, method = "remove")
    Integer remove(ActivityApplyDO bean);

    @DeleteProvider(type = ActivityApplyProvider.class, method = "delete")
    Integer delete(Long id);

    @SelectProvider(type = ActivityApplyProvider.class, method = "checkExport")
    Integer checkExport(ActivityApplyDO bean);

}
