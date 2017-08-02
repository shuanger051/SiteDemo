
package cn.qweb.cms.biz.service;

import cn.qweb.cms.biz.service.bo.SysDictItemRemoveBO;
import cn.qweb.cms.biz.service.bo.SysDictItemSaveBO;
import cn.qweb.cms.biz.service.bo.SysDictItemUpdateBO;
import cn.qweb.cms.biz.service.dto.SysDictItemDTO;
import cn.qweb.cms.biz.service.query.SysDictItemQUERY;
import cn.qweb.cms.core.base.Pagination;

import java.util.List;
import java.util.Map;

/*
 *  Created by xuebj - 2017/03/14.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public interface SysDictItemService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    SysDictItemDTO get(Long id);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<SysDictItemDTO> list(SysDictItemQUERY bean);

    /**
     * 根据字典查询字典条目
     * @param entryCodesList
     * @return
     */
    Map<String,List<SysDictItemDTO>> list(List<String> entryCodesList);


    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(SysDictItemSaveBO bean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(SysDictItemUpdateBO bean);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(SysDictItemRemoveBO bean);

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    Integer doRemove(Long id);

}