package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.FriendlinkProvider;
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
public interface FriendlinkMapper {

    @SelectProvider(type = FriendlinkProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "siteName", column = "site_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "siteLink", column = "site_link", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "friendlinkctgId", column = "friendlinkctg_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "logo", column = "logo", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "email", column = "email", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "description", column = "description", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "views", column = "views", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "isEnabled", column = "is_enabled", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    FriendlinkDO get(Long id);

    @SelectProvider(type = FriendlinkProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "siteName", column = "site_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "siteLink", column = "site_link", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "friendlinkctgId", column = "friendlinkctg_id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "logo", column = "logo", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "email", column = "email", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "description", column = "description", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "views", column = "views", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "isEnabled", column = "is_enabled", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<FriendlinkDO> list(FriendlinkDO bean);

    @InsertProvider(type = FriendlinkProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(FriendlinkDO bean);

    @UpdateProvider(type = FriendlinkProvider.class, method = "update")
    Integer update(FriendlinkDO bean);

    @DeleteProvider(type = FriendlinkProvider.class, method = "remove")
    Integer remove(FriendlinkDO bean);

    @DeleteProvider(type = FriendlinkProvider.class, method = "delete")
    Integer delete(Long id);
}
