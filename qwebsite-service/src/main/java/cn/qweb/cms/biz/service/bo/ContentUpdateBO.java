package cn.qweb.cms.biz.service.bo;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
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

public class ContentUpdateBO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    @NotNull(message = "唯一键不能为空")
    private Long id;
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

    private ContentExtUpdateBO contentExt;

    private ContentTxtUpdateBO contentTxt;

    private List<ContentAttrSaveBO> contentAttr;

    private List<ContentPictureSaveBO> contentPicture;

    private List<ContentAttachmentSaveBO> contentAttachment;

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

    public Boolean getRecommend() {
        return isRecommend;
    }

    public void setRecommend(Boolean recommend) {
        isRecommend = recommend;
    }

    public ContentExtUpdateBO getContentExt() {
        return contentExt;
    }

    public void setContentExt(ContentExtUpdateBO contentExt) {
        this.contentExt = contentExt;
    }

    public ContentTxtUpdateBO getContentTxt() {
        return contentTxt;
    }

    public void setContentTxt(ContentTxtUpdateBO contentTxt) {
        this.contentTxt = contentTxt;
    }

    public List<ContentAttrSaveBO> getContentAttr() {
        return contentAttr;
    }

    public void setContentAttr(List<ContentAttrSaveBO> contentAttr) {
        this.contentAttr = contentAttr;
    }

    public List<ContentPictureSaveBO> getContentPicture() {
        return contentPicture;
    }

    public void setContentPicture(List<ContentPictureSaveBO> contentPicture) {
        this.contentPicture = contentPicture;
    }

    public List<ContentAttachmentSaveBO> getContentAttachment() {
        return contentAttachment;
    }

    public void setContentAttachment(List<ContentAttachmentSaveBO> contentAttachment) {
        this.contentAttachment = contentAttachment;
    }

    @Override
    public String toString() {
        return "ContentUpdateBO{" +
                "id=" + id +
                ", channelId=" + channelId +
                ", sortDate=" + sortDate +
                ", topLevel=" + topLevel +
                ", isRecommend=" + isRecommend +
                ", contentExt=" + contentExt +
                ", contentTxt=" + contentTxt +
                ", contentAttr=" + contentAttr +
                ", contentPicture=" + contentPicture +
                ", contentAttachment=" + contentAttachment +
                '}';
    }
}