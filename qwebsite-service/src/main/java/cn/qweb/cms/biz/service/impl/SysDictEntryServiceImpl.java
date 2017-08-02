package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.service.SysDictEntryService;
import cn.qweb.cms.biz.domain.SysDictEntryMapper;
import cn.qweb.cms.biz.domain.SysDictEntryDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;

import cn.qweb.cms.biz.service.bo.SysDictEntrySaveBO;
import cn.qweb.cms.biz.service.query.SysDictEntryQUERY;
import cn.qweb.cms.biz.service.bo.SysDictEntryRemoveBO;
import cn.qweb.cms.biz.service.dto.SysDictEntryDTO;
import cn.qweb.cms.biz.service.bo.SysDictEntryUpdateBO;
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
public class SysDictEntryServiceImpl implements SysDictEntryService {

    @Autowired
    private SysDictEntryMapper sysDictEntryMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public SysDictEntryDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(sysDictEntryMapper.get(id),SysDictEntryDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<SysDictEntryDTO> list(SysDictEntryQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<SysDictEntryDO> sysDictEntry = (Page<SysDictEntryDO>) sysDictEntryMapper.list(BeanPropertiesUtils.copyProperties(bean, SysDictEntryDO.class));
        Pagination<SysDictEntryDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(sysDictEntry, SysDictEntryDTO.class));
        result.setTotal(sysDictEntry.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(SysDictEntrySaveBO bean){
        SysDictEntryDO sysDictEntry = BeanPropertiesUtils.copyProperties(bean, SysDictEntryDO.class);
        sysDictEntry.setGmtCreate(new Date());
        sysDictEntryMapper.save(sysDictEntry);
        return sysDictEntry.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(SysDictEntryUpdateBO bean){
        SysDictEntryDO sysDictEntry = BeanPropertiesUtils.copyProperties(bean, SysDictEntryDO.class);
        sysDictEntry.setGmtModified(new Date());
        return sysDictEntryMapper.update(sysDictEntry);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(SysDictEntryRemoveBO bean){
        SysDictEntryDO sysDictEntry = BeanPropertiesUtils.copyProperties(bean, SysDictEntryDO.class);
        return sysDictEntryMapper.remove(sysDictEntry);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return sysDictEntryMapper.delete(id);
        }
}
