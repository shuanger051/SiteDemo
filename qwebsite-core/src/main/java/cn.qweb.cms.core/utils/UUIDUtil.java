package cn.qweb.cms.core.utils;

import com.relops.snowflake.Snowflake;

import java.util.UUID;

/**
 * UUID 工具类
 * Created by xuebj on 2017/3/7.
 */
public final class UUIDUtil {

    private static final Snowflake SNOWFLAKE = new Snowflake(1);

    /**
     * 获取全局唯一UUID
     * @return
     */
    public static final Long getUUID(){
        return SNOWFLAKE.next();
    }

    /**
     * @info 获取32位UUID字符串
     * @return
     */
    public static final String get32CharsUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}
