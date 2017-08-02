package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.ContentAttachmentDO;
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

public class ContentAttachmentProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_content_attachment";

    public static final String[] Fields={"id","content_id","priority","attachment_path","attachment_name","filename","download_count","gmt_create","gmt_modified"};

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

    public String listByContentId(final Long contentId) {
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            WHERE("content_id=#{contentId}");
        }}.toString();
    }

    /**
     * 查询多个结果集
     */
    public String list(final ContentAttachmentDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("id=#{id}");
                }
                if(bean.getContentId()!=null){
                    WHERE("content_id=#{contentId}");
                }
                if(bean.getPriority()!=null){
                    WHERE("priority=#{priority}");
                }
                if(bean.getAttachmentPath()!=null){
                    WHERE("attachment_path=#{attachmentPath}");
                }
                if(bean.getAttachmentName()!=null){
                    WHERE("attachment_name=#{attachmentName}");
                }
                if(bean.getFilename()!=null){
                    WHERE("filename=#{filename}");
                }
                if(bean.getDownloadCount()!=null){
                    WHERE("download_count=#{downloadCount}");
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
    public String save(final ContentAttachmentDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getContentId() != null) {
                VALUES("content_id", "#{contentId}");
            }
            if (bean.getPriority() != null) {
                VALUES("priority", "#{priority}");
            }
            if (bean.getAttachmentPath() != null) {
                VALUES("attachment_path", "#{attachmentPath}");
            }
            if (bean.getAttachmentName() != null) {
                VALUES("attachment_name", "#{attachmentName}");
            }
            if (bean.getFilename() != null) {
                VALUES("filename", "#{filename}");
            }
            if (bean.getDownloadCount() != null) {
                VALUES("download_count", "#{downloadCount}");
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
    public String update(final ContentAttachmentDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getContentId() != null) {
                SET("content_id=#{contentId}");
            }
            if (bean.getPriority() != null) {
                SET("priority=#{priority}");
            }
            if (bean.getAttachmentPath() != null) {
                SET("attachment_path=#{attachmentPath}");
            }
            if (bean.getAttachmentName() != null) {
                SET("attachment_name=#{attachmentName}");
            }
            if (bean.getFilename() != null) {
                SET("filename=#{filename}");
            }
            if (bean.getDownloadCount() != null) {
                SET("download_count=#{downloadCount}");
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
    public String remove(final ContentAttachmentDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getContentId()!=null){
                WHERE("content_id=#{contentId}");
            }
            if(bean.getPriority()!=null){
                WHERE("priority=#{priority}");
            }
            if(bean.getAttachmentPath()!=null){
                WHERE("attachment_path=#{attachmentPath}");
            }
            if(bean.getAttachmentName()!=null){
                WHERE("attachment_name=#{attachmentName}");
            }
            if(bean.getFilename()!=null){
                WHERE("filename=#{filename}");
            }
            if(bean.getDownloadCount()!=null){
                WHERE("download_count=#{downloadCount}");
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