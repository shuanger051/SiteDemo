package cn.qweb.cms.front.biz.manager.bo.param;

/**
 * Created by xuebj on 2017/5/15.
 */
public class WithDrawalPAR extends PagePAR{

    private Long start_time;

    private Long end_time;

    public Long getStart_time() {
        return start_time;
    }

    public void setStart_time(Long start_time) {
        this.start_time = start_time;
    }

    public Long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Long end_time) {
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "WithDrawalPAR{" +
                "start_time=" + start_time +
                ", end_time=" + end_time +
                '}';
    }
}
