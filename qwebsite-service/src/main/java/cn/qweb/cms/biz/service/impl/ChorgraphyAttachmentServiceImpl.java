package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.domain.ChorgraphyAttachmentDO;
import cn.qweb.cms.biz.domain.ChorgraphyAttachmentMapper;
import cn.qweb.cms.biz.service.ChorgraphyAttachmentService;
import cn.qweb.cms.biz.service.bo.ChorgraphyAttachmentRemoveBO;
import cn.qweb.cms.biz.service.bo.ChorgraphyAttachmentSaveBO;
import cn.qweb.cms.biz.service.bo.ChorgraphyAttachmentUpdateBO;
import cn.qweb.cms.biz.service.dto.ChorgraphyAttachmentDTO;
import cn.qweb.cms.biz.service.query.ChorgraphyAttachmentQUERY;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/*
 *  Created by xuebj - 2017/05/11.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class ChorgraphyAttachmentServiceImpl implements ChorgraphyAttachmentService {

    @Autowired
    private ChorgraphyAttachmentMapper chorgraphyAttachmentMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public ChorgraphyAttachmentDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(chorgraphyAttachmentMapper.get(id),ChorgraphyAttachmentDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<ChorgraphyAttachmentDTO> list(ChorgraphyAttachmentQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<ChorgraphyAttachmentDO> chorgraphyAttachment = (Page<ChorgraphyAttachmentDO>) chorgraphyAttachmentMapper.list(BeanPropertiesUtils.copyProperties(bean, ChorgraphyAttachmentDO.class));
        Pagination<ChorgraphyAttachmentDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(chorgraphyAttachment, ChorgraphyAttachmentDTO.class));
        result.setTotal(chorgraphyAttachment.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(ChorgraphyAttachmentSaveBO bean){
        ChorgraphyAttachmentDO chorgraphyAttachment = BeanPropertiesUtils.copyProperties(bean, ChorgraphyAttachmentDO.class);
        chorgraphyAttachment.setGmtCreate(new Date());
        chorgraphyAttachmentMapper.save(chorgraphyAttachment);
        return chorgraphyAttachment.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(ChorgraphyAttachmentUpdateBO bean){
        ChorgraphyAttachmentDO chorgraphyAttachment = BeanPropertiesUtils.copyProperties(bean, ChorgraphyAttachmentDO.class);
        chorgraphyAttachment.setGmtModified(new Date());
        return chorgraphyAttachmentMapper.update(chorgraphyAttachment);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(ChorgraphyAttachmentRemoveBO bean){
        ChorgraphyAttachmentDO chorgraphyAttachment = BeanPropertiesUtils.copyProperties(bean, ChorgraphyAttachmentDO.class);
        return chorgraphyAttachmentMapper.remove(chorgraphyAttachment);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return chorgraphyAttachmentMapper.delete(id);
        }
}
