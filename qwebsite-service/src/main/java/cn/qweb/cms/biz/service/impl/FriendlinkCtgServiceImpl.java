package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.service.FriendlinkCtgService;
import cn.qweb.cms.biz.domain.FriendlinkCtgMapper;
import cn.qweb.cms.biz.domain.FriendlinkCtgDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;

import cn.qweb.cms.biz.service.bo.FriendlinkCtgSaveBO;
import cn.qweb.cms.biz.service.query.FriendlinkCtgQUERY;
import cn.qweb.cms.biz.service.bo.FriendlinkCtgRemoveBO;
import cn.qweb.cms.biz.service.dto.FriendlinkCtgDTO;
import cn.qweb.cms.biz.service.bo.FriendlinkCtgUpdateBO;
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
public class FriendlinkCtgServiceImpl implements FriendlinkCtgService {

    @Autowired
    private FriendlinkCtgMapper friendlinkCtgMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public FriendlinkCtgDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(friendlinkCtgMapper.get(id),FriendlinkCtgDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<FriendlinkCtgDTO> list(FriendlinkCtgQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<FriendlinkCtgDO> friendlinkCtg = (Page<FriendlinkCtgDO>) friendlinkCtgMapper.list(BeanPropertiesUtils.copyProperties(bean, FriendlinkCtgDO.class));
        Pagination<FriendlinkCtgDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(friendlinkCtg, FriendlinkCtgDTO.class));
        result.setTotal(friendlinkCtg.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(FriendlinkCtgSaveBO bean){
        FriendlinkCtgDO friendlinkCtg = BeanPropertiesUtils.copyProperties(bean, FriendlinkCtgDO.class);
        friendlinkCtg.setGmtCreate(new Date());
        friendlinkCtgMapper.save(friendlinkCtg);
        return friendlinkCtg.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(FriendlinkCtgUpdateBO bean){
        FriendlinkCtgDO friendlinkCtg = BeanPropertiesUtils.copyProperties(bean, FriendlinkCtgDO.class);
        friendlinkCtg.setGmtModified(new Date());
        return friendlinkCtgMapper.update(friendlinkCtg);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(FriendlinkCtgRemoveBO bean){
        FriendlinkCtgDO friendlinkCtg = BeanPropertiesUtils.copyProperties(bean, FriendlinkCtgDO.class);
        return friendlinkCtgMapper.remove(friendlinkCtg);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return friendlinkCtgMapper.delete(id);
        }
}
