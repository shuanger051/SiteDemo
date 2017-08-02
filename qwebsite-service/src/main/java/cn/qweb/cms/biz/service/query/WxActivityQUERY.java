package cn.qweb.cms.biz.service.query;
import cn.qweb.cms.core.base.BaseQueryEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/*
 *  Created by xuebj - 2017/05/03.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class WxActivityQUERY extends BaseQueryEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields title:标题
     */
    private String title;

    /**
     *@Fields teacher_name:教师名称
     */
    private String teacherName;

    /**
     *@Fields bigin_date:开始日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;

    /**
     *@Fields end_date:结束日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private String teacherId;

    /**
     *@Fields status:课程状态
     */
    @Pattern(regexp = "1|2|3|4|5",message = "状态允许的值错误")
    private String status;

    /**
     * 最小价格
     */
    @Digits(integer = 6,fraction = 2,message = "价格格式错误")
    private BigDecimal minPrice;

    /**
     * 最大价格
     */
    @Digits(integer = 6,fraction = 2,message = "价格格式错误")
    private BigDecimal maxPrice;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public String toString() {
        return "WxActivityQUERY{" +
                "title='" + title + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", teacherId='" + teacherId + '\'' +
                ", status='" + status + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                '}';
    }
}