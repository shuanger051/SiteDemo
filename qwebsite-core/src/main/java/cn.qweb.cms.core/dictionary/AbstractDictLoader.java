package cn.qweb.cms.core.dictionary;

import java.util.List;

/** 
 * 数据字典提供者接口
 * 数据字典，来源有多个地方 如T2服务。本地配置文件等
 * 继承ordered 设置优先级
 * @author: xuebj07252 
 * @since: 2014-4-8 下午3:21:32 
 * @history:
 */
public abstract class AbstractDictLoader {

    /** 
     * 加载 数据字典项
     * @create: 2014-4-8 下午3:26:35 xuebj07252
     * @history: 
     */
    public void load() {
        loadDictItems();
    }

    /**
     * 加载数据字典条目
     *  
     * @create: 2014-4-8 下午3:46:33 xuebj07252
     * @history:
     */
    protected abstract void loadDictItems();

    /** 
     * 获取数据字典项
     * @param entryCode
     * @return 
     * @create: 2014-4-8 下午3:43:39 xuebj07252
     * @history: 
     */
    public abstract List<Item> getItem(String entryCode);

}
