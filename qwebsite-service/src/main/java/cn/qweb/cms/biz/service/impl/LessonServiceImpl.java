package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.domain.LessonDO;
import cn.qweb.cms.biz.domain.LessonMapper;
import cn.qweb.cms.biz.service.LessonService;
import cn.qweb.cms.biz.service.bo.LessonRemoveBO;
import cn.qweb.cms.biz.service.bo.LessonSaveBO;
import cn.qweb.cms.biz.service.bo.LessonUpdateBO;
import cn.qweb.cms.biz.service.dto.LessonDTO;
import cn.qweb.cms.biz.service.dto.LessonNumberDTO;
import cn.qweb.cms.biz.service.query.LessonQUERY;
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
 *  Created by xuebj - 2017/04/20.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonMapper lessonMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public LessonDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(lessonMapper.get(id),LessonDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<LessonDTO> list(LessonQUERY bean){
        PageHelper.startPage(bean.getPage(),bean.getPageSize());
        Page<LessonDO> lesson = (Page<LessonDO>) lessonMapper.listByQuery(bean);
        Pagination<LessonDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(lesson, LessonDTO.class));
        result.setTotal(lesson.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(LessonSaveBO bean){
        LessonDO lesson = BeanPropertiesUtils.copyProperties(bean, LessonDO.class);
        lesson.setGmtCreate(new Date());
        lessonMapper.save(lesson);
        return lesson.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(LessonUpdateBO bean){
        LessonDO lesson = BeanPropertiesUtils.copyProperties(bean, LessonDO.class);
        lesson.setGmtModified(new Date());
        return lessonMapper.update(lesson);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(LessonRemoveBO bean){
        LessonDO lesson = BeanPropertiesUtils.copyProperties(bean, LessonDO.class);
        return lessonMapper.remove(lesson);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return lessonMapper.delete(id);
        }

    @Override
    public LessonNumberDTO queryLessonNumber(LessonQUERY bean) {
        PageHelper.startPage(1,1);
        LessonDO lessonDO = new LessonDO();
        lessonDO.setTeacherId(bean.getTeacherId());
        LessonNumberDTO dto = new LessonNumberDTO();
        Page<LessonDO> lesson = (Page<LessonDO>) lessonMapper.list(lessonDO);
        dto.setTotal(lesson.getTotal());
        lessonDO.setStatus("1");
        PageHelper.startPage(1,1);
        lesson = (Page<LessonDO>) lessonMapper.list(lessonDO);
        dto.setPendingCheck(lesson.getTotal());
        lessonDO.setStatus("2");
        PageHelper.startPage(1,1);
        lesson = (Page<LessonDO>) lessonMapper.list(lessonDO);
        dto.setNotPass(lesson.getTotal());
        lessonDO.setStatus("3");
        PageHelper.startPage(1,1);
        lesson = (Page<LessonDO>) lessonMapper.list(lessonDO);
        dto.setPass(lesson.getTotal());
        lessonDO.setStatus("4");
        PageHelper.startPage(1,1);
        lesson = (Page<LessonDO>) lessonMapper.list(lessonDO);
        dto.setOnline(lesson.getTotal());
        lessonDO.setStatus("5");
        PageHelper.startPage(1,1);
        lesson = (Page<LessonDO>) lessonMapper.list(lessonDO);
        dto.setUnderline(lesson.getTotal());
        return dto;
    }
}
