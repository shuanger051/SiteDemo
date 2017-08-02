package cn.qweb.cms.biz.domain;

import cn.qweb.cms.biz.domain.sqlprovider.TrainApplyProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import java.util.List;
import java.util.Date;


/*
 *  Created by xuebj - 2017/03/29.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface TrainApplyMapper {

    @SelectProvider(type = TrainApplyProvider.class, method = "get")
    @Results(value = {
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "channelId", column = "channel_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "realName", column = "real_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "sex", column = "sex", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "idNo", column = "id_no", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "idKind", column = "id_kind", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "readFlag", column = "read_flag", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "trainerType", column = "trainer_type", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "mobile", column = "mobile", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "email", column = "email", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "qq", column = "qq", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "height", column = "height", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    TrainApplyDO get(Long id);

    @SelectProvider(type = TrainApplyProvider.class, method = "list")
    @Results(value= {
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "channelId", column = "channel_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "realName", column = "real_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "sex", column = "sex", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "idNo", column = "id_no", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "idKind", column = "id_kind", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "readFlag", column = "read_flag", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "trainerType", column = "trainer_type", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "mobile", column = "mobile", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "email", column = "email", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "qq", column = "qq", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "height", column = "height", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<TrainApplyDO> list(TrainApplyDO bean);

    @SelectProvider(type = TrainApplyProvider.class, method = "queryUnIndexList")
    @Results(value= {
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "channelId", column = "channel_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "realName", column = "real_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "sex", column = "sex", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "idNo", column = "id_no", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "idKind", column = "id_kind", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "readFlag", column = "read_flag", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "trainerType", column = "trainer_type", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "mobile", column = "mobile", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "email", column = "email", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "qq", column = "qq", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "height", column = "height", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    List<TrainApplyDO> queryUnIndexList(TrainApplyDO bean);

    @SelectProvider(type = TrainApplyProvider.class, method = "queryIndexList")
    @Results(value= {
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "channelId", column = "channel_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "contentId", column = "content_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "realName", column = "real_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "sex", column = "sex", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "idNo", column = "id_no", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "idKind", column = "id_kind", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "readFlag", column = "read_flag", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "trainerType", column = "trainer_type", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "mobile", column = "mobile", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "email", column = "email", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "qq", column = "qq", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "height", column = "height", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtIndex", column = "gmt_index", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    List<TrainApplyDO> queryIndexList(TrainApplyDO bean);

    @InsertProvider(type = TrainApplyProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(TrainApplyDO bean);

    @UpdateProvider(type = TrainApplyProvider.class, method = "update")
    Integer update(TrainApplyDO bean);

    @UpdateProvider(type = TrainApplyProvider.class, method = "updateIndexTime")
    Integer updateIndexTime(TrainApplyDO bean);

    @DeleteProvider(type = TrainApplyProvider.class, method = "remove")
    Integer remove(TrainApplyDO bean);

    @DeleteProvider(type = TrainApplyProvider.class, method = "delete")
    Integer delete(Long id);

    @SelectProvider(type = TrainApplyProvider.class, method = "queryUnIndexTotalNum")
    Integer queryUnIndexTotalNum();

    @SelectProvider(type = TrainApplyProvider.class, method = "queryIndexTotalNum")
    Integer queryIndexTotalNum();

    @SelectProvider(type = TrainApplyProvider.class, method = "checkExport")
    Integer checkExport(TrainApplyDO bean);

}
