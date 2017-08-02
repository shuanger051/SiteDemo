package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.SysDictEntryDO;
import org.apache.ibatis.jdbc.SQL;
import cn.qweb.cms.core.base.BaseDynaSqlProvider;

/*
 *  Created by xuebj - 2017/03/15.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class SysDictEntryProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_sys_dict_entry";

    public static final String[] Fields={"id","entry_code","entry_name","remark","gmt_create","gmt_modified"};

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
    public String list(final SysDictEntryDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("id=#{id}");
                }
                if(bean.getEntryCode()!=null){
                    WHERE("entry_code=#{entryCode}");
                }
                if(bean.getEntryName()!=null){
                    WHERE("entry_name like CONCAT('%',#{entry_name},'%')");
                }
                if(bean.getRemark()!=null){
                    WHERE("remark=#{remark}");
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
    public String save(final SysDictEntryDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getEntryCode() != null) {
                VALUES("entry_code", "#{entryCode}");
            }
            if (bean.getEntryName() != null) {
                VALUES("entry_name", "#{entryName}");
            }
            if (bean.getRemark() != null) {
                VALUES("remark", "#{remark}");
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
    public String update(final SysDictEntryDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getEntryCode() != null) {
                SET("entry_code=#{entryCode}");
            }
            if (bean.getEntryName() != null) {
                SET("entry_name=#{entryName}");
            }
            if (bean.getRemark() != null) {
                SET("remark=#{remark}");
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
    public String remove(final SysDictEntryDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getEntryCode()!=null){
                WHERE("entry_code=#{entryCode}");
            }
            if(bean.getEntryName()!=null){
                WHERE("entry_name=#{entryName}");
            }
            if(bean.getRemark()!=null){
                WHERE("remark=#{remark}");
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