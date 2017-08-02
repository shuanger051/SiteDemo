
package cn.qweb.cms.biz.service;
import java.util.List;
import cn.qweb.cms.biz.service.bo.FriendlinkCtgSaveBO;
import cn.qweb.cms.biz.service.query.FriendlinkCtgQUERY;
import cn.qweb.cms.biz.service.bo.FriendlinkCtgRemoveBO;
import cn.qweb.cms.biz.service.dto.FriendlinkCtgDTO;
import cn.qweb.cms.biz.service.bo.FriendlinkCtgUpdateBO;
import cn.qweb.cms.core.base.Pagination;

/*
 *  Created by xuebj - 2017/03/20.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public interface FriendlinkCtgService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    FriendlinkCtgDTO get(Long id);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<FriendlinkCtgDTO> list(FriendlinkCtgQUERY bean);

    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(FriendlinkCtgSaveBO bean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(FriendlinkCtgUpdateBO bean);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(FriendlinkCtgRemoveBO bean);

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    Integer doRemove(Long id);

}