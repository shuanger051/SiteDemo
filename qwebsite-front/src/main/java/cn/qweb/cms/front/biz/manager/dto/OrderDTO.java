package cn.qweb.cms.front.biz.manager.dto;

import cn.qweb.cms.core.dictionary.DictManager;

/**
 * Created by xuebj on 2017/5/15.
 */
public class OrderDTO {

    private	String	bill_no	;//	订单号
    private	String	student_no	;//	学员号
    private	String	course_name	;//	课程名称
    private	String	course_id	;//	课程ID
    private	String	course_type_name	;//	类别（名）
    private	String	start_time	;//	上课时间。上课时间段，格式：日期 开始时间-结束时间
    private	String	choreographer_name	;//	教练名称
    private	Long	number	;//	报名数量
    private	String	coupon_descriptions	;//	所用优惠券(多个用";"连接)
    private	Double	total_money	;//	课程总价
    private	Double	pay_money	;//	实付金额
    private	Double	price	;//	价格
    private	String	nick_name	;//	用户名
    private	String	phone_number	;//	手机号
    private	Long	record_time	;//	订单时间
    private	String	status	;//	订单状态。(0:未定义 1:待上课 2:已授课 3:已完成 4:授课中 5:已退课)
    private String statusName;
    private	String	bill_id	;//	订单ID
    private	String	user_id	;//	用户ID
    private	String	square_dance	;//	0:不是排舞   1:排舞
    private	String	line_dance	;//	0:不是广场舞 1:广场舞
    private	String	choreographer_id	;//	教练/机构ID
    private	String	choreographer_type	;//	0、教练  1、机构
    private	String	pay_source 	;	//支付来源，0：微信H5页面 ，1：广场舞App ，2 ：排舞App，3：公务卡支付

    public String getBill_no() {
        return bill_no;
    }

    public void setBill_no(String bill_no) {
        this.bill_no = bill_no;
    }

    public String getStudent_no() {
        return student_no;
    }

    public void setStudent_no(String student_no) {
        this.student_no = student_no;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_type_name() {
        return course_type_name;
    }

    public void setCourse_type_name(String course_type_name) {
        this.course_type_name = course_type_name;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getChoreographer_name() {
        return choreographer_name;
    }

    public void setChoreographer_name(String choreographer_name) {
        this.choreographer_name = choreographer_name;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getCoupon_descriptions() {
        return coupon_descriptions;
    }

    public void setCoupon_descriptions(String coupon_descriptions) {
        this.coupon_descriptions = coupon_descriptions;
    }

    public Double getTotal_money() {
        return total_money;
    }

    public void setTotal_money(Double total_money) {
        this.total_money = total_money;
    }

    public Double getPay_money() {
        return pay_money;
    }

    public void setPay_money(Double pay_money) {
        this.pay_money = pay_money;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Long getRecord_time() {
        return record_time;
    }

    public void setRecord_time(Long record_time) {
        this.record_time = record_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        this.setStatusName(DictManager.getItem("orderStatus",status));
    }

    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getSquare_dance() {
        return square_dance;
    }

    public void setSquare_dance(String square_dance) {
        this.square_dance = square_dance;
    }

    public String getLine_dance() {
        return line_dance;
    }

    public void setLine_dance(String line_dance) {
        this.line_dance = line_dance;
    }

    public String getChoreographer_id() {
        return choreographer_id;
    }

    public void setChoreographer_id(String choreographer_id) {
        this.choreographer_id = choreographer_id;
    }

    public String getChoreographer_type() {
        return choreographer_type;
    }

    public void setChoreographer_type(String choreographer_type) {
        this.choreographer_type = choreographer_type;
    }

    public String getPay_source() {
        return pay_source;
    }

    public void setPay_source(String pay_source) {
        this.pay_source = pay_source;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "bill_no='" + bill_no + '\'' +
                ", student_no='" + student_no + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_id='" + course_id + '\'' +
                ", course_type_name='" + course_type_name + '\'' +
                ", start_time='" + start_time + '\'' +
                ", choreographer_name='" + choreographer_name + '\'' +
                ", number=" + number +
                ", coupon_descriptions='" + coupon_descriptions + '\'' +
                ", total_money=" + total_money +
                ", pay_money=" + pay_money +
                ", price=" + price +
                ", nick_name='" + nick_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", record_time=" + record_time +
                ", status='" + status + '\'' +
                ", bill_id='" + bill_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", square_dance='" + square_dance + '\'' +
                ", line_dance='" + line_dance + '\'' +
                ", choreographer_id='" + choreographer_id + '\'' +
                ", choreographer_type='" + choreographer_type + '\'' +
                ", pay_source='" + pay_source + '\'' +
                '}';
    }
}
