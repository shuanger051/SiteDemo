package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.service.ActivityService;
import cn.qweb.cms.biz.domain.ActivityMapper;
import cn.qweb.cms.biz.domain.ActivityDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;

import cn.qweb.cms.biz.service.bo.ActivitySaveBO;
import cn.qweb.cms.biz.service.query.ActivityQUERY;
import cn.qweb.cms.biz.service.bo.ActivityRemoveBO;
import cn.qweb.cms.biz.service.dto.ActivityDTO;
import cn.qweb.cms.biz.service.bo.ActivityUpdateBO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
 *  Created by xuebj - 2017/03/31.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public ActivityDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(activityMapper.get(id),ActivityDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<ActivityDTO> list(ActivityQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<ActivityDO> activity = (Page<ActivityDO>) activityMapper.list(BeanPropertiesUtils.copyProperties(bean, ActivityDO.class));
        Pagination<ActivityDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(activity, ActivityDTO.class));
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
    public Long doSave(ActivitySaveBO bean){
        ActivityDO activity = BeanPropertiesUtils.copyProperties(bean, ActivityDO.class);
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
    public Integer doUpdate(ActivityUpdateBO bean){
        ActivityDO activity = BeanPropertiesUtils.copyProperties(bean, ActivityDO.class);
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
    public Integer doRemove(ActivityRemoveBO bean){
        ActivityDO activity = BeanPropertiesUtils.copyProperties(bean, ActivityDO.class);
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
    public List<ActivityDTO> queryLuceneList(ActivityQUERY bean){
        List<ActivityDO> trainDOList = activityMapper.list(BeanPropertiesUtils.copyProperties(bean, ActivityDO.class));
        return BeanPropertiesUtils.covert2List(trainDOList, ActivityDTO.class);
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
    public List<ActivityDTO> queryIndexList(ActivityQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        List<ActivityDO> trainApplyDOList = activityMapper.queryIndexList(BeanPropertiesUtils.copyProperties(bean, ActivityDO.class));
        return BeanPropertiesUtils.covert2List(trainApplyDOList, ActivityDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  list集合
     */
    @Override
    public List<ActivityDTO> queryUnIndexList(ActivityQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        List<ActivityDO> trainApplyDOList = activityMapper.queryUnIndexList(BeanPropertiesUtils.copyProperties(bean, ActivityDO.class));
        return BeanPropertiesUtils.covert2List(trainApplyDOList, ActivityDTO.class);
    }

    /**
     * 更新索引时间 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer updateIndexTime(ActivityUpdateBO bean){
        ActivityDO activityDO = BeanPropertiesUtils.copyProperties(bean, ActivityDO.class);
        return activityMapper.updateIndexTime(activityDO);
    }

}
