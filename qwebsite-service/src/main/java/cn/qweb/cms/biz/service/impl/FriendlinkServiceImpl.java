package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.service.FriendlinkService;
import cn.qweb.cms.biz.domain.FriendlinkMapper;
import cn.qweb.cms.biz.domain.FriendlinkDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;

import cn.qweb.cms.biz.service.bo.FriendlinkSaveBO;
import cn.qweb.cms.biz.service.query.FriendlinkQUERY;
import cn.qweb.cms.biz.service.bo.FriendlinkRemoveBO;
import cn.qweb.cms.biz.service.dto.FriendlinkDTO;
import cn.qweb.cms.biz.service.bo.FriendlinkUpdateBO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
 *  Created by xuebj - 2017/03/20.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class FriendlinkServiceImpl implements FriendlinkService {

    @Autowired
    private FriendlinkMapper friendlinkMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public FriendlinkDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(friendlinkMapper.get(id),FriendlinkDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<FriendlinkDTO> list(FriendlinkQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<FriendlinkDO> friendlink = (Page<FriendlinkDO>) friendlinkMapper.list(BeanPropertiesUtils.copyProperties(bean, FriendlinkDO.class));
        Pagination<FriendlinkDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(friendlink, FriendlinkDTO.class));
        result.setTotal(friendlink.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(FriendlinkSaveBO bean){
        FriendlinkDO friendlink = BeanPropertiesUtils.copyProperties(bean, FriendlinkDO.class);
        friendlink.setGmtCreate(new Date());
        friendlinkMapper.save(friendlink);
        return friendlink.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(FriendlinkUpdateBO bean){
        FriendlinkDO friendlink = BeanPropertiesUtils.copyProperties(bean, FriendlinkDO.class);
        friendlink.setGmtModified(new Date());
        return friendlinkMapper.update(friendlink);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(FriendlinkRemoveBO bean){
        FriendlinkDO friendlink = BeanPropertiesUtils.copyProperties(bean, FriendlinkDO.class);
        return friendlinkMapper.remove(friendlink);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return friendlinkMapper.delete(id);
        }
}
