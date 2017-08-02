package cn.qweb.cms.biz.service.bo;
import org.springframework.format.annotation.DateTimeFormat;

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

public class ContentSaveBO implements Serializable{
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

    private ContentExtSaveBO contentExt;

    private ContentCheckSaveBO contentCheck;

    private List<ContentAttachmentSaveBO> contentAttachment;

    private ContentTxtSaveBO contentTxt;

    private List<ContentAttrSaveBO> contentAttr;

    private List<ContentPictureSaveBO> contentPicture;

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Date getSortDate() {
        return sortDate;
    }

    public void setSortDate(Date sortDate) {
        this.sortDate = sortDate;
    }

    public Integer getTopLevel() {
        return topLevel;
    }

    public void setTopLevel(Integer topLevel) {
        this.topLevel = topLevel;
    }

    public Boolean getRecommend() {
        return isRecommend;
    }

    public void setRecommend(Boolean recommend) {
        isRecommend = recommend;
    }

    public ContentExtSaveBO getContentExt() {
        return contentExt;
    }

    public void setContentExt(ContentExtSaveBO contentExt) {
        this.contentExt = contentExt;
    }

    public List<ContentAttachmentSaveBO> getContentAttachment() {
        return contentAttachment;
    }

    public void setContentAttachment(List<ContentAttachmentSaveBO> contentAttachment) {
        this.contentAttachment = contentAttachment;
    }

    public ContentTxtSaveBO getContentTxt() {
        return contentTxt;
    }

    public void setContentTxt(ContentTxtSaveBO contentTxt) {
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

    public ContentCheckSaveBO getContentCheck() {
        return contentCheck;
    }

    public void setContentCheck(ContentCheckSaveBO contentCheck) {
        this.contentCheck = contentCheck;
    }

    @Override
    public String toString() {
        return "ContentSaveBO{" +
                "channelId=" + channelId +
                ", sortDate=" + sortDate +
                ", topLevel=" + topLevel +
                ", isRecommend=" + isRecommend +
                ", contentExt=" + contentExt +
                ", contentCheck=" + contentCheck +
                ", contentAttachment=" + contentAttachment +
                ", contentTxt=" + contentTxt +
                ", contentAttr=" + contentAttr +
                ", contentPicture=" + contentPicture +
                '}';
    }
}