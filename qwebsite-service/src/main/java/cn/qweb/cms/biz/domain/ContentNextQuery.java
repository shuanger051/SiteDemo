package cn.qweb.cms.biz.domain;

import cn.qweb.cms.biz.service.query.ContentExtQUERY;

import java.io.Serializable;

/**
 * Created by xuebj on 2017/4/13.
 */
public class ContentNextQuery extends ContentExtQUERY implements Serializable {


    private static final long serialVersionUID = -5319876612311050187L;
    private Long id;

    private Long channelId;

    private Boolean next;

    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Boolean getNext() {
        return next;
    }

    public void setNext(Boolean next) {
        this.next = next;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ContentNextQuery{" +
                "id=" + id +
                ", channelId=" + channelId +
                ", next=" + next +
                ", status=" + status +
                '}';
    }
}
