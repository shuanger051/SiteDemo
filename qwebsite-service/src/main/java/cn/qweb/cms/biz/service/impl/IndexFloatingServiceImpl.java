package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.service.IndexFloatingService;
import cn.qweb.cms.biz.domain.IndexFloatingMapper;
import cn.qweb.cms.biz.domain.IndexFloatingDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;

import cn.qweb.cms.biz.service.bo.IndexFloatingSaveBO;
import cn.qweb.cms.biz.service.query.IndexFloatingQUERY;
import cn.qweb.cms.biz.service.bo.IndexFloatingRemoveBO;
import cn.qweb.cms.biz.service.dto.IndexFloatingDTO;
import cn.qweb.cms.biz.service.bo.IndexFloatingUpdateBO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
 *  Created by xuebj - 2017/03/24.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class IndexFloatingServiceImpl implements IndexFloatingService {

    @Autowired
    private IndexFloatingMapper indexFloatingMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public IndexFloatingDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(indexFloatingMapper.get(id),IndexFloatingDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<IndexFloatingDTO> list(IndexFloatingQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<IndexFloatingDO> indexFloating = (Page<IndexFloatingDO>) indexFloatingMapper.list(BeanPropertiesUtils.copyProperties(bean, IndexFloatingDO.class));
        Pagination<IndexFloatingDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(indexFloating, IndexFloatingDTO.class));
        result.setTotal(indexFloating.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(IndexFloatingSaveBO bean){
        IndexFloatingDO indexFloating = BeanPropertiesUtils.copyProperties(bean, IndexFloatingDO.class);
        indexFloating.setGmtCreate(new Date());
        indexFloatingMapper.save(indexFloating);
        return indexFloating.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(IndexFloatingUpdateBO bean){
        IndexFloatingDO indexFloating = BeanPropertiesUtils.copyProperties(bean, IndexFloatingDO.class);
        indexFloating.setGmtModified(new Date());
        return indexFloatingMapper.update(indexFloating);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(IndexFloatingRemoveBO bean){
        IndexFloatingDO indexFloating = BeanPropertiesUtils.copyProperties(bean, IndexFloatingDO.class);
        return indexFloatingMapper.remove(indexFloating);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return indexFloatingMapper.delete(id);
        }
}
