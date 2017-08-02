
package cn.qweb.cms.biz.service;
import cn.qweb.cms.biz.service.bo.SysRolePermissionRemoveBO;
import cn.qweb.cms.biz.service.bo.SysRolePermissionSaveBO;
import cn.qweb.cms.biz.service.bo.SysRolePermissionUpdateBO;
import cn.qweb.cms.biz.service.dto.SysPermissionDTO;
import cn.qweb.cms.biz.service.dto.SysRolePermissionDTO;
import cn.qweb.cms.biz.service.query.SysRolePermissionQUERY;
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

public interface SysRolePermissionService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    SysRolePermissionDTO get(Long id);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<SysRolePermissionDTO> list(SysRolePermissionQUERY bean);

    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(SysRolePermissionSaveBO bean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(SysRolePermissionUpdateBO bean);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(SysRolePermissionRemoveBO bean);

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    Integer doRemove(Long id);

    /**
     * 根据roleId 获取权限列表
     * @param roleId
     * @return
     */
    List<SysPermissionDTO> listPermissionByRoles(Set<String> roleId);

}