package cn.qweb.cms.front.biz.web;

import cn.qweb.cms.biz.service.ChannelService;
import cn.qweb.cms.biz.service.ContentService;
import cn.qweb.cms.biz.service.dto.ChannelDTO;
import cn.qweb.cms.biz.service.dto.ContentDTO;
import cn.qweb.cms.biz.service.query.ContentQUERY;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.core.base.Pagination;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by xuebj on 2017/4/12.
 */
@RestController
@RequestMapping("/content")
public class ContentController extends BaseController{

    @Autowired
    private ContentService contentService;

    @Autowired
    private ChannelService channelService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "ContentQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<ContentDTO> getContentList(@Valid ContentQUERY bean){
        ChannelDTO channel = channelService.get(bean.getChannelId());
        bean.setStatus(channel.getFinalStep());
        return contentService.list(bean);
    }

    @ApiOperation(value = "获取单个内容")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "ContentQUERY")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ContentDTO getContent(Long id){
        return contentService.get(id);
    }

    @ApiOperation(value = "内容浏览次统计")
    @ApiImplicitParam(name = "内容id", value = "id", dataType = "java.lang.Long")
    @RequestMapping(value = "/view",method = RequestMethod.GET)
    public String view(@Valid Long id){
        contentService.doViewUpdate(id);
        return SUCCESS;
    }
}
