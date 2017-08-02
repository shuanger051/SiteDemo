package cn.qweb.cms.core.dictionary.cache;

import cn.qweb.cms.core.dictionary.Item;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuebj on 2017/1/18.
 */
@Component
public class HashMapDictCache implements IDictCache {

    private static final Map<String,List<Item>> cache = new HashMap<>();

    @Override
    public void setEntry(String entryCode, List<Item> items) {
        if(!cache.containsKey(entryCode)){
            cache.put(entryCode,items);
        }
    }

    @Override
    public List<Item> getEntry(String entryCode) {
        return cache.get(entryCode);
    }

    /**
     * 失效
     *
     * @param entryCode
     */
    @Override
    public void clear(String entryCode) {
        cache.remove(entryCode);
    }
}
