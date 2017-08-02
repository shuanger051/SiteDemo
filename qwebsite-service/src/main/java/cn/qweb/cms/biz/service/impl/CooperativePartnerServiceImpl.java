package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.service.CooperativePartnerService;
import cn.qweb.cms.biz.domain.CooperativePartnerMapper;
import cn.qweb.cms.biz.domain.CooperativePartnerDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;

import cn.qweb.cms.biz.service.bo.CooperativePartnerSaveBO;
import cn.qweb.cms.biz.service.query.CooperativePartnerQUERY;
import cn.qweb.cms.biz.service.bo.CooperativePartnerRemoveBO;
import cn.qweb.cms.biz.service.dto.CooperativePartnerDTO;
import cn.qweb.cms.biz.service.bo.CooperativePartnerUpdateBO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
 *  Created by xuebj - 2017/03/23.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class CooperativePartnerServiceImpl implements CooperativePartnerService {

    @Autowired
    private CooperativePartnerMapper cooperativePartnerMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public CooperativePartnerDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(cooperativePartnerMapper.get(id),CooperativePartnerDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<CooperativePartnerDTO> list(CooperativePartnerQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<CooperativePartnerDO> cooperativePartner = (Page<CooperativePartnerDO>) cooperativePartnerMapper.list(BeanPropertiesUtils.copyProperties(bean, CooperativePartnerDO.class));
        Pagination<CooperativePartnerDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(cooperativePartner, CooperativePartnerDTO.class));
        result.setTotal(cooperativePartner.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(CooperativePartnerSaveBO bean){
        CooperativePartnerDO cooperativePartner = BeanPropertiesUtils.copyProperties(bean, CooperativePartnerDO.class);
        cooperativePartner.setGmtCreate(new Date());
        cooperativePartnerMapper.save(cooperativePartner);
        return cooperativePartner.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(CooperativePartnerUpdateBO bean){
        CooperativePartnerDO cooperativePartner = BeanPropertiesUtils.copyProperties(bean, CooperativePartnerDO.class);
        cooperativePartner.setGmtModified(new Date());
        return cooperativePartnerMapper.update(cooperativePartner);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(CooperativePartnerRemoveBO bean){
        CooperativePartnerDO cooperativePartner = BeanPropertiesUtils.copyProperties(bean, CooperativePartnerDO.class);
        return cooperativePartnerMapper.remove(cooperativePartner);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return cooperativePartnerMapper.delete(id);
        }
}
