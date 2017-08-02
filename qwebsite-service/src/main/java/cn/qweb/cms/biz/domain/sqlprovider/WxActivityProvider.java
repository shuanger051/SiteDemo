package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.WxActivityDO;
import cn.qweb.cms.biz.service.query.WxActivityQUERY;
import cn.qweb.cms.core.base.BaseDynaSqlProvider;
import org.apache.ibatis.jdbc.SQL;

/*
 *  Created by xuebj - 2017/05/03.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class WxActivityProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_wx_activity";

    public static final String[] Fields={"id","activity_id","title","teacher_name","teacher_id","bigin_date","end_date","begin_time","end_time","activity_type","activity_kind","activity_pic","content","person_no","site","address","status","price","tel_no","appointment_flag","appointment_days","app_show_flag","suggestion","gmt_create","gmt_modified"};

    /**
     * 获取单个结果集
     */
    public String get(final Long id){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            WHERE("id="+id);
        }}.toString();
    }

    public String listByQuery(final WxActivityQUERY bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getTeacherName()!=null){
                    WHERE("teacher_name=#{teacherName}");
                }
                if(bean.getBeginDate()!=null){
                    WHERE("bigin_date >= #{beginDate}");
                }
                if(bean.getEndDate()!=null){
                    WHERE("end_date <= #{endDate}");
                }
                if(bean.getStatus()!=null){
                    WHERE("status=#{status}");
                }
                if(bean.getMinPrice()!=null){
                    WHERE("price>=#{minPrice}");
                }
                if(bean.getMaxPrice()!=null){
                    WHERE("price<=#{maxPrice}");
                }
                if (bean.getTeacherId() !=null){
                    WHERE("teacher_id=#{teacherId}");
                }
                if(bean.getTitle()!=null){
                    WHERE("title like CONCAT('%',#{title},'%')");
                }
                if(bean.getSort() != null){
                    ORDER_BY(bean.getSort());
                }else{
                    ORDER_BY("gmt_create DESC");
                }
            }

        }}.toString();
    }
    /**
     * 查询多个结果集
     */
    public String list(final WxActivityDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("id=#{id}");
                }
                if(bean.getActivityId()!=null){
                    WHERE("activity_id=#{activityId}");
                }
                if(bean.getTitle()!=null){
                    WHERE("title=#{title}");
                }
                if(bean.getTeacherName()!=null){
                    WHERE("teacher_name=#{teacherName}");
                }
                if(bean.getTeacherId()!=null){
                    WHERE("teacher_id=#{teacherId}");
                }
                if(bean.getBiginDate()!=null){
                    WHERE("bigin_date=#{biginDate}");
                }
                if(bean.getEndDate()!=null){
                    WHERE("end_date=#{endDate}");
                }
                if(bean.getBeginTime()!=null){
                    WHERE("begin_time=#{beginTime}");
                }
                if(bean.getEndTime()!=null){
                    WHERE("end_time=#{endTime}");
                }
                if(bean.getActivityType()!=null){
                    WHERE("activity_type=#{activityType}");
                }
                if(bean.getActivityKind()!=null){
                    WHERE("activity_kind=#{activityKind}");
                }
                if(bean.getActivityPic()!=null){
                    WHERE("activity_pic=#{activityPic}");
                }
                if(bean.getContent()!=null){
                    WHERE("content=#{content}");
                }
                if(bean.getPersonNo()!=null){
                    WHERE("person_no=#{personNo}");
                }
                if(bean.getSite()!=null){
                    WHERE("site=#{site}");
                }
                if(bean.getAddress()!=null){
                    WHERE("address=#{address}");
                }
                if(bean.getStatus()!=null){
                    WHERE("status=#{status}");
                }
                if(bean.getPrice()!=null){
                    WHERE("price=#{price}");
                }
                if(bean.getTelNo()!=null){
                    WHERE("tel_no=#{telNo}");
                }
                if(bean.getAppointmentFlag()!=null){
                    WHERE("appointment_flag=#{appointmentFlag}");
                }
                if(bean.getAppointmentDays()!=null){
                    WHERE("appointment_days=#{appointmentDays}");
                }
                if(bean.getAppShowFlag()!=null){
                    WHERE("app_show_flag=#{appShowFlag}");
                }
                if(bean.getSuggestion()!=null){
                    WHERE("suggestion=#{suggestion}");
                }
                if(bean.getGmtCreate()!=null){
                    WHERE("gmt_create=#{gmtCreate}");
                }
                if(bean.getGmtModified()!=null){
                    WHERE("gmt_modified=#{gmtModified}");
                }
                if(bean.getSort() != null){
                    ORDER_BY(bean.getSort());
                }else{
                    ORDER_BY("gmt_create DESC");
                }
            }

        }}.toString();
    }

    /**
     *  保存单个对象
     */
    public String save(final WxActivityDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getActivityId() != null) {
                VALUES("activity_id", "#{activityId}");
            }
            if (bean.getTitle() != null) {
                VALUES("title", "#{title}");
            }
            if (bean.getTeacherName() != null) {
                VALUES("teacher_name", "#{teacherName}");
            }
            if (bean.getTeacherId() != null) {
                VALUES("teacher_id", "#{teacherId}");
            }
            if (bean.getBiginDate() != null) {
                VALUES("bigin_date", "#{biginDate}");
            }
            if (bean.getEndDate() != null) {
                VALUES("end_date", "#{endDate}");
            }
            if (bean.getBeginTime() != null) {
                VALUES("begin_time", "#{beginTime}");
            }
            if (bean.getEndTime() != null) {
                VALUES("end_time", "#{endTime}");
            }
            if (bean.getActivityType() != null) {
                VALUES("activity_type", "#{activityType}");
            }
            if (bean.getActivityKind() != null) {
                VALUES("activity_kind", "#{activityKind}");
            }
            if (bean.getActivityPic() != null) {
                VALUES("activity_pic", "#{activityPic}");
            }
            if (bean.getContent() != null) {
                VALUES("content", "#{content}");
            }
            if (bean.getPersonNo() != null) {
                VALUES("person_no", "#{personNo}");
            }
            if (bean.getSite() != null) {
                VALUES("site", "#{site}");
            }
            if (bean.getAddress() != null) {
                VALUES("address", "#{address}");
            }
            if (bean.getStatus() != null) {
                VALUES("status", "#{status}");
            }
            if (bean.getPrice() != null) {
                VALUES("price", "#{price}");
            }
            if (bean.getTelNo() != null) {
                VALUES("tel_no", "#{telNo}");
            }
            if (bean.getAppointmentFlag() != null) {
                VALUES("appointment_flag", "#{appointmentFlag}");
            }
            if (bean.getAppointmentDays() != null) {
                VALUES("appointment_days", "#{appointmentDays}");
            }
            if (bean.getAppShowFlag() != null) {
                VALUES("app_show_flag", "#{appShowFlag}");
            }
            if (bean.getSuggestion() != null) {
                VALUES("suggestion", "#{suggestion}");
            }
            if (bean.getGmtCreate() != null) {
                VALUES("gmt_create", "#{gmtCreate}");
            }
            if (bean.getGmtModified() != null) {
                VALUES("gmt_modified", "#{gmtModified}");
            }
        }}.toString();
    }

    /**
     * 更新对象
     */
    public String update(final WxActivityDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getActivityId() != null) {
                SET("activity_id=#{activityId}");
            }
            if (bean.getTitle() != null) {
                SET("title=#{title}");
            }
            if (bean.getTeacherName() != null) {
                SET("teacher_name=#{teacherName}");
            }
            if (bean.getTeacherId() != null) {
                SET("teacher_id=#{teacherId}");
            }
            if (bean.getBiginDate() != null) {
                SET("bigin_date=#{biginDate}");
            }
            if (bean.getEndDate() != null) {
                SET("end_date=#{endDate}");
            }
            if (bean.getBeginTime() != null) {
                SET("begin_time=#{beginTime}");
            }
            if (bean.getEndTime() != null) {
                SET("end_time=#{endTime}");
            }
            if (bean.getActivityType() != null) {
                SET("activity_type=#{activityType}");
            }
            if (bean.getActivityKind() != null) {
                SET("activity_kind=#{activityKind}");
            }
            if (bean.getActivityPic() != null) {
                SET("activity_pic=#{activityPic}");
            }
            if (bean.getContent() != null) {
                SET("content=#{content}");
            }
            if (bean.getPersonNo() != null) {
                SET("person_no=#{personNo}");
            }
            if (bean.getSite() != null) {
                SET("site=#{site}");
            }
            if (bean.getAddress() != null) {
                SET("address=#{address}");
            }
            if (bean.getStatus() != null) {
                SET("status=#{status}");
            }
            if (bean.getPrice() != null) {
                SET("price=#{price}");
            }
            if (bean.getTelNo() != null) {
                SET("tel_no=#{telNo}");
            }
            if (bean.getAppointmentFlag() != null) {
                SET("appointment_flag=#{appointmentFlag}");
            }
            if (bean.getAppointmentDays() != null) {
                SET("appointment_days=#{appointmentDays}");
            }
            if (bean.getAppShowFlag() != null) {
                SET("app_show_flag=#{appShowFlag}");
            }
            if (bean.getSuggestion() != null) {
                SET("suggestion=#{suggestion}");
            }
            if (bean.getGmtCreate() != null) {
                SET("gmt_create=#{gmtCreate}");
            }
            if (bean.getGmtModified() != null) {
                SET("gmt_modified=#{gmtModified}");
            }
            WHERE("id = #{id}");
        }}.toString();
    }


    /**
     * 按条件移除对象
     */
    public String remove(final WxActivityDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getActivityId()!=null){
                WHERE("activity_id=#{activityId}");
            }
            if(bean.getTitle()!=null){
                WHERE("title=#{title}");
            }
            if(bean.getTeacherName()!=null){
                WHERE("teacher_name=#{teacherName}");
            }
            if(bean.getTeacherId()!=null){
                WHERE("teacher_id=#{teacherId}");
            }
            if(bean.getBiginDate()!=null){
                WHERE("bigin_date=#{biginDate}");
            }
            if(bean.getEndDate()!=null){
                WHERE("end_date=#{endDate}");
            }
            if(bean.getBeginTime()!=null){
                WHERE("begin_time=#{beginTime}");
            }
            if(bean.getEndTime()!=null){
                WHERE("end_time=#{endTime}");
            }
            if(bean.getActivityType()!=null){
                WHERE("activity_type=#{activityType}");
            }
            if(bean.getActivityKind()!=null){
                WHERE("activity_kind=#{activityKind}");
            }
            if(bean.getActivityPic()!=null){
                WHERE("activity_pic=#{activityPic}");
            }
            if(bean.getContent()!=null){
                WHERE("content=#{content}");
            }
            if(bean.getPersonNo()!=null){
                WHERE("person_no=#{personNo}");
            }
            if(bean.getSite()!=null){
                WHERE("site=#{site}");
            }
            if(bean.getAddress()!=null){
                WHERE("address=#{address}");
            }
            if(bean.getStatus()!=null){
                WHERE("status=#{status}");
            }
            if(bean.getPrice()!=null){
                WHERE("price=#{price}");
            }
            if(bean.getTelNo()!=null){
                WHERE("tel_no=#{telNo}");
            }
            if(bean.getAppointmentFlag()!=null){
                WHERE("appointment_flag=#{appointmentFlag}");
            }
            if(bean.getAppointmentDays()!=null){
                WHERE("appointment_days=#{appointmentDays}");
            }
            if(bean.getAppShowFlag()!=null){
                WHERE("app_show_flag=#{appShowFlag}");
            }
            if(bean.getSuggestion()!=null){
                WHERE("suggestion=#{suggestion}");
            }
            if(bean.getGmtCreate()!=null){
                WHERE("gmt_create=#{gmtCreate}");
            }
            if(bean.getGmtModified()!=null){
                WHERE("gmt_modified=#{gmtModified}");
            }
            }}.toString();
    }

    /**
     * 删除单个对象
     */
    public String delete(final Long id){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            WHERE("id=" + id);
        }}.toString();
    }


}