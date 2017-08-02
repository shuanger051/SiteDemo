package cn.qweb.cms.biz.service.dto;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;


/*
 *  Created by xuebj - 2017/04/07.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class LuceneDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields id:主键ID
     */
    private Long id;
    /**
     *@Fields title:索引标题
     */
    private String title;
    /**
     *@Fields content:内容详情
     */
    private String content;
    /**
     *@Fields pic:图片
     */
    private String pic;
    /**
     *@Fields video:音视频
     */
    private String video;
    /**
     *@Fields status:状态
     */
    private String status;
    /**
     *@Fields gmt_add:添加索引时间
     */
    private String gmtAdd;
    /**
     *@Fields gmt_create:创建时间
     */
    private String gmtCreate;
    /**
     *@Fields gmt_modified:索引更新时间
     */
    private String gmtModified;
    /**
     *@Fields link:索引链接地址
     */
    private String link;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return content;
    }
    public void setPic(String pic){
        this.pic = pic;
    }
    public String getPic(){
        return pic;
    }
    public void setVideo(String video){
        this.video = video;
    }
    public String getVideo(){
        return video;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return status;
    }

    public String getGmtAdd() {
        return gmtAdd;
    }

    public void setGmtAdd(String gmtAdd) {
        this.gmtAdd = gmtAdd;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString(){
        return "Lucene{" +
                    "id='" + id + "\'," +
                    "title='" + title + "\'," +
                    "content='" + content + "\'," +
                    "pic='" + pic + "\'," +
                    "video='" + video + "\'," +
                    "status='" + status + "\'," +
                    "gmtAdd='" + gmtAdd + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                    "link='" + link + "\'" +
                "}";
    }
        }