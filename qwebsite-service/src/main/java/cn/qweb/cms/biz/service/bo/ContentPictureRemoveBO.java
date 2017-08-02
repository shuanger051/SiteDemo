package cn.qweb.cms.biz.service.bo;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/*
 *  Created by xuebj - 2017/03/29.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class ContentPictureRemoveBO implements Serializable{
    private static final long serialVersionUID = 1L;


    /**
     *@Fields priority:排列顺序
     */
    private Integer priority;

    /**
     *@Fields content_id:
     */
    private Long contentId;

    /**
     *@Fields img_path:图片地址
     */
    private String imgPath;

    /**
     *@Fields description:描述
     */
    private String description;

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


    public void setPriority(Integer priority){
        this.priority = priority;
    }
    public Integer getPriority(){
        return priority;
    }
    public void setContentId(Long contentId){
        this.contentId = contentId;
    }
    public Long getContentId(){
        return contentId;
    }
    public void setImgPath(String imgPath){
        this.imgPath = imgPath;
    }
    public String getImgPath(){
        return imgPath;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
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
        return "ContentPicture{" +
                    "priority='" + priority + "\'," +
                    "contentId='" + contentId + "\'," +
                    "imgPath='" + imgPath + "\'," +
                    "description='" + description + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
}