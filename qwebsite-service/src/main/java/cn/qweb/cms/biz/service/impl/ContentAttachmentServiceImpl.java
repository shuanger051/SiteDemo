package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.service.ContentAttachmentService;
import cn.qweb.cms.biz.domain.ContentAttachmentMapper;
import cn.qweb.cms.biz.domain.ContentAttachmentDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;

import cn.qweb.cms.biz.service.bo.ContentAttachmentSaveBO;
import cn.qweb.cms.biz.service.query.ContentAttachmentQUERY;
import cn.qweb.cms.biz.service.bo.ContentAttachmentRemoveBO;
import cn.qweb.cms.biz.service.dto.ContentAttachmentDTO;
import cn.qweb.cms.biz.service.bo.ContentAttachmentUpdateBO;
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
public class ContentAttachmentServiceImpl implements ContentAttachmentService {

    @Autowired
    private ContentAttachmentMapper contentAttachmentMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public ContentAttachmentDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(contentAttachmentMapper.get(id),ContentAttachmentDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<ContentAttachmentDTO> list(ContentAttachmentQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<ContentAttachmentDO> contentAttachment = (Page<ContentAttachmentDO>) contentAttachmentMapper.list(BeanPropertiesUtils.copyProperties(bean, ContentAttachmentDO.class));
        Pagination<ContentAttachmentDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(contentAttachment, ContentAttachmentDTO.class));
        result.setTotal(contentAttachment.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(ContentAttachmentSaveBO bean){
        ContentAttachmentDO contentAttachment = BeanPropertiesUtils.copyProperties(bean, ContentAttachmentDO.class);
        contentAttachment.setGmtCreate(new Date());
        contentAttachmentMapper.save(contentAttachment);
        return contentAttachment.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(ContentAttachmentUpdateBO bean){
        ContentAttachmentDO contentAttachment = BeanPropertiesUtils.copyProperties(bean, ContentAttachmentDO.class);
        contentAttachment.setGmtModified(new Date());
        return contentAttachmentMapper.update(contentAttachment);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(ContentAttachmentRemoveBO bean){
        ContentAttachmentDO contentAttachment = BeanPropertiesUtils.copyProperties(bean, ContentAttachmentDO.class);
        return contentAttachmentMapper.remove(contentAttachment);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return contentAttachmentMapper.delete(id);
        }
}
