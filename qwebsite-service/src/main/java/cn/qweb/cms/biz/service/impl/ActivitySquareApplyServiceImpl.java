package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.domain.ActivitySquareApplyDO;
import cn.qweb.cms.biz.domain.ActivitySquareApplyMapper;
import cn.qweb.cms.biz.service.ActivitySquareApplyService;
import cn.qweb.cms.biz.service.bo.ActivitySquareApplyRemoveBO;
import cn.qweb.cms.biz.service.bo.ActivitySquareApplySaveBO;
import cn.qweb.cms.biz.service.bo.ActivitySquareApplyUpdateBO;
import cn.qweb.cms.biz.service.dto.ActivitySquareApplyDTO;
import cn.qweb.cms.biz.service.query.ActivitySquareApplyQUERY;
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
 *  Created by xuebj - 2017/03/20.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class ActivitySquareApplyServiceImpl implements ActivitySquareApplyService {

    @Autowired
    private ActivitySquareApplyMapper activityApplyMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public ActivitySquareApplyDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(activityApplyMapper.get(id),ActivitySquareApplyDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<ActivitySquareApplyDTO> list(ActivitySquareApplyQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<ActivitySquareApplyDO> activityApply = (Page<ActivitySquareApplyDO>) activityApplyMapper.list(BeanPropertiesUtils.copyProperties(bean, ActivitySquareApplyDO.class));
        Pagination<ActivitySquareApplyDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(activityApply, ActivitySquareApplyDTO.class));
        result.setTotal(activityApply.getTotal());
        return result;
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  list集合
     */
    @Override
    public List<ActivitySquareApplyDTO> queryList(ActivitySquareApplyQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        List<ActivitySquareApplyDO> activityApplyDOList = activityApplyMapper.list(BeanPropertiesUtils.copyProperties(bean, ActivitySquareApplyDO.class));
        return BeanPropertiesUtils.covert2List(activityApplyDOList, ActivitySquareApplyDTO.class);
    }
    

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(ActivitySquareApplySaveBO bean){
        //判断是否报过名
        ActivitySquareApplyDO query = new ActivitySquareApplyDO();
        query.setIdNo(bean.getIdNo());
        query.setContentId(bean.getContentId());
        if(activityApplyMapper.list(query).size() > 0){
            throw new BizException(ErrorBuilder.buildBizError("您已报名"));
        }
        ActivitySquareApplyDO activityApply = BeanPropertiesUtils.copyProperties(bean, ActivitySquareApplyDO.class);
        activityApply.setGmtCreate(new Date());
        activityApplyMapper.save(activityApply);
        return activityApply.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(ActivitySquareApplyUpdateBO bean){
        ActivitySquareApplyDO activityApply = BeanPropertiesUtils.copyProperties(bean, ActivitySquareApplyDO.class);
        activityApply.setGmtModified(new Date());
        return activityApplyMapper.update(activityApply);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(ActivitySquareApplyRemoveBO bean){
        ActivitySquareApplyDO activityApply = BeanPropertiesUtils.copyProperties(bean, ActivitySquareApplyDO.class);
        return activityApplyMapper.remove(activityApply);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return activityApplyMapper.delete(id);
    }

    /**
     * 查询需要导出的数据总条数
     * @return 查询需要导出的数据总条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer checkExport(ActivitySquareApplyQUERY activitySquareApplyQUERY){
        return activityApplyMapper.checkExport(BeanPropertiesUtils.copyProperties(activitySquareApplyQUERY, ActivitySquareApplyDO.class));
    }

}
