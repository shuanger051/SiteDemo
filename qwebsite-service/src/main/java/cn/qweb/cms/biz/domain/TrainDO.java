package cn.qweb.cms.biz.domain;

import java.io.Serializable;
import cn.qweb.cms.core.base.BaseQueryEntity;
import java.util.Date;


/*
 *  Created by xuebj - 2017/03/31.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class TrainDO extends BaseQueryEntity implements Serializable {

private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    private Long id;
    /**
     *@Fields title:标题
     */
    private String title;
    /**
     *@Fields content:详情
     */
    private String content;

    /**
     *@Fields 发布状态
     */
    private String status;

    /**
     * @Fields 所在地区
     */
    private String province;

    /**
     * @Fields 开始日期
     */
    private Date gmtBegin;

    /**
     * @Fields 结束日期
     */
    private Date gmtEnd;

    /**
     *@Fields gmt_create:
     */
    private Date gmtCreate;
    /**
     *@Fields gmt_modified:
     */
    private Date gmtModified;

    private Date gmtIndex;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return content;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Date getGmtBegin() {
        return gmtBegin;
    }

    public void setGmtBegin(Date gmtBegin) {
        this.gmtBegin = gmtBegin;
    }

    public Date getGmtEnd() {
        return gmtEnd;
    }

    public void setGmtEnd(Date gmtEnd) {
        this.gmtEnd = gmtEnd;
    }

    @Override
    public String toString() {
        return "TrainDO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", province='" + province + '\'' +
                ", gmtBegin=" + gmtBegin +
                ", gmtEnd=" + gmtEnd +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", gmtIndex=" + gmtIndex +
                '}';
    }
}