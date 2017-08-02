package cn.qweb.cms.biz.service.dto;
import cn.qweb.cms.core.dictionary.DictManager;
import org.wuwz.poi.annotation.ExportConfig;

import java.io.Serializable;
import java.util.Date;


/*
 *  Created by xuebj - 2017/04/06.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class TeacherDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    private Long id;
    /**
     *@Fields real_name:姓名
     */
    @ExportConfig(value = "姓名", width = 150)
    private String realName;
    /**
     *@Fields head_img:头像
     */
    private String headImg;
    /**
     *@Fields content_img:内容照片
     */
    private String contentImg;
    /**
     *@Fields brief:简介
     */
    @ExportConfig(value = "简介",width = 200)
    private String brief;
    /**
     *@Fields txt:个人详细介绍
     */
    private String txt;
    /**
     *@Fields link:连接
     */
    private String link;
    /**
     *@Fields priority:排列顺序
     */
    private Integer priority;
    /**
     *@Fields is_enabled:是否显示
     */
    private String isEnabled;

    /**
     * is_enabled的转义
     */
    @ExportConfig(value = "是否显示", width = 150)
    private String isEnabledName;
    /**
     *@Fields release_date:发布时间
     */
    private Date releaseDate;
    /**
     *@Fields author:发布者
     */
    private String author;
    /**
     *@Fields views:浏览次数
     */
    private Integer views;
    /**
     *@Fields gmt_create:
     */
    private Date gmtCreate;
    /**
     *@Fields gmt_modified:
     */
    private Date gmtModified;

    /**
     *@Fields type:类型 1 排舞 2 广场舞
     */
    private String type;

    @ExportConfig(value = "舞蹈类别", width = 150)
    private String typeName;

    /**
     *@Fields level:0 表示未填
     */
    private Integer level;

    @ExportConfig(value = "职称", width = 200)
    private String levelName;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setRealName(String realName){
        this.realName = realName;
    }
    public String getRealName(){
        return realName;
    }
    public void setHeadImg(String headImg){
        this.headImg = headImg;
    }
    public String getHeadImg(){
        return headImg;
    }
    public void setContentImg(String contentImg){
        this.contentImg = contentImg;
    }
    public String getContentImg(){
        return contentImg;
    }
    public void setBrief(String brief){
        this.brief = brief;
    }
    public String getBrief(){
        return brief;
    }
    public void setTxt(String txt){
        this.txt = txt;
    }
    public String getTxt(){
        return txt;
    }
    public void setLink(String link){
        this.link = link;
    }
    public String getLink(){
        return link;
    }
    public void setPriority(Integer priority){
        this.priority = priority;
    }
    public Integer getPriority(){
        return priority;
    }
    public void setIsEnabled(String isEnabled){
        this.isEnabled = isEnabled;
        this.setIsEnabledName(DictManager.getItem("isShow",isEnabled));
    }
    public String getIsEnabled(){
        return isEnabled;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        this.setTypeName(DictManager.getItem("teacherType",type));
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return author;
    }
    public void setViews(Integer views){
        this.views = views;
    }
    public Integer getViews(){
        return views;
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

    public String getIsEnabledName() {
        return isEnabledName;
    }

    public void setIsEnabledName(String isEnabledName) {
        this.isEnabledName = isEnabledName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
        this.setLevelName(DictManager.getItem("teacherLevel",String.valueOf(level)));
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    @Override
    public String toString() {
        return "TeacherDTO{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", headImg='" + headImg + '\'' +
                ", contentImg='" + contentImg + '\'' +
                ", brief='" + brief + '\'' +
                ", txt='" + txt + '\'' +
                ", link='" + link + '\'' +
                ", priority=" + priority +
                ", isEnabled='" + isEnabled + '\'' +
                ", isEnabledName='" + isEnabledName + '\'' +
                ", releaseDate=" + releaseDate +
                ", author='" + author + '\'' +
                ", views=" + views +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", type='" + type + '\'' +
                ", typeName='" + typeName + '\'' +
                ", level=" + level +
                ", levelName='" + levelName + '\'' +
                '}';
    }
}