package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.domain.UserExtDO;
import cn.qweb.cms.biz.domain.UserExtMapper;
import cn.qweb.cms.biz.service.UserExtService;
import cn.qweb.cms.biz.service.bo.UserExtRemoveBO;
import cn.qweb.cms.biz.service.bo.UserExtSaveBO;
import cn.qweb.cms.biz.service.bo.UserExtUpdateBO;
import cn.qweb.cms.biz.service.dto.UserExtDTO;
import cn.qweb.cms.biz.service.query.UserExtQUERY;
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
 *  Created by xuebj - 2017/03/22.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class UserExtServiceImpl implements UserExtService {

    @Autowired
    private UserExtMapper userExtMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public UserExtDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(userExtMapper.get(id),UserExtDTO.class);
    }

    /**
     * 获取单个对象
     *
     * @param id 主键
     * @return 结果对象
     */
    @Override
    public UserExtDTO getByUserId(Long id) {
        return BeanPropertiesUtils.copyProperties(userExtMapper.getByUserId(id),UserExtDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<UserExtDTO> list(UserExtQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<UserExtDO> userExt = (Page<UserExtDO>) userExtMapper.list(BeanPropertiesUtils.copyProperties(bean, UserExtDO.class));
        Pagination<UserExtDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(userExt, UserExtDTO.class));
        result.setTotal(userExt.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(UserExtSaveBO bean){
        UserExtDO userExt = BeanPropertiesUtils.copyProperties(bean, UserExtDO.class);
        userExt.setGmtCreate(new Date());
        userExtMapper.save(userExt);
        return userExt.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(UserExtUpdateBO bean){
        UserExtDO userExt = BeanPropertiesUtils.copyProperties(bean, UserExtDO.class);
        userExt.setGmtModified(new Date());
        return userExtMapper.update(userExt);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(UserExtRemoveBO bean){
        UserExtDO userExt = BeanPropertiesUtils.copyProperties(bean, UserExtDO.class);
        return userExtMapper.remove(userExt);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return userExtMapper.delete(id);
        }
}
