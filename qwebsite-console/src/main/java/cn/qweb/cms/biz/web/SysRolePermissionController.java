package cn.qweb.cms.biz.web;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.biz.service.SysRolePermissionService;
import cn.qweb.cms.biz.service.bo.SysRolePermissionSaveBO;
import cn.qweb.cms.biz.service.query.SysRolePermissionQUERY;
import cn.qweb.cms.biz.service.bo.SysRolePermissionRemoveBO;
import cn.qweb.cms.biz.service.dto.SysRolePermissionDTO;
import cn.qweb.cms.biz.service.bo.SysRolePermissionUpdateBO;
import cn.qweb.cms.core.base.Pagination;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/sys_role_permission")
public class SysRolePermissionController extends BaseController{

    @Autowired
    private SysRolePermissionService sysRolePermissionService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "SysRolePermissionQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<SysRolePermissionDTO> getSysRolePermissionList(@Valid SysRolePermissionQUERY bean){
        return sysRolePermissionService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public SysRolePermissionDTO getSysRolePermission(Long id){
        return sysRolePermissionService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "SysRolePermissionSaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postSysRolePermission(@Valid SysRolePermissionSaveBO bean){
        return sysRolePermissionService.doSave(bean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "SysRolePermissionUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public String putSysRolePermission(@Valid SysRolePermissionUpdateBO bean){
        sysRolePermissionService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteSysRolePermission(Long id) {
        sysRolePermissionService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "SysRolePermissionRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeSysRolePermission(SysRolePermissionRemoveBO bean) {
        sysRolePermissionService.doRemove(bean);
        return SUCCESS;
    }

}