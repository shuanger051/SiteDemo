package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.constant.ContentConstant;
import cn.qweb.cms.biz.domain.ContentCheckDO;
import cn.qweb.cms.biz.domain.ContentCheckMapper;
import cn.qweb.cms.biz.domain.ContentDO;
import cn.qweb.cms.biz.domain.ContentMapper;
import cn.qweb.cms.biz.service.ContentCheckService;
import cn.qweb.cms.biz.service.bo.ContentCheckRemoveBO;
import cn.qweb.cms.biz.service.bo.ContentCheckSaveBO;
import cn.qweb.cms.biz.service.bo.ContentCheckUpdateBO;
import cn.qweb.cms.biz.service.dto.ContentCheckDTO;
import cn.qweb.cms.biz.service.query.ContentCheckQUERY;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.exception.BizException;
import cn.qweb.cms.core.exception.builder.ErrorBuilder;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/*
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class ContentCheckServiceImpl implements ContentCheckService {

    @Autowired
    private ContentCheckMapper contentCheckMapper;

    @Autowired
    private ContentMapper contentMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public ContentCheckDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(contentCheckMapper.get(id),ContentCheckDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<ContentCheckDTO> list(ContentCheckQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<ContentCheckDO> contentCheck = (Page<ContentCheckDO>) contentCheckMapper.list(BeanPropertiesUtils.copyProperties(bean, ContentCheckDO.class));
        Pagination<ContentCheckDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(contentCheck, ContentCheckDTO.class));
        result.setTotal(contentCheck.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(ContentCheckSaveBO bean){
        ContentCheckDO contentCheck = BeanPropertiesUtils.copyProperties(bean, ContentCheckDO.class);
        contentCheck.setGmtCreate(new Date());
        contentCheckMapper.save(contentCheck);
        return contentCheck.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(ContentCheckUpdateBO bean){
        ContentCheckDO contentCheck = BeanPropertiesUtils.copyProperties(bean, ContentCheckDO.class);
        contentCheck.setGmtModified(new Date());
        ContentCheckDO checkDO = contentCheckMapper.get(bean.getId());
        ContentDO content = contentMapper.get(checkDO.getContentId());
        Integer finalStep = content.getChannel().getFinalStep();
        Integer currentSetp =  checkDO.getCheckStep();
        if(contentCheck.getIsRejected()){//退回
            if(checkDO.getCheckStep() == ContentConstant.DRAFT){
                throw new BizException(ErrorBuilder.buildBizError("当前内容已被退回了"));
            }
            if(contentCheck.getCheckStep() != null ){//说明退回到指定审核阶段
                //规范checkStep参数返回在【0，finalStep】
                formateStep(contentCheck,finalStep);
                //需要判断如果退回到草稿，需要更新内容的status为草稿 0，
                if(contentCheck.getCheckStep() == ContentConstant.DRAFT) {
                    updateContentStauts(content.getId(),ContentConstant.DRAFT);
                }
                return contentCheckMapper.update(contentCheck);
            }else{//退回到上一阶段
                if((currentSetp -1) <= ContentConstant.DRAFT){
                    updateContentStauts(content.getId(),ContentConstant.DRAFT);
                }else{
                    updateContentStauts(content.getId(),ContentConstant.CHECKING);
                }
                contentCheck.setCheckStep((currentSetp-1)< ContentConstant.DRAFT ? ContentConstant.DRAFT :(currentSetp-1));
                return contentCheckMapper.update(contentCheck);
            }
        }else{//审核
            if(finalStep >  currentSetp){//终审大于目前的审核状态
                if(finalStep == (currentSetp +1)){//终审
                    updateContentStauts(content.getId(),ContentConstant.CHECKED); //2 表示已经审核通过了
                }
                contentCheck.setCheckStep(currentSetp+1);
                contentCheck.setCheckOpinion("");
                return contentCheckMapper.update(contentCheck);
            }
        }

        throw new BizException(ErrorBuilder.buildBizError("当前内容已经归档，不允许再操作了"));
    }

    private void formateStep(ContentCheckDO contentCheck, Integer finalStep){
        if(contentCheck.getCheckStep() < ContentConstant.DRAFT){
            contentCheck.setCheckStep(ContentConstant.DRAFT);
        }else if (contentCheck.getCheckStep() > finalStep){
            contentCheck.setCheckStep(finalStep);
        }
    }

    private void updateContentStauts(Long id,Integer status){
        ContentDO updateBean = new ContentDO();
        updateBean.setId(id);
        updateBean.setStatus(status);
        contentMapper.update(updateBean);
    }
    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(ContentCheckRemoveBO bean){
        ContentCheckDO contentCheck = BeanPropertiesUtils.copyProperties(bean, ContentCheckDO.class);
        return contentCheckMapper.remove(contentCheck);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return contentCheckMapper.delete(id);
        }
}
