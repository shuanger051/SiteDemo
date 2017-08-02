package cn.qweb.cms.core.dictionary;

import java.io.Serializable;

/** 
 * 数据字典条目
 * @author: xuebj07252 
 * @since: 2014-4-8 下午3:16:07 
 * @history:
 */
public class Item implements Serializable {
    /** 
     * @Fields serialVersionUID : 
     */
    private static final long serialVersionUID = -886300758162522398L;

    /** 
     * @Fields dict_entry_code : 数据字典编码
     */
    private String entryCode;

    /** 
     * @Fields dict_item_code : 条目编号 
     */
    private String itemCode;

    /** 
     * @Fields dict_item_name : 条目名称
     */
    private String itemName;

    /** 
     * @Fields dict_item_order : 排序号
     */
    private Long itemOrder;

    public String getEntryCode() {
        return entryCode;
    }

    public void setEntryCode(String entryCode) {
        this.entryCode = entryCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(Long itemOrder) {
        this.itemOrder = itemOrder;
    }

    @Override
    public String toString() {
        return "Item{" +
                "entryCode='" + entryCode + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemOrder=" + itemOrder +
                '}';
    }
}
