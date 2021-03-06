package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.service.ContentAttrService;
import cn.qweb.cms.biz.domain.ContentAttrMapper;
import cn.qweb.cms.biz.domain.ContentAttrDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;

import cn.qweb.cms.biz.service.bo.ContentAttrSaveBO;
import cn.qweb.cms.biz.service.query.ContentAttrQUERY;
import cn.qweb.cms.biz.service.bo.ContentAttrRemoveBO;
import cn.qweb.cms.biz.service.dto.ContentAttrDTO;
import cn.qweb.cms.biz.service.bo.ContentAttrUpdateBO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class ContentAttrServiceImpl implements ContentAttrService {

    @Autowired
    private ContentAttrMapper contentAttrMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public ContentAttrDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(contentAttrMapper.get(id),ContentAttrDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<ContentAttrDTO> list(ContentAttrQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<ContentAttrDO> contentAttr = (Page<ContentAttrDO>) contentAttrMapper.list(BeanPropertiesUtils.copyProperties(bean, ContentAttrDO.class));
        Pagination<ContentAttrDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(contentAttr, ContentAttrDTO.class));
        result.setTotal(contentAttr.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(ContentAttrSaveBO bean){
        ContentAttrDO contentAttr = BeanPropertiesUtils.copyProperties(bean, ContentAttrDO.class);
        contentAttr.setGmtCreate(new Date());
        contentAttrMapper.save(contentAttr);
        return contentAttr.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(ContentAttrUpdateBO bean){
        ContentAttrDO contentAttr = BeanPropertiesUtils.copyProperties(bean, ContentAttrDO.class);
        contentAttr.setGmtModified(new Date());
        return contentAttrMapper.update(contentAttr);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(ContentAttrRemoveBO bean){
        ContentAttrDO contentAttr = BeanPropertiesUtils.copyProperties(bean, ContentAttrDO.class);
        return contentAttrMapper.remove(contentAttr);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return contentAttrMapper.delete(id);
        }
}
