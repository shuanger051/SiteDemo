package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.TeacherProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/*
 *  Created by xuebj - 2017/04/06.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface TeacherMapper {

    @SelectProvider(type = TeacherProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "realName", column = "real_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "headImg", column = "head_img", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "contentImg", column = "content_img", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "brief", column = "brief", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "txt", column = "txt", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "link", column = "link", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "isEnabled", column = "is_enabled", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "releaseDate", column = "release_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "author", column = "author", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "views", column = "views", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "type", column = "type", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "level", column = "level", jdbcType = JdbcType.INTEGER, javaType = Integer.class)
    })
    TeacherDO get(Long id);

    @SelectProvider(type = TeacherProvider.class, method = "getNext")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "realName", column = "real_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "headImg", column = "head_img", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "contentImg", column = "content_img", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "brief", column = "brief", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class),
            @Result(property = "txt", column = "txt", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class),
            @Result(property = "link", column = "link", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "isEnabled", column = "is_enabled", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "releaseDate", column = "release_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "author", column = "author", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "views", column = "views", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "type", column = "type", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "level", column = "level", jdbcType = JdbcType.INTEGER, javaType = Integer.class)
    })
    List<TeacherDO> getNext(TeacherNextDO nextDO);

    @SelectProvider(type = TeacherProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "realName", column = "real_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "headImg", column = "head_img", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "contentImg", column = "content_img", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "brief", column = "brief", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "txt", column = "txt", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "link", column = "link", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "isEnabled", column = "is_enabled", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "releaseDate", column = "release_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "author", column = "author", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "views", column = "views", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "type", column = "type", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "level", column = "level", jdbcType = JdbcType.INTEGER, javaType = Integer.class)
    })
    List<TeacherDO> list(TeacherDO bean);

    @InsertProvider(type = TeacherProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(TeacherDO bean);

    @UpdateProvider(type = TeacherProvider.class, method = "update")
    Integer update(TeacherDO bean);

    @DeleteProvider(type = TeacherProvider.class, method = "remove")
    Integer remove(TeacherDO bean);

    @DeleteProvider(type = TeacherProvider.class, method = "delete")
    Integer delete(Long id);
}
