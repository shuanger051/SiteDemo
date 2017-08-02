package cn.qweb.cms.biz.service.bo;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;

/*
 *  Created by xuebj - 2017/05/11.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class ChorgraphyAttachmentUpdateBO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    @NotNull(message = "唯一键不能为空")
    private Long id;
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
    /**
     *@Fields gmt_create:
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;
    /**
     *@Fields gmt_modified:
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
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
        return "ChorgraphyAttachment{" +
                    "id='" + id + "\'," +
                    "chorgraphyId='" + chorgraphyId + "\'," +
                    "priority='" + priority + "\'," +
                    "attachmentPath='" + attachmentPath + "\'," +
                    "attachmentName='" + attachmentName + "\'," +
                    "filename='" + filename + "\'," +
                    "type='" + type + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
        }