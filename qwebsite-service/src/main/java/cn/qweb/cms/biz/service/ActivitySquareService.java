
package cn.qweb.cms.biz.service;
import cn.qweb.cms.biz.service.bo.ActivitySquareRemoveBO;
import cn.qweb.cms.biz.service.bo.ActivitySquareSaveBO;
import cn.qweb.cms.biz.service.bo.ActivitySquareUpdateBO;
import cn.qweb.cms.biz.service.dto.ActivitySquareDTO;
import cn.qweb.cms.biz.service.query.ActivitySquareQUERY;
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

public interface ActivitySquareService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    ActivitySquareDTO get(Long id);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<ActivitySquareDTO> list(ActivitySquareQUERY bean);

    /**
     * lucene 查询创建索引
     * @param bean
     * @return
     */
    List<ActivitySquareDTO> queryLuceneList(ActivitySquareQUERY bean);
    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(ActivitySquareSaveBO bean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(ActivitySquareUpdateBO bean);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(ActivitySquareRemoveBO bean);

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

    List<ActivitySquareDTO> queryIndexList(ActivitySquareQUERY bean);

    /**
     * 分页查询未索引数据
     * @param bean
     * @return
     */
    List<ActivitySquareDTO> queryUnIndexList(ActivitySquareQUERY bean);

    /**
     * 更新索引时间 ID 必须有
     * @param bean
     * @return
     */
    Integer updateIndexTime(ActivitySquareUpdateBO bean);

}