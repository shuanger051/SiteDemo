package cn.qweb.cms.biz.web;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.biz.service.SysPermissionService;
import cn.qweb.cms.biz.service.bo.SysPermissionSaveBO;
import cn.qweb.cms.biz.service.query.SysPermissionQUERY;
import cn.qweb.cms.biz.service.bo.SysPermissionRemoveBO;
import cn.qweb.cms.biz.service.dto.SysPermissionDTO;
import cn.qweb.cms.biz.service.bo.SysPermissionUpdateBO;
import cn.qweb.cms.core.base.Pagination;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/sys_permission")
public class SysPermissionController extends BaseController{

    @Autowired
    private SysPermissionService sysPermissionService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "SysPermissionQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<SysPermissionDTO> getSysPermissionList(@Valid SysPermissionQUERY bean){
        return sysPermissionService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public SysPermissionDTO getSysPermission(Long id){
        return sysPermissionService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "SysPermissionSaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postSysPermission(@Valid SysPermissionSaveBO bean){
        return sysPermissionService.doSave(bean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "SysPermissionUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public String putSysPermission(@Valid SysPermissionUpdateBO bean){
        sysPermissionService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteSysPermission(Long id) {
        sysPermissionService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "SysPermissionRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeSysPermission(SysPermissionRemoveBO bean) {
        sysPermissionService.doRemove(bean);
        return SUCCESS;
    }

}