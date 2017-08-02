package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.domain.*;
import cn.qweb.cms.biz.service.ChorgraphyService;
import cn.qweb.cms.biz.service.bo.ChorgraphyRemoveBO;
import cn.qweb.cms.biz.service.bo.ChorgraphySaveBO;
import cn.qweb.cms.biz.service.bo.ChorgraphyUpdateBO;
import cn.qweb.cms.biz.service.dto.ChorgraphyDTO;
import cn.qweb.cms.biz.service.query.ChorgraphyQUERY;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/*
 *  Created by xuebj - 2017/05/11.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class ChorgraphyServiceImpl implements ChorgraphyService {

    @Autowired
    private ChorgraphyMapper chorgraphyMapper;

    @Autowired
    private ChorgraphyAttachmentMapper attachmentMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public ChorgraphyDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(chorgraphyMapper.get(id),ChorgraphyDTO.class);
    }

    @Override
    public ChorgraphyDTO getNext(Long id, Integer status, Boolean next) {

        ChorgraphyNextQuery query = new ChorgraphyNextQuery();
        query.setId(id);
        query.setNext(next);
        query.setPageSize(1);
        query.setStatus(status);
        PageHelper.startPage(1,1);
        List<ChorgraphyDO> contents = chorgraphyMapper.getNext(query);
        if(contents != null && !contents.isEmpty()){
            return BeanPropertiesUtils.copyProperties(contents.get(0),ChorgraphyDTO.class);
        }
        return null;
    }

    @Override
    public Boolean doPublish(Long id) {
        ChorgraphyDO bean = new ChorgraphyDO();
        bean.setId(id);
        bean.setReleaseDate(new Date());
        bean.setStatus(3);//已发布
        chorgraphyMapper.update(bean);
        return Boolean.TRUE;
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<ChorgraphyDTO> list(ChorgraphyQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<ChorgraphyDO> chorgraphy = (Page<ChorgraphyDO>) chorgraphyMapper.list(BeanPropertiesUtils.copyProperties(bean, ChorgraphyDO.class));
        Pagination<ChorgraphyDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(chorgraphy, ChorgraphyDTO.class));
        result.setTotal(chorgraphy.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(ChorgraphySaveBO bean){
        ChorgraphyDO chorgraphy = BeanPropertiesUtils.copyProperties(bean, ChorgraphyDO.class);
        Date date = new Date();
        chorgraphy.setGmtCreate(date);
        chorgraphy.setUpDate(date);
        chorgraphyMapper.save(chorgraphy);
        if(bean.getAttachments() != null){
            bean.getAttachments().stream().forEach(attachmentBean-> {
                attachmentBean.setChorgraphyId(chorgraphy.getId());
                attachmentMapper.save(BeanPropertiesUtils.copyProperties(attachmentBean,ChorgraphyAttachmentDO.class));
            });
        }
        return chorgraphy.getId();
    }

    @Override
    public void doViewUpdate(Long id) {
        ChorgraphyDO chorgraphyDO = chorgraphyMapper.get(id);
        ChorgraphyDO newChorgraphyDO = new ChorgraphyDO();
        newChorgraphyDO.setId(id);
        newChorgraphyDO.setViews(chorgraphyDO.getViews() + 1);
        chorgraphyMapper.update(newChorgraphyDO);
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(ChorgraphyUpdateBO bean){
        ChorgraphyDO chorgraphy = BeanPropertiesUtils.copyProperties(bean, ChorgraphyDO.class);
        chorgraphy.setGmtModified(new Date());
        ChorgraphyAttachmentDO attachmentDO = new ChorgraphyAttachmentDO();
        attachmentDO.setChorgraphyId(bean.getId());
        attachmentMapper.remove(attachmentDO);
        if(bean.getAttachments() != null){
            bean.getAttachments().stream().forEach(attachmentBean-> {
                attachmentBean.setChorgraphyId(bean.getId());
                attachmentMapper.save(BeanPropertiesUtils.copyProperties(attachmentBean,ChorgraphyAttachmentDO.class));
            });
        }
        return chorgraphyMapper.update(chorgraphy);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(ChorgraphyRemoveBO bean){
        ChorgraphyDO chorgraphy = BeanPropertiesUtils.copyProperties(bean, ChorgraphyDO.class);
        return chorgraphyMapper.remove(chorgraphy);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return chorgraphyMapper.delete(id);
        }
}
