package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.domain.CertificateDO;
import cn.qweb.cms.biz.domain.CertificateMapper;
import cn.qweb.cms.biz.service.CertificateService;
import cn.qweb.cms.biz.service.bo.CertificateRemoveBO;
import cn.qweb.cms.biz.service.bo.CertificateSaveBO;
import cn.qweb.cms.biz.service.bo.CertificateUpdateBO;
import cn.qweb.cms.biz.service.dto.CertificateDTO;
import cn.qweb.cms.biz.service.query.CertificateQUERY;
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
 *  Created by xuebj - 2017/04/06.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private CertificateMapper certificateMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public CertificateDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(certificateMapper.get(id),CertificateDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<CertificateDTO> list(CertificateQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<CertificateDO> certificate = (Page<CertificateDO>) certificateMapper.list(BeanPropertiesUtils.copyProperties(bean, CertificateDO.class));
        Pagination<CertificateDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(certificate, CertificateDTO.class));
        result.setTotal(certificate.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(CertificateSaveBO bean){
        CertificateDO certificate = BeanPropertiesUtils.copyProperties(bean, CertificateDO.class);
        certificate.setGmtCreate(new Date());
        certificateMapper.save(certificate);
        return certificate.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(CertificateUpdateBO bean){
        CertificateDO certificate = BeanPropertiesUtils.copyProperties(bean, CertificateDO.class);
        certificate.setGmtModified(new Date());
        return certificateMapper.update(certificate);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(CertificateRemoveBO bean){
        CertificateDO certificate = BeanPropertiesUtils.copyProperties(bean, CertificateDO.class);
        return certificateMapper.remove(certificate);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return certificateMapper.delete(id);
        }
}
