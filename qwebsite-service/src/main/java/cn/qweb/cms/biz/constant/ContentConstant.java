package cn.qweb.cms.biz.constant;

/**
 * Created by xuebj on 2017/4/1.
 */
public interface ContentConstant {
    /**
     * 草稿
     */
    Integer DRAFT = 0;
    /**
     * 审核中
     */
    Integer CHECKING = 1;
    /**
     * 退回
     */
    Integer REJECT = -1;
    /**
     * 已审核
     */
    Integer CHECKED = 2;
    /**
     * 回收站
     */
    Integer RECYCLE = 3;
    /**
     * 投稿
     */
    Integer CONTRIBUTE = 4;
    /**
     * 归档
     */
    Integer PIGEONHOLE = 5;


    /**
     * 不能修改，不能删除。
     */
    Integer CANNOT_UPDATE = 1;
    /**
     * 可以修改，可以删除。修改之后退回到草稿状态
     */
    Integer BACK_UPDATE = 2;
    /**
     * 可以修改，可以删除。 修改后文章保持原状态。//不实现
     */
    Integer KEEP_UPDATE = 3;

    /**
     * Excel最大支持导出条数
     */
    Integer MAX_EXPORT_COUNT = 5000;
}
