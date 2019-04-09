package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.CompetitionApplyProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/*
 *  Created by xuebj - 2017/05/24.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface CompetitionApplyMapper {

    @SelectProvider(type = CompetitionApplyProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "channelId", column = "channel_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "division", column = "division", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "realName", column = "real_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "teamName", column = "team_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "projectKind", column = "project_kind", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "mobile", column = "mobile", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "email", column = "email", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "address", column = "address", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "readFlag", column = "read_flag", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "captain_name", column = "captainName", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "captainName", column = "captain_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "teamType", column = "team_type", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "groupNum", column = "group_num", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "groupCode", column = "group_code", jdbcType = JdbcType.INTEGER, javaType = Integer.class)
    })
    CompetitionApplyDO get(Long id);

    @SelectProvider(type = CompetitionApplyProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "channelId", column = "channel_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "division", column = "division", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "realName", column = "real_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "teamName", column = "team_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "projectKind", column = "project_kind", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "mobile", column = "mobile", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "email", column = "email", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "address", column = "address", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "readFlag", column = "read_flag", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "captainName", column = "captain_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "teamType", column = "team_type", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "groupNum", column = "group_num", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "groupCode", column = "group_code", jdbcType = JdbcType.INTEGER, javaType = Integer.class)
            })
    List<CompetitionApplyDO> list(CompetitionApplyDO bean);

    @InsertProvider(type = CompetitionApplyProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(CompetitionApplyDO bean);

    @UpdateProvider(type = CompetitionApplyProvider.class, method = "update")
    Integer update(CompetitionApplyDO bean);

    @DeleteProvider(type = CompetitionApplyProvider.class, method = "remove")
    Integer remove(CompetitionApplyDO bean);

    @DeleteProvider(type = CompetitionApplyProvider.class, method = "delete")
    Integer delete(Long id);

    @SelectProvider(type = CompetitionApplyProvider.class, method = "checkExport")
    Integer checkExport(CompetitionApplyDO bean);

}
