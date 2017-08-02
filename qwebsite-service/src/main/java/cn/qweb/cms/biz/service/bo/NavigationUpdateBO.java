package cn.qweb.cms.biz.service.bo;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/*
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class NavigationUpdateBO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    @NotNull(message = "唯一键不能为空")
    private Long id;
    /**
     *@Fields name:导航名称
     */
    private String name;
    /**
     *@Fields parent_id:父导航
     */
    private Long parentId;
    /**
     *@Fields is_display:是否显示
     */
    private String isDisplay;
    /**
     *@Fields is_expand:是否展开
     */
    private String isExpand;
    /**
     *@Fields link:连接
     */
    private String link;
    /**
     *@Fields is_blank:新窗口打开
     */
    private String isBlank;
    /**
     *@Fields icon:图标
     */
    private String icon;
    /**
     *@Fields priority:排列顺序
     */
    private Integer priority;
    /**
     *@Fields style:样式
     */
    private String style;
    /**
     *@Fields clas:样式名
     */
    private String clas;


    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setParentId(Long parentId){
        this.parentId = parentId;
    }
    public Long getParentId(){
        return parentId;
    }
    public void setIsDisplay(String isDisplay){
        this.isDisplay = isDisplay;
    }
    public String getIsDisplay(){
        return isDisplay;
    }
    public void setIsExpand(String isExpand){
        this.isExpand = isExpand;
    }
    public String getIsExpand(){
        return isExpand;
    }
    public void setLink(String link){
        this.link = link;
    }
    public String getLink(){
        return link;
    }
    public void setIsBlank(String isBlank){
        this.isBlank = isBlank;
    }
    public String getIsBlank(){
        return isBlank;
    }
    public void setIcon(String icon){
        this.icon = icon;
    }
    public String getIcon(){
        return icon;
    }
    public void setPriority(Integer priority){
        this.priority = priority;
    }
    public Integer getPriority(){
        return priority;
    }
    public void setStyle(String style){
        this.style = style;
    }
    public String getStyle(){
        return style;
    }
    public void setClas(String clas){
        this.clas = clas;
    }
    public String getClas(){
        return clas;
    }

    @Override
    public String toString(){
        return "Navigation{" +
                    "id='" + id + "\'," +
                    "name='" + name + "\'," +
                    "parentId='" + parentId + "\'," +
                    "isDisplay='" + isDisplay + "\'," +
                    "isExpand='" + isExpand + "\'," +
                    "link='" + link + "\'," +
                    "isBlank='" + isBlank + "\'," +
                    "icon='" + icon + "\'," +
                    "priority='" + priority + "\'," +
                    "style='" + style + "\'," +
                    "clas='" + clas + "\'" +
                "}";
    }
        }