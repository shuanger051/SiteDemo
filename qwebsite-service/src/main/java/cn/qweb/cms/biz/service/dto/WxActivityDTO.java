package cn.qweb.cms.biz.service.dto;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.qweb.cms.core.dictionary.DictManager;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;


/*
 *  Created by xuebj - 2017/05/03.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class WxActivityDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields id:主键ID
     */
    private Long id;
    /**
     *@Fields activity_id:课程ID
     */
    private Long activityId;
    /**
     * @Fields title 标题
     */
    private String title;
    /**
     *@Fields teacher_name:教师名称
     */
    private String teacherName;
    /**
     *@Fields teacher_id:教师唯一标识
     */
    private String teacherId;
    /**
     *@Fields bigin_date:开始日期
     */
    private Date biginDate;
    private String biginDateFormat;
    /**
     *@Fields end_date:结束日期
     */
    private Date endDate;
    private String endDateFormat;
    /**
     *@Fields begin_time:开始时间
     */
    private Date beginTime;
    private String beginTimeFormat;
    /**
     *@Fields end_time:结束时间
     */
    private Date endTime;
    private String endTimeFormat;
    /**
     *@Fields activity_type:课程类型
     */
    private String activityType;
    private String activityTypeName;
    /**
     *@Fields activity_kind:课程种类
     */
    private String activityKind;
    private String activityKindName;
    /**
     *@Fields activity_pic:课程封面
     */
    private String activityPic;
    /**
     *@Fields content:课程简介
     */
    private String content;
    /**
     *@Fields person_no:团课人数
     */
    private Long personNo;
    /**
     *@Fields site:省市县地点
     */
    private String site;
    /**
     *@Fields address:详细地址
     */
    private String address;
    /**
     *@Fields status:课程状态
     */
    private String status;
    private String statusName;
    /**
     *@Fields price:价格
     */
    private BigDecimal price;
    /**
     *@Fields tel_no:联系电话
     */
    private String telNo;
    /**
     *@Fields appointment_flag:是否预约
     */
    private String appointmentFlag;
    private String appointmentFlagName;
    /**
     *@Fields appointment_days:提前预约天数
     */
    private Integer appointmentDays;
    /**
     *@Fields app_show_flag:是否在APP端显示
     */
    private String appShowFlag;
    private String appShowFlagName;
    /**
     *@Fields suggestion:打回意见
     */
    private String suggestion;
    /**
     *@Fields gmt_create:创建时间
     */
    private Date gmtCreate;
    /**
     *@Fields gmt_modified:修改时间
     */
    private Date gmtModified;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setActivityId(Long activityId){
        this.activityId = activityId;
    }
    public Long getActivityId(){
        return activityId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setTeacherName(String teacherName){
        this.teacherName = teacherName;
    }
    public String getTeacherName(){
        return teacherName;
    }
    public void setTeacherId(String teacherId){
        this.teacherId = teacherId;
    }
    public String getTeacherId(){
        return teacherId;
    }
    public void setBiginDate(Date biginDate){
        this.biginDate = biginDate;
        this.biginDateFormat = new SimpleDateFormat("yyyy-MM-dd").format(biginDate);
    }
    public Date getBiginDate(){
        return biginDate;
    }
    public void setEndDate(Date endDate){
        this.endDate = endDate;
        this.endDateFormat = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
    }
    public Date getEndDate(){
        return endDate;
    }
    public void setBeginTime(Date beginTime){
        this.beginTime = beginTime;
        this.beginTimeFormat = new SimpleDateFormat("HH:mm:ss").format(beginTime);
    }
    public Date getBeginTime(){
        return beginTime;
    }
    public void setEndTime(Date endTime){
        this.endTime = endTime;
        this.endTimeFormat = new SimpleDateFormat("HH:mm:ss").format(endTime);
    }
    public Date getEndTime(){
        return endTime;
    }
    public void setActivityType(String activityType){
        this.activityType = activityType;
        //如果项目种类是1,则项目类型取字典activityType,种类是2，则取项目字典cardType
        if(null != this.activityKind && "1".equals(this.activityKind.trim())){
            this.activityTypeName = DictManager.getItem("activityType",activityType);
        }else{
            this.activityTypeName = DictManager.getItem("cardType",activityType);
        }
    }
    public String getActivityType(){
        return activityType;
    }
    public void setActivityKind(String activityKind){
        this.activityKind = activityKind;
        this.activityKindName = DictManager.getItem("activityKind",activityKind);
    }
    public String getActivityKind(){
        return activityKind;
    }
    public void setActivityPic(String activityPic){
        this.activityPic = activityPic;
    }
    public String getActivityPic(){
        return activityPic;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return content;
    }
    public void setPersonNo(Long personNo){
        this.personNo = personNo;
    }
    public Long getPersonNo(){
        return personNo;
    }
    public void setSite(String site){
        this.site = site;
    }
    public String getSite(){
        return site;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }
    public void setStatus(String status){
        this.status = status;
        this.statusName = DictManager.getItem("activityStatus",status);
    }
    public String getStatus(){
        return status;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }
    public BigDecimal getPrice(){
        return price;
    }
    public void setTelNo(String telNo){
        this.telNo = telNo;
    }
    public String getTelNo(){
        return telNo;
    }
    public void setAppointmentFlag(String appointmentFlag){
        this.appointmentFlag = appointmentFlag;
        this.appointmentFlagName = DictManager.getItem("isDisplay",appointmentFlag);
    }
    public String getAppointmentFlag(){
        return appointmentFlag;
    }
    public void setAppointmentDays(Integer appointmentDays){
        this.appointmentDays = appointmentDays;
    }
    public Integer getAppointmentDays(){
        return appointmentDays;
    }
    public void setAppShowFlag(String appShowFlag){
        this.appShowFlag = appShowFlag;
        this.appShowFlagName = DictManager.getItem("isDisplay",appShowFlag);
    }
    public String getAppShowFlag(){
        return appShowFlag;
    }
    public void setSuggestion(String suggestion){
        this.suggestion = suggestion;
    }
    public String getSuggestion(){
        return suggestion;
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
    public String getBiginDateFormat() {
        return biginDateFormat;
    }
    public void setBiginDateFormat(String biginDateFormat) {
        this.biginDateFormat = biginDateFormat;
    }
    public String getEndDateFormat() {
        return endDateFormat;
    }
    public void setEndDateFormat(String endDateFormat) {
        this.endDateFormat = endDateFormat;
    }
    public String getBeginTimeFormat() {
        return beginTimeFormat;
    }
    public void setBeginTimeFormat(String beginTimeFormat) {
        this.beginTimeFormat = beginTimeFormat;
    }
    public String getEndTimeFormat() {
        return endTimeFormat;
    }
    public void setEndTimeFormat(String endTimeFormat) {
        this.endTimeFormat = endTimeFormat;
    }
    public String getActivityTypeName() {
        return activityTypeName;
    }
    public void setActivityTypeName(String activityTypeName) {
        this.activityTypeName = activityTypeName;
    }
    public String getActivityKindName() {
        return activityKindName;
    }
    public void setActivityKindName(String activityKindName) {
        this.activityKindName = activityKindName;
    }
    public String getStatusName() {
        return statusName;
    }
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
    public String getAppointmentFlagName() {
        return appointmentFlagName;
    }
    public void setAppointmentFlagName(String appointmentFlagName) {
        this.appointmentFlagName = appointmentFlagName;
    }
    public String getAppShowFlagName() {
        return appShowFlagName;
    }
    public void setAppShowFlagName(String appShowFlagName) {
        this.appShowFlagName = appShowFlagName;
    }

    @Override
    public String toString(){
        return "WxActivity{" +
                    "id='" + id + "\'," +
                    "activityId='" + activityId + "\'," +
                    "title='" + title + "\'," +
                    "teacherId='" + teacherId + "\'," +
                    "biginDate='" + biginDate + "\'," +
                    "endDate='" + endDate + "\'," +
                    "beginTime='" + beginTime + "\'," +
                    "endTime='" + endTime + "\'," +
                    "activityType='" + activityType + "\'," +
                    "activityKind='" + activityKind + "\'," +
                    "activityPic='" + activityPic + "\'," +
                    "content='" + content + "\'," +
                    "personNo='" + personNo + "\'," +
                    "site='" + site + "\'," +
                    "address='" + address + "\'," +
                    "status='" + status + "\'," +
                    "price='" + price + "\'," +
                    "telNo='" + telNo + "\'," +
                    "appointmentFlag='" + appointmentFlag + "\'," +
                    "appointmentDays='" + appointmentDays + "\'," +
                    "appShowFlag='" + appShowFlag + "\'," +
                    "suggestion='" + suggestion + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
        }