package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.CompetitionSquareApplyProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import java.util.List;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/*
 *  Created by xuebj - 2017/05/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface CompetitionSquareApplyMapper {

    @SelectProvider(type = CompetitionSquareApplyProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "channelId", column = "channel_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "division", column = "division", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
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
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    CompetitionSquareApplyDO get(Long id);

    @SelectProvider(type = CompetitionSquareApplyProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "channelId", column = "channel_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "division", column = "division", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
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
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<CompetitionSquareApplyDO> list(CompetitionSquareApplyDO bean);

    @InsertProvider(type = CompetitionSquareApplyProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(CompetitionSquareApplyDO bean);

    @UpdateProvider(type = CompetitionSquareApplyProvider.class, method = "update")
    Integer update(CompetitionSquareApplyDO bean);

    @DeleteProvider(type = CompetitionSquareApplyProvider.class, method = "remove")
    Integer remove(CompetitionSquareApplyDO bean);

    @DeleteProvider(type = CompetitionSquareApplyProvider.class, method = "delete")
    Integer delete(Long id);

    @SelectProvider(type = CompetitionSquareApplyProvider.class, method = "checkExport")
    Integer checkExport(CompetitionSquareApplyDO bean);
}
