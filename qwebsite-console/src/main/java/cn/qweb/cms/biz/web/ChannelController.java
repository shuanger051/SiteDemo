package cn.qweb.cms.biz.web;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.biz.service.ChannelService;
import cn.qweb.cms.biz.service.bo.ChannelSaveBO;
import cn.qweb.cms.biz.service.query.ChannelQUERY;
import cn.qweb.cms.biz.service.bo.ChannelRemoveBO;
import cn.qweb.cms.biz.service.dto.ChannelDTO;
import cn.qweb.cms.biz.service.bo.ChannelUpdateBO;
import cn.qweb.cms.core.base.Pagination;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/channel")
public class ChannelController extends BaseController{

    @Autowired
    private ChannelService channelService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "ChannelQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<ChannelDTO> getChannelList(@Valid ChannelQUERY bean){
        return channelService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ChannelDTO getChannel(Long id){
        return channelService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "ChannelSaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postChannel(@Valid ChannelSaveBO bean){
        return channelService.doSave(bean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "ChannelUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public String putChannel(@Valid ChannelUpdateBO bean){
        channelService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteChannel(Long id) {
        channelService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "ChannelRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeChannel(ChannelRemoveBO bean) {
        channelService.doRemove(bean);
        return SUCCESS;
    }

}