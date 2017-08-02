package cn.qweb.cms.biz.service.dto;
import cn.qweb.cms.core.dictionary.DictManager;

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

public class ChannelDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    private Long id;
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
     * is_display 转义
     */
    private String isDisplayName;
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
     * commentControl 转义
     */
    private String commentControlName;
    /**
     *@Fields allow_updown:1 开发 0 关闭
     */
    private Boolean allowUpdown;
    /**
     *@Fields channel_path:访问路径
     */
    private String channelPath;

    /**
     *@Fields tpl_content:内容模板
     */
    private String tplContent;

    /**
     *@Fields tpl_channel:栏目模板
     */
    private String tplChannel;
    /**
     *@Fields tpl_model:后台编辑模型
     */
    private String tplModel;

    /**
     * allowUpdown 转义
     */
    private String allowUpdownName;
    /**
     *@Fields gmt_create:
     */
    private Date gmtCreate;
    /**
     *@Fields gmt_modified:
     */
    private Date gmtModified;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
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
        this.setIsDisplayName(DictManager.getItem("isDisplay",isDisplay));
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
        this.setCommentControlName(DictManager.getItem("commentControl",String.valueOf(commentControl)));
    }
    public Integer getCommentControl(){
        return commentControl;
    }
    public void setAllowUpdown(Boolean allowUpdown){
        this.allowUpdown = allowUpdown;
        this.setAllowUpdownName(DictManager.getItem("allowUpdown",allowUpdown?"1":"0"));
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

    public String getIsDisplayName() {
        return isDisplayName;
    }

    public void setIsDisplayName(String isDisplayName) {
        this.isDisplayName = isDisplayName;
    }

    public String getCommentControlName() {
        return commentControlName;
    }

    public void setCommentControlName(String commentControlName) {
        this.commentControlName = commentControlName;
    }

    public String getAllowUpdownName() {
        return allowUpdownName;
    }

    public void setAllowUpdownName(String allowUpdownName) {
        this.allowUpdownName = allowUpdownName;
    }

    public String getChannelPath() {
        return channelPath;
    }

    public void setChannelPath(String channelPath) {
        this.channelPath = channelPath;
    }

    public String getTplContent() {
        return tplContent;
    }

    public void setTplContent(String tplContent) {
        this.tplContent = tplContent;
    }

    public String getTplChannel() {
        return tplChannel;
    }

    public void setTplChannel(String tplChannel) {
        this.tplChannel = tplChannel;
    }

    public String getTplModel() {
        return tplModel;
    }

    public void setTplModel(String tplModel) {
        this.tplModel = tplModel;
    }

    @Override
    public String toString() {
        return "ChannelDTO{" +
                "id=" + id +
                ", modelId=" + modelId +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", priority=" + priority +
                ", isDisplay='" + isDisplay + '\'' +
                ", isDisplayName='" + isDisplayName + '\'' +
                ", keywords='" + keywords + '\'' +
                ", description='" + description + '\'' +
                ", finalStep=" + finalStep +
                ", afterCheck=" + afterCheck +
                ", link='" + link + '\'' +
                ", isBlank='" + isBlank + '\'' +
                ", commentControl=" + commentControl +
                ", commentControlName='" + commentControlName + '\'' +
                ", allowUpdown=" + allowUpdown +
                ", channelPath='" + channelPath + '\'' +
                ", tplContent='" + tplContent + '\'' +
                ", tplChannel='" + tplChannel + '\'' +
                ", tplModel='" + tplModel + '\'' +
                ", allowUpdownName='" + allowUpdownName + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}