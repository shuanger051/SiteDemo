package cn.qweb.cms.biz.service.bo;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;

/*
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class ContentExtUpdateBO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    @NotNull(message = "唯一键不能为空")
    private Long id;
    /**
     *@Fields content_id:内容id
     */
    private Long contentId;
    /**
     *@Fields title:标题
     */
    private String title;
    /**
     *@Fields short_title:简短标题
     */
    private String shortTitle;
    /**
     *@Fields author:作者
     */
    private String author;
    /**
     *@Fields origin:来源
     */
    private String origin;
    /**
     *@Fields origin_url:来源链接
     */
    private String originUrl;
    /**
     *@Fields release_date:
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date releaseDate;
    /**
     *@Fields media_path:
     */
    private String mediaPath;
    /**
     *@Fields media_type:
     */
    private String mediaType;
    /**
     *@Fields title_img:
     */
    private String titleImg;
    /**
     *@Fields content_img:
     */
    private String contentImg;
    /**
     *@Fields type_img:
     */
    private String typeImg;
    /**
     *@Fields link:外部链接
     */
    private String link;
    /**
     *@Fields need_regenerate:需要重新生成静态页
     */
    private Boolean needRegenerate;
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

    /**
     *@Fields gmt_index:
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtIndex;

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
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setShortTitle(String shortTitle){
        this.shortTitle = shortTitle;
    }
    public String getShortTitle(){
        return shortTitle;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return author;
    }
    public void setOrigin(String origin){
        this.origin = origin;
    }
    public String getOrigin(){
        return origin;
    }
    public void setOriginUrl(String originUrl){
        this.originUrl = originUrl;
    }
    public String getOriginUrl(){
        return originUrl;
    }
    public void setReleaseDate(Date releaseDate){
        this.releaseDate = releaseDate;
    }
    public Date getReleaseDate(){
        return releaseDate;
    }
    public void setMediaPath(String mediaPath){
        this.mediaPath = mediaPath;
    }
    public String getMediaPath(){
        return mediaPath;
    }
    public void setMediaType(String mediaType){
        this.mediaType = mediaType;
    }
    public String getMediaType(){
        return mediaType;
    }
    public void setTitleImg(String titleImg){
        this.titleImg = titleImg;
    }
    public String getTitleImg(){
        return titleImg;
    }
    public void setContentImg(String contentImg){
        this.contentImg = contentImg;
    }
    public String getContentImg(){
        return contentImg;
    }
    public void setTypeImg(String typeImg){
        this.typeImg = typeImg;
    }
    public String getTypeImg(){
        return typeImg;
    }
    public void setLink(String link){
        this.link = link;
    }
    public String getLink(){
        return link;
    }
    public void setNeedRegenerate(Boolean needRegenerate){
        this.needRegenerate = needRegenerate;
    }
    public Boolean getNeedRegenerate(){
        return needRegenerate;
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
    public Date getGmtIndex() {
        return gmtIndex;
    }
    public void setGmtIndex(Date gmtIndex) {
        this.gmtIndex = gmtIndex;
    }

    @Override
    public String toString(){
        return "ContentExt{" +
                    "id='" + id + "\'," +
                    "contentId='" + contentId + "\'," +
                    "title='" + title + "\'," +
                    "shortTitle='" + shortTitle + "\'," +
                    "author='" + author + "\'," +
                    "origin='" + origin + "\'," +
                    "originUrl='" + originUrl + "\'," +
                    "releaseDate='" + releaseDate + "\'," +
                    "mediaPath='" + mediaPath + "\'," +
                    "mediaType='" + mediaType + "\'," +
                    "titleImg='" + titleImg + "\'," +
                    "contentImg='" + contentImg + "\'," +
                    "typeImg='" + typeImg + "\'," +
                    "link='" + link + "\'," +
                    "needRegenerate='" + needRegenerate + "\'," +
                    "description='" + description + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
        }