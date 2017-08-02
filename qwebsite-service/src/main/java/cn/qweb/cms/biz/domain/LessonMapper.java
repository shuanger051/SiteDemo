package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.LessonProvider;
import cn.qweb.cms.biz.service.query.LessonQUERY;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/*
 *  Created by xuebj - 2017/04/20.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface LessonMapper {

    @SelectProvider(type = LessonProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "lessonId", column = "lesson_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "teacherName", column = "teacher_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "teacherId", column = "teacher_id", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "biginDate", column = "bigin_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "endDate", column = "end_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "beginTime", column = "begin_time", jdbcType = JdbcType.TIME, javaType = Date.class),
            @Result(property = "endTime", column = "end_time", jdbcType = JdbcType.TIME, javaType = Date.class),
            @Result(property = "lessonType", column = "lesson_type", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "lessonKind", column = "lesson_kind", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "lessonPic", column = "lesson_pic", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
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
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "suggestion", column = "suggestion", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class),
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class)
    })
    LessonDO get(Long id);

    @SelectProvider(type = LessonProvider.class, method = "listByQuery")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "lessonId", column = "lesson_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "teacherName", column = "teacher_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "teacherId", column = "teacher_id", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "biginDate", column = "bigin_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "endDate", column = "end_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "beginTime", column = "begin_time", jdbcType = JdbcType.TIME, javaType = Date.class),
            @Result(property = "endTime", column = "end_time", jdbcType = JdbcType.TIME, javaType = Date.class),
            @Result(property = "lessonType", column = "lesson_type", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "lessonKind", column = "lesson_kind", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "lessonPic", column = "lesson_pic", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
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
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "suggestion", column = "suggestion", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class),
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class)
    })
    List<LessonDO> listByQuery(LessonQUERY bean);

    @SelectProvider(type = LessonProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "lessonId", column = "lesson_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "teacherName", column = "teacher_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "teacherId", column = "teacher_id", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "biginDate", column = "bigin_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "endDate", column = "end_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "beginTime", column = "begin_time", jdbcType = JdbcType.TIME, javaType = Date.class),
            @Result(property = "endTime", column = "end_time", jdbcType = JdbcType.TIME, javaType = Date.class),
            @Result(property = "lessonType", column = "lesson_type", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "lessonKind", column = "lesson_kind", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "lessonPic", column = "lesson_pic", jdbcType = JdbcType.VARCHAR, javaType = String.class),
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
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "suggestion", column = "suggestion", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class),
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class)
    })
    List<LessonDO> list(LessonDO bean);

    @InsertProvider(type = LessonProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(LessonDO bean);

    @UpdateProvider(type = LessonProvider.class, method = "update")
    Integer update(LessonDO bean);

    @DeleteProvider(type = LessonProvider.class, method = "remove")
    Integer remove(LessonDO bean);

    @DeleteProvider(type = LessonProvider.class, method = "delete")
    Integer delete(Long id);
}
