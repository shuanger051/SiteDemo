package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.domain.TrainSquareDO;
import cn.qweb.cms.biz.domain.TrainSquareMapper;
import cn.qweb.cms.biz.service.TrainSquareService;
import cn.qweb.cms.biz.service.bo.TrainSquareRemoveBO;
import cn.qweb.cms.biz.service.bo.TrainSquareSaveBO;
import cn.qweb.cms.biz.service.bo.TrainSquareUpdateBO;
import cn.qweb.cms.biz.service.dto.TrainSquareDTO;
import cn.qweb.cms.biz.service.query.TrainSquareQUERY;
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
public class TrainSquareServiceImpl implements TrainSquareService {

    @Autowired
    private TrainSquareMapper trainMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public TrainSquareDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(trainMapper.get(id),TrainSquareDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<TrainSquareDTO> list(TrainSquareQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<TrainSquareDO> train = (Page<TrainSquareDO>) trainMapper.list(BeanPropertiesUtils.copyProperties(bean, TrainSquareDO.class));
        Pagination<TrainSquareDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(train, TrainSquareDTO.class));
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
    public Long doSave(TrainSquareSaveBO bean){
        TrainSquareDO train = BeanPropertiesUtils.copyProperties(bean, TrainSquareDO.class);
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
    public Integer doUpdate(TrainSquareUpdateBO bean){
        TrainSquareDO train = BeanPropertiesUtils.copyProperties(bean, TrainSquareDO.class);
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
    public Integer doRemove(TrainSquareRemoveBO bean){
        TrainSquareDO train = BeanPropertiesUtils.copyProperties(bean, TrainSquareDO.class);
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
    public List<TrainSquareDTO> queryLuceneList(TrainSquareQUERY bean){
        List<TrainSquareDO> trainDOList = trainMapper.list(BeanPropertiesUtils.copyProperties(bean, TrainSquareDO.class));
        return BeanPropertiesUtils.covert2List(trainDOList, TrainSquareDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  list集合
     */
    @Override
    public List<TrainSquareDTO> queryUnIndexList(TrainSquareQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        List<TrainSquareDO> trainApplyDOList = trainMapper.queryUnIndexList(BeanPropertiesUtils.copyProperties(bean, TrainSquareDO.class));
        return BeanPropertiesUtils.covert2List(trainApplyDOList, TrainSquareDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  list集合
     */
    @Override
    public List<TrainSquareDTO> queryIndexList(TrainSquareQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        List<TrainSquareDO> trainApplyDOList = trainMapper.queryIndexList(BeanPropertiesUtils.copyProperties(bean, TrainSquareDO.class));
        return BeanPropertiesUtils.covert2List(trainApplyDOList, TrainSquareDTO.class);
    }

    /**
     * 更新索引时间 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer updateIndexTime(TrainSquareUpdateBO bean){
        TrainSquareDO train = BeanPropertiesUtils.copyProperties(bean, TrainSquareDO.class);
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
