package cn.qweb.cms.core.dictionary.cache;

import cn.qweb.cms.core.dictionary.Item;

import java.util.List;

/**
 * Created by xuebj on 2017/1/18.
 */
public interface IDictCache {


    /**
     * 保存
     * @param entryCode
     * @param items
     */
    void setEntry(String entryCode, List<Item> items);

    /**
     * 获取
     * @param entryCode
     */
    List<Item>  getEntry(String entryCode);

    /**
     * 失效
     * @param entryCode
     */
    void clear(String entryCode);
}
