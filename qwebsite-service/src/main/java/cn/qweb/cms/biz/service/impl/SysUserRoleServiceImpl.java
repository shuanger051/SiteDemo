package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.domain.SysUserRoleDO;
import cn.qweb.cms.biz.domain.SysUserRoleMapper;
import cn.qweb.cms.biz.domain.UserRoleDO;
import cn.qweb.cms.biz.service.SysUserRoleService;
import cn.qweb.cms.biz.service.bo.SysUserRoleRemoveBO;
import cn.qweb.cms.biz.service.bo.SysUserRoleSaveBO;
import cn.qweb.cms.biz.service.bo.SysUserRoleUpdateBO;
import cn.qweb.cms.biz.service.dto.SysUserRoleDTO;
import cn.qweb.cms.biz.service.dto.UserRoleDTO;
import cn.qweb.cms.biz.service.query.SysUserRoleQUERY;
import cn.qweb.cms.biz.service.query.UserRoleQUERY;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.exception.BizException;
import cn.qweb.cms.core.exception.builder.ErrorBuilder;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public SysUserRoleDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(sysUserRoleMapper.get(id),SysUserRoleDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<SysUserRoleDTO> list(SysUserRoleQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<SysUserRoleDO> sysUserRole = (Page<SysUserRoleDO>) sysUserRoleMapper.list(BeanPropertiesUtils.copyProperties(bean, SysUserRoleDO.class));
        Pagination<SysUserRoleDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(sysUserRole, SysUserRoleDTO.class));
        result.setTotal(sysUserRole.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(SysUserRoleSaveBO bean){
        //需要判断唯一性，
        SysUserRoleDO result = new SysUserRoleDO();
        result.setUserId(bean.getUserId());
        List<SysUserRoleDO> searchResult = sysUserRoleMapper.list(result);
        if(searchResult != null && !searchResult.isEmpty()){
            throw new BizException(ErrorBuilder.buildBizError("用户已拥有角色，不能重复分配"));
        }
        SysUserRoleDO sysUserRole = BeanPropertiesUtils.copyProperties(bean, SysUserRoleDO.class);
        sysUserRole.setGmtCreate(new Date());
        sysUserRoleMapper.save(sysUserRole);
        return sysUserRole.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(SysUserRoleUpdateBO bean){
        SysUserRoleDO sysUserRole = BeanPropertiesUtils.copyProperties(bean, SysUserRoleDO.class);
        sysUserRole.setGmtModified(new Date());
        return sysUserRoleMapper.update(sysUserRole);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(SysUserRoleRemoveBO bean){
        SysUserRoleDO sysUserRole = BeanPropertiesUtils.copyProperties(bean, SysUserRoleDO.class);
        return sysUserRoleMapper.remove(sysUserRole);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return sysUserRoleMapper.delete(id);
    }


    /**
     * 按角色ID查找用户列表
     *
     * @param bean 角色ID
     * @return
     */
    @Override
    public Pagination<UserRoleDTO> listUserByRole(UserRoleQUERY bean) {
        PageHelper.startPage(bean.getPage(),bean.getPageSize());
        Page<UserRoleDO> userRoleDOs = (Page<UserRoleDO>) sysUserRoleMapper.listUser(bean);
        Pagination<UserRoleDTO> result = new Pagination<>();
        result.setTotal(userRoleDOs.getTotal());
        result.setData(BeanPropertiesUtils.covert2List(userRoleDOs,UserRoleDTO.class));
        return result;
    }

    /**
     * 角色界面添加角色成员搜索 接口
     *
     * @param bean
     * @return
     */
    @Override
    public Pagination<UserRoleDTO> searchUser(UserRoleQUERY bean) {
        PageHelper.startPage(bean.getPage(),bean.getPageSize());
        Page<UserRoleDO> userRoleDOs = (Page<UserRoleDO>) sysUserRoleMapper.searchUser(bean);
        Pagination<UserRoleDTO> result = new Pagination<>();
        result.setTotal(userRoleDOs.getTotal());
        result.setData(BeanPropertiesUtils.covert2List(userRoleDOs,UserRoleDTO.class));
        return result;
    }
}
