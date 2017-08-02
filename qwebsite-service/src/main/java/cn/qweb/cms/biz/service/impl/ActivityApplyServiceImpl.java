package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.domain.ActivityApplyDO;
import cn.qweb.cms.biz.domain.ActivityApplyMapper;
import cn.qweb.cms.biz.service.ActivityApplyService;
import cn.qweb.cms.biz.service.bo.ActivityApplyRemoveBO;
import cn.qweb.cms.biz.service.bo.ActivityApplySaveBO;
import cn.qweb.cms.biz.service.bo.ActivityApplyUpdateBO;
import cn.qweb.cms.biz.service.dto.ActivityApplyDTO;
import cn.qweb.cms.biz.service.query.ActivityApplyQUERY;
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
public class ActivityApplyServiceImpl implements ActivityApplyService {

    @Autowired
    private ActivityApplyMapper activityApplyMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public ActivityApplyDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(activityApplyMapper.get(id),ActivityApplyDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<ActivityApplyDTO> list(ActivityApplyQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<ActivityApplyDO> activityApply = (Page<ActivityApplyDO>) activityApplyMapper.list(BeanPropertiesUtils.copyProperties(bean, ActivityApplyDO.class));
        Pagination<ActivityApplyDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(activityApply, ActivityApplyDTO.class));
        result.setTotal(activityApply.getTotal());
        return result;
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  list集合
     */
    @Override
    public List<ActivityApplyDTO> queryList(ActivityApplyQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        List<ActivityApplyDO> activityApplyDOList = activityApplyMapper.list(BeanPropertiesUtils.copyProperties(bean, ActivityApplyDO.class));
        return BeanPropertiesUtils.covert2List(activityApplyDOList, ActivityApplyDTO.class);
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(ActivityApplySaveBO bean){
        //判断是否报过名
        ActivityApplyDO query = new ActivityApplyDO();
        query.setIdNo(bean.getIdNo());
        query.setContentId(bean.getContentId());
        if(activityApplyMapper.list(query).size() > 0){
            throw new BizException(ErrorBuilder.buildBizError("您已报名"));
        }
        ActivityApplyDO activityApply = BeanPropertiesUtils.copyProperties(bean, ActivityApplyDO.class);
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
    public Integer doUpdate(ActivityApplyUpdateBO bean){
        ActivityApplyDO activityApply = BeanPropertiesUtils.copyProperties(bean, ActivityApplyDO.class);
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
    public Integer doRemove(ActivityApplyRemoveBO bean){
        ActivityApplyDO activityApply = BeanPropertiesUtils.copyProperties(bean, ActivityApplyDO.class);
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
    public Integer checkExport(ActivityApplyQUERY competitionApplyQUERY){
        return activityApplyMapper.checkExport(BeanPropertiesUtils.copyProperties(competitionApplyQUERY, ActivityApplyDO.class));
    }

}
