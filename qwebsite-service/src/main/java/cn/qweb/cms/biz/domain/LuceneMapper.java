package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.LuceneProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import java.util.List;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/*
 *  Created by xuebj - 2017/04/07.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface LuceneMapper {

    @SelectProvider(type = LuceneProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "content", column = "content", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "pic", column = "pic", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "video", column = "video", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "status", column = "status", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "gmtAdd", column = "gmt_add", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    LuceneDO get(Long id);

    @SelectProvider(type = LuceneProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "content", column = "content", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "pic", column = "pic", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "video", column = "video", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "status", column = "status", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "gmtAdd", column = "gmt_add", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<LuceneDO> list(LuceneDO bean);

    @InsertProvider(type = LuceneProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(LuceneDO bean);

    @UpdateProvider(type = LuceneProvider.class, method = "update")
    Integer update(LuceneDO bean);

    @DeleteProvider(type = LuceneProvider.class, method = "remove")
    Integer remove(LuceneDO bean);

    @DeleteProvider(type = LuceneProvider.class, method = "delete")
    Integer delete(Long id);
}
