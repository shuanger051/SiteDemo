package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.service.LuceneService;
import cn.qweb.cms.biz.domain.LuceneMapper;
import cn.qweb.cms.biz.domain.LuceneDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;

import cn.qweb.cms.biz.service.bo.LuceneSaveBO;
import cn.qweb.cms.biz.service.query.LuceneQUERY;
import cn.qweb.cms.biz.service.bo.LuceneRemoveBO;
import cn.qweb.cms.biz.service.dto.LuceneDTO;
import cn.qweb.cms.biz.service.bo.LuceneUpdateBO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
 *  Created by xuebj - 2017/04/07.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class LuceneServiceImpl implements LuceneService {

    @Autowired
    private LuceneMapper luceneMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public LuceneDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(luceneMapper.get(id),LuceneDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<LuceneDTO> list(LuceneQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<LuceneDO> lucene = (Page<LuceneDO>) luceneMapper.list(BeanPropertiesUtils.copyProperties(bean, LuceneDO.class));
        Pagination<LuceneDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(lucene, LuceneDTO.class));
        result.setTotal(lucene.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(LuceneSaveBO bean){
        LuceneDO lucene = BeanPropertiesUtils.copyProperties(bean, LuceneDO.class);
        lucene.setGmtCreate(new Date());
        luceneMapper.save(lucene);
        return lucene.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(LuceneUpdateBO bean){
        LuceneDO lucene = BeanPropertiesUtils.copyProperties(bean, LuceneDO.class);
        lucene.setGmtModified(new Date());
        return luceneMapper.update(lucene);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(LuceneRemoveBO bean){
        LuceneDO lucene = BeanPropertiesUtils.copyProperties(bean, LuceneDO.class);
        return luceneMapper.remove(lucene);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return luceneMapper.delete(id);
        }
}
