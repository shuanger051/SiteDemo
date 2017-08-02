package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.domain.SysDictItemDO;
import cn.qweb.cms.biz.domain.SysDictItemMapper;
import cn.qweb.cms.biz.service.SysDictItemService;
import cn.qweb.cms.biz.service.bo.SysDictItemRemoveBO;
import cn.qweb.cms.biz.service.bo.SysDictItemSaveBO;
import cn.qweb.cms.biz.service.bo.SysDictItemUpdateBO;
import cn.qweb.cms.biz.service.dto.SysDictItemDTO;
import cn.qweb.cms.biz.service.query.SysDictItemQUERY;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *  Created by xuebj - 2017/03/14.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class SysDictItemServiceImpl implements SysDictItemService {

    @Autowired
    private SysDictItemMapper sysDictItemMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public SysDictItemDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(sysDictItemMapper.get(id),SysDictItemDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<SysDictItemDTO> list(SysDictItemQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<SysDictItemDO> sysDictItem = (Page<SysDictItemDO>) sysDictItemMapper.list(BeanPropertiesUtils.copyProperties(bean, SysDictItemDO.class));
        Pagination<SysDictItemDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(sysDictItem, SysDictItemDTO.class));
        result.setTotal(sysDictItem.getTotal());
        return result;
    }

    /**
     * 根据字典查询字典条目
     *
     * @param entryCodesList
     * @return
     */
    @Override
    public Map<String, List<SysDictItemDTO>> list(List<String> entryCodesList) {
        Map<String,List<SysDictItemDTO>> result = new HashMap<>();
        entryCodesList.stream().forEach(entryCode ->
            result.put(entryCode,BeanPropertiesUtils.covert2List(sysDictItemMapper.list(new SysDictItemDO(entryCode)),SysDictItemDTO.class))
        );
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(SysDictItemSaveBO bean){
        SysDictItemDO sysDictItem = BeanPropertiesUtils.copyProperties(bean, SysDictItemDO.class);
        sysDictItem.setGmtCreate(new Date());
        sysDictItemMapper.save(sysDictItem);
        return sysDictItem.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(SysDictItemUpdateBO bean){
        SysDictItemDO sysDictItem = BeanPropertiesUtils.copyProperties(bean, SysDictItemDO.class);
        sysDictItem.setGmtModified(new Date());
        return sysDictItemMapper.update(sysDictItem);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(SysDictItemRemoveBO bean){
        SysDictItemDO sysDictItem = BeanPropertiesUtils.copyProperties(bean, SysDictItemDO.class);
        return sysDictItemMapper.remove(sysDictItem);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return sysDictItemMapper.delete(id);
        }
}
