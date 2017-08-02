package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.CredentialsProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/*
 *  Created by xuebj - 2017/05/05.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface CredentialsMapper {

    @SelectProvider(type = CredentialsProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "credentialsId", column = "credentials_id", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "credentialsType", column = "credentials_type", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "credentialsLevel", column = "credentials_level", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "credentialsDate", column = "credentials_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "name", column = "name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "personNo", column = "person_no", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "cardNo", column = "card_no", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "workUnit", column = "work_unit", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "personPic", column = "person_pic", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "trainerType", column = "trainer_type", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    CredentialsDO get(Long id);

    @SelectProvider(type = CredentialsProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "credentialsId", column = "credentials_id", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "credentialsType", column = "credentials_type", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "credentialsLevel", column = "credentials_level", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "credentialsDate", column = "credentials_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "name", column = "name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "personNo", column = "person_no", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "cardNo", column = "card_no", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "workUnit", column = "work_unit", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "personPic", column = "person_pic", jdbcType = JdbcType.LONGVARCHAR, javaType = String.class), 
            @Result(property = "trainerType", column = "trainer_type", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<CredentialsDO> list(CredentialsDO bean);

    @InsertProvider(type = CredentialsProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(CredentialsDO bean);

    @UpdateProvider(type = CredentialsProvider.class, method = "update")
    Integer update(CredentialsDO bean);

    @DeleteProvider(type = CredentialsProvider.class, method = "remove")
    Integer remove(CredentialsDO bean);

    @DeleteProvider(type = CredentialsProvider.class, method = "delete")
    Integer delete(Long id);

    @SelectProvider(type = CredentialsProvider.class, method = "checkExport")
    Integer checkExport(CredentialsDO bean);
}
