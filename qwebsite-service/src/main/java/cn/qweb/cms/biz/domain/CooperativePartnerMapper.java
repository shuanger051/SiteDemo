package cn.qweb.cms.biz.domain;
import cn.qweb.cms.biz.domain.sqlprovider.CooperativePartnerProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import java.util.List;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/*
 *  Created by xuebj - 2017/03/23.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface CooperativePartnerMapper {

    @SelectProvider(type = CooperativePartnerProvider.class, method = "get")
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
    CooperativePartnerDO get(Long id);

    @SelectProvider(type = CooperativePartnerProvider.class, method = "list")
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
    List<CooperativePartnerDO> list(CooperativePartnerDO bean);

    @InsertProvider(type = CooperativePartnerProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(CooperativePartnerDO bean);

    @UpdateProvider(type = CooperativePartnerProvider.class, method = "update")
    Integer update(CooperativePartnerDO bean);

    @DeleteProvider(type = CooperativePartnerProvider.class, method = "remove")
    Integer remove(CooperativePartnerDO bean);

    @DeleteProvider(type = CooperativePartnerProvider.class, method = "delete")
    Integer delete(Long id);
}
