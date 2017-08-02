package cn.qweb.cms.biz.service.dto;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/*
 *  Created by xuebj - 2017/05/24.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class CompetitionSquareDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    private Long id;
    /**
     *@Fields title:标题
     */
    private String title;
    /**
     *@Fields content:详情
     */
    private String content;

    /**
     *@Fields division:赛区 多个赛区已逗号分隔
     */
    private String division;
    /**
     *@Fields status:发布状态
     */
    private String status;

    /**
     * @Fields 所在地区
     */
    private String province;

    /**
     * @Fields 开始日期
     */
    private Date gmtBegin;
    private String gmtBeginFormat;

    /**
     * @Fields 结束日期
     */
    private Date gmtEnd;
    private String gmtEndFormat;

    /**
     * 项目当前状态
     */
    private String dateStatus;

    /**
     *@Fields gmt_create:
     */
    private Date gmtCreate;
    private String gmtCreateFormat;
    /**
     *@Fields gmt_modified:
     */
    private Date gmtModified;
    /**
     *@Fields gmt_index:索引时间
     */
    private Date gmtIndex;

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return content;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return status;
    }
    public void setGmtCreate(Date gmtCreate){
        this.gmtCreate = gmtCreate;
        this.gmtCreateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(gmtCreate);
    }
    public Date getGmtCreate(){
        return gmtCreate;
    }
    public String getGmtCreateFormat() {
        return gmtCreateFormat;
    }
    public void setGmtCreateFormat(String gmtCreateFormat) {
        this.gmtCreateFormat = gmtCreateFormat;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Date getGmtBegin() {
        return gmtBegin;
    }

    public void setGmtBegin(Date gmtBegin) {
        this.gmtBegin = gmtBegin;
        this.gmtBeginFormat = new SimpleDateFormat("yyyy-MM-dd").format(gmtBegin);
    }

    public String getGmtBeginFormat() {
        return gmtBeginFormat;
    }

    public void setGmtBeginFormat(String gmtBeginFormat) {
        this.gmtBeginFormat = gmtBeginFormat;
    }

    public Date getGmtEnd() {
        return gmtEnd;
    }

    public void setGmtEnd(Date gmtEnd) {
        this.gmtEnd = gmtEnd;
        this.gmtEndFormat = new SimpleDateFormat("yyyy-MM-dd").format(gmtEnd);
    }

    public String getGmtEndFormat() {
        return gmtEndFormat;
    }

    public void setGmtEndFormat(String gmtEndFormat) {
        this.gmtEndFormat = gmtEndFormat;
    }

    public String getDateStatus() throws Exception{
        String now = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        DateFormat dateFormat  = new SimpleDateFormat("yyyy-MM-dd");
        Date nowTimeDate = dateFormat.parse(now);
        if (nowTimeDate.getTime() < getGmtBegin().getTime()){
            return "未开始";
        }else if(nowTimeDate.getTime() > getGmtEnd().getTime()){
            return "已结束";
        }else{
            return "进行中";
        }
    }

    public void setDateStatus(String dateStatus) {
        this.dateStatus = dateStatus;
    }

    @Override
    public String toString() {
        return "CompetitionSquareDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", division='" + division + '\'' +
                ", status='" + status + '\'' +
                ", province='" + province + '\'' +
                ", gmtBegin=" + gmtBegin +
                ", gmtBeginFormat='" + gmtBeginFormat + '\'' +
                ", gmtEnd=" + gmtEnd +
                ", gmtEndFormat='" + gmtEndFormat + '\'' +
                ", dateStatus='" + dateStatus + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", gmtIndex=" + gmtIndex +
                '}';
    }
}