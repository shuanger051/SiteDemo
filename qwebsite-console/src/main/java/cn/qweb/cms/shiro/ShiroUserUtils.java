package cn.qweb.cms.shiro;

import org.apache.shiro.SecurityUtils;

/**
 * Created by xuebj on 2015/12/25.
 */
public class ShiroUserUtils {


    public static ShiroUser toUser(Object object) {
        return (ShiroUser) object;
    }

    /**
     * 获取当前登录用户
     * @return
     */
    public static ShiroUser getUser() {
        return toUser(SecurityUtils.getSubject().getPrincipal());
    }


}
