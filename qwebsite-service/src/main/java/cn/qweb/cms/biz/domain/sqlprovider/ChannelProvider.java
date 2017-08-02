package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.ChannelDO;
import org.apache.ibatis.jdbc.SQL;
import cn.qweb.cms.core.base.BaseDynaSqlProvider;

/*
 *  Created by xuebj - 2017/03/27.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class ChannelProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_channel";

    public static final String[] Fields={"id","model_id","parent_id","name","title","priority","is_display","keywords","description","final_step","after_check","link","is_blank","comment_control","channel_path","tpl_content","tpl_channel","tpl_model","allow_updown","gmt_create","gmt_modified"};

    /**
     * 获取单个结果集
     */
    public String get(final Long id){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            WHERE("id="+id);
        }}.toString();
    }

    /**
     * 查询多个结果集
     */
    public String list(final ChannelDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("id=#{id}");
                }
                if(bean.getModelId()!=null){
                    WHERE("model_id=#{modelId}");
                }
                if(bean.getParentId()!=null){
                    WHERE("parent_id=#{parentId}");
                }
                if(bean.getName()!=null){
                    WHERE("name=#{name}");
                }
                if(bean.getTitle()!=null){
                    WHERE("title=#{title}");
                }
                if(bean.getPriority()!=null){
                    WHERE("priority=#{priority}");
                }
                if(bean.getIsDisplay()!=null){
                    WHERE("is_display=#{isDisplay}");
                }
                if(bean.getKeywords()!=null){
                    WHERE("keywords=#{keywords}");
                }
                if(bean.getDescription()!=null){
                    WHERE("description=#{description}");
                }
                if(bean.getFinalStep()!=null){
                    WHERE("final_step=#{finalStep}");
                }
                if(bean.getAfterCheck()!=null){
                    WHERE("after_check=#{afterCheck}");
                }
                if(bean.getLink()!=null){
                    WHERE("link=#{link}");
                }
                if(bean.getIsBlank()!=null){
                    WHERE("is_blank=#{isBlank}");
                }
                if(bean.getChannelPath()!=null){
                    WHERE("channel_path=#{channelPath}");
                }
                if(bean.getTplContent()!=null){
                    WHERE("tpl_content=#{tplContent}");
                }
                if(bean.getTplChannel()!=null){
                    WHERE("tpl_channel=#{tplChannel}");
                }
                if(bean.getTplModel()!=null){
                    WHERE("tpl_model=#{tplModel}");
                }
                if(bean.getCommentControl()!=null){
                    WHERE("comment_control=#{commentControl}");
                }
                if(bean.getAllowUpdown()!=null){
                    WHERE("allow_updown=#{allowUpdown}");
                }
                if(bean.getGmtCreate()!=null){
                    WHERE("gmt_create=#{gmtCreate}");
                }
                if(bean.getGmtModified()!=null){
                    WHERE("gmt_modified=#{gmtModified}");
                }
                if(bean.getSort() != null){
                    ORDER_BY(bean.getSort());
                }else{
                    ORDER_BY("parent_id , priority");
                }
            }

        }}.toString();
    }

    /**
     *  保存单个对象
     */
    public String save(final ChannelDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getModelId() != null) {
                VALUES("model_id", "#{modelId}");
            }
            if (bean.getParentId() != null) {
                VALUES("parent_id", "#{parentId}");
            }
            if (bean.getName() != null) {
                VALUES("name", "#{name}");
            }
            if (bean.getTitle() != null) {
                VALUES("title", "#{title}");
            }
            if (bean.getPriority() != null) {
                VALUES("priority", "#{priority}");
            }
            if (bean.getIsDisplay() != null) {
                VALUES("is_display", "#{isDisplay}");
            }
            if (bean.getKeywords() != null) {
                VALUES("keywords", "#{keywords}");
            }
            if (bean.getDescription() != null) {
                VALUES("description", "#{description}");
            }
            if (bean.getFinalStep() != null) {
                VALUES("final_step", "#{finalStep}");
            }
            if (bean.getAfterCheck() != null) {
                VALUES("after_check", "#{afterCheck}");
            }
            if (bean.getLink() != null) {
                VALUES("link", "#{link}");
            }
            if (bean.getIsBlank() != null) {
                VALUES("is_blank", "#{isBlank}");
            }
            if (bean.getChannelPath() != null) {
                VALUES("channel_path", "#{channelPath}");
            }
            if (bean.getTplContent() != null) {
                VALUES("tpl_content", "#{tplContent}");
            }
            if (bean.getTplChannel() != null) {
                VALUES("tpl_channel", "#{tplChannel}");
            }
            if (bean.getTplModel() != null) {
                VALUES("tpl_model", "#{tplModel}");
            }
            if (bean.getCommentControl() != null) {
                VALUES("comment_control", "#{commentControl}");
            }
            if (bean.getAllowUpdown() != null) {
                VALUES("allow_updown", "#{allowUpdown}");
            }
            if (bean.getGmtCreate() != null) {
                VALUES("gmt_create", "#{gmtCreate}");
            }
            if (bean.getGmtModified() != null) {
                VALUES("gmt_modified", "#{gmtModified}");
            }
        }}.toString();
    }

    /**
     * 更新对象
     */
    public String update(final ChannelDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getModelId() != null) {
                SET("model_id=#{modelId}");
            }
            if (bean.getParentId() != null) {
                SET("parent_id=#{parentId}");
            }
            if (bean.getName() != null) {
                SET("name=#{name}");
            }
            if (bean.getTitle() != null) {
                SET("title=#{title}");
            }
            if (bean.getPriority() != null) {
                SET("priority=#{priority}");
            }
            if (bean.getIsDisplay() != null) {
                SET("is_display=#{isDisplay}");
            }
            if (bean.getKeywords() != null) {
                SET("keywords=#{keywords}");
            }
            if (bean.getDescription() != null) {
                SET("description=#{description}");
            }
            if (bean.getFinalStep() != null) {
                SET("final_step=#{finalStep}");
            }
            if (bean.getAfterCheck() != null) {
                SET("after_check=#{afterCheck}");
            }
            if (bean.getLink() != null) {
                SET("link=#{link}");
            }
            if (bean.getIsBlank() != null) {
                SET("is_blank=#{isBlank}");
            }
            if (bean.getCommentControl() != null) {
                SET("comment_control=#{commentControl}");
            }
            if (bean.getChannelPath() != null) {
                SET("channel_path=#{channelPath}");
            }
            if (bean.getTplContent() != null) {
                SET("tpl_content=#{tplContent}");
            }
            if (bean.getTplChannel() != null) {
                SET("tpl_channel=#{tplChannel}");
            }
            if (bean.getTplModel() != null) {
                SET("tpl_model=#{tplModel}");
            }
            if (bean.getAllowUpdown() != null) {
                SET("allow_updown=#{allowUpdown}");
            }
            if (bean.getGmtCreate() != null) {
                SET("gmt_create=#{gmtCreate}");
            }
            if (bean.getGmtModified() != null) {
                SET("gmt_modified=#{gmtModified}");
            }
            WHERE("id = #{id}");
        }}.toString();
    }


    /**
     * 按条件移除对象
     */
    public String remove(final ChannelDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getModelId()!=null){
                WHERE("model_id=#{modelId}");
            }
            if(bean.getParentId()!=null){
                WHERE("parent_id=#{parentId}");
            }
            if(bean.getName()!=null){
                WHERE("name=#{name}");
            }
            if(bean.getTitle()!=null){
                WHERE("title=#{title}");
            }
            if(bean.getPriority()!=null){
                WHERE("priority=#{priority}");
            }
            if(bean.getIsDisplay()!=null){
                WHERE("is_display=#{isDisplay}");
            }
            if(bean.getKeywords()!=null){
                WHERE("keywords=#{keywords}");
            }
            if(bean.getDescription()!=null){
                WHERE("description=#{description}");
            }
            if(bean.getFinalStep()!=null){
                WHERE("final_step=#{finalStep}");
            }
            if(bean.getAfterCheck()!=null){
                WHERE("after_check=#{afterCheck}");
            }
            if(bean.getLink()!=null){
                WHERE("link=#{link}");
            }
            if(bean.getIsBlank()!=null){
                WHERE("is_blank=#{isBlank}");
            }
            if(bean.getCommentControl()!=null){
                WHERE("comment_control=#{commentControl}");
            }
            if(bean.getChannelPath()!=null){
                WHERE("channel_path=#{channelPath}");
            }
            if(bean.getTplContent()!=null){
                WHERE("tpl_content=#{tplContent}");
            }
            if(bean.getTplChannel()!=null){
                WHERE("tpl_channel=#{tplChannel}");
            }
            if(bean.getTplModel()!=null){
                WHERE("tpl_model=#{tplModel}");
            }
            if(bean.getAllowUpdown()!=null){
                WHERE("allow_updown=#{allowUpdown}");
            }
            if(bean.getGmtCreate()!=null){
                WHERE("gmt_create=#{gmtCreate}");
            }
            if(bean.getGmtModified()!=null){
                WHERE("gmt_modified=#{gmtModified}");
            }
            }}.toString();
    }

    /**
     * 删除单个对象
     */
    public String delete(final Long id){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            WHERE("id=" + id);
        }}.toString();
    }


}