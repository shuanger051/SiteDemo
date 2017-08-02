package cn.qweb.cms.core.base;

/**
 * Created by xuebj on 2017/2/20.
 */
public class BaseQueryEntity extends TraceBean{

    /**
     * 排序列及字段 如 user asc,name desc
     */
    private String sort;

    /**
     * 页大小
     */
    private Integer pageSize = 10;
    /**
     * 第几页
     */
    private Integer page = 1;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
