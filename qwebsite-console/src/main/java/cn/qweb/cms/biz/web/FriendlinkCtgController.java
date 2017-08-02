package cn.qweb.cms.biz.web;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.biz.service.FriendlinkCtgService;
import cn.qweb.cms.biz.service.bo.FriendlinkCtgSaveBO;
import cn.qweb.cms.biz.service.query.FriendlinkCtgQUERY;
import cn.qweb.cms.biz.service.bo.FriendlinkCtgRemoveBO;
import cn.qweb.cms.biz.service.dto.FriendlinkCtgDTO;
import cn.qweb.cms.biz.service.bo.FriendlinkCtgUpdateBO;
import cn.qweb.cms.core.base.Pagination;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/friendlink_ctg")
public class FriendlinkCtgController extends BaseController{

    @Autowired
    private FriendlinkCtgService friendlinkCtgService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "FriendlinkCtgQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<FriendlinkCtgDTO> getFriendlinkCtgList(@Valid FriendlinkCtgQUERY bean){
        return friendlinkCtgService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public FriendlinkCtgDTO getFriendlinkCtg(Long id){
        return friendlinkCtgService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "FriendlinkCtgSaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postFriendlinkCtg(@Valid FriendlinkCtgSaveBO bean){
        return friendlinkCtgService.doSave(bean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "FriendlinkCtgUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public String putFriendlinkCtg(@Valid FriendlinkCtgUpdateBO bean){
        friendlinkCtgService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteFriendlinkCtg(Long id) {
        friendlinkCtgService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "FriendlinkCtgRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeFriendlinkCtg(FriendlinkCtgRemoveBO bean) {
        friendlinkCtgService.doRemove(bean);
        return SUCCESS;
    }

}