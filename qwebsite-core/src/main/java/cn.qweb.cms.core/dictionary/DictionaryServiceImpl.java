package cn.qweb.cms.core.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/** 
 * @author: xuebj07252 
 * @since: 2014-4-8 下午3:37:10 
 * @history:
 */
@Service
public class DictionaryServiceImpl {

    /** 
     * @Fields loaders : 数据字典
     */
    private List<AbstractDictLoader> loaders;

    // @CacheEvict(value = "data", key = "'dict_'+#entryCode")
    public void clear(String entryCode) {

    }

    // @Cacheable(value = "data", key = "'dict_'+#entryCode", condition =
    // "#entryCode.length() > 0", unless = "#result == null")
    public List<Item> getEntry(String entryCode) {
        List<Item> items;
        for (AbstractDictLoader loader : loaders) {
            items = loader.getItem(entryCode);
            items.sort(Comparator.comparingLong(Item::getItemOrder));
            if (items!=null&&!items.isEmpty()) {
                return items;
            }
        }
        return null;
    }

    /** 
    * @return loaders 
    */
    public List<AbstractDictLoader> getLoaders() {
        return loaders;
    }

    /**
     * @param loaders the loaders to set
     */
    @Autowired
    public void setLoaders(List<AbstractDictLoader> loaders) {
        this.loaders = loaders;
    }

}
