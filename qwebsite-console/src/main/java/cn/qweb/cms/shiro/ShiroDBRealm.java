package cn.qweb.cms.shiro;

import cn.qweb.cms.core.mvc.ShiroPasswordService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.HashSet;

/**
 * 用户身份认证及权限Reaml
 * Created by xuebj on 2015/12/15.
 */
public class ShiroDBRealm  extends AuthorizingRealm {
    /**
     * 日志对象
     */
    private static final Logger logger = LoggerFactory.getLogger(ShiroDBRealm.class);

    /**
     * 用户禁用状态
     */
    private static final String USER_DISABLED = "1";

    /**
     * 权限相关用户服务接口
     */
    private IShiroUserService shiroUserService;

    /**
     * 密码服务类 加密作用
     */
    private ShiroPasswordService shiroPasswordService;

    /**
     * 获取授权信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 因为非正常退出，即没有显式调用 SecurityUtils.getSubject().logout()
        // (可能是关闭浏览器，或超时)，但此时缓存依旧存在(principals)，所以会自己跑到授权方法里。
        if (!SecurityUtils.getSubject().isAuthenticated()) {
            doClearCache(principalCollection);
            SecurityUtils.getSubject().logout();
            return null;
        }
        ShiroUser shiroUser = (ShiroUser)principalCollection.getPrimaryPrincipal();
        String userName = shiroUser.getUserName();
        if(StringUtils.isNotBlank(userName)){
            SimpleAuthorizationInfo sazi = new SimpleAuthorizationInfo();
            try {
                sazi.addRoles(new HashSet<>());
                sazi.addStringPermissions(shiroUserService.getPermissions(shiroUser.getId()));
                return sazi;
            } catch (Exception e) {
                logger.error(e.getMessage(),e);
            }
        }
        return null;
    }

    /**
     * 获取身份验证信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        ShiroUser shiroUser = shiroUserService.getShiroUser(token.getUsername());
        checkUserStatus(shiroUser);
        if(shiroUser != null){
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(shiroUser,shiroUser.getPassword(),ByteSource.Util.bytes(shiroUser.getUserName()+shiroPasswordService.getPublicSalt()),getName());
            return authenticationInfo;
        }
        return null;
    }

    /**
     * 检查用户状态
     * @param shiroUser
     */
    private void checkUserStatus(ShiroUser shiroUser) {
        if(null == shiroUser){
            throw new ForbiddenException("用户名或密码错误");
        }
        //完善资料和 正常状态的用户可以登录
        if(!shiroUser.getActivation()) {
            throw new ForbiddenException("用户未激活");
        }
        if(StringUtils.equalsIgnoreCase(USER_DISABLED,shiroUser.getIsDisabled())){
            throw new ForbiddenException("用户已被禁用");
        }
    }

    /**
    * 初始化方法
     * 设定Password校验的Hash算法与迭代次数.
     **/
    @PostConstruct
    public void initCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(
                shiroPasswordService.getHashAlgorithm());
        matcher.setHashIterations(shiroPasswordService.getHashInterations());
        setCredentialsMatcher(matcher);
    }

    public void setShiroUserService(IShiroUserService shiroUserService) {
        this.shiroUserService = shiroUserService;
    }

    public void setShiroPasswordService(ShiroPasswordService shiroPasswordService) {
        this.shiroPasswordService = shiroPasswordService;
    }
}
