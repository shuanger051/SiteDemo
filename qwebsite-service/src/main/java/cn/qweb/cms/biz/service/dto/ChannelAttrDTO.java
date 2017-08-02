package cn.qweb.cms.biz.service.dto;
import java.io.Serializable;
import java.util.Date;


/*
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class ChannelAttrDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    private Long id;
    /**
     *@Fields channel_id:
     */
    private Long channelId;
    /**
     *@Fields attr_name:
     */
    private String attrName;
    /**
     *@Fields attr_value:扩展属性表
     */
    private String attrValue;
    /**
     *@Fields gmt_create:
     */
    private Date gmtCreate;
    /**
     *@Fields gmt_modified:
     */
    private Date gmtModified;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setChannelId(Long channelId){
        this.channelId = channelId;
    }
    public Long getChannelId(){
        return channelId;
    }
    public void setAttrName(String attrName){
        this.attrName = attrName;
    }
    public String getAttrName(){
        return attrName;
    }
    public void setAttrValue(String attrValue){
        this.attrValue = attrValue;
    }
    public String getAttrValue(){
        return attrValue;
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
        return "ChannelAttr{" +
                    "id='" + id + "\'," +
                    "channelId='" + channelId + "\'," +
                    "attrName='" + attrName + "\'," +
                    "attrValue='" + attrValue + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
        }