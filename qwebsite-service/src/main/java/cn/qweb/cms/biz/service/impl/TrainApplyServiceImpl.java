package cn.qweb.cms.biz.service.impl;


import cn.qweb.cms.biz.domain.TrainApplyDO;
import cn.qweb.cms.biz.domain.TrainApplyMapper;
import cn.qweb.cms.biz.service.TrainApplyService;
import cn.qweb.cms.biz.service.bo.TrainApplyRemoveBO;
import cn.qweb.cms.biz.service.bo.TrainApplySaveBO;
import cn.qweb.cms.biz.service.bo.TrainApplyUpdateBO;
import cn.qweb.cms.biz.service.dto.TrainApplyDTO;
import cn.qweb.cms.biz.service.query.TrainApplyQUERY;
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
import java.util.List;

/*
 *  Created by xuebj - 2017/03/29.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class TrainApplyServiceImpl implements TrainApplyService {

    @Autowired
    private TrainApplyMapper trainApplyMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public TrainApplyDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(trainApplyMapper.get(id),TrainApplyDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<TrainApplyDTO> list(TrainApplyQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<TrainApplyDO> trainApply = (Page<TrainApplyDO>) trainApplyMapper.list(BeanPropertiesUtils.copyProperties(bean, TrainApplyDO.class));
        Pagination<TrainApplyDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(trainApply, TrainApplyDTO.class));
        result.setTotal(trainApply.getTotal());
        return result;
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  list集合
     */
    @Override
    public List<TrainApplyDTO> queryList(TrainApplyQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        List<TrainApplyDO> trainApplyDOList = trainApplyMapper.list(BeanPropertiesUtils.copyProperties(bean, TrainApplyDO.class));
        return BeanPropertiesUtils.covert2List(trainApplyDOList, TrainApplyDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  list集合
     */
    @Override
    public List<TrainApplyDTO> queryUnIndexList(TrainApplyQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        List<TrainApplyDO> trainApplyDOList = trainApplyMapper.queryUnIndexList(BeanPropertiesUtils.copyProperties(bean, TrainApplyDO.class));
        return BeanPropertiesUtils.covert2List(trainApplyDOList, TrainApplyDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  list集合
     */
    @Override
    public List<TrainApplyDTO> queryIndexList(TrainApplyQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        List<TrainApplyDO> trainApplyDOList = trainApplyMapper.queryIndexList(BeanPropertiesUtils.copyProperties(bean, TrainApplyDO.class));
        return BeanPropertiesUtils.covert2List(trainApplyDOList, TrainApplyDTO.class);
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(TrainApplySaveBO bean){
        //判断是否报过名
        TrainApplyDO query = new TrainApplyDO();
        query.setIdNo(bean.getIdNo());
        query.setContentId(bean.getContentId());
        if(trainApplyMapper.list(query).size() > 0){
            throw new BizException(ErrorBuilder.buildBizError("您已报名"));
        }
        TrainApplyDO trainApply = BeanPropertiesUtils.copyProperties(bean, TrainApplyDO.class);
        trainApply.setGmtCreate(new Date());
        trainApplyMapper.save(trainApply);
        return trainApply.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(TrainApplyUpdateBO bean){
        TrainApplyDO trainApply = BeanPropertiesUtils.copyProperties(bean, TrainApplyDO.class);
        trainApply.setGmtModified(new Date());
        return trainApplyMapper.update(trainApply);
    }

    /**
     * 更新索引时间 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer updateIndexTime(TrainApplyUpdateBO bean){
        TrainApplyDO trainApply = BeanPropertiesUtils.copyProperties(bean, TrainApplyDO.class);
        return trainApplyMapper.updateIndexTime(trainApply);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(TrainApplyRemoveBO bean){
        TrainApplyDO trainApply = BeanPropertiesUtils.copyProperties(bean, TrainApplyDO.class);
        return trainApplyMapper.remove(trainApply);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return trainApplyMapper.delete(id);
        }

    /**
     * 查询未添加到索引的总数据条数
     * @return 未索引的数据总条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer queryUnIndexTotalNum(){
        return trainApplyMapper.queryUnIndexTotalNum();
    }

    /**
     * 查询已添加到索引的总数据条数
     * @return 未索引的数据总条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer queryIndexTotalNum(){
        return trainApplyMapper.queryIndexTotalNum();
    }

    /**
     * 查询需要导出的数据总条数
     * @return 查询需要导出的数据总条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer checkExport(TrainApplyQUERY trainApplyQUERY){
        return trainApplyMapper.checkExport(BeanPropertiesUtils.copyProperties(trainApplyQUERY, TrainApplyDO.class));
    }

}
