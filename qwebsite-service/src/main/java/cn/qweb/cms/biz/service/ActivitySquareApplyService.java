
package cn.qweb.cms.biz.service;
import cn.qweb.cms.biz.service.bo.ActivitySquareApplyRemoveBO;
import cn.qweb.cms.biz.service.bo.ActivitySquareApplySaveBO;
import cn.qweb.cms.biz.service.bo.ActivitySquareApplyUpdateBO;
import cn.qweb.cms.biz.service.dto.ActivitySquareApplyDTO;
import cn.qweb.cms.biz.service.query.ActivitySquareApplyQUERY;
import cn.qweb.cms.core.base.Pagination;

import java.util.List;

/*
 *  Created by xuebj - 2017/05/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public interface ActivitySquareApplyService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    ActivitySquareApplyDTO get(Long id);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<ActivitySquareApplyDTO> list(ActivitySquareApplyQUERY bean);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    List<ActivitySquareApplyDTO> queryList(ActivitySquareApplyQUERY bean);

    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(ActivitySquareApplySaveBO bean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(ActivitySquareApplyUpdateBO bean);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(ActivitySquareApplyRemoveBO bean);

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
    Integer checkExport(ActivitySquareApplyQUERY activitySquareApplyQUERY);

}