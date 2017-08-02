package cn.qweb.cms.biz.domain;
import cn.qweb.cms.core.base.BaseQueryEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/*
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class ContentDO extends BaseQueryEntity implements Serializable {

private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    private Long id;
    /**
     *@Fields channel_id:栏目id
     */
    private Long channelId;
    /**
     *@Fields sort_date:排序日期
     */
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
    private Date gmtCreate;
    /**
     *@Fields gmt_modified:
     */
    private Date gmtModified;

    private ChannelDO channel;

    private ContentTxtDO contentTxt;

    private ContentExtDO contentExt;

    private ContentCheckDO contentCheck;

    private List<ContentAttrDO> contentAttrs;

    private List<ContentPictureDO> contentPictures;

    private List<ContentAttachmentDO> contentAttachments;


    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
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

    public Boolean getRecommend() {
        return isRecommend;
    }

    public void setRecommend(Boolean recommend) {
        isRecommend = recommend;
    }

    public ChannelDO getChannel() {
        return channel;
    }

    public void setChannel(ChannelDO channel) {
        this.channel = channel;
    }

    public ContentTxtDO getContentTxt() {
        return contentTxt;
    }

    public void setContentTxt(ContentTxtDO contentTxt) {
        this.contentTxt = contentTxt;
    }

    public ContentExtDO getContentExt() {
        return contentExt;
    }

    public void setContentExt(ContentExtDO contentExt) {
        this.contentExt = contentExt;
    }

    public List<ContentAttrDO> getContentAttrs() {
        return contentAttrs;
    }

    public void setContentAttrs(List<ContentAttrDO> contentAttrs) {
        this.contentAttrs = contentAttrs;
    }

    public List<ContentPictureDO> getContentPictures() {
        return contentPictures;
    }

    public void setContentPictures(List<ContentPictureDO> contentPictures) {
        this.contentPictures = contentPictures;
    }

    public List<ContentAttachmentDO> getContentAttachments() {
        return contentAttachments;
    }

    public void setContentAttachments(List<ContentAttachmentDO> contentAttachments) {
        this.contentAttachments = contentAttachments;
    }

    public ContentCheckDO getContentCheck() {
        return contentCheck;
    }

    public void setContentCheck(ContentCheckDO contentCheck) {
        this.contentCheck = contentCheck;
    }

    @Override
    public String toString() {
        return "ContentDO{" +
                "id=" + id +
                ", channelId=" + channelId +
                ", sortDate=" + sortDate +
                ", topLevel=" + topLevel +
                ", isRecommend=" + isRecommend +
                ", status=" + status +
                ", viewsDay=" + viewsDay +
                ", commentsDay=" + commentsDay +
                ", downloadsDay=" + downloadsDay +
                ", upsDay=" + upsDay +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", channel=" + channel +
                ", contentTxt=" + contentTxt +
                ", contentExt=" + contentExt +
                ", contentCheck=" + contentCheck +
                ", contentAttrs=" + contentAttrs +
                ", contentPictures=" + contentPictures +
                ", contentAttachments=" + contentAttachments +
                '}';
    }
}