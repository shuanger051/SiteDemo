package cn.qweb.cms.biz.service.bo;
import java.io.Serializable;


/*
 *  Created by xuebj - 2017/05/11.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class ChorgraphyAttachmentSaveBO implements Serializable{
    private static final long serialVersionUID = 1L;


    /**
     *@Fields chorgraphy_id:对应舞谱id
     */
    private Long chorgraphyId;

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
     *@Fields type:附件类型，1 文件，2 视频
     */
    private String type;

    public ChorgraphyAttachmentSaveBO(String attachmentPath, String attachmentName) {
        this.attachmentPath = attachmentPath;
        this.attachmentName = attachmentName;
    }

    public ChorgraphyAttachmentSaveBO() {
    }

    public void setChorgraphyId(Long chorgraphyId){
        this.chorgraphyId = chorgraphyId;
    }
    public Long getChorgraphyId(){
        return chorgraphyId;
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
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }

    @Override
    public String toString(){
        return "ChorgraphyAttachment{" +
                    "chorgraphyId='" + chorgraphyId + "\'," +
                    "priority='" + priority + "\'," +
                    "attachmentPath='" + attachmentPath + "\'," +
                    "attachmentName='" + attachmentName + "\'," +
                    "filename='" + filename + "\'," +
                    "type='" + type +
                "}";
    }
}