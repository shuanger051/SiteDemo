package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.domain.ActivitySquareDO;
import cn.qweb.cms.biz.domain.ActivitySquareMapper;
import cn.qweb.cms.biz.service.ActivitySquareService;
import cn.qweb.cms.biz.service.bo.ActivitySquareRemoveBO;
import cn.qweb.cms.biz.service.bo.ActivitySquareSaveBO;
import cn.qweb.cms.biz.service.bo.ActivitySquareUpdateBO;
import cn.qweb.cms.biz.service.dto.ActivitySquareDTO;
import cn.qweb.cms.biz.service.query.ActivitySquareQUERY;
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
 *  Created by xuebj - 2017/03/31.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class ActivitySquareServiceImpl implements ActivitySquareService {

    @Autowired
    private ActivitySquareMapper activityMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public ActivitySquareDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(activityMapper.get(id),ActivitySquareDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<ActivitySquareDTO> list(ActivitySquareQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<ActivitySquareDO> activity = (Page<ActivitySquareDO>) activityMapper.list(BeanPropertiesUtils.copyProperties(bean, ActivitySquareDO.class));
        Pagination<ActivitySquareDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(activity, ActivitySquareDTO.class));
        result.setTotal(activity.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(ActivitySquareSaveBO bean){
        ActivitySquareDO activity = BeanPropertiesUtils.copyProperties(bean, ActivitySquareDO.class);
        activity.setGmtCreate(new Date());
        activityMapper.save(activity);
        return activity.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(ActivitySquareUpdateBO bean){
        ActivitySquareDO activity = BeanPropertiesUtils.copyProperties(bean, ActivitySquareDO.class);
        activity.setGmtModified(new Date());
        return activityMapper.update(activity);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(ActivitySquareRemoveBO bean){
        ActivitySquareDO activity = BeanPropertiesUtils.copyProperties(bean, ActivitySquareDO.class);
        return activityMapper.remove(activity);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return activityMapper.delete(id);
        }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public List<ActivitySquareDTO> queryLuceneList(ActivitySquareQUERY bean){
        List<ActivitySquareDO> trainDOList = activityMapper.list(BeanPropertiesUtils.copyProperties(bean, ActivitySquareDO.class));
        return BeanPropertiesUtils.covert2List(trainDOList, ActivitySquareDTO.class);
    }

    /**
     * 查询未添加到索引的总数据条数
     * @return 未索引的数据总条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer queryUnIndexTotalNum(){
        return activityMapper.queryUnIndexTotalNum();
    }

    /**
     * 查询已添加到索引的总数据条数
     * @return 未索引的数据总条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer queryIndexTotalNum(){
        return activityMapper.queryIndexTotalNum();
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  list集合
     */
    @Override
    public List<ActivitySquareDTO> queryIndexList(ActivitySquareQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        List<ActivitySquareDO> trainApplyDOList = activityMapper.queryIndexList(BeanPropertiesUtils.copyProperties(bean, ActivitySquareDO.class));
        return BeanPropertiesUtils.covert2List(trainApplyDOList, ActivitySquareDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  list集合
     */
    @Override
    public List<ActivitySquareDTO> queryUnIndexList(ActivitySquareQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        List<ActivitySquareDO> trainApplyDOList = activityMapper.queryUnIndexList(BeanPropertiesUtils.copyProperties(bean, ActivitySquareDO.class));
        return BeanPropertiesUtils.covert2List(trainApplyDOList, ActivitySquareDTO.class);
    }

    /**
     * 更新索引时间 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer updateIndexTime(ActivitySquareUpdateBO bean){
        ActivitySquareDO activityDO = BeanPropertiesUtils.copyProperties(bean, ActivitySquareDO.class);
        return activityMapper.updateIndexTime(activityDO);
    }

}
