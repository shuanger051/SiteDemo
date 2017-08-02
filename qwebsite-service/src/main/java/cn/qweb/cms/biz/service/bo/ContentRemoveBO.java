package cn.qweb.cms.biz.service.bo;
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

public class ContentRemoveBO implements Serializable{
    private static final long serialVersionUID = 1L;


    /**
     *@Fields channel_id:栏目id
     */
    private Long channelId;

    /**
     *@Fields sort_date:排序日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sortDate;

    /**
     *@Fields top_level:固定级别
     */
    private Integer topLevel;

    /**
     *@Fields is_recommend:是否推荐
     */
    private Boolean isRecommend;

    /**
     *@Fields status:状态 0:草稿;1:审核中;2:审核通过;3:回收站
     */
    private Integer status;

    /**
     *@Fields views_day:日访问数
     */
    private Integer viewsDay;

    /**
     *@Fields comments_day:日评论数
     */
    private Integer commentsDay;

    /**
     *@Fields downloads_day:日下载数
     */
    private Integer downloadsDay;

    /**
     *@Fields ups_day:日顶数
     */
    private Integer upsDay;

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


    public void setChannelId(Long channelId){
        this.channelId = channelId;
    }
    public Long getChannelId(){
        return channelId;
    }
    public void setSortDate(Date sortDate){
        this.sortDate = sortDate;
    }
    public Date getSortDate(){
        return sortDate;
    }
    public void setTopLevel(Integer topLevel){
        this.topLevel = topLevel;
    }
    public Integer getTopLevel(){
        return topLevel;
    }
    public void setIsRecommend(Boolean isRecommend){
        this.isRecommend = isRecommend;
    }
    public Boolean getIsRecommend(){
        return isRecommend;
    }
    public void setStatus(Integer status){
        this.status = status;
    }
    public Integer getStatus(){
        return status;
    }
    public void setViewsDay(Integer viewsDay){
        this.viewsDay = viewsDay;
    }
    public Integer getViewsDay(){
        return viewsDay;
    }
    public void setCommentsDay(Integer commentsDay){
        this.commentsDay = commentsDay;
    }
    public Integer getCommentsDay(){
        return commentsDay;
    }
    public void setDownloadsDay(Integer downloadsDay){
        this.downloadsDay = downloadsDay;
    }
    public Integer getDownloadsDay(){
        return downloadsDay;
    }
    public void setUpsDay(Integer upsDay){
        this.upsDay = upsDay;
    }
    public Integer getUpsDay(){
        return upsDay;
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
        return "Content{" +
                    "channelId='" + channelId + "\'," +
                    "sortDate='" + sortDate + "\'," +
                    "topLevel='" + topLevel + "\'," +
                    "isRecommend='" + isRecommend + "\'," +
                    "status='" + status + "\'," +
                    "viewsDay='" + viewsDay + "\'," +
                    "commentsDay='" + commentsDay + "\'," +
                    "downloadsDay='" + downloadsDay + "\'," +
                    "upsDay='" + upsDay + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
}