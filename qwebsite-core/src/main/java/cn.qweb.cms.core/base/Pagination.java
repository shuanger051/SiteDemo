package cn.qweb.cms.core.base;

import java.util.List;

/**
 * Created by xuebj on 2017/1/17.
 */
public class Pagination<T> {

    /**
     * 数据总条数
     */
    private Long total;
    /**
     * 具体的数据
     */
    private List<T> data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "total=" + total +
                ", data=" + data +
                '}';
    }
}
