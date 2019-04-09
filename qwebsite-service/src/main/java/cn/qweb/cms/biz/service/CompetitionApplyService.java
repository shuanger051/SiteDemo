
package cn.qweb.cms.biz.service;
import cn.qweb.cms.biz.service.bo.*;
import cn.qweb.cms.biz.service.dto.CompetitionApplyDTO;
import cn.qweb.cms.biz.service.query.CompetitionApplyQUERY;
import cn.qweb.cms.core.base.Pagination;

/*
 *  Created by xuebj - 2017/05/24.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public interface CompetitionApplyService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    CompetitionApplyDTO get(Long id);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<CompetitionApplyDTO> list(CompetitionApplyQUERY bean);

    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(CompetitionApplySaveBO bean);

    /**
     * 保存单个对象-70周年报名团队
     * @param bean  保存对象
     * @return 主键
     */
    Long doSaveForSeventyYearTeam(CompetitionApplyForSeventyYearTeamSaveBO bean);

    /**
     * 保存单个对象-70周年报名个人
     * @param bean
     * @return
     */
    Long doSaveForSeventyYearPerson(CompetitionApplyForSeventyYearPersonSaveBO bean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(CompetitionApplyUpdateBO bean);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(CompetitionApplyRemoveBO bean);

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
    Integer checkExport(CompetitionApplyQUERY competitionSquareApplyQUERY);

}