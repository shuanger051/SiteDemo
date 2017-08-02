package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.domain.SysRolePermissionDO;
import cn.qweb.cms.biz.domain.SysRolePermissionMapper;
import cn.qweb.cms.biz.service.SysRolePermissionService;
import cn.qweb.cms.biz.service.bo.SysRolePermissionRemoveBO;
import cn.qweb.cms.biz.service.bo.SysRolePermissionSaveBO;
import cn.qweb.cms.biz.service.bo.SysRolePermissionUpdateBO;
import cn.qweb.cms.biz.service.dto.SysPermissionDTO;
import cn.qweb.cms.biz.service.dto.SysRolePermissionDTO;
import cn.qweb.cms.biz.service.query.SysRolePermissionQUERY;
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
public class SysRolePermissionServiceImpl implements SysRolePermissionService {

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public SysRolePermissionDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(sysRolePermissionMapper.get(id),SysRolePermissionDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<SysRolePermissionDTO> list(SysRolePermissionQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<SysRolePermissionDO> sysRolePermission = (Page<SysRolePermissionDO>) sysRolePermissionMapper.list(BeanPropertiesUtils.copyProperties(bean, SysRolePermissionDO.class));
        Pagination<SysRolePermissionDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(sysRolePermission, SysRolePermissionDTO.class));
        result.setTotal(sysRolePermission.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(SysRolePermissionSaveBO bean){
        SysRolePermissionDO sysRolePermission = BeanPropertiesUtils.copyProperties(bean, SysRolePermissionDO.class);
        sysRolePermission.setGmtCreate(new Date());
        sysRolePermissionMapper.save(sysRolePermission);
        return sysRolePermission.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(SysRolePermissionUpdateBO bean){
        SysRolePermissionDO sysRolePermission = BeanPropertiesUtils.copyProperties(bean, SysRolePermissionDO.class);
        sysRolePermission.setGmtModified(new Date());
        return sysRolePermissionMapper.update(sysRolePermission);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(SysRolePermissionRemoveBO bean){
        SysRolePermissionDO sysRolePermission = BeanPropertiesUtils.copyProperties(bean, SysRolePermissionDO.class);
        return sysRolePermissionMapper.remove(sysRolePermission);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return sysRolePermissionMapper.delete(id);
        }

    /**
     * 根据roleId 获取权限列表
     *
     * @param roleId
     * @return
     */
    @Override
    public List<SysPermissionDTO> listPermissionByRoles(Set<String> roleId) {
        return null;
    }
}
