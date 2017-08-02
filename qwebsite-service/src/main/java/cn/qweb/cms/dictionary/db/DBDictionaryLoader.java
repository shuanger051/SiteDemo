package cn.qweb.cms.dictionary.db;

import cn.qweb.cms.biz.service.SysDictItemService;
import cn.qweb.cms.biz.service.dto.SysDictItemDTO;
import cn.qweb.cms.biz.service.query.SysDictItemQUERY;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.dictionary.AbstractDictLoader;
import cn.qweb.cms.core.dictionary.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xuebj on 2017/1/18.
 */
@Component
public class DBDictionaryLoader extends AbstractDictLoader {

    @Autowired
    private SysDictItemService dictItemService;
    /**
     * 加载数据字典条目
     *
     * @create: 2014-4-8 下午3:46:33 xuebj07252
     * @history:
     */
    @Override
    protected void loadDictItems() {

    }

    /**
     * 获取数据字典项
     *
     * @param entryCode
     * @return
     * @create: 2014-4-8 下午3:43:39 xuebj07252
     * @history:
     */
    @Override
    public List<Item> getItem(String entryCode) {
        SysDictItemQUERY bean = new SysDictItemQUERY();
        bean.setEntryCode(entryCode);
        bean.setPageSize(Integer.MAX_VALUE);
        Pagination<SysDictItemDTO> list = dictItemService.list(bean);
        return list.getData().stream().map(dictItem -> {
            Item item = new Item();
            item.setEntryCode(dictItem.getEntryCode());
            item.setItemCode(dictItem.getItemCode());
            item.setItemName(dictItem.getItemName());
            item.setItemOrder((long)dictItem.getItemOrder());
            return item;
        }).collect(Collectors.toList());
    }
}
