
package cn.qweb.cms.biz.service;
import cn.qweb.cms.biz.service.bo.ChorgraphyRemoveBO;
import cn.qweb.cms.biz.service.bo.ChorgraphySaveBO;
import cn.qweb.cms.biz.service.bo.ChorgraphyUpdateBO;
import cn.qweb.cms.biz.service.dto.ChorgraphyDTO;
import cn.qweb.cms.biz.service.query.ChorgraphyQUERY;
import cn.qweb.cms.core.base.Pagination;

/*
 *  Created by xuebj - 2017/05/11.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public interface ChorgraphyService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    ChorgraphyDTO get(Long id);


    /**
     * 获得一篇内容的上一篇或下一篇内容
     * @param id id
     * @param status 状态
     * @param next  根据文章ID，大者为下一篇，小者为上一篇。true：下一篇；fasle：上一篇。
     * @return
     */
    ChorgraphyDTO getNext(Long id, Integer status, Boolean next);

    /**
     * 发布舞谱
     * @param id
     * @return
     */
    Boolean doPublish(Long id);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<ChorgraphyDTO> list(ChorgraphyQUERY bean);

    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(ChorgraphySaveBO bean);

    /**
     * 统计阅读次数
     * @param id
     */
    void doViewUpdate(Long id);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(ChorgraphyUpdateBO bean);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(ChorgraphyRemoveBO bean);

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    Integer doRemove(Long id);

}