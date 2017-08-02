package cn.qweb.cms.front.biz.manager.dto;

import cn.qweb.cms.core.dictionary.DictManager;

/**
 * Created by xuebj on 2017/5/15.
 */
public class WithdrawalDTO {

    /**
     * 时间
     */
    private Long record_time;

    /**
     * 教练机构名称
     */
    private String choreographer_name;

    /**
     * 手机号
     */
    private String phone_number;

    /**
     * contact_name
     */
    private String contact_name;

    /**
     * 金额
     */
    private Double money;

    /**
     * 银行
     */
    private String bank_name;

    /**
     * 银行账号
     */
    private String account_code;

    /**
     * 状态
     */
    private String status;

    private String statusName;
    /**
     * 提现单据ID
     */
    private String transfer_id;

    /**
     * 提现单据的最后更新时间
     */
    private Long update_time;

    /**
     * 订单号数量
     */
    private Long transfer_bill_num;

    /**
     * 银行流水号
     */
    private String bank_statements_no;


    public Long getRecord_time() {
        return record_time;
    }

    public void setRecord_time(Long record_time) {
        this.record_time = record_time;
    }

    public String getChoreographer_name() {
        return choreographer_name;
    }

    public void setChoreographer_name(String choreographer_name) {
        this.choreographer_name = choreographer_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getAccount_code() {
        return account_code;
    }

    public void setAccount_code(String account_code) {
        this.account_code = account_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        this.setStatusName(DictManager.getItem("withdrawalStatus",status));
    }

    public String getTransfer_id() {
        return transfer_id;
    }

    public void setTransfer_id(String transfer_id) {
        this.transfer_id = transfer_id;
    }

    public Long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }

    public Long getTransfer_bill_num() {
        return transfer_bill_num;
    }

    public void setTransfer_bill_num(Long transfer_bill_num) {
        this.transfer_bill_num = transfer_bill_num;
    }

    public String getBank_statements_no() {
        return bank_statements_no;
    }

    public void setBank_statements_no(String bank_statements_no) {
        this.bank_statements_no = bank_statements_no;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "WithdrawalDTO{" +
                "record_time=" + record_time +
                ", choreographer_name='" + choreographer_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", contact_name='" + contact_name + '\'' +
                ", money=" + money +
                ", bank_name='" + bank_name + '\'' +
                ", account_code='" + account_code + '\'' +
                ", status='" + status + '\'' +
                ", statusName='" + statusName + '\'' +
                ", transfer_id='" + transfer_id + '\'' +
                ", update_time=" + update_time +
                ", transfer_bill_num=" + transfer_bill_num +
                ", bank_statements_no='" + bank_statements_no + '\'' +
                '}';
    }
}

