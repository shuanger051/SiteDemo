
package cn.qweb.cms.biz.service;
import cn.qweb.cms.biz.service.bo.ChannelAttrRemoveBO;
import cn.qweb.cms.biz.service.bo.ChannelAttrSaveBO;
import cn.qweb.cms.biz.service.bo.ChannelAttrUpdateBO;
import cn.qweb.cms.biz.service.dto.ChannelAttrDTO;
import cn.qweb.cms.biz.service.query.ChannelAttrQUERY;
import cn.qweb.cms.core.base.Pagination;

/*
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public interface ChannelAttrService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    ChannelAttrDTO get(Long id);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<ChannelAttrDTO> list(ChannelAttrQUERY bean);

    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(ChannelAttrSaveBO bean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(ChannelAttrUpdateBO bean);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(ChannelAttrRemoveBO bean);

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    Integer doRemove(Long id);

}