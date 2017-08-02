package cn.qweb.cms.biz.service.bo;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;


/*
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class ContentAttrRemoveBO implements Serializable{
    private static final long serialVersionUID = 1L;


    /**
     *@Fields content_id:内容id
     */
    private Long contentId;

    /**
     *@Fields attr_name:属性名
     */
    private String attrName;

    /**
     *@Fields attr_value:值
     */
    private String attrValue;

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


    public void setContentId(Long contentId){
        this.contentId = contentId;
    }
    public Long getContentId(){
        return contentId;
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
        return "ContentAttr{" +
                    "contentId='" + contentId + "\'," +
                    "attrName='" + attrName + "\'," +
                    "attrValue='" + attrValue + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
}