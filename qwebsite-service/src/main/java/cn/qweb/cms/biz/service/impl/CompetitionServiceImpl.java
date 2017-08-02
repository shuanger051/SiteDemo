package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.service.CompetitionService;
import cn.qweb.cms.biz.domain.CompetitionMapper;
import cn.qweb.cms.biz.domain.CompetitionDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;

import cn.qweb.cms.biz.service.bo.CompetitionSaveBO;
import cn.qweb.cms.biz.service.query.CompetitionQUERY;
import cn.qweb.cms.biz.service.bo.CompetitionRemoveBO;
import cn.qweb.cms.biz.service.dto.CompetitionDTO;
import cn.qweb.cms.biz.service.bo.CompetitionUpdateBO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
 *  Created by xuebj - 2017/05/24.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    private CompetitionMapper competitionMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public CompetitionDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(competitionMapper.get(id),CompetitionDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<CompetitionDTO> list(CompetitionQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<CompetitionDO> competition = (Page<CompetitionDO>) competitionMapper.list(BeanPropertiesUtils.copyProperties(bean, CompetitionDO.class));
        Pagination<CompetitionDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(competition, CompetitionDTO.class));
        result.setTotal(competition.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(CompetitionSaveBO bean){
        CompetitionDO competition = BeanPropertiesUtils.copyProperties(bean, CompetitionDO.class);
        competition.setGmtCreate(new Date());
        competitionMapper.save(competition);
        return competition.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(CompetitionUpdateBO bean){
        CompetitionDO competition = BeanPropertiesUtils.copyProperties(bean, CompetitionDO.class);
        competition.setGmtModified(new Date());
        return competitionMapper.update(competition);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(CompetitionRemoveBO bean){
        CompetitionDO competition = BeanPropertiesUtils.copyProperties(bean, CompetitionDO.class);
        return competitionMapper.remove(competition);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return competitionMapper.delete(id);
        }
}
