package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.constant.ContentConstant;
import cn.qweb.cms.biz.domain.*;
import cn.qweb.cms.biz.service.*;
import cn.qweb.cms.biz.service.bo.*;
import cn.qweb.cms.biz.service.dto.*;
import cn.qweb.cms.biz.service.query.ContentQUERY;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.exception.BizException;
import cn.qweb.cms.core.exception.builder.ErrorBuilder;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
@ConfigurationProperties(prefix = "uploadresource")
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper contentMapper;

    @Autowired
    private ContentAttrService contentAttrService;

    @Autowired
    private ContentAttachmentService contentAttachmentService;

    @Autowired
    private ContentPictureService contentPictureService;

    @Autowired
    private ContentExtService contentExtService;

    @Autowired
    private ContentTxtService contentTxtService;

    @Autowired
    private ContentCheckService contentCheckService;

    @Autowired
    private ContentCheckMapper checkMapper;

    @Autowired
    private ChannelMapper channelMapper;

    /**
     * 获取单个对象
     *
     * @param id 主键
     * @return 结果对象
     */
    @Override
    public ContentDTO get(Long id) {
        ContentDO contentDO = contentMapper.get(id);
        ContentDTO dto = new ContentDTO();
        BeanUtils.copyProperties(contentDO, dto, "contentTxt", "contentExt", "contentAttrs", "contentPictures", "contentAttachments,channel");
        dto.setContentAttachments(BeanPropertiesUtils.covert2List(contentDO.getContentAttachments(), ContentAttachmentDTO.class));
        dto.setContentAttrs(BeanPropertiesUtils.covert2List(contentDO.getContentAttrs(), ContentAttrDTO.class));
        dto.setContentPictures(BeanPropertiesUtils.covert2List(contentDO.getContentPictures(), ContentPictureDTO.class));
        dto.setContentExt(BeanPropertiesUtils.copyProperties(contentDO.getContentExt(), ContentExtDTO.class));
        dto.setContentTxt(BeanPropertiesUtils.copyProperties(contentDO.getContentTxt(), ContentTxtDTO.class));
        dto.setContentCheck(BeanPropertiesUtils.copyProperties(contentDO.getContentCheck(), ContentCheckDTO.class));
        dto.setChannel(BeanPropertiesUtils.copyProperties(contentDO.getChannel(), ChannelDTO.class));
        return dto;
    }

    @Override
    public ContentDTO getNext(Long id, Long channelId, Boolean next) {
        ChannelDO channel = channelMapper.get(channelId);
        ContentNextQuery query = new ContentNextQuery();
        query.setChannelId(channelId);
        query.setId(id);
        query.setNext(next);
        query.setPageSize(1);
        query.setStatus(channel.getFinalStep());
        PageHelper.startPage(1,1);
        List<ContentDO> contents = contentMapper.getNext(query);

        if (contents.isEmpty()) {
            return null;
        }
        ContentDO contentDO = contentMapper.getNext(query).get(0);
        ContentDTO dto = new ContentDTO();
        BeanUtils.copyProperties(contentDO, dto, "contentTxt", "contentExt", "contentAttrs", "contentPictures", "contentAttachments,channel");
        dto.setContentAttachments(BeanPropertiesUtils.covert2List(contentDO.getContentAttachments(), ContentAttachmentDTO.class));
        dto.setContentAttrs(BeanPropertiesUtils.covert2List(contentDO.getContentAttrs(), ContentAttrDTO.class));
        dto.setContentPictures(BeanPropertiesUtils.covert2List(contentDO.getContentPictures(), ContentPictureDTO.class));
        dto.setContentExt(BeanPropertiesUtils.copyProperties(contentDO.getContentExt(), ContentExtDTO.class));
        dto.setContentTxt(BeanPropertiesUtils.copyProperties(contentDO.getContentTxt(), ContentTxtDTO.class));
        dto.setContentCheck(BeanPropertiesUtils.copyProperties(contentDO.getContentCheck(), ContentCheckDTO.class));
        dto.setChannel(BeanPropertiesUtils.copyProperties(contentDO.getChannel(), ChannelDTO.class));
        return dto;
    }

    /**
     * 查询对象列表
     *
     * @param bean 查询条件对象
     * @return 分页对象
     */
    @Override
    public Pagination<ContentDTO> list(ContentQUERY bean) {
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<ContentDO> content = (Page<ContentDO>) contentMapper.list(bean);
        Pagination<ContentDTO> result = new Pagination<>();
        List<ContentDTO> data = new ArrayList<>();
        content.stream().forEach(contentDO -> {
            ContentDTO dto = new ContentDTO();
            BeanUtils.copyProperties(contentDO, dto, "contentTxt", "contentExt", "contentAttrs", "contentPictures", "contentAttachments,channel");
            dto.setContentAttachments(BeanPropertiesUtils.covert2List(contentDO.getContentAttachments(), ContentAttachmentDTO.class));
            dto.setContentAttrs(BeanPropertiesUtils.covert2List(contentDO.getContentAttrs(), ContentAttrDTO.class));
            dto.setContentPictures(BeanPropertiesUtils.covert2List(contentDO.getContentPictures(), ContentPictureDTO.class));
            dto.setContentExt(BeanPropertiesUtils.copyProperties(contentDO.getContentExt(), ContentExtDTO.class));
            dto.setContentTxt(BeanPropertiesUtils.copyProperties(contentDO.getContentTxt(), ContentTxtDTO.class));
            dto.setContentCheck(BeanPropertiesUtils.copyProperties(contentDO.getContentCheck(), ContentCheckDTO.class));
            dto.setChannel(BeanPropertiesUtils.copyProperties(contentDO.getChannel(), ChannelDTO.class));
            data.add(dto);
        });
        result.setData(data);
        result.setTotal(content.getTotal());
        return result;
    }

    /**
     * 保存单个对象,返回主键
     *
     * @param bean 保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(ContentSaveBO bean) {
        ContentDO content = BeanPropertiesUtils.copyProperties(bean, ContentDO.class);
        content.setGmtCreate(new Date());
        contentMapper.save(content);
        Long contentId = content.getId();
        if (null != bean.getContentAttachment()) {
            bean.getContentAttachment().stream().forEach(contentAttachmentSaveBO -> {
                contentAttachmentSaveBO.setContentId(contentId);
                contentAttachmentService.doSave(contentAttachmentSaveBO);
            });

        }
        if (null != bean.getContentExt()) {
            bean.getContentExt().setContentId(contentId);
            contentExtService.doSave(bean.getContentExt());
        }
        if (null != bean.getContentTxt()) {
            bean.getContentTxt().setContentId(contentId);
            contentTxtService.doSave(bean.getContentTxt());
        }
        if (null != bean.getContentPicture()) {
            bean.getContentPicture().stream().forEach(contentPictureSaveBO -> {
                contentPictureSaveBO.setContentId(contentId);
                contentPictureService.doSave(contentPictureSaveBO);
            });
        }
        if (null != bean.getContentAttr()) {
            bean.getContentAttr().stream().forEach(contentAttrSaveBO -> {
                contentAttrSaveBO.setContentId(contentId);
                contentAttrService.doSave(contentAttrSaveBO);
            });
        }
        ContentCheckSaveBO checkSaveBO = bean.getContentCheck();
        if (null == checkSaveBO) {
            checkSaveBO = new ContentCheckSaveBO();
        }
        checkSaveBO.setContentId(contentId);
        checkSaveBO.setCheckStep(1);//默认给1 表示 审核第一步
        checkSaveBO.setCheckOpinion("");//审核意见为空
        checkSaveBO.setIsRejected(Boolean.FALSE);
        contentCheckService.doSave(checkSaveBO);
        return content.getId();
    }

    /**
     * 更新单个对象 id必须有
     *
     * @param bean 更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(ContentUpdateBO bean) {
        ContentDO old = contentMapper.get(bean.getId());
        if (old.getStatus() == 2 && old.getChannel().getAfterCheck() == 1) {
            throw new BizException(ErrorBuilder.buildBizError("内容已终审不允许进行修改"));
        }
        ContentDO content = BeanPropertiesUtils.copyProperties(bean, ContentDO.class);
        if (null != bean.getContentExt()) {
            bean.getContentExt().setContentId(content.getId());
            contentExtService.doUpdate(bean.getContentExt());
        }
        if (null != bean.getContentTxt()) {
            bean.getContentTxt().setContentId(content.getId());
            contentTxtService.doUpdate(bean.getContentTxt());
        }

        //图片，附件 先删除 再添加
        reSavePictures(bean, content);
        reSaveAttachment(bean, content);
        //扩展字段也是如此
        reSaveAttr(bean, content);
        content.setGmtModified(new Date());
        //判断 当前状态，
        // 如果是草稿修改之后进行提交审核
        if (old.getStatus() == ContentConstant.DRAFT) {//草稿
            content.setStatus(ContentConstant.CHECKING);//审核中
            //更新审核表
            ContentCheckDO checkUpdateBO = new ContentCheckDO();
            checkUpdateBO.setId(old.getContentCheck().getId());
            checkUpdateBO.setCheckStep(ContentConstant.CHECKING);
            checkUpdateBO.setCheckOpinion("");
            checkUpdateBO.setIsRejected(Boolean.FALSE);
            checkMapper.update(checkUpdateBO);
        } else if (old.getStatus() == ContentConstant.CHECKED) {
            if (old.getChannel().getAfterCheck() == ContentConstant.BACK_UPDATE) {//如果是终审，修改之后进行退回。
                content.setStatus(ContentConstant.DRAFT);//终审修改进行退回到草稿状态
                //更新审核表 到 草稿
                ContentCheckDO checkUpdateBO = new ContentCheckDO();
                checkUpdateBO.setId(old.getContentCheck().getId());
                checkUpdateBO.setCheckStep(ContentConstant.DRAFT);
                checkMapper.update(checkUpdateBO);
            }
        }
        return contentMapper.update(content);
    }

    private void reSaveAttr(ContentUpdateBO bean, ContentDO content) {
        ContentAttrRemoveBO attrRemoveBO = new ContentAttrRemoveBO();
        attrRemoveBO.setContentId(content.getId());
        contentAttrService.doRemove(attrRemoveBO);
        if (null != bean.getContentAttr()) {
            bean.getContentAttr().stream().forEach(attr -> {
                attr.setContentId(content.getId());
                contentAttrService.doSave(attr);
            });
        }
    }

    private void reSaveAttachment(ContentUpdateBO bean, ContentDO content) {
        ContentAttachmentRemoveBO attachmentRemoveBO = new ContentAttachmentRemoveBO();
        attachmentRemoveBO.setContentId(content.getId());
        contentAttachmentService.doRemove(attachmentRemoveBO);
        if (null != bean.getContentAttachment()) {
            bean.getContentAttachment().stream().forEach(attachment -> {
                attachment.setContentId(content.getId());
                contentAttachmentService.doSave(attachment);
            });
        }
    }

    private void reSavePictures(ContentUpdateBO bean, ContentDO content) {
        ContentPictureRemoveBO pictureRemoveBo = new ContentPictureRemoveBO();
        pictureRemoveBo.setContentId(content.getId());
        contentPictureService.doRemove(pictureRemoveBo);
        if (null != bean.getContentPicture()) {
            bean.getContentPicture().stream().forEach(pic -> {
                pic.setContentId(content.getId());
                contentPictureService.doSave(pic);
            });
        }
    }

    /**
     * 按主键删除对象
     *
     * @param id 主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id) {
        //删除附件表，图片表，扩展属性表，内容表，基础字段表，审核表
        ContentDO content = contentMapper.get(id);
        if (content != null) {
            delAttachment(content.getId());
            delAttr(content.getId());
            delCheck(content.getId());
            delExt(content.getId());
            delTxt(content.getId());
            delPicture(content.getId());
        }
        return contentMapper.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void doViewUpdate(Long id) {
        ContentDO content = contentMapper.get(id);
        if(null != content){
            ContentDO bean = new ContentDO();
            bean.setId(id);
            //暂时把日访问数当做总访问数来使用，不新增字段了，如果后期有其他需求再考虑增加字段
            bean.setViewsDay(content.getViewsDay()+1);
            contentMapper.update(bean);
        }
    }

    /**
     * 删除副表信息
     */

    private void delAttachment(Long contentId) {
        ContentAttachmentRemoveBO attachmentRemoveBO = new ContentAttachmentRemoveBO();
        attachmentRemoveBO.setContentId(contentId);
        contentAttachmentService.doRemove(attachmentRemoveBO);
    }

    private void delPicture(Long contentId) {
        ContentAttrRemoveBO attrRemoveBO = new ContentAttrRemoveBO();
        attrRemoveBO.setContentId(contentId);
        contentAttrService.doRemove(attrRemoveBO);
    }

    private void delAttr(Long contentId) {
        ContentPictureRemoveBO pictureRemoveBo = new ContentPictureRemoveBO();
        pictureRemoveBo.setContentId(contentId);
        contentPictureService.doRemove(pictureRemoveBo);
    }

    private void delTxt(Long contentId) {
        ContentTxtRemoveBO bean = new ContentTxtRemoveBO();
        bean.setContentId(contentId);
        contentTxtService.doRemove(bean);
    }

    private void delExt(Long contentId) {
        ContentExtRemoveBO bean = new ContentExtRemoveBO();
        bean.setContentId(contentId);
        contentExtService.doRemove(bean);
    }

    private void delCheck(Long contentId) {
        ContentCheckRemoveBO bean = new ContentCheckRemoveBO();
        bean.setContentId(contentId);
        contentCheckService.doRemove(bean);
    }

}
