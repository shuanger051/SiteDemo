package cn.qweb.cms.biz.service.bo;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*
 *  Created by xuebj - 2017/05/11.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class ChorgraphyUpdateBO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * @Fields id:
     */
    @NotNull(message = "唯一键不能为空")
    private Long id;
    /**
     * @Fields name:舞谱名称
     */
    private String name;

    /**
     * @Fields content:舞谱内容
     */
    private String content;
    /**
     * @Fields authors:填写作曲，音乐等作者
     */
    private String authors;
    /**
     * @Fields brief:简介
     */
    private String brief;
    /**
     * @Fields release_date:发布时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date releaseDate;
    /**
     *@Fields starts:评分星数
     */
    private Integer starts;
    /**
     * @Fields level:适合人群级别
     */
    private String level;
    /**
     * @Fields wall:难度
     */
    private Integer wall;
    /**
     * @Fields status:状态 1 审核中，2 已审核
     */
    private Integer status;
    /**
     * @Fields dance_type:舞种，1：排舞，2：广场舞
     */
    private String danceType;

    /**
     * 附件列表
     */
    private List<ChorgraphyAttachmentSaveBO> attachments;

    public Integer getStarts() {
        return starts;
    }

    public void setStarts(Integer starts) {
        this.starts = starts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
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
        return "ChorgraphyUpdateBO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", authors='" + authors + '\'' +
                ", brief='" + brief + '\'' +
                ", releaseDate=" + releaseDate +
                ", starts=" + starts +
                ", level='" + level + '\'' +
                ", wall=" + wall +
                ", status=" + status +
                ", danceType='" + danceType + '\'' +
                ", attachments=" + attachments +
                '}';
    }
}

