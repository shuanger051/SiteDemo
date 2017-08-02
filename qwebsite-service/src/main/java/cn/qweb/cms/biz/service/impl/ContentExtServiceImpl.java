package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.service.ContentExtService;
import cn.qweb.cms.biz.domain.ContentExtMapper;
import cn.qweb.cms.biz.domain.ContentExtDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;

import cn.qweb.cms.biz.service.bo.ContentExtSaveBO;
import cn.qweb.cms.biz.service.query.ContentExtQUERY;
import cn.qweb.cms.biz.service.bo.ContentExtRemoveBO;
import cn.qweb.cms.biz.service.dto.ContentExtDTO;
import cn.qweb.cms.biz.service.bo.ContentExtUpdateBO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class ContentExtServiceImpl implements ContentExtService {

    @Autowired
    private ContentExtMapper contentExtMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public ContentExtDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(contentExtMapper.get(id),ContentExtDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<ContentExtDTO> list(ContentExtQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<ContentExtDO> contentExt = (Page<ContentExtDO>) contentExtMapper.list(BeanPropertiesUtils.copyProperties(bean, ContentExtDO.class));
        Pagination<ContentExtDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(contentExt, ContentExtDTO.class));
        result.setTotal(contentExt.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(ContentExtSaveBO bean){
        ContentExtDO contentExt = BeanPropertiesUtils.copyProperties(bean, ContentExtDO.class);
        contentExt.setGmtCreate(new Date());
        contentExtMapper.save(contentExt);
        return contentExt.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(ContentExtUpdateBO bean){
        ContentExtDO contentExt = BeanPropertiesUtils.copyProperties(bean, ContentExtDO.class);
        contentExt.setGmtModified(new Date());
        return contentExtMapper.update(contentExt);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(ContentExtRemoveBO bean){
        ContentExtDO contentExt = BeanPropertiesUtils.copyProperties(bean, ContentExtDO.class);
        return contentExtMapper.remove(contentExt);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return contentExtMapper.delete(id);
        }

    /**
     * 查询未添加到索引的总数据条数
     * @return 未索引的数据总条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer queryUnIndexTotalNum(){
        return contentExtMapper.queryUnIndexTotalNum();
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  list集合
     */
    @Override
    public List<ContentExtDTO> queryUnIndexList(ContentExtQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        List<ContentExtDO> trainApplyDOList = contentExtMapper.queryUnIndexList(BeanPropertiesUtils.copyProperties(bean, ContentExtDO.class));
        return BeanPropertiesUtils.covert2List(trainApplyDOList, ContentExtDTO.class);
    }

    /**
     * 查询已添加到索引的总数据条数
     * @return 未索引的数据总条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer queryIndexTotalNum(){
        return contentExtMapper.queryIndexTotalNum();
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  list集合
     */
    @Override
    public List<ContentExtDTO> queryIndexList(ContentExtQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        List<ContentExtDO> trainApplyDOList = contentExtMapper.queryIndexList(BeanPropertiesUtils.copyProperties(bean, ContentExtDO.class));
        return BeanPropertiesUtils.covert2List(trainApplyDOList, ContentExtDTO.class);
    }

    /**
     * 更新索引时间 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer updateIndexTime(ContentExtUpdateBO bean){
        ContentExtDO contentExtDO = BeanPropertiesUtils.copyProperties(bean, ContentExtDO.class);
        return contentExtMapper.updateIndexTime(contentExtDO);
    }


    /**
     * 根据contentID查询出所属栏目
     * @param contentID
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public String queryChannelByContentID(Long contentID){
        ContentExtDO contentExtDO = new ContentExtDO();
        contentExtDO.setContentId(contentID);
        return contentExtMapper.queryChannelByContentID(contentExtDO);
    }

}
