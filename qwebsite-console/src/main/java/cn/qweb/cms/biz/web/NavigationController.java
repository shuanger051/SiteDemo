package cn.qweb.cms.biz.web;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.biz.service.NavigationService;
import cn.qweb.cms.biz.service.bo.NavigationSaveBO;
import cn.qweb.cms.biz.service.query.NavigationQUERY;
import cn.qweb.cms.biz.service.bo.NavigationRemoveBO;
import cn.qweb.cms.biz.service.dto.NavigationDTO;
import cn.qweb.cms.biz.service.bo.NavigationUpdateBO;
import cn.qweb.cms.core.base.Pagination;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/navigation")
public class NavigationController extends BaseController{

    @Autowired
    private NavigationService navigationService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "NavigationQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<NavigationDTO> getNavigationList(@Valid NavigationQUERY bean){
        return navigationService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public NavigationDTO getNavigation(Long id){
        return navigationService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "NavigationSaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postNavigation(@Valid NavigationSaveBO bean){
        return navigationService.doSave(bean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "NavigationUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public String putNavigation(@Valid NavigationUpdateBO bean){
        navigationService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteNavigation(Long id) {
        navigationService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "NavigationRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeNavigation(NavigationRemoveBO bean) {
        navigationService.doRemove(bean);
        return SUCCESS;
    }

}