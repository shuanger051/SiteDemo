package cn.qweb.cms.biz.web;
import cn.qweb.cms.biz.service.SysUserRoleService;
import cn.qweb.cms.biz.service.bo.SysUserRoleRemoveBO;
import cn.qweb.cms.biz.service.bo.SysUserRoleSaveBO;
import cn.qweb.cms.biz.service.bo.SysUserRoleUpdateBO;
import cn.qweb.cms.biz.service.dto.SysUserRoleDTO;
import cn.qweb.cms.biz.service.dto.UserRoleDTO;
import cn.qweb.cms.biz.service.query.SysUserRoleQUERY;
import cn.qweb.cms.biz.service.query.UserRoleQUERY;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.core.base.Pagination;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/sys_user_role")
public class SysUserRoleController extends BaseController{

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "SysUserRoleQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<SysUserRoleDTO> getSysUserRoleList(@Valid SysUserRoleQUERY bean){
        return sysUserRoleService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public SysUserRoleDTO getSysUserRole(Long id){
        return sysUserRoleService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "SysUserRoleSaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postSysUserRole(@Valid SysUserRoleSaveBO bean){
        return sysUserRoleService.doSave(bean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "SysUserRoleUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public String putSysUserRole(@Valid SysUserRoleUpdateBO bean){
        sysUserRoleService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteSysUserRole(Long id) {
        sysUserRoleService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "SysUserRoleRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeSysUserRole(SysUserRoleRemoveBO bean) {
        sysUserRoleService.doRemove(bean);
        return SUCCESS;
    }

    @ApiOperation(value = "根据角色查询用户列表")
    @ApiImplicitParam(name = "roleId", value = "角色ID", required = true, dataType = "Long")
    @RequestMapping(value = "/list_user", method = RequestMethod.GET)
    public Pagination<UserRoleDTO> listUserWithRole(Long roleId){
        UserRoleQUERY bean = new UserRoleQUERY();
        bean.setRoleId(roleId);
        return sysUserRoleService.listUserByRole(bean);
    }

    @ApiOperation(value="搜索用户，返回包括用户角色字段")
    @ApiImplicitParam(name = "bean", value = "搜索bean", required = true, dataType = "UserRoleQUERY")
    @RequestMapping(value = "/search_user",method = RequestMethod.GET)
    public Pagination<UserRoleDTO> listUser(@Valid UserRoleQUERY bean){
        return sysUserRoleService.searchUser(bean);
    }
}