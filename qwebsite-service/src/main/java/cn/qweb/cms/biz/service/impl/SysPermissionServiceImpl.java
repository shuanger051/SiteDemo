package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.service.SysPermissionService;
import cn.qweb.cms.biz.domain.SysPermissionMapper;
import cn.qweb.cms.biz.domain.SysPermissionDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;

import cn.qweb.cms.biz.service.bo.SysPermissionSaveBO;
import cn.qweb.cms.biz.service.query.SysPermissionQUERY;
import cn.qweb.cms.biz.service.bo.SysPermissionRemoveBO;
import cn.qweb.cms.biz.service.dto.SysPermissionDTO;
import cn.qweb.cms.biz.service.bo.SysPermissionUpdateBO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
 *  Created by xuebj - 2017/03/14.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public SysPermissionDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(sysPermissionMapper.get(id),SysPermissionDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<SysPermissionDTO> list(SysPermissionQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<SysPermissionDO> sysPermission = (Page<SysPermissionDO>) sysPermissionMapper.list(BeanPropertiesUtils.copyProperties(bean, SysPermissionDO.class));
        Pagination<SysPermissionDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(sysPermission, SysPermissionDTO.class));
        result.setTotal(sysPermission.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(SysPermissionSaveBO bean){
        SysPermissionDO sysPermission = BeanPropertiesUtils.copyProperties(bean, SysPermissionDO.class);
        sysPermission.setGmtCreate(new Date());
        sysPermissionMapper.save(sysPermission);
        return sysPermission.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(SysPermissionUpdateBO bean){
        SysPermissionDO sysPermission = BeanPropertiesUtils.copyProperties(bean, SysPermissionDO.class);
        sysPermission.setGmtModified(new Date());
        return sysPermissionMapper.update(sysPermission);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(SysPermissionRemoveBO bean){
        SysPermissionDO sysPermission = BeanPropertiesUtils.copyProperties(bean, SysPermissionDO.class);
        return sysPermissionMapper.remove(sysPermission);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return sysPermissionMapper.delete(id);
        }
}
