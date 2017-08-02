package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.domain.*;
import cn.qweb.cms.biz.service.SysRoleService;
import cn.qweb.cms.biz.service.bo.SysRoleRemoveBO;
import cn.qweb.cms.biz.service.bo.SysRoleSaveBO;
import cn.qweb.cms.biz.service.bo.SysRoleUpdateBO;
import cn.qweb.cms.biz.service.dto.SysRoleDTO;
import cn.qweb.cms.biz.service.query.SysRoleQUERY;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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


@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public SysRoleDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(sysRoleMapper.get(id),SysRoleDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<SysRoleDTO> list(SysRoleQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<SysRoleDO> sysRole = (Page<SysRoleDO>) sysRoleMapper.list(BeanPropertiesUtils.copyProperties(bean, SysRoleDO.class));
        Pagination<SysRoleDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(sysRole, SysRoleDTO.class));
        result.setTotal(sysRole.getTotal());
        return result;
    }

    /**
     * 查询对象列表
     *
     * @param ids id 集合
     * @return 分页对象
     */
    @Override
    public List<SysRoleDTO> listByIds(Set<Long> ids) {
        return BeanPropertiesUtils.covert2List(sysRoleMapper.listByIds(ids),SysRoleDTO.class);
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(SysRoleSaveBO bean, List<Long> pers){
        SysRoleDO sysRole = BeanPropertiesUtils.copyProperties(bean, SysRoleDO.class);
        sysRole.setGmtCreate(new Date());
        sysRoleMapper.save(sysRole);
        //主键
        Long roleId = sysRole.getId();
        if(pers != null && !pers.isEmpty()){
            pers.stream().forEach(perId -> sysRolePermissionMapper.save(new SysRolePermissionDO(roleId,perId)));
        }
        return roleId;
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(SysRoleUpdateBO bean, List<Long> pers){
        SysRoleDO sysRole = BeanPropertiesUtils.copyProperties(bean, SysRoleDO.class);
        sysRole.setGmtModified(new Date());
        Integer count  = sysRoleMapper.update(sysRole);
        //主键
        if(count > 0){ // 更新记录条数大于1
            Long roleId = sysRole.getId();
            if(pers != null && !pers.isEmpty()){
                //先删除后重新添加
                sysRolePermissionMapper.remove(new SysRolePermissionDO(roleId));
                pers.stream().forEach(perId -> sysRolePermissionMapper.save(new SysRolePermissionDO(roleId,perId)));
            }
        }
        return count;
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(SysRoleRemoveBO bean){
        SysRoleDO sysRole = BeanPropertiesUtils.copyProperties(bean, SysRoleDO.class);
        List<SysRoleDO> list =  sysRoleMapper.list(sysRole);
        Integer count  = sysRoleMapper.remove(sysRole); //删除对应的关系
        if(count > 0){
            list.stream().forEach(sysRoleDO -> doRemove(sysRole.getId()));
        }
        return count;
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        Integer count = sysRoleMapper.delete(id);
        if(count >0){
            //需要删除对应的角色和权限关联表
            sysRolePermissionMapper.remove(new SysRolePermissionDO(id));
            //需要删除对应的用户和角色关联表
            SysUserRoleDO userRoleDO = new SysUserRoleDO();
            userRoleDO.setRoleId(id);
            sysUserRoleMapper.remove(userRoleDO);
        }
        return count;
    }
}
