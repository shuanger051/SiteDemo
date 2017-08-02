package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.service.IndexLineService;
import cn.qweb.cms.biz.domain.IndexLineMapper;
import cn.qweb.cms.biz.domain.IndexLineDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;

import cn.qweb.cms.biz.service.bo.IndexLineSaveBO;
import cn.qweb.cms.biz.service.query.IndexLineQUERY;
import cn.qweb.cms.biz.service.bo.IndexLineRemoveBO;
import cn.qweb.cms.biz.service.dto.IndexLineDTO;
import cn.qweb.cms.biz.service.bo.IndexLineUpdateBO;
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
public class IndexLineServiceImpl implements IndexLineService {

    @Autowired
    private IndexLineMapper indexLineMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public IndexLineDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(indexLineMapper.get(id),IndexLineDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<IndexLineDTO> list(IndexLineQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<IndexLineDO> indexLine = (Page<IndexLineDO>) indexLineMapper.list(BeanPropertiesUtils.copyProperties(bean, IndexLineDO.class));
        Pagination<IndexLineDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(indexLine, IndexLineDTO.class));
        result.setTotal(indexLine.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(IndexLineSaveBO bean){
        IndexLineDO indexLine = BeanPropertiesUtils.copyProperties(bean, IndexLineDO.class);
        indexLine.setGmtCreate(new Date());
        indexLineMapper.save(indexLine);
        return indexLine.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(IndexLineUpdateBO bean){
        IndexLineDO indexLine = BeanPropertiesUtils.copyProperties(bean, IndexLineDO.class);
        indexLine.setGmtModified(new Date());
        return indexLineMapper.update(indexLine);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(IndexLineRemoveBO bean){
        IndexLineDO indexLine = BeanPropertiesUtils.copyProperties(bean, IndexLineDO.class);
        return indexLineMapper.remove(indexLine);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return indexLineMapper.delete(id);
        }
}
