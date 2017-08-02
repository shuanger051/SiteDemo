package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.service.TrainService;
import cn.qweb.cms.biz.domain.TrainMapper;
import cn.qweb.cms.biz.domain.TrainDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;

import cn.qweb.cms.biz.service.bo.TrainSaveBO;
import cn.qweb.cms.biz.service.query.TrainQUERY;
import cn.qweb.cms.biz.service.bo.TrainRemoveBO;
import cn.qweb.cms.biz.service.dto.TrainDTO;
import cn.qweb.cms.biz.service.bo.TrainUpdateBO;
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
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainMapper trainMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public TrainDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(trainMapper.get(id),TrainDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<TrainDTO> list(TrainQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<TrainDO> train = (Page<TrainDO>) trainMapper.list(BeanPropertiesUtils.copyProperties(bean, TrainDO.class));
        Pagination<TrainDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(train, TrainDTO.class));
        result.setTotal(train.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(TrainSaveBO bean){
        TrainDO train = BeanPropertiesUtils.copyProperties(bean, TrainDO.class);
        train.setGmtCreate(new Date());
        trainMapper.save(train);
        return train.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(TrainUpdateBO bean){
        TrainDO train = BeanPropertiesUtils.copyProperties(bean, TrainDO.class);
        train.setGmtModified(new Date());
        return trainMapper.update(train);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(TrainRemoveBO bean){
        TrainDO train = BeanPropertiesUtils.copyProperties(bean, TrainDO.class);
        return trainMapper.remove(train);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return trainMapper.delete(id);
        }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public List<TrainDTO> queryLuceneList(TrainQUERY bean){
        List<TrainDO> trainDOList = trainMapper.list(BeanPropertiesUtils.copyProperties(bean, TrainDO.class));
        return BeanPropertiesUtils.covert2List(trainDOList, TrainDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  list集合
     */
    @Override
    public List<TrainDTO> queryUnIndexList(TrainQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        List<TrainDO> trainApplyDOList = trainMapper.queryUnIndexList(BeanPropertiesUtils.copyProperties(bean, TrainDO.class));
        return BeanPropertiesUtils.covert2List(trainApplyDOList, TrainDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  list集合
     */
    @Override
    public List<TrainDTO> queryIndexList(TrainQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        List<TrainDO> trainApplyDOList = trainMapper.queryIndexList(BeanPropertiesUtils.copyProperties(bean, TrainDO.class));
        return BeanPropertiesUtils.covert2List(trainApplyDOList, TrainDTO.class);
    }

    /**
     * 更新索引时间 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer updateIndexTime(TrainUpdateBO bean){
        TrainDO train = BeanPropertiesUtils.copyProperties(bean, TrainDO.class);
        return trainMapper.updateIndexTime(train);
    }

    /**
     * 查询未添加到索引的总数据条数
     * @return 未索引的数据总条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer queryUnIndexTotalNum(){
        return trainMapper.queryUnIndexTotalNum();
    }

    /**
     * 查询已添加到索引的总数据条数
     * @return 未索引的数据总条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer queryIndexTotalNum(){
        return trainMapper.queryIndexTotalNum();
    }


}
