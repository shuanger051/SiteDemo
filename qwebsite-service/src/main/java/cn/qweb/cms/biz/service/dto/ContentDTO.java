package cn.qweb.cms.biz.service.dto;
import cn.qweb.cms.core.dictionary.DictManager;

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

public class ContentDTO implements Serializable{
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
     * status 转义
     */
    private String statusName;
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

    private ChannelDTO channel;

    private ContentTxtDTO contentTxt;

    private ContentExtDTO contentExt;

    private ContentCheckDTO contentCheck;

    private List<ContentAttachmentDTO> contentAttachments;

    private List<ContentAttrDTO> contentAttrs;

    private List<ContentPictureDTO> contentPictures;

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
        this.setStatusName(DictManager.getItem("contentStatus",String.valueOf(status)));
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

    public Boolean getRecommend() {
        return isRecommend;
    }

    public void setRecommend(Boolean recommend) {
        isRecommend = recommend;
    }

    public ChannelDTO getChannel() {
        return channel;
    }

    public void setChannel(ChannelDTO channel) {
        this.channel = channel;
    }

    public ContentTxtDTO getContentTxt() {
        return contentTxt;
    }

    public void setContentTxt(ContentTxtDTO contentTxt) {
        this.contentTxt = contentTxt;
    }

    public ContentExtDTO getContentExt() {
        return contentExt;
    }

    public void setContentExt(ContentExtDTO contentExt) {
        this.contentExt = contentExt;
    }

    public List<ContentAttachmentDTO> getContentAttachments() {
        return contentAttachments;
    }

    public void setContentAttachments(List<ContentAttachmentDTO> contentAttachments) {
        this.contentAttachments = contentAttachments;
    }

    public List<ContentAttrDTO> getContentAttrs() {
        return contentAttrs;
    }

    public void setContentAttrs(List<ContentAttrDTO> contentAttrs) {
        this.contentAttrs = contentAttrs;
    }

    public List<ContentPictureDTO> getContentPictures() {
        return contentPictures;
    }

    public void setContentPictures(List<ContentPictureDTO> contentPictures) {
        this.contentPictures = contentPictures;
    }

    public ContentCheckDTO getContentCheck() {
        return contentCheck;
    }

    public void setContentCheck(ContentCheckDTO contentCheck) {
        this.contentCheck = contentCheck;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "ContentDTO{" +
                "id=" + id +
                ", channelId=" + channelId +
                ", sortDate=" + sortDate +
                ", topLevel=" + topLevel +
                ", isRecommend=" + isRecommend +
                ", status=" + status +
                ", statusName='" + statusName + '\'' +
                ", viewsDay=" + viewsDay +
                ", commentsDay=" + commentsDay +
                ", downloadsDay=" + downloadsDay +
                ", upsDay=" + upsDay +
                ", channel=" + channel +
                ", contentTxt=" + contentTxt +
                ", contentExt=" + contentExt +
                ", contentCheck=" + contentCheck +
                ", contentAttachments=" + contentAttachments +
                ", contentAttrs=" + contentAttrs +
                ", contentPictures=" + contentPictures +
                '}';
    }
}