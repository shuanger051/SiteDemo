package cn.qweb.cms.biz.service.dto;

/**
 * Created by xuebj on 2017/5/15.
 */
public class LessonNumberDTO {

    /**
     * 全部
     */
    private Long total;

    /**
     * 待审核
     */
    private Long pendingCheck;

    /**
     * 未通过
     */
    private Long notPass;

    /**
     * 已通过
     */
    private Long pass;

    /**
     * 已上线
     */
    private Long online;

    /**
     * 已下线
     */
    private Long underline;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getPendingCheck() {
        return pendingCheck;
    }

    public void setPendingCheck(Long pendingCheck) {
        this.pendingCheck = pendingCheck;
    }

    public Long getNotPass() {
        return notPass;
    }

    public void setNotPass(Long notPass) {
        this.notPass = notPass;
    }

    public Long getPass() {
        return pass;
    }

    public void setPass(Long pass) {
        this.pass = pass;
    }

    public Long getOnline() {
        return online;
    }

    public void setOnline(Long online) {
        this.online = online;
    }

    public Long getUnderline() {
        return underline;
    }

    public void setUnderline(Long underline) {
        this.underline = underline;
    }

    @Override
    public String toString() {
        return "LessonNumberDTO{" +
                "total=" + total +
                ", pendingCheck=" + pendingCheck +
                ", notPass=" + notPass +
                ", pass=" + pass +
                ", online=" + online +
                ", underline=" + underline +
                '}';
    }
}
