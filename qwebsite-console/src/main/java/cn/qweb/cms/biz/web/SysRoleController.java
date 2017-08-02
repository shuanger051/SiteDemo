package cn.qweb.cms.biz.web;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.biz.service.SysRoleService;
import cn.qweb.cms.biz.service.bo.SysRoleSaveBO;
import cn.qweb.cms.biz.service.query.SysRoleQUERY;
import cn.qweb.cms.biz.service.bo.SysRoleRemoveBO;
import cn.qweb.cms.biz.service.dto.SysRoleDTO;
import cn.qweb.cms.biz.service.bo.SysRoleUpdateBO;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.constants.SymbolConstants;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/sys_role")
public class SysRoleController extends BaseController{

    @Autowired
    private SysRoleService sysRoleService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "SysRoleQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<SysRoleDTO> getSysRoleList(@Valid SysRoleQUERY bean){
        return sysRoleService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public SysRoleDTO getSysRole(Long id){
        return sysRoleService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "SysRoleSaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postSysRole(@Valid SysRoleSaveBO bean, @Valid @RequestParam(required = false) @Pattern(regexp="^\\d*$|^(\\d+\\,)+\\d+$",message = "权限格式错误") String pers){
        if(StringUtils.isNotEmpty(pers)){
            List<Long> perIds =  Arrays.stream(pers.split(SymbolConstants.COMMA)).map(Long::parseLong).collect(Collectors.toList());
            return sysRoleService.doSave(bean,perIds);
        }else {
            return sysRoleService.doSave(bean, null);
        }
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "SysRoleUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public String putSysRole(@Valid SysRoleUpdateBO bean,@Valid @RequestParam(required = false) @Pattern(regexp="^\\d*$|^(\\d+\\,)+\\d+$",message = "权限格式错误") String pers){
        if(StringUtils.isNotEmpty(pers)) {
            List<Long> perIds = Arrays.stream(pers.split(SymbolConstants.COMMA)).map(Long::parseLong).collect(Collectors.toList());
            sysRoleService.doUpdate(bean,perIds);
        }else{
            sysRoleService.doUpdate(bean,null);
        }

        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteSysRole(Long id) {
        sysRoleService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "SysRoleRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeSysRole(SysRoleRemoveBO bean) {
        sysRoleService.doRemove(bean);
        return SUCCESS;
    }

}