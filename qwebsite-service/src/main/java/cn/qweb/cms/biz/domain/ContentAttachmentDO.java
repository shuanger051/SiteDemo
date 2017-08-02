package cn.qweb.cms.biz.domain;
import java.io.Serializable;
import cn.qweb.cms.core.base.BaseQueryEntity;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;


/*
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class ContentAttachmentDO extends BaseQueryEntity implements Serializable {

private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    private Long id;
    /**
     *@Fields content_id:内容id
     */
    private Long contentId;
    /**
     *@Fields priority:排列顺序
     */
    private Integer priority;
    /**
     *@Fields attachment_path:附件路径
     */
    private String attachmentPath;
    /**
     *@Fields attachment_name:附件名称
     */
    private String attachmentName;
    /**
     *@Fields filename:文件名
     */
    private String filename;
    /**
     *@Fields download_count:下载次数
     */
    private Integer downloadCount;
    /**
     *@Fields gmt_create:
     */
    private Date gmtCreate;
    /**
     *@Fields gmt_modified:
     */
    private Date gmtModified;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setContentId(Long contentId){
        this.contentId = contentId;
    }
    public Long getContentId(){
        return contentId;
    }
    public void setPriority(Integer priority){
        this.priority = priority;
    }
    public Integer getPriority(){
        return priority;
    }
    public void setAttachmentPath(String attachmentPath){
        this.attachmentPath = attachmentPath;
    }
    public String getAttachmentPath(){
        return attachmentPath;
    }
    public void setAttachmentName(String attachmentName){
        this.attachmentName = attachmentName;
    }
    public String getAttachmentName(){
        return attachmentName;
    }
    public void setFilename(String filename){
        this.filename = filename;
    }
    public String getFilename(){
        return filename;
    }
    public void setDownloadCount(Integer downloadCount){
        this.downloadCount = downloadCount;
    }
    public Integer getDownloadCount(){
        return downloadCount;
    }
    public void setGmtCreate(Date gmtCreate){
        this.gmtCreate = gmtCreate;
    }
    public Date getGmtCreate(){
        return gmtCreate;
    }
    public void setGmtModified(Date gmtModified){
        this.gmtModified = gmtModified;
    }
    public Date getGmtModified(){
        return gmtModified;
    }
    @Override
    public String toString(){
        return "ContentAttachmentDO{" +
                    "id='" + id + "\'," +
                    "contentId='" + contentId + "\'," +
                    "priority='" + priority + "\'," +
                    "attachmentPath='" + attachmentPath + "\'," +
                    "attachmentName='" + attachmentName + "\'," +
                    "filename='" + filename + "\'," +
                    "downloadCount='" + downloadCount + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
		}