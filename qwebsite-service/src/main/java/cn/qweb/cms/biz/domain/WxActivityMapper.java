package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.WxActivityProvider;
import cn.qweb.cms.biz.service.query.WxActivityQUERY;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/*
 *  Created by xuebj - 2017/05/03.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface WxActivityMapper {

    @SelectProvider(type = WxActivityProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "activityId", column = "activity_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "teacherName", column = "teacher_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "teacherId", column = "teacher_id", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "biginDate", column = "bigin_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "endDate", column = "end_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "beginTime", column = "begin_time", jdbcType = JdbcType.TIME, javaType = Date.class), 
            @Result(property = "endTime", column = "end_time", jdbcType = JdbcType.TIME, javaType = Date.class), 
            @Result(property = "activityType", column = "activity_type", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "activityKind", column = "activity_kind", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "activityPic", column = "activity_pic", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "content", column = "content", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "personNo", column = "person_no", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "site", column = "site", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "address", column = "address", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "status", column = "status", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "price", column = "price", jdbcType = JdbcType.DECIMAL, javaType = BigDecimal.class), 
            @Result(property = "telNo", column = "tel_no", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "appointmentFlag", column = "appointment_flag", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "appointmentDays", column = "appointment_days", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "appShowFlag", column = "app_show_flag", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "suggestion", column = "suggestion", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    WxActivityDO get(Long id);

    @SelectProvider(type = WxActivityProvider.class, method = "listByQuery")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "activityId", column = "activity_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "teacherName", column = "teacher_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "teacherId", column = "teacher_id", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "biginDate", column = "bigin_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "endDate", column = "end_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "beginTime", column = "begin_time", jdbcType = JdbcType.TIME, javaType = Date.class),
            @Result(property = "endTime", column = "end_time", jdbcType = JdbcType.TIME, javaType = Date.class),
            @Result(property = "activityType", column = "activity_type", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "activityKind", column = "activity_kind", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "activityPic", column = "activity_pic", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "content", column = "content", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class),
            @Result(property = "personNo", column = "person_no", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "site", column = "site", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "address", column = "address", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "status", column = "status", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "price", column = "price", jdbcType = JdbcType.DECIMAL, javaType = BigDecimal.class),
            @Result(property = "telNo", column = "tel_no", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "appointmentFlag", column = "appointment_flag", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "appointmentDays", column = "appointment_days", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "appShowFlag", column = "app_show_flag", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "suggestion", column = "suggestion", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    List<WxActivityDO> listByQuery(WxActivityQUERY bean);

    @SelectProvider(type = WxActivityProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "activityId", column = "activity_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "teacherName", column = "teacher_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "teacherId", column = "teacher_id", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "biginDate", column = "bigin_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "endDate", column = "end_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "beginTime", column = "begin_time", jdbcType = JdbcType.TIME, javaType = Date.class), 
            @Result(property = "endTime", column = "end_time", jdbcType = JdbcType.TIME, javaType = Date.class), 
            @Result(property = "activityType", column = "activity_type", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "activityKind", column = "activity_kind", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "activityPic", column = "activity_pic", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "content", column = "content", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "personNo", column = "person_no", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "site", column = "site", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "address", column = "address", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "status", column = "status", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "price", column = "price", jdbcType = JdbcType.DECIMAL, javaType = BigDecimal.class), 
            @Result(property = "telNo", column = "tel_no", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "appointmentFlag", column = "appointment_flag", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "appointmentDays", column = "appointment_days", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "appShowFlag", column = "app_show_flag", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "suggestion", column = "suggestion", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<WxActivityDO> list(WxActivityDO bean);

    @InsertProvider(type = WxActivityProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(WxActivityDO bean);

    @UpdateProvider(type = WxActivityProvider.class, method = "update")
    Integer update(WxActivityDO bean);

    @DeleteProvider(type = WxActivityProvider.class, method = "remove")
    Integer remove(WxActivityDO bean);

    @DeleteProvider(type = WxActivityProvider.class, method = "delete")
    Integer delete(Long id);
}
