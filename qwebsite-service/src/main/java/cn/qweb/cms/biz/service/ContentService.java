
package cn.qweb.cms.biz.service;
import cn.qweb.cms.biz.service.bo.ContentSaveBO;
import cn.qweb.cms.biz.service.bo.ContentUpdateBO;
import cn.qweb.cms.biz.service.dto.ContentDTO;
import cn.qweb.cms.biz.service.query.ContentQUERY;
import cn.qweb.cms.core.base.Pagination;

/*
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public interface ContentService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    ContentDTO get(Long id);

    /**
     * 获得一篇内容的上一篇或下一篇内容
     * @param id 内容id
     * @param channelId 栏目id
     * @param next  根据文章ID，大者为下一篇，小者为上一篇。true：下一篇；fasle：上一篇。
     * @return
     */
    ContentDTO getNext(Long id, Long channelId, Boolean next);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<ContentDTO> list(ContentQUERY bean);

    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(ContentSaveBO bean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(ContentUpdateBO bean);

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    Integer doRemove(Long id);

    /**
     * 内容浏览次数统计
     * @param id
     */
    void doViewUpdate(Long id);

}