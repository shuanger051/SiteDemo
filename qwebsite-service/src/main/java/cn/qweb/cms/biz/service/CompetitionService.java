
package cn.qweb.cms.biz.service;
import java.util.List;
import cn.qweb.cms.biz.service.bo.CompetitionSaveBO;
import cn.qweb.cms.biz.service.query.CompetitionQUERY;
import cn.qweb.cms.biz.service.bo.CompetitionRemoveBO;
import cn.qweb.cms.biz.service.dto.CompetitionDTO;
import cn.qweb.cms.biz.service.bo.CompetitionUpdateBO;
import cn.qweb.cms.core.base.Pagination;

/*
 *  Created by xuebj - 2017/05/24.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public interface CompetitionService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    CompetitionDTO get(Long id);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<CompetitionDTO> list(CompetitionQUERY bean);

    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(CompetitionSaveBO bean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(CompetitionUpdateBO bean);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(CompetitionRemoveBO bean);

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    Integer doRemove(Long id);

}