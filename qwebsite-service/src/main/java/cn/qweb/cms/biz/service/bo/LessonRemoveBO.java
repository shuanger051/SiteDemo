package cn.qweb.cms.biz.service.bo;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;


/*
 *  Created by xuebj - 2017/04/20.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class LessonRemoveBO implements Serializable{
    private static final long serialVersionUID = 1L;


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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date biginDate;

    /**
     *@Fields end_date:结束日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    /**
     *@Fields begin_time:开始时间
     */
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date beginTime;

    /**
     *@Fields end_time:结束时间
     */
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date endTime;

    /**
     *@Fields lesson_type:课程类型
     */
    private String lessonType;

    /**
     *@Fields lesson_kind:课程种类
     */
    private String lessonKind;

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

    /**
     *@Fields appointment_days:提前预约天数
     */
    private Integer appointmentDays;

    /**
     *@Fields app_show_flag:是否在APP端显示
     */
    private String appShowFlag;

    /**
     *@Fields gmt_create:创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    /**
     *@Fields gmt_modified:修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;

    private String suggestion;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    }
    public Date getBiginDate(){
        return biginDate;
    }
    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }
    public Date getEndDate(){
        return endDate;
    }
    public void setBeginTime(Date beginTime){
        this.beginTime = beginTime;
    }
    public Date getBeginTime(){
        return beginTime;
    }
    public void setEndTime(Date endTime){
        this.endTime = endTime;
    }
    public Date getEndTime(){
        return endTime;
    }
    public void setLessonType(String lessonType){
        this.lessonType = lessonType;
    }
    public String getLessonType(){
        return lessonType;
    }
    public void setLessonKind(String lessonKind){
        this.lessonKind = lessonKind;
    }
    public String getLessonKind(){
        return lessonKind;
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
    }
    public String getAppShowFlag(){
        return appShowFlag;
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

    @Override
    public String toString(){
        return "Lesson{" +
                    "id='" + id + "\'," +
                    "lessonId='" + lessonId + "\'," +
                    "teacherName='" + teacherName + "\'," +
                    "teacherId='" + teacherId + "\'," +
                    "biginDate='" + biginDate + "\'," +
                    "endDate='" + endDate + "\'," +
                    "beginTime='" + beginTime + "\'," +
                    "endTime='" + endTime + "\'," +
                    "lessonType='" + lessonType + "\'," +
                    "lessonKind='" + lessonKind + "\'," +
                    "lessonPic='" + lessonPic + "\'," +
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
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
}