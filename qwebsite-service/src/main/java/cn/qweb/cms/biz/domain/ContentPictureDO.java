package cn.qweb.cms.biz.domain;
import cn.qweb.cms.core.base.BaseQueryEntity;

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

public class ContentPictureDO extends BaseQueryEntity implements Serializable {

private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    private Long id;
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
        return "ContentPictureDO{" +
                    "id='" + id + "\'," +
                    "priority='" + priority + "\'," +
                    "contentId='" + contentId + "\'," +
                    "imgPath='" + imgPath + "\'," +
                    "description='" + description + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
		}