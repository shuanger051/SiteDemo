
package cn.qweb.cms.biz.service;
import cn.qweb.cms.biz.service.bo.SysRoleRemoveBO;
import cn.qweb.cms.biz.service.bo.SysRoleSaveBO;
import cn.qweb.cms.biz.service.bo.SysRoleUpdateBO;
import cn.qweb.cms.biz.service.dto.SysRoleDTO;
import cn.qweb.cms.biz.service.query.SysRoleQUERY;
import cn.qweb.cms.core.base.Pagination;

import java.util.List;
import java.util.Set;

/*
 *  Created by xuebj - 2017/03/14.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public interface SysRoleService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    SysRoleDTO get(Long id);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<SysRoleDTO> list(SysRoleQUERY bean);

    /**
     * 查询对象列表
     * @param ids  id 集合
     * @return  分页对象
     */
    List<SysRoleDTO> listByIds(Set<Long> ids);

    /**
     * 保存单个对象
     * @param bean  保存对象
     * @param pers  权限集合
     * @return 主键
     */
    Long doSave(SysRoleSaveBO bean, List<Long> pers);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @param perId 新的权限ID
     * @return 更新的记录条数
     */
    Integer doUpdate(SysRoleUpdateBO bean, List<Long> perId);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(SysRoleRemoveBO bean);

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    Integer doRemove(Long id);

}