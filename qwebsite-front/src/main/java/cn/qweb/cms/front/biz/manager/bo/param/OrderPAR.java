package cn.qweb.cms.front.biz.manager.bo.param;

/**
 * Created by xuebj on 2017/5/15.
 */
public class OrderPAR extends PagePAR{

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderPAR{" +
                "status='" + status + '\'' +
                '}';
    }
}
