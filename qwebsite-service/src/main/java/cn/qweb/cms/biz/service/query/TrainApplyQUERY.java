package cn.qweb.cms.biz.service.query;
import java.io.Serializable;
import cn.qweb.cms.core.base.BaseQueryEntity;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;


/*
 *  Created by xuebj - 2017/03/29.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class TrainApplyQUERY extends BaseQueryEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    private String title;

    /**
     *@Fields channel_id:栏目号
     */
    private Long channelId;

    /**
     *@Fields content_id:活动ID
     */
    private Long contentId;

    /**
     *@Fields real_name:真是姓名
     */
    private String realName;

    /**
     *@Fields sex:性别
     */
    private String sex;

    /**
     *@Fields id_no:身份证号
     */
    private String idNo;

    /**
     *@Fields id_kind:证件类型，默认身份证
     */
    private String idKind;

    /**
     *@Fields read_flag:是否查阅
     */
    private String readFlag;

    /**
     *@Fields trainer_type:教练员类型
     */
    private String trainerType;

    /**
     *@Fields mobile:联系方式
     */
    private String mobile;

    /**
     *@Fields email:邮箱
     */
    private String email;

    /**
     *@Fields qq:qq号
     */
    private String qq;

    /**
     *@Fields height:身高，单位厘米
     */
    private String height;

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
    public void setRealName(String realName){
        this.realName = realName;
    }
    public String getRealName(){
        return realName;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public String getSex(){
        return sex;
    }
    public void setIdNo(String idNo){
        this.idNo = idNo;
    }
    public String getIdNo(){
        return idNo;
    }
    public void setIdKind(String idKind){
        this.idKind = idKind;
    }
    public String getIdKind(){
        return idKind;
    }
    public void setReadFlag(String readFlag){
        this.readFlag = readFlag;
    }
    public String getReadFlag(){
        return readFlag;
    }
    public void setTrainerType(String trainerType){
        this.trainerType = trainerType;
    }
    public String getTrainerType(){
        return trainerType;
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
    public void setQq(String qq){
        this.qq = qq;
    }
    public String getQq(){
        return qq;
    }
    public void setHeight(String height){
        this.height = height;
    }
    public String getHeight(){
        return height;
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
    public String toString() {
        return "TrainApplyQUERY{" +
                "title='" + title + '\'' +
                ", channelId=" + channelId +
                ", contentId=" + contentId +
                ", realName='" + realName + '\'' +
                ", sex='" + sex + '\'' +
                ", idNo='" + idNo + '\'' +
                ", idKind='" + idKind + '\'' +
                ", readFlag='" + readFlag + '\'' +
                ", trainerType='" + trainerType + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", height='" + height + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }

}