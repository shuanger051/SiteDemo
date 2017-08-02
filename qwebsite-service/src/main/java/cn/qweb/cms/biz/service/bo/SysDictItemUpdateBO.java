package cn.qweb.cms.biz.service.bo;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;

/*
 *  Created by xuebj - 2017/03/16.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class SysDictItemUpdateBO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    @NotNull(message = "唯一键不能为空")
    private Long id;
    /**
     *@Fields item_code:子项
     */
    private String itemCode;
    /**
     *@Fields item_name:子项名称
     */
    private String itemName;
    /**
     *@Fields entry_code:字典条目代码
     */
    private String entryCode;
    /**
     *@Fields entry_id:字典条目id
     */
    private String entryId;
    /**
     *@Fields item_order:排序
     */
    private Integer itemOrder;
    /**
     *@Fields remark:备注
     */
    private String remark;
    /**
     *@Fields gmt_create:
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;
    /**
     *@Fields gmt_modified:
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setItemCode(String itemCode){
        this.itemCode = itemCode;
    }
    public String getItemCode(){
        return itemCode;
    }
    public void setItemName(String itemName){
        this.itemName = itemName;
    }
    public String getItemName(){
        return itemName;
    }
    public void setEntryCode(String entryCode){
        this.entryCode = entryCode;
    }
    public String getEntryCode(){
        return entryCode;
    }
    public void setEntryId(String entryId){
        this.entryId = entryId;
    }
    public String getEntryId(){
        return entryId;
    }
    public void setItemOrder(Integer itemOrder){
        this.itemOrder = itemOrder;
    }
    public Integer getItemOrder(){
        return itemOrder;
    }
    public void setRemark(String remark){
        this.remark = remark;
    }
    public String getRemark(){
        return remark;
    }
    public void setGmtCreate(Date gmtCreate){
        this.gmtCreate = gmtCreate;
    }
    public Date getGmtCreate(){
        return gmtCreate;
    }
    public void setGmtModified(Date gmtModified){
        this.gmtModified = gmtModified;
    }
    public Date getGmtModified(){
        return gmtModified;
    }
    @Override
    public String toString(){
        return "SysDictItem{" +
                    "id='" + id + "\'," +
                    "itemCode='" + itemCode + "\'," +
                    "itemName='" + itemName + "\'," +
                    "entryCode='" + entryCode + "\'," +
                    "entryId='" + entryId + "\'," +
                    "itemOrder='" + itemOrder + "\'," +
                    "remark='" + remark + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
        }