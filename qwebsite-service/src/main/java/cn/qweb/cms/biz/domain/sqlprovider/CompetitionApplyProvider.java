package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.CompetitionApplyDO;
import cn.qweb.cms.core.base.BaseDynaSqlProvider;
import org.apache.ibatis.jdbc.SQL;

/*
 *  Created by xuebj - 2017/05/24.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class CompetitionApplyProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_competition_apply";

    public static final String[] Fields={"id","channel_id","content_id","division","real_name","team_name","project_kind","mobile","email","address","group_code","read_flag","team_type","group_num","captain_name","gmt_create","gmt_modified","gmt_index"};

    /**
     * 获取单个结果集
     */
    public String get(final Long id){
        return new SQL(){{
            SELECT(getField(Fields, "t") + ", a.title as title");
            FROM(TABLE_ALIAS + " t, " + CompetitionProvider.TABLE_ALIAS + " a");
            WHERE("t.content_id = a.id");
            WHERE("t.id="+id);
        }}.toString();
    }

    /**
     * 查询多个结果集
     */
    public String list(final CompetitionApplyDO bean){
        return new SQL(){{
            SELECT(getField(Fields, "t") + ", a.title as title");
            FROM(TABLE_ALIAS + " t, " + CompetitionProvider.TABLE_ALIAS + " a");
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("t.id=#{id}");
                }
                if(bean.getTitle()!=null && bean.getTitle().trim() != ""){
                    WHERE("a.title like concat('%',#{title},'%')");
                }
                if(bean.getChannelId()!=null){
                    WHERE("t.channel_id=#{channelId}");
                }
                if(bean.getContentId()!=null){
                    WHERE("t.content_id=#{contentId}");
                }
                if(bean.getDivision()!=null && bean.getDivision().trim() != ""){
                    WHERE("t.division=#{division}");
                }
                if(bean.getRealName()!=null && bean.getRealName().trim() != ""){
                    WHERE("t.real_name=#{realName}");
                }
                if(bean.getTeamName()!=null && bean.getTeamName().trim() != ""){
                    WHERE("t.team_name=#{teamName}");
                }
                if(bean.getProjectKind()!=null && bean.getProjectKind().trim() != ""){
                    WHERE("t.project_kind=#{projectKind}");
                }
                if(bean.getMobile()!=null && bean.getMobile().trim() != ""){
                    WHERE("t.mobile=#{mobile}");
                }
                if(bean.getEmail()!=null && bean.getEmail().trim() != ""){
                    WHERE("t.email=#{email}");
                }
                if(bean.getAddress()!=null && bean.getAddress().trim() != ""){
                    WHERE("t.address=#{address}");
                }
                if(bean.getGroupCode()!=null){
                    WHERE("t.group_code=#{groupCode}");
                }
                if(bean.getReadFlag()!=null && bean.getReadFlag().trim() != ""){
                    WHERE("t.read_flag=#{readFlag}");
                }
                if(bean.getGroupNum()!=null){
                    WHERE("t.group_num=#{groupNum}");
                }
                if(bean.getCaptainName()!= null && bean.getCaptainName().trim() != ""){
                    WHERE("t.captain_name=#{captainName}");
                }
                if(bean.getTeamType()!=null && bean.getTeamType().trim() != ""){
                    WHERE("t.team_type=#{teamType}");
                }
                if(bean.getGmtCreate()!=null){
                    WHERE("t.gmt_create=#{gmtCreate}");
                }
                if(bean.getGmtModified()!=null){
                    WHERE("t.gmt_modified=#{gmtModified}");
                }
                if(bean.getGmtIndex()!=null){
                    WHERE("t.gmt_index=#{gmtIndex}");
                }
                WHERE("t.content_id = a.id");
                if(bean.getSort() != null){
                    ORDER_BY(bean.getSort());
                }else{
                    ORDER_BY(" gmt_create DESC");
                }
            }

        }}.toString();
    }

    /**
     *  保存单个对象
     */
    public String save(final CompetitionApplyDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getChannelId() != null) {
                VALUES("channel_id", "#{channelId}");
            }
            if (bean.getContentId() != null) {
                VALUES("content_id", "#{contentId}");
            }
            if (bean.getDivision() != null) {
                VALUES("division", "#{division}");
            }
            if (bean.getRealName() != null) {
                VALUES("real_name", "#{realName}");
            }
            if (bean.getTeamName() != null) {
                VALUES("team_name", "#{teamName}");
            }
            if (bean.getProjectKind() != null) {
                VALUES("project_kind", "#{projectKind}");
            }
            if (bean.getMobile() != null) {
                VALUES("mobile", "#{mobile}");
            }
            if (bean.getEmail() != null) {
                VALUES("email", "#{email}");
            }
            if (bean.getAddress() != null) {
                VALUES("address", "#{address}");
            }
            if (bean.getGroupCode() != null) {
                VALUES("group_code", "#{groupCode}");
            }
            if (bean.getReadFlag() != null) {
                VALUES("read_flag", "#{readFlag}");
            }
            if (bean.getGroupNum() != null) {
                VALUES("group_num", "#{groupNum}");
            }
            if(bean.getCaptainName() != null){
                VALUES("captain_name", "#{captainName}");
            }
            if(bean.getTeamType() != null){
                VALUES("team_type", "#{teamType}");
            }
            if (bean.getGmtCreate() != null) {
                VALUES("gmt_create", "#{gmtCreate}");
            }
            if (bean.getGmtModified() != null) {
                VALUES("gmt_modified", "#{gmtModified}");
            }
            if (bean.getGmtIndex() != null) {
                VALUES("gmt_index", "#{gmtIndex}");
            }
        }}.toString();
    }

    /**
     * 更新对象
     */
    public String update(final CompetitionApplyDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getChannelId() != null) {
                SET("channel_id=#{channelId}");
            }
            if (bean.getContentId() != null) {
                SET("content_id=#{contentId}");
            }
            if (bean.getDivision() != null) {
                SET("division=#{division}");
            }
            if (bean.getRealName() != null) {
                SET("real_name=#{realName}");
            }
            if (bean.getTeamName() != null) {
                SET("team_name=#{teamName}");
            }
            if (bean.getProjectKind() != null) {
                SET("project_kind=#{projectKind}");
            }
            if (bean.getMobile() != null) {
                SET("mobile=#{mobile}");
            }
            if (bean.getEmail() != null) {
                SET("email=#{email}");
            }
            if (bean.getAddress() != null) {
                SET("address=#{address}");
            }
            if (bean.getGroupCode() != null) {
                SET("group_code=#{groupCode}");
            }
            if (bean.getReadFlag() != null) {
                SET("read_flag=#{readFlag}");
            }
            if (bean.getGroupNum() != null) {
                SET("group_num=#{groupNum}");
            }
            if(bean.getCaptainName() != null){
                SET("captain_name=#{captainName}");
            }
            if(bean.getTeamType() != null){
                SET("team_type=#{teamType}");
            }
            if (bean.getGmtCreate() != null) {
                SET("gmt_create=#{gmtCreate}");
            }
            if (bean.getGmtModified() != null) {
                SET("gmt_modified=#{gmtModified}");
            }
            if (bean.getGmtIndex() != null) {
                SET("gmt_index=#{gmtIndex}");
            }
            WHERE("id = #{id}");
        }}.toString();
    }


    /**
     * 按条件移除对象
     */
    public String remove(final CompetitionApplyDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getChannelId()!=null){
                WHERE("channel_id=#{channelId}");
            }
            if(bean.getContentId()!=null){
                WHERE("content_id=#{contentId}");
            }
            if(bean.getDivision()!=null){
                WHERE("division=#{division}");
            }
            if(bean.getRealName()!=null){
                WHERE("real_name=#{realName}");
            }
            if(bean.getTeamName()!=null){
                WHERE("team_name=#{teamName}");
            }
            if(bean.getProjectKind()!=null){
                WHERE("project_kind=#{projectKind}");
            }
            if(bean.getMobile()!=null){
                WHERE("mobile=#{mobile}");
            }
            if(bean.getEmail()!=null){
                WHERE("email=#{email}");
            }
            if(bean.getAddress()!=null){
                WHERE("address=#{address}");
            }
            if(bean.getGroupCode()!=null){
                WHERE("group_code=#{groupCode}");
            }
            if(bean.getReadFlag()!=null){
                WHERE("read_flag=#{readFlag}");
            }
            if(bean.getGroupNum()!=null){
                WHERE("group_num=#{groupNum}");
            }
            if(bean.getCaptainName() != null){
                WHERE("captain_name=#{captainName}");
            }
            if(bean.getTeamType() != null){
                WHERE("team_type=#{teamType}");
            }
            if(bean.getGmtCreate()!=null){
                WHERE("gmt_create=#{gmtCreate}");
            }
            if(bean.getGmtModified()!=null){
                WHERE("gmt_modified=#{gmtModified}");
            }
            if(bean.getGmtIndex()!=null){
                WHERE("gmt_index=#{gmtIndex}");
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

    /**
     * 查询未添加到索引的总数据条数
     * @param bean
     * @return
     */
    public String checkExport(final CompetitionApplyDO bean){
        return new SQL(){{
            SELECT(" count(*) ");
            FROM(TABLE_ALIAS + " t, " + CompetitionProvider.TABLE_ALIAS + " a");
            if (null != bean) {
                if (bean.getId() != null) {
                    WHERE("t.id=#{id}");
                }
                if (bean.getTitle() != null && bean.getTitle().trim() != "") {
                    WHERE("a.title like concat('%',#{title},'%')");
                }
                if (bean.getChannelId() != null) {
                    WHERE("t.channel_id=#{channelId}");
                }
                if (bean.getContentId() != null) {
                    WHERE("t.content_id=#{contentId}");
                }
                if (bean.getDivision() != null && bean.getDivision().trim() != "") {
                    WHERE("t.division=#{division}");
                }
                if (bean.getRealName() != null && bean.getRealName().trim() != "") {
                    WHERE("t.real_name=#{realName}");
                }
                if (bean.getTeamName() != null && bean.getTeamName().trim() != "") {
                    WHERE("t.team_name=#{teamName}");
                }
                if (bean.getProjectKind() != null && bean.getProjectKind().trim() != "") {
                    WHERE("t.project_kind=#{projectKind}");
                }
                if (bean.getMobile() != null && bean.getMobile().trim() != "") {
                    WHERE("t.mobile=#{mobile}");
                }
                if (bean.getEmail() != null && bean.getEmail().trim() != "") {
                    WHERE("t.email=#{email}");
                }
                if (bean.getAddress() != null && bean.getAddress().trim() != "") {
                    WHERE("t.address=#{address}");
                }
                if (bean.getGroupCode() != null) {
                    WHERE("t.group_code=#{groupCode}");
                }
                if (bean.getReadFlag() != null && bean.getReadFlag().trim() != "") {
                    WHERE("t.read_flag=#{readFlag}");
                }
                if (bean.getGroupNum() != null) {
                    WHERE("t.group_num=#{groupNum}");
                }
                if(bean.getCaptainName() != null && bean.getCaptainName().trim() != ""){
                    WHERE("t.captain_name = #{captainName}");
                }
                if(bean.getTeamType() != null && bean.getTeamType().trim()!=null){
                    WHERE("t.team_type = #{teamType}");
                }
                if (bean.getGmtCreate() != null) {
                    WHERE("t.gmt_create=#{gmtCreate}");
                }
                if (bean.getGmtModified() != null) {
                    WHERE("t.gmt_modified=#{gmtModified}");
                }
                if (bean.getGmtIndex() != null) {
                    WHERE("t.gmt_index=#{gmtIndex}");
                }
                WHERE("t.content_id = a.id");
                if (bean.getSort() != null) {
                    ORDER_BY(bean.getSort());
                }
            }
        }}.toString();
    }


}