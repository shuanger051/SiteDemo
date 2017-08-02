package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.service.ContentPictureService;
import cn.qweb.cms.biz.domain.ContentPictureMapper;
import cn.qweb.cms.biz.domain.ContentPictureDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;

import cn.qweb.cms.biz.service.bo.ContentPictureSaveBO;
import cn.qweb.cms.biz.service.query.ContentPictureQUERY;
import cn.qweb.cms.biz.service.bo.ContentPictureRemoveBO;
import cn.qweb.cms.biz.service.dto.ContentPictureDTO;
import cn.qweb.cms.biz.service.bo.ContentPictureUpdateBO;
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
public class ContentPictureServiceImpl implements ContentPictureService {

    @Autowired
    private ContentPictureMapper contentPictureMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public ContentPictureDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(contentPictureMapper.get(id),ContentPictureDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<ContentPictureDTO> list(ContentPictureQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<ContentPictureDO> contentPicture = (Page<ContentPictureDO>) contentPictureMapper.list(BeanPropertiesUtils.copyProperties(bean, ContentPictureDO.class));
        Pagination<ContentPictureDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(contentPicture, ContentPictureDTO.class));
        result.setTotal(contentPicture.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(ContentPictureSaveBO bean){
        ContentPictureDO contentPicture = BeanPropertiesUtils.copyProperties(bean, ContentPictureDO.class);
        contentPicture.setGmtCreate(new Date());
        contentPictureMapper.save(contentPicture);
        return contentPicture.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(ContentPictureUpdateBO bean){
        ContentPictureDO contentPicture = BeanPropertiesUtils.copyProperties(bean, ContentPictureDO.class);
        contentPicture.setGmtModified(new Date());
        return contentPictureMapper.update(contentPicture);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(ContentPictureRemoveBO bean){
        ContentPictureDO contentPicture = BeanPropertiesUtils.copyProperties(bean, ContentPictureDO.class);
        return contentPictureMapper.remove(contentPicture);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return contentPictureMapper.delete(id);
        }
}
