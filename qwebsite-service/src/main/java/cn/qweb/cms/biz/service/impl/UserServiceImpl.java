package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.domain.UserDO;
import cn.qweb.cms.biz.domain.UserExtDO;
import cn.qweb.cms.biz.domain.UserExtMapper;
import cn.qweb.cms.biz.domain.UserMapper;
import cn.qweb.cms.biz.service.UserService;
import cn.qweb.cms.biz.service.bo.*;
import cn.qweb.cms.biz.service.dto.UserDTO;
import cn.qweb.cms.biz.service.dto.UserWithPwdDTO;
import cn.qweb.cms.biz.service.query.UserQUERY;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.exception.BizException;
import cn.qweb.cms.core.exception.builder.ErrorBuilder;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/*
 *  Created by xuebj - 2017/03/14.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserExtMapper userExtMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public UserDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(userMapper.get(id),UserDTO.class);
    }


    /**
     * 根据用户名获取用户信息
     *
     * @param userName
     * @return
     */
    @Override
    public UserDTO getByUserName(String userName) {
        return BeanPropertiesUtils.copyProperties(userMapper.getByUserName(userName),UserDTO.class);
    }

    /**
     * 根据用户名获取用户信息
     *
     * @param userName
     * @return
     */
    @Override
    public UserWithPwdDTO getByUserNameWithPwd(String userName) {
        return BeanPropertiesUtils.copyProperties(userMapper.getByUserName(userName),UserWithPwdDTO.class);
    }

    /**
     * 根据用户名获取用户信息
     *
     * @param id
     * @return
     */
    @Override
    public UserWithPwdDTO getWithPwd(Long id) {
        return BeanPropertiesUtils.copyProperties(userMapper.get(id),UserWithPwdDTO.class);
    }

    /**
     * 根据邮箱查找用户
     *
     * @param email
     * @return
     */
    @Override
    public UserWithPwdDTO getByEmail(String email) {
        return BeanPropertiesUtils.copyProperties(userMapper.getByEmail(email),UserWithPwdDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<UserDTO> list(UserQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<UserDO> user = (Page<UserDO>) userMapper.list(BeanPropertiesUtils.copyProperties(bean, UserDO.class));
        Pagination<UserDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(user, UserDTO.class));
        result.setTotal(user.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键,用户名和邮箱必须唯一
     * @param bean  保存对象
     * @param exBean  用户扩展信息对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(UserSaveBO bean, UserExtSaveBO exBean){
        UserDO user = BeanPropertiesUtils.copyProperties(bean, UserDO.class);
        //校验 手机号和用户名和 邮箱
        checkUseName(bean.getUserName());
        checkEmail(bean.getEmail());
        checkMobile(exBean.getMobile());
        Date now = new Date();
        user.setRegisterTime(now);
        user.setLastLoginIp(user.getRegisterIp());
        user.setLastLoginTime(now);
        user.setActivation(true);
        user.setGmtCreate(now);
        userMapper.save(user);
        Long userId = user.getId();
        UserExtDO extDO = BeanPropertiesUtils.copyProperties(exBean,UserExtDO.class);
        extDO.setUserId(userId);
        userExtMapper.save(extDO);
        return user.getId();
    }

    private void checkUseName(String userName){
        if(StringUtils.isNotBlank(userName)){
            UserDTO user = getByUserName(userName);
            if(user !=null){
                throw new BizException(ErrorBuilder.buildBizError("用户名已经存在"));
            }
        }
    }

    private void checkEmail(String email){
        if(StringUtils.isNotBlank(email)) {
            UserDTO user = getByEmail(email);
            if (user != null) {
                throw new BizException(ErrorBuilder.buildBizError("邮箱已经存在"));
            }
        }
    }

    private void checkEmailForUpdate(String email,Long id){
        if(StringUtils.isNotBlank(email)) {
            UserDTO user = getByEmail(email);
            if (user != null && id != user.getId()) { //不为null 并且不是当前用户id
                throw new BizException(ErrorBuilder.buildBizError("邮箱已经存在"));
            }
        }
    }

    private void checkMobile(String mobile) {
        if (StringUtils.isNotBlank(mobile)) {
            UserExtDO queryBean = new UserExtDO();
            queryBean.setMobile(mobile);
            List<UserExtDO> userExts = userExtMapper.list(queryBean);
            if (!userExts.isEmpty()) {
                throw new BizException(ErrorBuilder.buildBizError("手机号已经存在"));
            }
        }
    }
    private void checkMobileForUpdate(String mobile,Long userId) {
        if (StringUtils.isNotBlank(mobile)) {
            UserExtDO queryBean = new UserExtDO();
            queryBean.setMobile(mobile);
            List<UserExtDO> userExts = userExtMapper.list(queryBean);
            if (userExts.size() > 1 || (!userExts.isEmpty() && userExts.get(0).getUserId() != userId)) {
                //记录大于2条，或者只有1条，就比对userId是否一致
                throw new BizException(ErrorBuilder.buildBizError("手机号已经存在"));
            }
        }
    }

    /**
     * 更新单个对象 id必须有 需要检查手机号和邮箱的唯一性
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(UserUpdateBO bean,UserExtUpdateBO useExtBean){
        UserDO user = BeanPropertiesUtils.copyProperties(bean, UserDO.class);
        user.setGmtModified(new Date());
        UserExtDO userExt = BeanPropertiesUtils.copyProperties(useExtBean,UserExtDO.class);
        userExt.setUserId(user.getId());
        checkEmailForUpdate(user.getEmail(),user.getId());
        checkMobileForUpdate(userExt.getMobile(),user.getId());
        Integer count = userMapper.update(user);
        userExtMapper.update(userExt);
        return count;
    }

    /**
     * 更新用户登录信息，保存登录ip 登录次数，错误次数等
     *
     * @param loginInfoBo
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void doUpdateLoginInfo(LoginInfoBo loginInfoBo) {
        UserDO bo = BeanPropertiesUtils.copyProperties(loginInfoBo, UserDO.class);
        UserWithPwdDTO user = getByUserNameWithPwd(loginInfoBo.getUserName());
        if(null != user) {
            bo.setUserName(null);//防止用户名被更新
            bo.setId(user.getId());
            if (StringUtils.isNotBlank(bo.getErrorIp())) {//错误记录
                bo.setErrorTime(new Date());
                bo.setErrorCount(user.getErrorCount() + 1);
            } else {
                bo.setLastLoginTime(new Date());
                bo.setErrorCount(0);
                bo.setLoginCount(user.getLoginCount() + 1);
            }
            userMapper.update(bo);
        }
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(UserRemoveBO bean){
        UserDO user = BeanPropertiesUtils.copyProperties(bean, UserDO.class);
        return userMapper.remove(user);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return userMapper.delete(id);
        }
}
