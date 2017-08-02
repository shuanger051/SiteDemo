package cn.qweb.cms.biz.service.query;
import cn.qweb.cms.core.base.BaseQueryEntity;
import org.springframework.format.annotation.DateTimeFormat;

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

public class TeacherQUERY extends BaseQueryEntity implements Serializable{
    private static final long serialVersionUID = 1L;


    /**
     *@Fields real_name:姓名
     */
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
     *@Fields release_date:发布时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
     *@Fields type:类型 1 排舞 2 广场舞
     */
    private String type;

    /**
     *@Fields level:0 表示未填
     */
    private Integer level;


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
    }
    public String getIsEnabled(){
        return isEnabled;
    }
    public void setReleaseDate(Date releaseDate){
        this.releaseDate = releaseDate;
    }
    public Date getReleaseDate(){
        return releaseDate;
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
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "TeacherQUERY{" +
                "realName='" + realName + '\'' +
                ", headImg='" + headImg + '\'' +
                ", contentImg='" + contentImg + '\'' +
                ", brief='" + brief + '\'' +
                ", txt='" + txt + '\'' +
                ", link='" + link + '\'' +
                ", priority=" + priority +
                ", isEnabled='" + isEnabled + '\'' +
                ", releaseDate=" + releaseDate +
                ", author='" + author + '\'' +
                ", views=" + views +
                ", type='" + type + '\'' +
                ", level=" + level +
                '}';
    }
}