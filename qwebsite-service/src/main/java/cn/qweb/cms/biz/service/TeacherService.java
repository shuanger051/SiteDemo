
package cn.qweb.cms.biz.service;
import cn.qweb.cms.biz.service.bo.TeacherRemoveBO;
import cn.qweb.cms.biz.service.bo.TeacherSaveBO;
import cn.qweb.cms.biz.service.bo.TeacherUpdateBO;
import cn.qweb.cms.biz.service.dto.TeacherDTO;
import cn.qweb.cms.biz.service.query.TeacherQUERY;
import cn.qweb.cms.core.base.Pagination;

import java.util.List;

/*
 *  Created by xuebj - 2017/04/06.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public interface TeacherService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    TeacherDTO get(Long id);

    /**
     * 获取下一篇
     * @param id    当前id
     * @param type  类型
     * @param level 级别
     * @param next  根据文章ID，大者为下一篇，小者为上一篇。true：下一篇；fasle：上一篇。
     * @return
     */
    TeacherDTO getNext(Long id,String type,Integer level,Boolean next);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<TeacherDTO> list(TeacherQUERY bean);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return
     */
    List<TeacherDTO> queryList(TeacherQUERY bean);

    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(TeacherSaveBO bean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(TeacherUpdateBO bean);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(TeacherRemoveBO bean);

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    Integer doRemove(Long id);

}