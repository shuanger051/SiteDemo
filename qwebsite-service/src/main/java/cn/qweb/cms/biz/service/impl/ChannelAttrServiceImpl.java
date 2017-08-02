package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.service.ChannelAttrService;
import cn.qweb.cms.biz.domain.ChannelAttrMapper;
import cn.qweb.cms.biz.domain.ChannelAttrDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;

import cn.qweb.cms.biz.service.bo.ChannelAttrSaveBO;
import cn.qweb.cms.biz.service.query.ChannelAttrQUERY;
import cn.qweb.cms.biz.service.bo.ChannelAttrRemoveBO;
import cn.qweb.cms.biz.service.dto.ChannelAttrDTO;
import cn.qweb.cms.biz.service.bo.ChannelAttrUpdateBO;
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
public class ChannelAttrServiceImpl implements ChannelAttrService {

    @Autowired
    private ChannelAttrMapper channelAttrMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public ChannelAttrDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(channelAttrMapper.get(id),ChannelAttrDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<ChannelAttrDTO> list(ChannelAttrQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<ChannelAttrDO> channelAttr = (Page<ChannelAttrDO>) channelAttrMapper.list(BeanPropertiesUtils.copyProperties(bean, ChannelAttrDO.class));
        Pagination<ChannelAttrDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(channelAttr, ChannelAttrDTO.class));
        result.setTotal(channelAttr.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(ChannelAttrSaveBO bean){
        ChannelAttrDO channelAttr = BeanPropertiesUtils.copyProperties(bean, ChannelAttrDO.class);
        channelAttr.setGmtCreate(new Date());
        channelAttrMapper.save(channelAttr);
        return channelAttr.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(ChannelAttrUpdateBO bean){
        ChannelAttrDO channelAttr = BeanPropertiesUtils.copyProperties(bean, ChannelAttrDO.class);
        channelAttr.setGmtModified(new Date());
        return channelAttrMapper.update(channelAttr);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(ChannelAttrRemoveBO bean){
        ChannelAttrDO channelAttr = BeanPropertiesUtils.copyProperties(bean, ChannelAttrDO.class);
        return channelAttrMapper.remove(channelAttr);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return channelAttrMapper.delete(id);
        }
}
