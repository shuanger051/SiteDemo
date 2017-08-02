package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.domain.CompetitionSquareApplyDO;
import cn.qweb.cms.biz.domain.CompetitionSquareApplyMapper;
import cn.qweb.cms.biz.service.CompetitionSquareApplyService;
import cn.qweb.cms.biz.service.bo.CompetitionSquareApplyRemoveBO;
import cn.qweb.cms.biz.service.bo.CompetitionSquareApplySaveBO;
import cn.qweb.cms.biz.service.bo.CompetitionSquareApplyUpdateBO;
import cn.qweb.cms.biz.service.dto.CompetitionSquareApplyDTO;
import cn.qweb.cms.biz.service.query.CompetitionSquareApplyQUERY;
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

/*
 *  Created by xuebj - 2017/05/24.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class CompetitionSquareApplyServiceImpl implements CompetitionSquareApplyService {

    @Autowired
    private CompetitionSquareApplyMapper competitionApplyMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public CompetitionSquareApplyDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(competitionApplyMapper.get(id),CompetitionSquareApplyDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<CompetitionSquareApplyDTO> list(CompetitionSquareApplyQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<CompetitionSquareApplyDO> competitionApply = (Page<CompetitionSquareApplyDO>) competitionApplyMapper.list(BeanPropertiesUtils.copyProperties(bean, CompetitionSquareApplyDO.class));
        Pagination<CompetitionSquareApplyDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(competitionApply, CompetitionSquareApplyDTO.class));
        result.setTotal(competitionApply.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(CompetitionSquareApplySaveBO bean){
        //判断是否报过名
        CompetitionSquareApplyDO query = new CompetitionSquareApplyDO();
        query.setMobile(bean.getMobile());
        query.setContentId(bean.getContentId());
        if(competitionApplyMapper.list(query).size() > 0){
            throw new BizException(ErrorBuilder.buildBizError("您已报名"));
        }
        CompetitionSquareApplyDO competitionApply = BeanPropertiesUtils.copyProperties(bean, CompetitionSquareApplyDO.class);
        competitionApply.setGmtCreate(new Date());
        competitionApplyMapper.save(competitionApply);
        return competitionApply.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(CompetitionSquareApplyUpdateBO bean){
        CompetitionSquareApplyDO competitionApply = BeanPropertiesUtils.copyProperties(bean, CompetitionSquareApplyDO.class);
        competitionApply.setGmtModified(new Date());
        return competitionApplyMapper.update(competitionApply);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(CompetitionSquareApplyRemoveBO bean){
        CompetitionSquareApplyDO competitionApply = BeanPropertiesUtils.copyProperties(bean, CompetitionSquareApplyDO.class);
        return competitionApplyMapper.remove(competitionApply);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return competitionApplyMapper.delete(id);
    }

    /**
     * 查询需要导出的数据总条数
     * @return 查询需要导出的数据总条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer checkExport(CompetitionSquareApplyQUERY competitionSquareApplyQUERY){
        return competitionApplyMapper.checkExport(BeanPropertiesUtils.copyProperties(competitionSquareApplyQUERY, CompetitionSquareApplyDO.class));
    }

}
