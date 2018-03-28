package cn.qweb.cms.biz.domain.sqlprovider;

import cn.qweb.cms.biz.domain.TrainSquareApplyDO;
import cn.qweb.cms.core.base.BaseDynaSqlProvider;
import org.apache.ibatis.jdbc.SQL;

/*
 *  Created by xuebj - 2017/03/29.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class TrainSquareApplyProvider extends BaseDynaSqlProvider{

    public static final String TABLE_ALIAS = "t_train_square_apply";

    public static final String JOIN_TABLE_ALIAS = "t_train_square";

    public static final String[] Fields={"id","channel_id","content_id","real_name","sex","id_no","id_kind","read_flag","trainer_type","mobile","email","qq","height","gmt_create","gmt_modified","gmt_index"};

    public static final String[] leftFields={"b.title","a.id","a.channel_id","a.content_id","a.real_name","a.sex","a.id_no","a.id_kind","a.read_flag","a.trainer_type","a.mobile","a.email","a.qq","a.height","a.gmt_create","a.gmt_modified","a.gmt_index"};


    /**
     * 获取单个结果集
     */
    public String get(final Long id){
        return new SQL(){{
            SELECT(getField(leftFields));
            FROM(TABLE_ALIAS + " a ");
            LEFT_OUTER_JOIN(JOIN_TABLE_ALIAS + " b ON a.content_id = b.id");
            WHERE("a.id="+id);
        }}.toString();
    }

    /**
     * 查询多个结果集
     */
    public String list(final TrainSquareApplyDO bean){
        return new SQL(){{
            SELECT(getField(leftFields));
            FROM(TABLE_ALIAS + " a ");
            LEFT_OUTER_JOIN(JOIN_TABLE_ALIAS + " b ON a.content_id = b.id");
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("a.id=#{id}");
                }
                if(bean.getChannelId()!=null){
                    WHERE("a.channel_id=#{channelId}");
                }
                if(bean.getContentId()!=null){
                    WHERE("a.content_id=#{contentId}");
                }
                if(bean.getRealName()!=null && !bean.getRealName().equals("%null%") && bean.getRealName().trim() != ""){
                    WHERE("a.real_name like #{realName}");
                }
                if(bean.getSex()!=null && bean.getSex().trim() != ""){
                    WHERE("a.sex=#{sex}");
                }
                if(bean.getIdNo()!=null && bean.getIdNo().trim() != ""){
                    WHERE("a.id_no=#{idNo}");
                }
                if(bean.getIdKind()!=null && bean.getIdKind().trim() != ""){
                    WHERE("a.id_kind=#{idKind}");
                }
                if(bean.getReadFlag()!=null && bean.getReadFlag().trim() != ""){
                    WHERE("a.read_flag=#{readFlag}");
                }
                if(bean.getTrainerType()!=null && bean.getTrainerType().trim() != ""){
                    WHERE("a.trainer_type=#{trainerType}");
                }
                if(bean.getMobile()!=null && bean.getMobile().trim() != ""){
                    WHERE("a.mobile=#{mobile}");
                }
                if(bean.getEmail()!=null && bean.getEmail().trim() != ""){
                    WHERE("a.email=#{email}");
                }
                if(bean.getQq()!=null && bean.getQq().trim() != ""){
                    WHERE("a.qq=#{qq}");
                }
                if(bean.getHeight()!=null && bean.getHeight().trim() != ""){
                    WHERE("a.height=#{height}");
                }
                if(bean.getGmtCreate()!=null){
                    WHERE("a.gmt_create=#{gmtCreate}");
                }
                if(bean.getGmtModified()!=null){
                    WHERE("a.gmt_modified=#{gmtModified}");
                }
                if(bean.getGmtIndex()!=null){
                    WHERE("a.gmt_index=#{gmtIndex}");
                }
                if(bean.getTitle() != null && !bean.getTitle().equals("%null%") && bean.getTitle().trim() != ""){
                    WHERE("b.title like #{title}");
                }
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
    public String save(final TrainSquareApplyDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getChannelId() != null) {
                VALUES("channel_id", "#{channelId}");
            }
            if (bean.getContentId() != null) {
                VALUES("content_id", "#{contentId}");
            }
            if (bean.getRealName() != null) {
                VALUES("real_name", "#{realName}");
            }
            if (bean.getSex() != null) {
                VALUES("sex", "#{sex}");
            }
            if (bean.getIdNo() != null) {
                VALUES("id_no", "#{idNo}");
            }
            if (bean.getIdKind() != null) {
                VALUES("id_kind", "#{idKind}");
            }
            if (bean.getReadFlag() != null) {
                VALUES("read_flag", "#{readFlag}");
            }
            if (bean.getTrainerType() != null) {
                VALUES("trainer_type", "#{trainerType}");
            }
            if (bean.getMobile() != null) {
                VALUES("mobile", "#{mobile}");
            }
            if (bean.getEmail() != null) {
                VALUES("email", "#{email}");
            }
            if (bean.getQq() != null) {
                VALUES("qq", "#{qq}");
            }
            if (bean.getHeight() != null) {
                VALUES("height", "#{height}");
            }
            if (bean.getGmtCreate() != null) {
                VALUES("gmt_create", "#{gmtCreate}");
            }
            if (bean.getGmtModified() != null) {
                VALUES("gmt_modified", "#{gmtModified}");
            }
            if(bean.getGmtIndex() != null){
                VALUES("gmt_index","#{gmtIndex}");
            }
        }}.toString();
    }

    /**
     * 更新对象
     */
    public String update(final TrainSquareApplyDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getChannelId() != null) {
                SET("channel_id=#{channelId}");
            }
            if (bean.getContentId() != null) {
                SET("content_id=#{contentId}");
            }
            if (bean.getRealName() != null) {
                SET("real_name=#{realName}");
            }
            if (bean.getSex() != null) {
                SET("sex=#{sex}");
            }
            if (bean.getIdNo() != null) {
                SET("id_no=#{idNo}");
            }
            if (bean.getIdKind() != null) {
                SET("id_kind=#{idKind}");
            }
            if (bean.getReadFlag() != null) {
                SET("read_flag=#{readFlag}");
            }
            if (bean.getTrainerType() != null) {
                SET("trainer_type=#{trainerType}");
            }
            if (bean.getMobile() != null) {
                SET("mobile=#{mobile}");
            }
            if (bean.getEmail() != null) {
                SET("email=#{email}");
            }
            if (bean.getQq() != null) {
                SET("qq=#{qq}");
            }
            if (bean.getHeight() != null) {
                SET("height=#{height}");
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
     * 删除索引时将索引置为空
     * @param bean
     * @return
     */
    public String updateIndexTime(final TrainSquareApplyDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            SET("gmt_index = null");
            WHERE("id = #{id}");
        }}.toString();
    }


    /**
     * 按条件移除对象
     */
    public String remove(final TrainSquareApplyDO bean){
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
            if(bean.getRealName()!=null){
                WHERE("real_name=#{realName}");
            }
            if(bean.getSex()!=null){
                WHERE("sex=#{sex}");
            }
            if(bean.getIdNo()!=null){
                WHERE("id_no=#{idNo}");
            }
            if(bean.getIdKind()!=null){
                WHERE("id_kind=#{idKind}");
            }
            if(bean.getReadFlag()!=null){
                WHERE("read_flag=#{readFlag}");
            }
            if(bean.getTrainerType()!=null){
                WHERE("trainer_type=#{trainerType}");
            }
            if(bean.getMobile()!=null){
                WHERE("mobile=#{mobile}");
            }
            if(bean.getEmail()!=null){
                WHERE("email=#{email}");
            }
            if(bean.getQq()!=null){
                WHERE("qq=#{qq}");
            }
            if(bean.getHeight()!=null){
                WHERE("height=#{height}");
            }
            if(bean.getGmtCreate()!=null){
                WHERE("gmt_create=#{gmtCreate}");
            }
            if(bean.getGmtModified()!=null){
                WHERE("gmt_modified=#{gmtModified}");
            }
            if (bean.getGmtIndex() != null) {
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
     * 查询未索引总条数
     * @return
     */
    public String queryUnIndexTotalNum(){
        return new SQL(){{
            SELECT(" count(*) ");
            FROM(TABLE_ALIAS);
            WHERE("gmt_index is null");
        }}.toString();
    }

    /**
     * 查询已索引总条数
     * @return
     */
    public String queryIndexTotalNum(){
        return new SQL(){{
            SELECT(" count(*) ");
            FROM(TABLE_ALIAS);
            WHERE("gmt_index is not null");
        }}.toString();
    }

    /**
     * 查询多个结果集
     */
    public String queryUnIndexList(final TrainSquareApplyDO bean){
        return new SQL(){{
            SELECT(getField(leftFields));
            FROM(TABLE_ALIAS + " a ");
            LEFT_OUTER_JOIN(JOIN_TABLE_ALIAS + " b ON a.content_id = b.id");
            WHERE("a.gmt_index is null");
            if(bean.getSort() != null){
                ORDER_BY(bean.getSort());
            }
        }}.toString();
    }

    /**
     * 查询多个结果集
     */
    public String queryIndexList(final TrainSquareApplyDO bean){
        return new SQL(){{
            SELECT(getField(leftFields));
            FROM(TABLE_ALIAS + " a ");
            LEFT_OUTER_JOIN(JOIN_TABLE_ALIAS + " b ON a.content_id = b.id");
            WHERE("a.gmt_index is not null");
            if(bean.getSort() != null){
                ORDER_BY(bean.getSort());
            }
        }}.toString();
    }

    /**
     * 查询未添加到索引的总数据条数
     * @param bean
     * @return
     */
    public String checkExport(final TrainSquareApplyDO bean){
        return new SQL(){{
            SELECT(" count(*) ");
            FROM(TABLE_ALIAS + " a ");
            LEFT_OUTER_JOIN(JOIN_TABLE_ALIAS + " b ON a.content_id = b.id");
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("a.id=#{id}");
                }
                if(bean.getChannelId()!=null){
                    WHERE("a.channel_id=#{channelId}");
                }
                if(bean.getContentId()!=null){
                    WHERE("a.content_id=#{contentId}");
                }
                if(bean.getRealName()!=null && bean.getRealName().trim() != ""){
                    WHERE("a.real_name like concat ('%',#{realName},'%')");
                }
                if(bean.getSex()!=null && bean.getSex().trim() != ""){
                    WHERE("a.sex=#{sex}");
                }
                if(bean.getIdNo()!=null && bean.getIdNo().trim() != ""){
                    WHERE("a.id_no=#{idNo}");
                }
                if(bean.getIdKind()!=null && bean.getIdKind().trim() != ""){
                    WHERE("a.id_kind=#{idKind}");
                }
                if(bean.getReadFlag()!=null && bean.getReadFlag().trim() != ""){
                    WHERE("a.read_flag=#{readFlag}");
                }
                if(bean.getTrainerType()!=null && bean.getTrainerType().trim() != ""){
                    WHERE("a.trainer_type=#{trainerType}");
                }
                if(bean.getMobile()!=null && bean.getMobile().trim() != ""){
                    WHERE("a.mobile=#{mobile}");
                }
                if(bean.getEmail()!=null && bean.getEmail().trim() != ""){
                    WHERE("a.email=#{email}");
                }
                if(bean.getQq()!=null && bean.getQq().trim() != ""){
                    WHERE("a.qq=#{qq}");
                }
                if(bean.getHeight()!=null && bean.getHeight().trim() != ""){
                    WHERE("a.height=#{height}");
                }
                if(bean.getGmtCreate()!=null){
                    WHERE("a.gmt_create=#{gmtCreate}");
                }
                if(bean.getGmtModified()!=null){
                    WHERE("a.gmt_modified=#{gmtModified}");
                }
                if(bean.getGmtIndex()!=null){
                    WHERE("a.gmt_index=#{gmtIndex}");
                }
                if(bean.getTitle() != null && !bean.getTitle().equals("%null%") && bean.getTitle().trim() != ""){
                    WHERE("b.title like #{title}");
                }
                if(bean.getSort() != null){
                    ORDER_BY(bean.getSort());
                }
            }

        }}.toString();
    }

}