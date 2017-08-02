
package cn.qweb.cms.biz.service;
import cn.qweb.cms.biz.service.bo.*;
import cn.qweb.cms.biz.service.dto.UserDTO;
import cn.qweb.cms.biz.service.dto.UserWithPwdDTO;
import cn.qweb.cms.biz.service.query.UserQUERY;
import cn.qweb.cms.core.base.Pagination;

/*
 *  Created by xuebj - 2017/03/14.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public interface UserService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    UserDTO get(Long id);

    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    UserDTO getByUserName(String userName);

    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    UserWithPwdDTO getByUserNameWithPwd(String userName);

    /**
     * 根据用户名获取用户信息
     * @param id
     * @return
     */
    UserWithPwdDTO getWithPwd(Long id);

    /**
     * 根据邮箱查找用户
     * @param email
     * @return
     */
    UserWithPwdDTO getByEmail(String email);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<UserDTO> list(UserQUERY bean);

    /**
     * 保存单个对象
     * @param bean  保存对象
     * @param exBean  用户扩展信息对象
     * @return 主键
     */
    Long doSave(UserSaveBO bean, UserExtSaveBO exBean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(UserUpdateBO bean,UserExtUpdateBO useExtBean);

    /**
     * 更新用户登录信息，保存登录ip 登录次数，错误次数等
     * @param loginInfoBo
     */
    void doUpdateLoginInfo(LoginInfoBo loginInfoBo);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(UserRemoveBO bean);

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    Integer doRemove(Long id);

}