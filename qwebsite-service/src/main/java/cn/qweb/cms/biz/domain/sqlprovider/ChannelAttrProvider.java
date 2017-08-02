package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.ChannelAttrDO;
import org.apache.ibatis.jdbc.SQL;
import cn.qweb.cms.core.base.BaseDynaSqlProvider;

/*
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class ChannelAttrProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_channel_attr";

    public static final String[] Fields={"id","channel_id","attr_name","attr_value","gmt_create","gmt_modified"};

    /**
     * 获取单个结果集
     */
    public String get(final Long id){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            WHERE("id="+id);
        }}.toString();
    }

    /**
     * 查询多个结果集
     */
    public String list(final ChannelAttrDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("id=#{id}");
                }
                if(bean.getChannelId()!=null){
                    WHERE("channel_id=#{channelId}");
                }
                if(bean.getAttrName()!=null){
                    WHERE("attr_name=#{attrName}");
                }
                if(bean.getAttrValue()!=null){
                    WHERE("attr_value=#{attrValue}");
                }
                if(bean.getGmtCreate()!=null){
                    WHERE("gmt_create=#{gmtCreate}");
                }
                if(bean.getGmtModified()!=null){
                    WHERE("gmt_modified=#{gmtModified}");
                }
                if(bean.getSort() != null){
                    ORDER_BY(bean.getSort());
                }
            }

        }}.toString();
    }

    /**
     *  保存单个对象
     */
    public String save(final ChannelAttrDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getChannelId() != null) {
                VALUES("channel_id", "#{channelId}");
            }
            if (bean.getAttrName() != null) {
                VALUES("attr_name", "#{attrName}");
            }
            if (bean.getAttrValue() != null) {
                VALUES("attr_value", "#{attrValue}");
            }
            if (bean.getGmtCreate() != null) {
                VALUES("gmt_create", "#{gmtCreate}");
            }
            if (bean.getGmtModified() != null) {
                VALUES("gmt_modified", "#{gmtModified}");
            }
        }}.toString();
    }

    /**
     * 更新对象
     */
    public String update(final ChannelAttrDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getChannelId() != null) {
                SET("channel_id=#{channelId}");
            }
            if (bean.getAttrName() != null) {
                SET("attr_name=#{attrName}");
            }
            if (bean.getAttrValue() != null) {
                SET("attr_value=#{attrValue}");
            }
            if (bean.getGmtCreate() != null) {
                SET("gmt_create=#{gmtCreate}");
            }
            if (bean.getGmtModified() != null) {
                SET("gmt_modified=#{gmtModified}");
            }
            WHERE("id = #{id}");
        }}.toString();
    }


    /**
     * 按条件移除对象
     */
    public String remove(final ChannelAttrDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getChannelId()!=null){
                WHERE("channel_id=#{channelId}");
            }
            if(bean.getAttrName()!=null){
                WHERE("attr_name=#{attrName}");
            }
            if(bean.getAttrValue()!=null){
                WHERE("attr_value=#{attrValue}");
            }
            if(bean.getGmtCreate()!=null){
                WHERE("gmt_create=#{gmtCreate}");
            }
            if(bean.getGmtModified()!=null){
                WHERE("gmt_modified=#{gmtModified}");
            }
            }}.toString();
    }

    /**
     * 删除单个对象
     */
    public String delete(final Long id){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            WHERE("id=" + id);
        }}.toString();
    }


}