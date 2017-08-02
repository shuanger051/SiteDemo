
package cn.qweb.cms.biz.service;
import cn.qweb.cms.biz.service.bo.CompetitionSquareRemoveBO;
import cn.qweb.cms.biz.service.bo.CompetitionSquareSaveBO;
import cn.qweb.cms.biz.service.bo.CompetitionSquareUpdateBO;
import cn.qweb.cms.biz.service.dto.CompetitionSquareDTO;
import cn.qweb.cms.biz.service.query.CompetitionSquareQUERY;
import cn.qweb.cms.core.base.Pagination;

/*
 *  Created by xuebj - 2017/05/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public interface CompetitionSquareService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    CompetitionSquareDTO get(Long id);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<CompetitionSquareDTO> list(CompetitionSquareQUERY bean);

    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(CompetitionSquareSaveBO bean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(CompetitionSquareUpdateBO bean);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(CompetitionSquareRemoveBO bean);

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    Integer doRemove(Long id);

}