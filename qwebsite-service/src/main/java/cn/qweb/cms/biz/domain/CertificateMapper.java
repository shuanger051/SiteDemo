package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.CertificateProvider;
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
public interface CertificateMapper {

    @SelectProvider(type = CertificateProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "name", column = "name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "type", column = "type", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "img", column = "img", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "txt", column = "txt", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "brief", column = "brief", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "releaseDate", column = "release_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "isEnabled", column = "is_enabled", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    CertificateDO get(Long id);

    @SelectProvider(type = CertificateProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "name", column = "name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "type", column = "type", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "img", column = "img", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "txt", column = "txt", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "brief", column = "brief", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "releaseDate", column = "release_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "isEnabled", column = "is_enabled", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<CertificateDO> list(CertificateDO bean);

    @InsertProvider(type = CertificateProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(CertificateDO bean);

    @UpdateProvider(type = CertificateProvider.class, method = "update")
    Integer update(CertificateDO bean);

    @DeleteProvider(type = CertificateProvider.class, method = "remove")
    Integer remove(CertificateDO bean);

    @DeleteProvider(type = CertificateProvider.class, method = "delete")
    Integer delete(Long id);
}
