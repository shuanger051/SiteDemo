
package cn.qweb.cms.biz.service;

import cn.qweb.cms.biz.service.bo.TrainSquareApplyRemoveBO;
import cn.qweb.cms.biz.service.bo.TrainSquareApplySaveBO;
import cn.qweb.cms.biz.service.bo.TrainSquareApplyUpdateBO;
import cn.qweb.cms.biz.service.dto.TrainSquareApplyDTO;
import cn.qweb.cms.biz.service.query.TrainSquareApplyQUERY;
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

public interface TrainSquareApplyService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    TrainSquareApplyDTO get(Long id);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<TrainSquareApplyDTO> list(TrainSquareApplyQUERY bean);
    List<TrainSquareApplyDTO> queryList(TrainSquareApplyQUERY bean);

    List<TrainSquareApplyDTO> queryUnIndexList(TrainSquareApplyQUERY bean);

    List<TrainSquareApplyDTO> queryIndexList(TrainSquareApplyQUERY bean);

    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(TrainSquareApplySaveBO bean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(TrainSquareApplyUpdateBO bean);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(TrainSquareApplyRemoveBO bean);

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    Integer doRemove(Long id);

    /**
     * 查询未添加到索引的总数据条数
     * @return 未索引的数据总条数
     */
    Integer queryUnIndexTotalNum();

    /**
     * 查询已添加到索引的总数据条数
     * @return
     */
    Integer queryIndexTotalNum();

    /**
     * 更新索引时间 ID 必须有
     * @param bean
     * @return
     */
    Integer updateIndexTime(TrainSquareApplyUpdateBO bean);

    /**
     * 查询需要导出的数据总条数
     * @return 数据总条数
     */
    Integer checkExport(TrainSquareApplyQUERY trainSquareApplyQUERY);

}