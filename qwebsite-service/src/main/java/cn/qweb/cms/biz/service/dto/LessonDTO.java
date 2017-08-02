package cn.qweb.cms.biz.service.dto;
import cn.qweb.cms.core.dictionary.DictManager;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


/*
 *  Created by xuebj - 2017/04/20.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class LessonDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields title:标题
     */
    private String title;
    /**
     *@Fields id:主键ID
     */
    private Long id;
    /**
     *@Fields lesson_id:课程ID
     */
    private Long lessonId;
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
     *@Fields lesson_type:课程类型
     */
    private String lessonType;
    private String lessonTypeName;
    /**
     *@Fields lesson_kind:课程种类
     */
    private String lessonKind;
    private String lessonKindName;
    /**
     *@Fields lesson_pic:课程封面
     */
    private String lessonPic;
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
     *@Fields gmt_create:创建时间
     */
    private Date gmtCreate;
    /**
     *@Fields gmt_modified:修改时间
     */
    private Date gmtModified;

    /**
     * @Fields 打回意见
     */
    private String suggestion;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setLessonId(Long lessonId){
        this.lessonId = lessonId;
    }
    public Long getLessonId(){
        return lessonId;
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
    public void setLessonType(String lessonType){
        this.lessonType = lessonType;
        this.lessonTypeName = DictManager.getItem("lessonType",lessonType);
    }
    public String getLessonType(){
        return lessonType;
    }
    public String getLessonTypeName() {
        return lessonTypeName;
    }
    public void setLessonTypeName(String lessonTypeName) {
        this.lessonTypeName = lessonTypeName;
    }
    public void setLessonKind(String lessonKind){
        this.lessonKind = lessonKind;
        this.lessonKindName = DictManager.getItem("lessonKind",lessonKind);
    }
    public String getLessonKind(){
        return lessonKind;
    }
    public String getLessonKindName() {
        return lessonKindName;
    }
    public void setLessonKindName(String lessonKindName) {
        this.lessonKindName = lessonKindName;
    }
    public void setLessonPic(String lessonPic){
        this.lessonPic = lessonPic;
    }
    public String getLessonPic(){
        return lessonPic;
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
        this.statusName = DictManager.getItem("lessonStatus",status);
    }
    public String getStatus(){
        return status;
    }
    public String getStatusName() {
        return statusName;
    }
    public void setStatusName(String statusName) {
        this.statusName = statusName;
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
    public String getAppointmentFlagName() {
        return appointmentFlagName;
    }
    public void setAppointmentFlagName(String appointmentFlagName) {
        this.appointmentFlagName = appointmentFlagName;
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
    public String getAppShowFlagName() {
        return appShowFlagName;
    }
    public void setAppShowFlagName(String appShowFlagName) {
        this.appShowFlagName = appShowFlagName;
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
    public String getSuggestion() {
        return suggestion;
    }
    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
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

    @Override
    public String toString() {
        return "LessonDTO{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", lessonId=" + lessonId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", biginDate=" + biginDate +
                ", biginDateFormat='" + biginDateFormat + '\'' +
                ", endDate=" + endDate +
                ", endDateFormat='" + endDateFormat + '\'' +
                ", beginTime=" + beginTime +
                ", beginTimeFormat='" + beginTimeFormat + '\'' +
                ", endTime=" + endTime +
                ", endTimeFormat='" + endTimeFormat + '\'' +
                ", lessonType='" + lessonType + '\'' +
                ", lessonTypeName='" + lessonTypeName + '\'' +
                ", lessonKind='" + lessonKind + '\'' +
                ", lessonKindName='" + lessonKindName + '\'' +
                ", lessonPic='" + lessonPic + '\'' +
                ", content='" + content + '\'' +
                ", personNo=" + personNo +
                ", site='" + site + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", statusName='" + statusName + '\'' +
                ", price=" + price +
                ", telNo='" + telNo + '\'' +
                ", appointmentFlag='" + appointmentFlag + '\'' +
                ", appointmentFlagName='" + appointmentFlagName + '\'' +
                ", appointmentDays=" + appointmentDays +
                ", appShowFlag='" + appShowFlag + '\'' +
                ", appShowFlagName='" + appShowFlagName + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", suggestion='" + suggestion + '\'' +
                '}';
    }
}