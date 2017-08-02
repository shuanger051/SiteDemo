package cn.qweb.cms.config;

import cn.qweb.cms.core.utils.UUIDUtil;
import org.springframework.beans.factory.FactoryBean;

/**
 * Author: caijl
 * Package:cn.qweb.cms.config
 * Project:qwebsite
 * Description:
 * Date: 2017/4/28
 * Time: 17:28
 * 系统版本:1.0.0
 */
public class SequenceFactoryConfig implements FactoryBean<String> {

    private static long counter = 1;

    public synchronized String getObject() throws Exception {
        return String.valueOf(UUIDUtil.getUUID());
    }

    public Class<String> getObjectType() {
        return String.class;
    }

    public boolean isSingleton() {
        return false;
    }

    public static void reset() {
        SequenceFactoryConfig.counter = 0;
    }

}
