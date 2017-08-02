package cn.qweb.cms.biz.service.bo;
import java.io.Serializable;
import java.util.List;


/*
 *  Created by xuebj - 2017/05/11.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class ChorgraphySaveBO implements Serializable{
    private static final long serialVersionUID = 1L;


    /**
     *@Fields name:舞谱名称
     */
    private String name;

    /**
     *@Fields user_id:当前登录用户的ID，有三方系统提供
     */
    private String userId;

    /**
     *@Fields content:舞谱内容
     */
    private String content;

    /**
     *@Fields authors:填写作曲，音乐等作者
     */
    private String authors;

    /**
     *@Fields brief:简介
     */
    private String brief;

    /**
     *@Fields uper_mobile:上传者手机号
     */
    private String uperMobile;

    /**
     *@Fields uper_name:上传者姓名
     */
    private String uperName;

    /**
     *@Fields uper_email:上传者邮箱
     */
    private String uperEmail;

    /**
     *@Fields level:适合人群级别
     */
    private String level;

    /**
     *@Fields wall:难度
     */
    private Integer wall;

    /**
     *@Fields count:
     */
    private Integer count;

    /**
     *@Fields status:状态 1 审核中，2 已审核
     */
    private Integer status;

    /**
     *@Fields dance_type:舞种，1：排舞，2：广场舞
     */
    private String danceType;

    /**
     * 附件
     */
    private List<ChorgraphyAttachmentSaveBO> attachments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getUperMobile() {
        return uperMobile;
    }

    public void setUperMobile(String uperMobile) {
        this.uperMobile = uperMobile;
    }

    public String getUperName() {
        return uperName;
    }

    public void setUperName(String uperName) {
        this.uperName = uperName;
    }

    public String getUperEmail() {
        return uperEmail;
    }

    public void setUperEmail(String uperEmail) {
        this.uperEmail = uperEmail;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getWall() {
        return wall;
    }

    public void setWall(Integer wall) {
        this.wall = wall;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDanceType() {
        return danceType;
    }

    public void setDanceType(String danceType) {
        this.danceType = danceType;
    }

    public List<ChorgraphyAttachmentSaveBO> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<ChorgraphyAttachmentSaveBO> attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "ChorgraphySaveBO{" +
                "name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                ", authors='" + authors + '\'' +
                ", brief='" + brief + '\'' +
                ", uperMobile='" + uperMobile + '\'' +
                ", uperName='" + uperName + '\'' +
                ", uperEmail='" + uperEmail + '\'' +
                ", level='" + level + '\'' +
                ", wall=" + wall +
                ", count=" + count +
                ", status=" + status +
                ", danceType='" + danceType + '\'' +
                ", attachments=" + attachments +
                '}';
    }
}