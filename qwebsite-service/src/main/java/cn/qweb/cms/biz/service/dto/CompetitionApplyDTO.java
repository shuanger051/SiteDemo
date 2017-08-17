package cn.qweb.cms.biz.service.dto;
import cn.qweb.cms.core.dictionary.DictManager;
import org.apache.commons.lang3.StringUtils;
import org.wuwz.poi.annotation.ExportConfig;

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

public class CompetitionApplyDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    @ExportConfig(value = "编号", width = 150)
    private Long id;
    /**
     *@Fields channel_id:栏目号
     */
    private Long channelId;
    /**
     *@Fields content_id:赛事ID
     */
    private Long contentId;

    @ExportConfig(value = "参赛项目", width = 200)
    private String title;
    /**
     *@Fields division:赛区
     */
    @ExportConfig(value = "赛区")
    private String division;

    /**
     *@Fields real_name:真实姓名
     */
    @ExportConfig(value = "姓名", width = 150)
    private String realName;
    /**
     *@Fields team_name:战队名称
     */
    @ExportConfig(value = "参赛队名", width = 150)
    private String teamName;
    /**
     *@Fields project_kind:项目种类
     */
    private String projectKind;
    @ExportConfig(value = "项目种类", width = 150)
    private String projectKindName;
    /**
     *@Fields mobile:联系方式
     */
    @ExportConfig(value = "联系方式", width = 150)
    private String mobile;
    /**
     *@Fields email:邮箱
     */
    @ExportConfig(value = "邮箱", width = 150)
    private String email;
    /**
     *@Fields address:详细地址
     */
    @ExportConfig(value = "联系地址")
    private String address;
    /**
     *@Fields read_flag:是否查阅
     */
    private String readFlag;
    private String readFlagName;

    /**
     * @Fields team_type 队名
     */
    private String teamType;
    private String teamTypeName;

    /**
     * @Fields captain_name 队长名称
     */
    private String captainName;

    /**
     *@Fields gmt_create:
     */
    private Date gmtCreate;
    /**
     *@Fields gmt_modified:
     */
    private Date gmtModified;
    /**
     *@Fields gmt_index:索引时间
     */
    private Date gmtIndex;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
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
        StringBuilder prodName = new StringBuilder();
        if(StringUtils.isNotBlank(projectKind)){
            String[] prods = StringUtils.split(projectKind, ",");
            for (String id : prods) {
                prodName.append(DictManager.getItem("projectKind",id)).append(",");
            }
        }
        this.setProjectKindName(prodName.deleteCharAt(prodName.length()-1).toString());
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
        this.setReadFlagName(DictManager.getItem("isRead",readFlag));
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

    public String getProjectKindName() {
        return projectKindName;
    }

    public void setProjectKindName(String projectKindName) {
        this.projectKindName = projectKindName;
    }

    public String getReadFlagName() {
        return readFlagName;
    }

    public void setReadFlagName(String readFlagName) {
        this.readFlagName = readFlagName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeamType() {
        return teamType;
    }

    public void setTeamType(String teamType) {
        this.teamType = teamType;
        this.teamTypeName = DictManager.getItem("teamType",teamType);
    }

    public String getTeamTypeName() {
        return teamTypeName;
    }

    public void setTeamTypeName(String teamTypeName) {
        this.teamTypeName = teamTypeName;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    @Override
    public String toString() {
        return "CompetitionApplyDTO{" +
                "id=" + id +
                ", channelId=" + channelId +
                ", contentId=" + contentId +
                ", title='" + title + '\'' +
                ", division='" + division + '\'' +
                ", realName='" + realName + '\'' +
                ", teamName='" + teamName + '\'' +
                ", projectKind='" + projectKind + '\'' +
                ", projectKindName='" + projectKindName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", readFlag='" + readFlag + '\'' +
                ", readFlagName='" + readFlagName + '\'' +
                ", teamType='" + teamType + '\'' +
                ", teamTypeName='" + teamTypeName + '\'' +
                ", captainName='" + captainName + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", gmtIndex=" + gmtIndex +
                '}';
    }
}