
package cn.qweb.cms.biz.service;
import java.util.List;
import cn.qweb.cms.biz.service.bo.IndexLineSaveBO;
import cn.qweb.cms.biz.service.query.IndexLineQUERY;
import cn.qweb.cms.biz.service.bo.IndexLineRemoveBO;
import cn.qweb.cms.biz.service.dto.IndexLineDTO;
import cn.qweb.cms.biz.service.bo.IndexLineUpdateBO;
import cn.qweb.cms.core.base.Pagination;

/*
 *  Created by xuebj - 2017/04/05.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public interface IndexLineService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    IndexLineDTO get(Long id);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<IndexLineDTO> list(IndexLineQUERY bean);

    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(IndexLineSaveBO bean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(IndexLineUpdateBO bean);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(IndexLineRemoveBO bean);

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    Integer doRemove(Long id);

}