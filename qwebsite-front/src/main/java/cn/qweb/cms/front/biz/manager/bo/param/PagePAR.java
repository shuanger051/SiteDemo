package cn.qweb.cms.front.biz.manager.bo.param;

/**
 * Created by xuebj on 2017/5/15.
 */
public class PagePAR {

    private Integer page_num;

    private Integer page_count;

    public Integer getPage_num() {
        return page_num;
    }

    public void setPage_num(Integer page_num) {
        this.page_num = page_num;
    }

    public Integer getPage_count() {
        return page_count;
    }

    public void setPage_count(Integer page_count) {
        this.page_count = page_count;
    }

    @Override
    public String toString() {
        return "PagePAR{" +
                "page_num=" + page_num +
                ", page_count=" + page_count +
                '}';
    }
}
