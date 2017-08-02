package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.domain.TeacherDO;
import cn.qweb.cms.biz.domain.TeacherMapper;
import cn.qweb.cms.biz.domain.TeacherNextDO;
import cn.qweb.cms.biz.service.TeacherService;
import cn.qweb.cms.biz.service.bo.TeacherRemoveBO;
import cn.qweb.cms.biz.service.bo.TeacherSaveBO;
import cn.qweb.cms.biz.service.bo.TeacherUpdateBO;
import cn.qweb.cms.biz.service.dto.TeacherDTO;
import cn.qweb.cms.biz.service.query.TeacherQUERY;
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
 *  Created by xuebj - 2017/04/06.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public TeacherDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(teacherMapper.get(id),TeacherDTO.class);
    }

    @Override
    public TeacherDTO getNext(Long id, String type, Integer level, Boolean next) {
        TeacherNextDO bean = new TeacherNextDO();
        PageHelper.startPage(1,1);
        bean.setId(id);
        bean.setLevel(level);
        bean.setNext(next);
        bean.setType(type);
        Page<TeacherDO> teachers = (Page<TeacherDO>) teacherMapper.getNext(bean);
        if(!teachers.isEmpty()){
            return BeanPropertiesUtils.copyProperties(teachers.get(0),TeacherDTO.class);
        }
        return null;
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<TeacherDTO> list(TeacherQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<TeacherDO> teacher = (Page<TeacherDO>) teacherMapper.list(BeanPropertiesUtils.copyProperties(bean, TeacherDO.class));
        Pagination<TeacherDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(teacher, TeacherDTO.class));
        result.setTotal(teacher.getTotal());
        return result;
    }

    /**
     * 查询对象列表
     *
     * @param bean 查询条件对象
     * @return
     */
    @Override
    public List<TeacherDTO> queryList(TeacherQUERY bean) {
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        List<TeacherDO> teachers =  teacherMapper.list(BeanPropertiesUtils.copyProperties(bean, TeacherDO.class));
        return BeanPropertiesUtils.covert2List(teachers,TeacherDTO.class);
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(TeacherSaveBO bean){
        TeacherDO teacher = BeanPropertiesUtils.copyProperties(bean, TeacherDO.class);
        teacher.setGmtCreate(new Date());
        teacherMapper.save(teacher);
        return teacher.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(TeacherUpdateBO bean){
        TeacherDO teacher = BeanPropertiesUtils.copyProperties(bean, TeacherDO.class);
        teacher.setGmtModified(new Date());
        return teacherMapper.update(teacher);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(TeacherRemoveBO bean){
        TeacherDO teacher = BeanPropertiesUtils.copyProperties(bean, TeacherDO.class);
        return teacherMapper.remove(teacher);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return teacherMapper.delete(id);
        }
}
