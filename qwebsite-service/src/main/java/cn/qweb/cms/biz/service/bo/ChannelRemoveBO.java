package cn.qweb.cms.biz.service.bo;
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

public class ChannelRemoveBO implements Serializable{
    private static final long serialVersionUID = 1L;


    /**
     *@Fields model_id:模型id
     */
    private Long modelId;

    /**
     *@Fields parent_id:父栏目ID
     */
    private Long parentId;

    /**
     *@Fields name:名称
     */
    private String name;

    /**
     *@Fields title:标题
     */
    private String title;

    /**
     *@Fields priority:排列顺序
     */
    private Integer priority;

    /**
     *@Fields is_display:是否显示
     */
    private String isDisplay;

    /**
     *@Fields keywords:关键字
     */
    private String keywords;

    /**
     *@Fields description:描述符
     */
    private String description;

    /**
     *@Fields final_step:终审级别
     */
    private Integer finalStep;

    /**
     *@Fields after_check:审核后，
1:不能修改删除;2:修改后退回;3:修改后不变
     */
    private Integer afterCheck;

    /**
     *@Fields link:外部链接
     */
    private String link;

    /**
     *@Fields is_blank:是否新窗口打开 1是，0 否
     */
    private String isBlank;

    /**
     *@Fields comment_control:0：匿名 1 会员 2 关闭
     */
    private Integer commentControl;

    /**
     *@Fields allow_updown:1 开发 0 关闭
     */
    private Boolean allowUpdown;

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


    public void setModelId(Long modelId){
        this.modelId = modelId;
    }
    public Long getModelId(){
        return modelId;
    }
    public void setParentId(Long parentId){
        this.parentId = parentId;
    }
    public Long getParentId(){
        return parentId;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setPriority(Integer priority){
        this.priority = priority;
    }
    public Integer getPriority(){
        return priority;
    }
    public void setIsDisplay(String isDisplay){
        this.isDisplay = isDisplay;
    }
    public String getIsDisplay(){
        return isDisplay;
    }
    public void setKeywords(String keywords){
        this.keywords = keywords;
    }
    public String getKeywords(){
        return keywords;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
    public void setFinalStep(Integer finalStep){
        this.finalStep = finalStep;
    }
    public Integer getFinalStep(){
        return finalStep;
    }
    public void setAfterCheck(Integer afterCheck){
        this.afterCheck = afterCheck;
    }
    public Integer getAfterCheck(){
        return afterCheck;
    }
    public void setLink(String link){
        this.link = link;
    }
    public String getLink(){
        return link;
    }
    public void setIsBlank(String isBlank){
        this.isBlank = isBlank;
    }
    public String getIsBlank(){
        return isBlank;
    }
    public void setCommentControl(Integer commentControl){
        this.commentControl = commentControl;
    }
    public Integer getCommentControl(){
        return commentControl;
    }
    public void setAllowUpdown(Boolean allowUpdown){
        this.allowUpdown = allowUpdown;
    }
    public Boolean getAllowUpdown(){
        return allowUpdown;
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
    @Override
    public String toString(){
        return "Channel{" +
                    "modelId='" + modelId + "\'," +
                    "parentId='" + parentId + "\'," +
                    "name='" + name + "\'," +
                    "title='" + title + "\'," +
                    "priority='" + priority + "\'," +
                    "isDisplay='" + isDisplay + "\'," +
                    "keywords='" + keywords + "\'," +
                    "description='" + description + "\'," +
                    "finalStep='" + finalStep + "\'," +
                    "afterCheck='" + afterCheck + "\'," +
                    "link='" + link + "\'," +
                    "isBlank='" + isBlank + "\'," +
                    "commentControl='" + commentControl + "\'," +
                    "allowUpdown='" + allowUpdown + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
}