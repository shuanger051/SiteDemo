package cn.qweb.cms.biz.service.impl;


import cn.qweb.cms.biz.domain.TrainSquareApplyDO;
import cn.qweb.cms.biz.domain.TrainSquareApplyMapper;
import cn.qweb.cms.biz.service.TrainSquareApplyService;
import cn.qweb.cms.biz.service.bo.TrainSquareApplyRemoveBO;
import cn.qweb.cms.biz.service.bo.TrainSquareApplySaveBO;
import cn.qweb.cms.biz.service.bo.TrainSquareApplyUpdateBO;
import cn.qweb.cms.biz.service.dto.TrainSquareApplyDTO;
import cn.qweb.cms.biz.service.query.TrainSquareApplyQUERY;
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
public class TrainSquareApplyServiceImpl implements TrainSquareApplyService {

    @Autowired
    private TrainSquareApplyMapper trainApplyMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public TrainSquareApplyDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(trainApplyMapper.get(id),TrainSquareApplyDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<TrainSquareApplyDTO> list(TrainSquareApplyQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<TrainSquareApplyDO> trainApply = (Page<TrainSquareApplyDO>) trainApplyMapper.list(BeanPropertiesUtils.copyProperties(bean, TrainSquareApplyDO.class));
        Pagination<TrainSquareApplyDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(trainApply, TrainSquareApplyDTO.class));
        result.setTotal(trainApply.getTotal());
        return result;
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  list集合
     */
    @Override
    public List<TrainSquareApplyDTO> queryList(TrainSquareApplyQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        List<TrainSquareApplyDO> trainApplyDOList = trainApplyMapper.list(BeanPropertiesUtils.copyProperties(bean, TrainSquareApplyDO.class));
        return BeanPropertiesUtils.covert2List(trainApplyDOList, TrainSquareApplyDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  list集合
     */
    @Override
    public List<TrainSquareApplyDTO> queryUnIndexList(TrainSquareApplyQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        List<TrainSquareApplyDO> trainApplyDOList = trainApplyMapper.queryUnIndexList(BeanPropertiesUtils.copyProperties(bean, TrainSquareApplyDO.class));
        return BeanPropertiesUtils.covert2List(trainApplyDOList, TrainSquareApplyDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  list集合
     */
    @Override
    public List<TrainSquareApplyDTO> queryIndexList(TrainSquareApplyQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        List<TrainSquareApplyDO> trainApplyDOList = trainApplyMapper.queryIndexList(BeanPropertiesUtils.copyProperties(bean, TrainSquareApplyDO.class));
        return BeanPropertiesUtils.covert2List(trainApplyDOList, TrainSquareApplyDTO.class);
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(TrainSquareApplySaveBO bean){
        //判断是否报过名
        TrainSquareApplyDO query = new TrainSquareApplyDO();
        query.setIdNo(bean.getIdNo());
        query.setContentId(bean.getContentId());
        if(trainApplyMapper.list(query).size() > 0){
            throw new BizException(ErrorBuilder.buildBizError("您已报名"));
        }
        TrainSquareApplyDO trainApply = BeanPropertiesUtils.copyProperties(bean, TrainSquareApplyDO.class);
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
    public Integer doUpdate(TrainSquareApplyUpdateBO bean){
        TrainSquareApplyDO trainApply = BeanPropertiesUtils.copyProperties(bean, TrainSquareApplyDO.class);
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
    public Integer updateIndexTime(TrainSquareApplyUpdateBO bean){
        TrainSquareApplyDO trainApply = BeanPropertiesUtils.copyProperties(bean, TrainSquareApplyDO.class);
        return trainApplyMapper.updateIndexTime(trainApply);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(TrainSquareApplyRemoveBO bean){
        TrainSquareApplyDO trainApply = BeanPropertiesUtils.copyProperties(bean, TrainSquareApplyDO.class);
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
    public Integer checkExport(TrainSquareApplyQUERY trainSquareApplyQUERY){
        return trainApplyMapper.checkExport(BeanPropertiesUtils.copyProperties(trainSquareApplyQUERY, TrainSquareApplyDO.class));
    }

}
