package cn.qweb.cms.biz.service.query;
import cn.qweb.cms.core.base.BaseQueryEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/*
 *  Created by xuebj - 2017/05/24.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class CompetitionApplyQUERY extends BaseQueryEntity implements Serializable{
    private static final long serialVersionUID = 1L;


    /**
     *@Fields channel_id:栏目号
     */
    private Long channelId;

    /**
     *@Fields content_id:赛事ID
     */
    private Long contentId;

    /**
     *@Fields division:赛区
     */
    private String division;

    private String title;

    /**
     *@Fields real_name:真实姓名
     */
    private String realName;

    /**
     *@Fields team_name:战队名称
     */
    private String teamName;

    /**
     *@Fields project_kind:项目种类
     */
    private String projectKind;

    /**
     *@Fields mobile:联系方式
     */
    private String mobile;

    /**
     *@Fields email:邮箱
     */
    private String email;

    /**
     *@Fields address:详细地址
     */
    private String address;

    /**
     *@Fields read_flag:是否查阅
     */
    private String readFlag;

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

    /**
     *@Fields gmt_index:索引时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtIndex;

    /**
     *@Fields group_code:团队编码
     */
    private Integer groupCode;

    /**
     *@Fields captain_name:队长姓名
     */
    private String captainName;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setChannelId(Long channelId){
        this.channelId = channelId;
    }
    public Long getChannelId(){
        return channelId;
    }
    public void setContentId(Long contentId){
        this.contentId = contentId;
    }
    public Long getContentId(){
        return contentId;
    }
    public void setDivision(String division){
        this.division = division;
    }
    public String getDivision(){
        return division;
    }
    public void setRealName(String realName){
        this.realName = realName;
    }
    public String getRealName(){
        return realName;
    }
    public void setTeamName(String teamName){
        this.teamName = teamName;
    }
    public String getTeamName(){
        return teamName;
    }
    public void setProjectKind(String projectKind){
        this.projectKind = projectKind;
    }
    public String getProjectKind(){
        return projectKind;
    }
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    public String getMobile(){
        return mobile;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }
    public void setReadFlag(String readFlag){
        this.readFlag = readFlag;
    }
    public String getReadFlag(){
        return readFlag;
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
    public void setGmtIndex(Date gmtIndex){
        this.gmtIndex = gmtIndex;
    }
    public Date getGmtIndex(){
        return gmtIndex;
    }

    public Integer getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(Integer groupCode) {
        this.groupCode = groupCode;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    @Override
    public String toString() {
        return "CompetitionApplyQUERY{" +
                "channelId=" + channelId +
                ", contentId=" + contentId +
                ", division='" + division + '\'' +
                ", title='" + title + '\'' +
                ", realName='" + realName + '\'' +
                ", teamName='" + teamName + '\'' +
                ", projectKind='" + projectKind + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", readFlag='" + readFlag + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", gmtIndex=" + gmtIndex +
                ", groupCode=" + groupCode +
                ", captainName='" + captainName + '\'' +
                '}';
    }

}