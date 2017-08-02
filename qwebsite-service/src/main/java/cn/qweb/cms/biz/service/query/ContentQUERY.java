package cn.qweb.cms.biz.service.query;
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

public class ContentQUERY extends ContentExtQUERY implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields channel_id:栏目id
     */
    private Long channelId;

    /**
     *@Fields sort_date:排序日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sortDateStart;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sortDateEnd;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date releaseDateStart;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date releaseDateEnd;

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

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Date getSortDateStart() {
        return sortDateStart;
    }

    public void setSortDateStart(Date sortDateStart) {
        this.sortDateStart = sortDateStart;
    }

    public Date getSortDateEnd() {
        return sortDateEnd;
    }

    public void setSortDateEnd(Date sortDateEnd) {
        this.sortDateEnd = sortDateEnd;
    }

    public Date getReleaseDateStart() {
        return releaseDateStart;
    }

    public void setReleaseDateStart(Date releaseDateStart) {
        this.releaseDateStart = releaseDateStart;
    }

    public Date getReleaseDateEnd() {
        return releaseDateEnd;
    }

    public void setReleaseDateEnd(Date releaseDateEnd) {
        this.releaseDateEnd = releaseDateEnd;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}