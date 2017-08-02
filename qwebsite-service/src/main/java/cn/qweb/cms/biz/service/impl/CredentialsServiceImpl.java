package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.service.CredentialsService;
import cn.qweb.cms.biz.domain.CredentialsMapper;
import cn.qweb.cms.biz.domain.CredentialsDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;

import cn.qweb.cms.biz.service.bo.CredentialsSaveBO;
import cn.qweb.cms.biz.service.query.CredentialsQUERY;
import cn.qweb.cms.biz.service.bo.CredentialsRemoveBO;
import cn.qweb.cms.biz.service.dto.CredentialsDTO;
import cn.qweb.cms.biz.service.bo.CredentialsUpdateBO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
 *  Created by xuebj - 2017/05/05.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class CredentialsServiceImpl implements CredentialsService {

    @Autowired
    private CredentialsMapper credentialsMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public CredentialsDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(credentialsMapper.get(id),CredentialsDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<CredentialsDTO> list(CredentialsQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<CredentialsDO> credentials = (Page<CredentialsDO>) credentialsMapper.list(BeanPropertiesUtils.copyProperties(bean, CredentialsDO.class));
        Pagination<CredentialsDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(credentials, CredentialsDTO.class));
        result.setTotal(credentials.getTotal());
        return result;
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  list集合
     */
    @Override
    public List<CredentialsDTO> queryList(CredentialsQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        List<CredentialsDO> trainApplyDOList = credentialsMapper.list(BeanPropertiesUtils.copyProperties(bean, CredentialsDO.class));
        return BeanPropertiesUtils.covert2List(trainApplyDOList, CredentialsDTO.class);
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(CredentialsSaveBO bean){
        CredentialsDO credentials = BeanPropertiesUtils.copyProperties(bean, CredentialsDO.class);
        credentials.setGmtCreate(new Date());
        credentialsMapper.save(credentials);
        return credentials.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(CredentialsUpdateBO bean){
        CredentialsDO credentials = BeanPropertiesUtils.copyProperties(bean, CredentialsDO.class);
        credentials.setGmtModified(new Date());
        return credentialsMapper.update(credentials);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(CredentialsRemoveBO bean){
        CredentialsDO credentials = BeanPropertiesUtils.copyProperties(bean, CredentialsDO.class);
        return credentialsMapper.remove(credentials);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return credentialsMapper.delete(id);
    }

    /**
     * 查询需要导出的数据总条数
     * @return 查询需要导出的数据总条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer checkExport(CredentialsQUERY bean){
        return credentialsMapper.checkExport(BeanPropertiesUtils.copyProperties(bean, CredentialsDO.class));
    }

}
