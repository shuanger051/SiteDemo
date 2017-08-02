package cn.qweb.cms.core.dictionary;


import cn.qweb.cms.core.dictionary.cache.IDictCache;
import cn.qweb.cms.core.dictionary.config.DictionaryProperties;
import cn.qweb.cms.core.dictionary.exception.DictNotFundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 数据字典管理类
 * @author: xuebj07252 
 * @since: 2014-4-8 下午3:09:54 
 * @history:
 */
@Component
public class DictManager {

    private static DictionaryServiceImpl dictionaryServiceImpl;

    private static DictionaryProperties dictionaryProperties;

    private static IDictCache dictCache;


    public static final void clear(String entryCode) {
        dictCache.clear(entryCode);
    }

    /** 
     * 获取数据字典项
     * @param entryCode
     * @return 
     * @create: 2014-4-8 下午4:07:08 xuebj07252
     * @history: 
     */
    public static final List<Item> getEntry(String entryCode) {
        List<Item> items = dictCache.getEntry(entryCode);
        if(null == items || items.isEmpty()){
            items = dictionaryServiceImpl.getEntry(entryCode);
            dictCache.setEntry(entryCode,items);
        }
        if (null == items || items.isEmpty()) {
            if(dictionaryProperties.getThrowExceptionWhenNotFund()){
                throw new DictNotFundException(dictionaryProperties.getExceptionMessage());
            }
        }
        return items;
    }

    /** 
     * 获取具体的数据字典条目名称
     * @param entryCode
     * @param itemCode
     * @return 
     * @create: 2014-4-8 下午4:07:23 xuebj07252
     * @history: 
     */
    public static final String getItem(String entryCode, String itemCode) {
        List<Item> items = getEntry(entryCode);
        for (Item item : items) {
            if (StringUtils.equals(itemCode, item.getItemCode())) {
                return item.getItemName();
            }
        }
        if(dictionaryProperties.getThrowExceptionWhenNotFund()){
            throw new DictNotFundException(dictionaryProperties.getExceptionMessage());
        }else{
            return dictionaryProperties.getNotFundMessage();
        }
    }

    /**
     * @param dictionaryServiceImpl the dictionaryServiceImpl to set
     */
    @Autowired
    public void setDictionaryServiceImpl(
            DictionaryServiceImpl dictionaryServiceImpl) {
        DictManager.dictionaryServiceImpl = dictionaryServiceImpl;
    }

    @Autowired
    public void setDictionaryProperties(DictionaryProperties dictionaryProperties) {
        DictManager.dictionaryProperties = dictionaryProperties;
    }

    @Autowired
    public void setDictCache(IDictCache dictCache) {
        DictManager.dictCache = dictCache;
    }
}
