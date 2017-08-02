package cn.qweb.cms.shiro;

import cn.qweb.cms.biz.domain.UserMapper;
import cn.qweb.cms.biz.service.SysRolePermissionService;
import cn.qweb.cms.biz.service.SysRoleService;
import cn.qweb.cms.biz.service.SysUserRoleService;
import cn.qweb.cms.biz.service.UserService;
import cn.qweb.cms.biz.service.bo.LoginInfoBo;
import cn.qweb.cms.biz.service.dto.SysPermissionDTO;
import cn.qweb.cms.biz.service.dto.SysRoleDTO;
import cn.qweb.cms.biz.service.dto.SysUserRoleDTO;
import cn.qweb.cms.biz.service.dto.UserWithPwdDTO;
import cn.qweb.cms.biz.service.query.SysUserRoleQUERY;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.exception.BizException;
import cn.qweb.cms.core.exception.builder.ErrorBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by xuebj on 2017/3/14.
 */
@Service
public class ShiroUserServiceImpl implements IShiroUserService{

    @Autowired
    private UserService userService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SysRolePermissionService sysRolePermissionService;

    /**
     * 获取权限用户
     *
     * @param userName 用户名
     * @return
     */
    @Override
    public ShiroUser getShiroUser(String userName) {
        UserWithPwdDTO user = userService.getByUserNameWithPwd(userName);
        if(null != user){
            ShiroUser shiroUser = new ShiroUser();
            BeanUtils.copyProperties(user,shiroUser);
            return shiroUser;
        }
        throw new BizException(ErrorBuilder.buildBizError("100000","用户名或密码错误"));
    }

    /**
     * 获取用户权限，以字符串表示
     *
     * @param id 用户名ID
     * @return
     */
    @Override
    public Set<String> getPermissions(Long id) {
        Set<String> perms = new HashSet<>();
        SysUserRoleQUERY queryBean = new SysUserRoleQUERY();
        queryBean.setUserId(id);
        queryBean.setPageSize(Integer.MAX_VALUE);
        Pagination<SysUserRoleDTO> userRole = sysUserRoleService.list(queryBean);
        Set<Long> roleIds = userRole.getData().stream().map(sysUserRoleDTO -> sysUserRoleDTO.getRoleId()).collect(Collectors.toSet());
        List<SysRoleDTO> roles =  sysRoleService.listByIds(roleIds);
        Long count = roles.stream().filter(roleDTO -> StringUtils.equalsIgnoreCase("1",roleDTO.getIsSuper())).count();
        if(count > 0){
            perms.add("*");
        }else{
            List<SysPermissionDTO> permissions = sysRolePermissionService.listPermissionByRoles(roleIds.stream().map(roleId -> String.valueOf(roleId)).collect(Collectors.toSet()));
            if(null != permissions){
                return permissions.stream().map(sysPermissionDTO -> sysPermissionDTO.getUri()).collect(Collectors.toSet());
            }
        }
        return perms;
    }


    @Override
    @Transactional
    public void updateUserLoginInfo(LoginInfoBo loginInfo) {
        userService.doUpdateLoginInfo(loginInfo);
    }
}
