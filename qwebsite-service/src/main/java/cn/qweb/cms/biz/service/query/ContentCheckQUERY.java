package cn.qweb.cms.biz.service.query;
import cn.qweb.cms.core.base.BaseQueryEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/*
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class ContentCheckQUERY extends BaseQueryEntity implements Serializable{
    private static final long serialVersionUID = 1L;


    /**
     *@Fields content_id:内容id
     */
    private Long contentId;

    /**
     *@Fields check_step:审核步数
     */
    private Integer checkStep;

    /**
     *@Fields check_opinion:审核意见
     */
    private String checkOpinion;

    /**
     *@Fields is_rejected:是否退回
     */
    private Boolean isRejected;

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


    public void setContentId(Long contentId){
        this.contentId = contentId;
    }
    public Long getContentId(){
        return contentId;
    }
    public void setCheckStep(Integer checkStep){
        this.checkStep = checkStep;
    }
    public Integer getCheckStep(){
        return checkStep;
    }
    public void setCheckOpinion(String checkOpinion){
        this.checkOpinion = checkOpinion;
    }
    public String getCheckOpinion(){
        return checkOpinion;
    }
    public void setIsRejected(Boolean isRejected){
        this.isRejected = isRejected;
    }
    public Boolean getIsRejected(){
        return isRejected;
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
        return "ContentCheck{" +
                    "contentId='" + contentId + "\'," +
                    "checkStep='" + checkStep + "\'," +
                    "checkOpinion='" + checkOpinion + "\'," +
                    "isRejected='" + isRejected + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
}