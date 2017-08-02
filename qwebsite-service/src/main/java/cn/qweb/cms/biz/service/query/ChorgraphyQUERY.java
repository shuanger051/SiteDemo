package cn.qweb.cms.biz.service.query;
import cn.qweb.cms.core.base.BaseQueryEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/*
 *  Created by xuebj - 2017/05/11.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class ChorgraphyQUERY extends BaseQueryEntity implements Serializable{
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
     *@Fields votes:投票次数
     */
    private Long votes;

    /**
     *@Fields starts:评分星数
     */
    private Integer starts;

    /**
     *@Fields views:访问次数
     */
    private Long views;

    /**
     *@Fields release_date:发布时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date releaseDate;

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
     *@Fields up_date:
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date upDate;

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


    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setUserId(String userId){
        this.userId = userId;
    }
    public String getUserId(){
        return userId;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return content;
    }
    public void setAuthors(String authors){
        this.authors = authors;
    }
    public String getAuthors(){
        return authors;
    }
    public void setBrief(String brief){
        this.brief = brief;
    }
    public String getBrief(){
        return brief;
    }
    public void setUperMobile(String uperMobile){
        this.uperMobile = uperMobile;
    }
    public String getUperMobile(){
        return uperMobile;
    }
    public void setUperName(String uperName){
        this.uperName = uperName;
    }
    public String getUperName(){
        return uperName;
    }
    public void setUperEmail(String uperEmail){
        this.uperEmail = uperEmail;
    }
    public String getUperEmail(){
        return uperEmail;
    }
    public void setVotes(Long votes){
        this.votes = votes;
    }
    public Long getVotes(){
        return votes;
    }
    public void setStarts(Integer starts){
        this.starts = starts;
    }
    public Integer getStarts(){
        return starts;
    }
    public void setViews(Long views){
        this.views = views;
    }
    public Long getViews(){
        return views;
    }
    public void setReleaseDate(Date releaseDate){
        this.releaseDate = releaseDate;
    }
    public Date getReleaseDate(){
        return releaseDate;
    }
    public void setLevel(String level){
        this.level = level;
    }
    public String getLevel(){
        return level;
    }
    public void setWall(Integer wall){
        this.wall = wall;
    }
    public Integer getWall(){
        return wall;
    }
    public void setCount(Integer count){
        this.count = count;
    }
    public Integer getCount(){
        return count;
    }
    public void setStatus(Integer status){
        this.status = status;
    }
    public Integer getStatus(){
        return status;
    }
    public void setDanceType(String danceType){
        this.danceType = danceType;
    }
    public String getDanceType(){
        return danceType;
    }
    public void setUpDate(Date upDate){
        this.upDate = upDate;
    }
    public Date getUpDate(){
        return upDate;
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
        return "Chorgraphy{" +
                    "name='" + name + "\'," +
                    "userId='" + userId + "\'," +
                    "content='" + content + "\'," +
                    "authors='" + authors + "\'," +
                    "brief='" + brief + "\'," +
                    "uperMobile='" + uperMobile + "\'," +
                    "uperName='" + uperName + "\'," +
                    "uperEmail='" + uperEmail + "\'," +
                    "votes='" + votes + "\'," +
                    "starts='" + starts + "\'," +
                    "views='" + views + "\'," +
                    "releaseDate='" + releaseDate + "\'," +
                    "level='" + level + "\'," +
                    "wall='" + wall + "\'," +
                    "count='" + count + "\'," +
                    "status='" + status + "\'," +
                    "danceType='" + danceType + "\'," +
                    "upDate='" + upDate + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
}