package cn.qweb.cms.biz.service.bo;
import java.io.Serializable;


/*
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class ContentAttachmentSaveBO implements Serializable{
    private static final long serialVersionUID = 1L;


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


    public ContentAttachmentSaveBO(String attachmentPath, String attachmentName) {
        this.attachmentPath = attachmentPath;
        this.attachmentName = attachmentName;
    }

    public ContentAttachmentSaveBO() {
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


    @Override
    public String toString() {
        return "ContentAttachmentSaveBO{" +
                "contentId=" + contentId +
                ", priority=" + priority +
                ", attachmentPath='" + attachmentPath + '\'' +
                ", attachmentName='" + attachmentName + '\'' +
                ", filename='" + filename + '\'' +
                '}';
    }
}