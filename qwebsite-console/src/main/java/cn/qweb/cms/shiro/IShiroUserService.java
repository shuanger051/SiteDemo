package cn.qweb.cms.shiro;

import cn.qweb.cms.biz.service.bo.LoginInfoBo;

import java.util.Set;

/**
 * 用于认证及权限获取相关的UserService 服务接口
 * Created by xuebj on 2015/12/15.
 */
public interface IShiroUserService {

    /**
     * 获取权限用户
     * @param userName 用户名
     * @return
     */
    ShiroUser getShiroUser(String userName);


    /**
     * 获取用户权限，以字符串表示
     * @param userId 用户ID
     * @return
     */
    Set<String> getPermissions(Long userId);

    /**
     * 更新用户登录信息
     * @param loginInfo
     */
    void updateUserLoginInfo(LoginInfoBo loginInfo);
}
