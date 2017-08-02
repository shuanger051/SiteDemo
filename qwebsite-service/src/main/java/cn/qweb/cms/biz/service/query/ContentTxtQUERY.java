package cn.qweb.cms.biz.service.query;
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

public class ContentTxtQUERY extends BaseQueryEntity implements Serializable{
    private static final long serialVersionUID = 1L;


    /**
     *@Fields content_id:内容id
     */
    private Long contentId;

    /**
     *@Fields txt:文章内容
     */
    private String txt;

    /**
     *@Fields txt1:扩展内容1
     */
    private String txt1;

    /**
     *@Fields txt2:扩展内容2
     */
    private String txt2;

    /**
     *@Fields txt3:扩展内容3
     */
    private String txt3;

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
    public void setTxt(String txt){
        this.txt = txt;
    }
    public String getTxt(){
        return txt;
    }
    public void setTxt1(String txt1){
        this.txt1 = txt1;
    }
    public String getTxt1(){
        return txt1;
    }
    public void setTxt2(String txt2){
        this.txt2 = txt2;
    }
    public String getTxt2(){
        return txt2;
    }
    public void setTxt3(String txt3){
        this.txt3 = txt3;
    }
    public String getTxt3(){
        return txt3;
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
        return "ContentTxt{" +
                    "contentId='" + contentId + "\'," +
                    "txt='" + txt + "\'," +
                    "txt1='" + txt1 + "\'," +
                    "txt2='" + txt2 + "\'," +
                    "txt3='" + txt3 + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
}