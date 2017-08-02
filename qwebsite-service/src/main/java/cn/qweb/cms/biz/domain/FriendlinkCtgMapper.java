package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.FriendlinkCtgProvider;
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
public interface FriendlinkCtgMapper {

    @SelectProvider(type = FriendlinkCtgProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "friendlinkctgName", column = "friendlinkctg_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    FriendlinkCtgDO get(Long id);

    @SelectProvider(type = FriendlinkCtgProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "friendlinkctgName", column = "friendlinkctg_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "priority", column = "priority", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<FriendlinkCtgDO> list(FriendlinkCtgDO bean);

    @InsertProvider(type = FriendlinkCtgProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(FriendlinkCtgDO bean);

    @UpdateProvider(type = FriendlinkCtgProvider.class, method = "update")
    Integer update(FriendlinkCtgDO bean);

    @DeleteProvider(type = FriendlinkCtgProvider.class, method = "remove")
    Integer remove(FriendlinkCtgDO bean);

    @DeleteProvider(type = FriendlinkCtgProvider.class, method = "delete")
    Integer delete(Long id);
}
