package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.domain.CompetitionSquareDO;
import cn.qweb.cms.biz.domain.CompetitionSquareMapper;
import cn.qweb.cms.biz.service.CompetitionSquareService;
import cn.qweb.cms.biz.service.bo.CompetitionSquareRemoveBO;
import cn.qweb.cms.biz.service.bo.CompetitionSquareSaveBO;
import cn.qweb.cms.biz.service.bo.CompetitionSquareUpdateBO;
import cn.qweb.cms.biz.service.dto.CompetitionSquareDTO;
import cn.qweb.cms.biz.service.query.CompetitionSquareQUERY;
import cn.qweb.cms.core.base.Pagination;
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
public class CompetitionSquareServiceImpl implements CompetitionSquareService {

    @Autowired
    private CompetitionSquareMapper competitionMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public CompetitionSquareDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(competitionMapper.get(id),CompetitionSquareDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<CompetitionSquareDTO> list(CompetitionSquareQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<CompetitionSquareDO> competition = (Page<CompetitionSquareDO>) competitionMapper.list(BeanPropertiesUtils.copyProperties(bean, CompetitionSquareDO.class));
        Pagination<CompetitionSquareDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(competition, CompetitionSquareDTO.class));
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
    public Long doSave(CompetitionSquareSaveBO bean){
        CompetitionSquareDO competition = BeanPropertiesUtils.copyProperties(bean, CompetitionSquareDO.class);
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
    public Integer doUpdate(CompetitionSquareUpdateBO bean){
        CompetitionSquareDO competition = BeanPropertiesUtils.copyProperties(bean, CompetitionSquareDO.class);
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
    public Integer doRemove(CompetitionSquareRemoveBO bean){
        CompetitionSquareDO competition = BeanPropertiesUtils.copyProperties(bean, CompetitionSquareDO.class);
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
