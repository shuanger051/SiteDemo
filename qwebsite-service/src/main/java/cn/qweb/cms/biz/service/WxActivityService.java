
package cn.qweb.cms.biz.service;
import cn.qweb.cms.biz.service.bo.WxActivityRemoveBO;
import cn.qweb.cms.biz.service.bo.WxActivitySaveBO;
import cn.qweb.cms.biz.service.bo.WxActivityUpdateBO;
import cn.qweb.cms.biz.service.dto.LessonNumberDTO;
import cn.qweb.cms.biz.service.dto.WxActivityDTO;
import cn.qweb.cms.biz.service.query.WxActivityQUERY;
import cn.qweb.cms.core.base.Pagination;

/*
 *  Created by xuebj - 2017/05/03.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public interface WxActivityService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    WxActivityDTO get(Long id);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<WxActivityDTO> list(WxActivityQUERY bean);

    /**
     * 统计各个课程的数量
     * @param bean
     * @return
     */
    LessonNumberDTO queryNumber(WxActivityQUERY bean);


    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(WxActivitySaveBO bean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(WxActivityUpdateBO bean);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(WxActivityRemoveBO bean);

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    Integer doRemove(Long id);

}