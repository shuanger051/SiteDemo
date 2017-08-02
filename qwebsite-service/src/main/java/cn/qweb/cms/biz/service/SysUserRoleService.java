
package cn.qweb.cms.biz.service;
import cn.qweb.cms.biz.service.bo.SysUserRoleRemoveBO;
import cn.qweb.cms.biz.service.bo.SysUserRoleSaveBO;
import cn.qweb.cms.biz.service.bo.SysUserRoleUpdateBO;
import cn.qweb.cms.biz.service.dto.SysUserRoleDTO;
import cn.qweb.cms.biz.service.dto.UserRoleDTO;
import cn.qweb.cms.biz.service.query.SysUserRoleQUERY;
import cn.qweb.cms.biz.service.query.UserRoleQUERY;
import cn.qweb.cms.core.base.Pagination;

/*
 *  Created by xuebj - 2017/03/14.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public interface SysUserRoleService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    SysUserRoleDTO get(Long id);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<SysUserRoleDTO> list(SysUserRoleQUERY bean);


    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(SysUserRoleSaveBO bean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(SysUserRoleUpdateBO bean);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(SysUserRoleRemoveBO bean);

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    Integer doRemove(Long id);


    /**
     * 按角色ID查找用户列表
     * @param bean  查询bean
     * @return
     */
    Pagination<UserRoleDTO> listUserByRole(UserRoleQUERY bean);


    /**
     * 角色界面添加角色成员搜索 接口
     * @param bean
     * @return
     */
    Pagination<UserRoleDTO> searchUser(UserRoleQUERY bean);

}