package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.domain.CompetitionApplyDO;
import cn.qweb.cms.biz.domain.CompetitionApplyMapper;
import cn.qweb.cms.biz.service.CompetitionApplyService;
import cn.qweb.cms.biz.service.bo.*;
import cn.qweb.cms.biz.service.dto.CompetitionApplyDTO;
import cn.qweb.cms.biz.service.query.CompetitionApplyQUERY;
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
public class CompetitionApplyServiceImpl implements CompetitionApplyService {

    @Autowired
    private CompetitionApplyMapper competitionApplyMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public CompetitionApplyDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(competitionApplyMapper.get(id),CompetitionApplyDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<CompetitionApplyDTO> list(CompetitionApplyQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<CompetitionApplyDO> competitionApply = (Page<CompetitionApplyDO>) competitionApplyMapper.list(BeanPropertiesUtils.copyProperties(bean, CompetitionApplyDO.class));
        Pagination<CompetitionApplyDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(competitionApply, CompetitionApplyDTO.class));
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
    public Long doSave(CompetitionApplySaveBO bean){
        //判断是否报过名
        CompetitionApplyDO query = new CompetitionApplyDO();
        query.setMobile(bean.getMobile());
        query.setContentId(bean.getContentId());
        if(competitionApplyMapper.list(query).size() > 0){
            throw new BizException(ErrorBuilder.buildBizError("您已报名"));
        }
        CompetitionApplyDO competitionApply = BeanPropertiesUtils.copyProperties(bean, CompetitionApplyDO.class);
        competitionApply.setGmtCreate(new Date());
        competitionApplyMapper.save(competitionApply);
        return competitionApply.getId();
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long  doSaveForSeventyYearTeam(CompetitionApplyForSeventyYearTeamSaveBO bean){
        //判断是否报过名
        CompetitionApplyDO query = new CompetitionApplyDO();
        query.setMobile(bean.getMobile());
        query.setContentId(bean.getContentId());
        if(competitionApplyMapper.list(query).size() > 0){
            throw new BizException(ErrorBuilder.buildBizError("您已报名"));
        }
        CompetitionApplyDO competitionApply = BeanPropertiesUtils.copyProperties(bean, CompetitionApplyDO.class);
        competitionApply.setGmtCreate(new Date());
        competitionApplyMapper.save(competitionApply);

        return competitionApply.getId();
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long  doSaveForSeventyYearPerson(CompetitionApplyForSeventyYearPersonSaveBO bean){
        //判断是否报过名
        CompetitionApplyDO query = new CompetitionApplyDO();
        query.setMobile(bean.getMobile());
        query.setContentId(bean.getContentId());
        if(competitionApplyMapper.list(query).size() > 0){
            throw new BizException(ErrorBuilder.buildBizError("您已报名"));
        }

        //判断是否填入团队码，若填写了团队码则根据团队码查询团队信息
        if (bean.getGroupCode() != null){
            CompetitionApplyDO competitionApplyDO = competitionApplyMapper.get(bean.getGroupCode().longValue());
            if (competitionApplyDO != null && competitionApplyDO.getId().toString().equals(competitionApplyDO.getGroupCode().toString())){
                bean.setTeamName(competitionApplyDO.getTeamName());
                bean.setCaptainName(competitionApplyDO.getCaptainName());
            }else {
                throw new BizException(ErrorBuilder.buildBizError("团队码错误"));
            }
        }

        CompetitionApplyDO competitionApply = BeanPropertiesUtils.copyProperties(bean, CompetitionApplyDO.class);
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
    public Integer doUpdate(CompetitionApplyUpdateBO bean){
        CompetitionApplyDO competitionApply = BeanPropertiesUtils.copyProperties(bean, CompetitionApplyDO.class);
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
    public Integer doRemove(CompetitionApplyRemoveBO bean){
        CompetitionApplyDO competitionApply = BeanPropertiesUtils.copyProperties(bean, CompetitionApplyDO.class);
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
    public Integer checkExport(CompetitionApplyQUERY competitionApplyQUERY){
        return competitionApplyMapper.checkExport(BeanPropertiesUtils.copyProperties(competitionApplyQUERY, CompetitionApplyDO.class));
    }

}
