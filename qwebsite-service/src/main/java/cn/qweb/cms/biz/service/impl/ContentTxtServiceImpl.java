package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.domain.ContentTxtDO;
import cn.qweb.cms.biz.domain.ContentTxtMapper;
import cn.qweb.cms.biz.service.ContentTxtService;
import cn.qweb.cms.biz.service.bo.ContentTxtRemoveBO;
import cn.qweb.cms.biz.service.bo.ContentTxtSaveBO;
import cn.qweb.cms.biz.service.bo.ContentTxtUpdateBO;
import cn.qweb.cms.biz.service.dto.ContentTxtDTO;
import cn.qweb.cms.biz.service.query.ContentTxtQUERY;
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
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class ContentTxtServiceImpl implements ContentTxtService {

    @Autowired
    private ContentTxtMapper contentTxtMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public ContentTxtDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(contentTxtMapper.get(id),ContentTxtDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<ContentTxtDTO> list(ContentTxtQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<ContentTxtDO> contentTxt = (Page<ContentTxtDO>) contentTxtMapper.list(BeanPropertiesUtils.copyProperties(bean, ContentTxtDO.class));
        Pagination<ContentTxtDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(contentTxt, ContentTxtDTO.class));
        result.setTotal(contentTxt.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(ContentTxtSaveBO bean){
        ContentTxtDO contentTxt = BeanPropertiesUtils.copyProperties(bean, ContentTxtDO.class);
        contentTxt.setGmtCreate(new Date());
        contentTxtMapper.save(contentTxt);
        return contentTxt.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(ContentTxtUpdateBO bean){
        ContentTxtDO contentTxt = BeanPropertiesUtils.copyProperties(bean, ContentTxtDO.class);
        contentTxt.setGmtModified(new Date());
        return contentTxtMapper.update(contentTxt);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(ContentTxtRemoveBO bean){
        ContentTxtDO contentTxt = BeanPropertiesUtils.copyProperties(bean, ContentTxtDO.class);
        return contentTxtMapper.remove(contentTxt);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return contentTxtMapper.delete(id);
        }

    /**
     * 查询未添加到索引的总数据条数
     * @return 未索引的数据总条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer queryUnIndexTotalNum(){
        return contentTxtMapper.queryUnIndexTotalNum();
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  list集合
     */
    @Override
    public List<ContentTxtDTO> queryUnIndexList(ContentTxtQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        List<ContentTxtDO> trainApplyDOList = contentTxtMapper.queryUnIndexList(BeanPropertiesUtils.copyProperties(bean, ContentTxtDO.class));
        return BeanPropertiesUtils.covert2List(trainApplyDOList, ContentTxtDTO.class);
    }
}
