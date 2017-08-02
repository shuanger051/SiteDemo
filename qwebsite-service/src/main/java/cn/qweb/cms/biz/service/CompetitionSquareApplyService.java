
package cn.qweb.cms.biz.service;
import cn.qweb.cms.biz.service.bo.CompetitionSquareApplyRemoveBO;
import cn.qweb.cms.biz.service.bo.CompetitionSquareApplySaveBO;
import cn.qweb.cms.biz.service.bo.CompetitionSquareApplyUpdateBO;
import cn.qweb.cms.biz.service.dto.CompetitionSquareApplyDTO;
import cn.qweb.cms.biz.service.query.CompetitionSquareApplyQUERY;
import cn.qweb.cms.core.base.Pagination;

/*
 *  Created by xuebj - 2017/05/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public interface CompetitionSquareApplyService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    CompetitionSquareApplyDTO get(Long id);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<CompetitionSquareApplyDTO> list(CompetitionSquareApplyQUERY bean);

    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(CompetitionSquareApplySaveBO bean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(CompetitionSquareApplyUpdateBO bean);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(CompetitionSquareApplyRemoveBO bean);

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    Integer doRemove(Long id);

    /**
     * 查询需要导出的数据总条数
     * @return 数据总条数
     */
    Integer checkExport(CompetitionSquareApplyQUERY competitionSquareApplyQUERY);

}