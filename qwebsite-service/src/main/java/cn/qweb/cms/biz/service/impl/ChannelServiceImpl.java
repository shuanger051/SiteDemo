package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.domain.ChannelDO;
import cn.qweb.cms.biz.domain.ChannelMapper;
import cn.qweb.cms.biz.service.ChannelService;
import cn.qweb.cms.biz.service.ContentService;
import cn.qweb.cms.biz.service.bo.ChannelRemoveBO;
import cn.qweb.cms.biz.service.bo.ChannelSaveBO;
import cn.qweb.cms.biz.service.bo.ChannelUpdateBO;
import cn.qweb.cms.biz.service.dto.ChannelDTO;
import cn.qweb.cms.biz.service.query.ChannelQUERY;
import cn.qweb.cms.biz.service.query.ContentQUERY;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.exception.BizException;
import cn.qweb.cms.core.exception.builder.ErrorBuilder;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/*
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelMapper channelMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public ChannelDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(channelMapper.get(id),ChannelDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<ChannelDTO> list(ChannelQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<ChannelDO> channel = (Page<ChannelDO>) channelMapper.list(BeanPropertiesUtils.copyProperties(bean, ChannelDO.class));
        Pagination<ChannelDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(channel, ChannelDTO.class));
        result.setTotal(channel.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(ChannelSaveBO bean){
        ChannelDO channel = BeanPropertiesUtils.copyProperties(bean, ChannelDO.class);
        channel.setGmtCreate(new Date());
        channelMapper.save(channel);
        return channel.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(ChannelUpdateBO bean){
        ChannelDO channel = BeanPropertiesUtils.copyProperties(bean, ChannelDO.class);
        channel.setGmtModified(new Date());
        return channelMapper.update(channel);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(ChannelRemoveBO bean){
        ChannelDO channel = BeanPropertiesUtils.copyProperties(bean, ChannelDO.class);
        return channelMapper.remove(channel);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        //如果有子栏目 不允许删除，
        //如果栏目下有文字不允许删除
        ChannelQUERY queryBean = new ChannelQUERY();
        queryBean.setParentId(id);
        if(list(queryBean).getTotal() > 0){//存在子栏目，不允许删除
            throw new BizException(ErrorBuilder.buildBizError("存在子栏目，请先删除子栏目。"));
        }
        ContentQUERY contentQUERY = new ContentQUERY();
        contentQUERY.setChannelId(id);
        if(contentService.list(contentQUERY).getTotal() > 0){
            throw new BizException(ErrorBuilder.buildBizError("栏目下存在内容，不允许删除"));
        }
        return channelMapper.delete(id);
    }

    @Autowired
    private ContentService contentService;
}
