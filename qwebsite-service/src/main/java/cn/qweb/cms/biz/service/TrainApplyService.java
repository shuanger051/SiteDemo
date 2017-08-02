package cn.qweb.cms.biz.service;

import java.util.List;
import cn.qweb.cms.biz.service.bo.TrainApplySaveBO;
import cn.qweb.cms.biz.service.query.TrainApplyQUERY;
import cn.qweb.cms.biz.service.bo.TrainApplyRemoveBO;
import cn.qweb.cms.biz.service.dto.TrainApplyDTO;
import cn.qweb.cms.biz.service.bo.TrainApplyUpdateBO;
import cn.qweb.cms.core.base.Pagination;

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public interface TrainApplyService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    TrainApplyDTO get(Long id);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<TrainApplyDTO> list(TrainApplyQUERY bean);

    List<TrainApplyDTO> queryList(TrainApplyQUERY bean);

    List<TrainApplyDTO> queryUnIndexList(TrainApplyQUERY bean);

    List<TrainApplyDTO> queryIndexList(TrainApplyQUERY bean);

    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(TrainApplySaveBO bean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(TrainApplyUpdateBO bean);

    /**
     * 更新索引时间 ID 必须有
     * @param bean
     * @return
     */
    Integer updateIndexTime(TrainApplyUpdateBO bean);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(TrainApplyRemoveBO bean);

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
     * 查询需要导出的数据总条数
     * @return 数据总条数
     */
    Integer checkExport(TrainApplyQUERY trainApplyQUERY);

}