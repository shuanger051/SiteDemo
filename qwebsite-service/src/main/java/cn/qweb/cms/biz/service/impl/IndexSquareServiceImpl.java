package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.service.IndexSquareService;
import cn.qweb.cms.biz.domain.IndexSquareMapper;
import cn.qweb.cms.biz.domain.IndexSquareDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;

import cn.qweb.cms.biz.service.bo.IndexSquareSaveBO;
import cn.qweb.cms.biz.service.query.IndexSquareQUERY;
import cn.qweb.cms.biz.service.bo.IndexSquareRemoveBO;
import cn.qweb.cms.biz.service.dto.IndexSquareDTO;
import cn.qweb.cms.biz.service.bo.IndexSquareUpdateBO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
 *  Created by xuebj - 2017/04/05.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class IndexSquareServiceImpl implements IndexSquareService {

    @Autowired
    private IndexSquareMapper indexSquareMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public IndexSquareDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(indexSquareMapper.get(id),IndexSquareDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<IndexSquareDTO> list(IndexSquareQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<IndexSquareDO> indexSquare = (Page<IndexSquareDO>) indexSquareMapper.list(BeanPropertiesUtils.copyProperties(bean, IndexSquareDO.class));
        Pagination<IndexSquareDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(indexSquare, IndexSquareDTO.class));
        result.setTotal(indexSquare.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(IndexSquareSaveBO bean){
        IndexSquareDO indexSquare = BeanPropertiesUtils.copyProperties(bean, IndexSquareDO.class);
        indexSquare.setGmtCreate(new Date());
        indexSquareMapper.save(indexSquare);
        return indexSquare.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(IndexSquareUpdateBO bean){
        IndexSquareDO indexSquare = BeanPropertiesUtils.copyProperties(bean, IndexSquareDO.class);
        indexSquare.setGmtModified(new Date());
        return indexSquareMapper.update(indexSquare);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(IndexSquareRemoveBO bean){
        IndexSquareDO indexSquare = BeanPropertiesUtils.copyProperties(bean, IndexSquareDO.class);
        return indexSquareMapper.remove(indexSquare);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return indexSquareMapper.delete(id);
        }
}
