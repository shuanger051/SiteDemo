
package cn.qweb.cms.biz.service;
import java.util.List;
import cn.qweb.cms.biz.service.bo.ContentExtSaveBO;
import cn.qweb.cms.biz.service.query.ContentExtQUERY;
import cn.qweb.cms.biz.service.bo.ContentExtRemoveBO;
import cn.qweb.cms.biz.service.dto.ContentExtDTO;
import cn.qweb.cms.biz.service.bo.ContentExtUpdateBO;
import cn.qweb.cms.core.base.Pagination;

/*
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public interface ContentExtService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    ContentExtDTO get(Long id);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<ContentExtDTO> list(ContentExtQUERY bean);

    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(ContentExtSaveBO bean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(ContentExtUpdateBO bean);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(ContentExtRemoveBO bean);

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    Integer doRemove(Long id);

    /**
     * 查询未添加到索引的总数据条数
     * @return 未索引的数据总条数
     */
    Integer queryUnIndexTotalNum();

    /**
     * 分页查询未索引数据
     * @param bean
     * @return
     */
    List<ContentExtDTO> queryUnIndexList(ContentExtQUERY bean);

    /**
     * 查询已添加到索引的总数据条数
     * @return
     */
    Integer queryIndexTotalNum();

    List<ContentExtDTO> queryIndexList(ContentExtQUERY bean);

    /**
     * 更新索引时间 ID 必须有
     * @param bean
     * @return
     */
    Integer updateIndexTime(ContentExtUpdateBO bean);

    /**
     * 根据contentID查询当前所属栏目
     * @param contentID
     * @return
     */
    String queryChannelByContentID(Long contentID);

}