package cn.qweb.cms.biz.domain;
import java.io.Serializable;
import cn.qweb.cms.core.base.BaseQueryEntity;
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

public class ContentAttrDO extends BaseQueryEntity implements Serializable {

private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    private Long id;
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
        return "ContentAttrDO{" +
                    "id='" + id + "\'," +
                    "contentId='" + contentId + "\'," +
                    "attrName='" + attrName + "\'," +
                    "attrValue='" + attrValue + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
		}