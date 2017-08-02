package cn.qweb.cms.biz.domain.sqlprovider;
import cn.qweb.cms.biz.domain.CredentialsDO;
import org.apache.ibatis.jdbc.SQL;
import cn.qweb.cms.core.base.BaseDynaSqlProvider;

/*
 *  Created by xuebj - 2017/05/05.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class CredentialsProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_credentials";

    public static final String[] Fields={"id","credentials_id","credentials_type","credentials_level","credentials_date","name","person_no","card_no","work_unit","person_pic","trainer_type","gmt_create","gmt_modified"};

    /**
     * 获取单个结果集
     */
    public String get(final Long id){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            WHERE("id=#{id}");
        }}.toString();
    }

    /**
     * 查询多个结果集
     */
    public String list(final CredentialsDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("id=#{id}");
                }
                if(bean.getCredentialsId()!=null){
                    WHERE("credentials_id=#{credentialsId}");
                }
                if(bean.getCredentialsType()!=null){
                    WHERE("credentials_type=#{credentialsType}");
                }
                if(bean.getCredentialsLevel()!=null){
                    WHERE("credentials_level=#{credentialsLevel}");
                }
                if(bean.getCredentialsDate()!=null){
                    WHERE("credentials_date=#{credentialsDate}");
                }
                if(bean.getName()!=null && !bean.getName().equals("%null%") && !bean.getName().trim().equals("")){
                    WHERE("name like #{name}");
                }
                if(bean.getPersonNo()!=null){
                    WHERE("person_no=#{personNo}");
                }
                if(bean.getCardNo()!=null){
                    WHERE("card_no=#{cardNo}");
                }
                if(bean.getWorkUnit()!=null && !bean.getWorkUnit().equals("%null%") && !bean.getWorkUnit().trim().equals("")){
                    WHERE("work_unit like #{workUnit}");
                }
                if(bean.getPersonPic()!=null){
                    WHERE("person_pic=#{personPic}");
                }
                if(bean.getTrainerType()!=null){
                    WHERE("trainer_type=#{trainerType}");
                }
                if(bean.getGmtCreate()!=null){
                    WHERE("gmt_create=#{gmtCreate}");
                }
                if(bean.getGmtModified()!=null){
                    WHERE("gmt_modified=#{gmtModified}");
                }
                if(bean.getSort() != null){
                    ORDER_BY(bean.getSort());
                }
            }

        }}.toString();
    }

    /**
     *  保存单个对象
     */
    public String save(final CredentialsDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getCredentialsId() != null) {
                VALUES("credentials_id", "#{credentialsId}");
            }
            if (bean.getCredentialsType() != null) {
                VALUES("credentials_type", "#{credentialsType}");
            }
            if (bean.getCredentialsLevel() != null) {
                VALUES("credentials_level", "#{credentialsLevel}");
            }
            if (bean.getCredentialsDate() != null) {
                VALUES("credentials_date", "#{credentialsDate}");
            }
            if (bean.getName() != null) {
                VALUES("name", "#{name}");
            }
            if (bean.getPersonNo() != null) {
                VALUES("person_no", "#{personNo}");
            }
            if (bean.getCardNo() != null) {
                VALUES("card_no", "#{cardNo}");
            }
            if (bean.getWorkUnit() != null) {
                VALUES("work_unit", "#{workUnit}");
            }
            if (bean.getPersonPic() != null) {
                VALUES("person_pic", "#{personPic}");
            }
            if (bean.getTrainerType() != null) {
                VALUES("trainer_type", "#{trainerType}");
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
    public String update(final CredentialsDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getCredentialsId() != null) {
                SET("credentials_id=#{credentialsId}");
            }
            if (bean.getCredentialsType() != null) {
                SET("credentials_type=#{credentialsType}");
            }
            if (bean.getCredentialsLevel() != null) {
                SET("credentials_level=#{credentialsLevel}");
            }
            if (bean.getCredentialsDate() != null) {
                SET("credentials_date=#{credentialsDate}");
            }
            if (bean.getName() != null) {
                SET("name=#{name}");
            }
            if (bean.getPersonNo() != null) {
                SET("person_no=#{personNo}");
            }
            if (bean.getCardNo() != null) {
                SET("card_no=#{cardNo}");
            }
            if (bean.getWorkUnit() != null) {
                SET("work_unit=#{workUnit}");
            }
            if (bean.getPersonPic() != null) {
                SET("person_pic=#{personPic}");
            }
            if (bean.getTrainerType() != null) {
                SET("trainer_type=#{trainerType}");
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
    public String remove(final CredentialsDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getCredentialsId()!=null){
                WHERE("credentials_id=#{credentialsId}");
            }
            if(bean.getCredentialsType()!=null){
                WHERE("credentials_type=#{credentialsType}");
            }
            if(bean.getCredentialsLevel()!=null){
                WHERE("credentials_level=#{credentialsLevel}");
            }
            if(bean.getCredentialsDate()!=null){
                WHERE("credentials_date=#{credentialsDate}");
            }
            if(bean.getName()!=null){
                WHERE("name=#{name}");
            }
            if(bean.getPersonNo()!=null){
                WHERE("person_no=#{personNo}");
            }
            if(bean.getCardNo()!=null){
                WHERE("card_no=#{cardNo}");
            }
            if(bean.getWorkUnit()!=null){
                WHERE("work_unit=#{workUnit}");
            }
            if(bean.getPersonPic()!=null){
                WHERE("person_pic=#{personPic}");
            }
            if(bean.getTrainerType()!=null){
                WHERE("trainer_type=#{trainerType}");
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
            WHERE("id=#{id}");
        }}.toString();
    }

    /**
     * 查询导出结果集
     */
    public String checkExport(final CredentialsDO bean){
        return new SQL(){{
            SELECT(" count(*) ");
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("id=#{id}");
                }
                if(bean.getCredentialsId()!=null){
                    WHERE("credentials_id=#{credentialsId}");
                }
                if(bean.getCredentialsType()!=null){
                    WHERE("credentials_type=#{credentialsType}");
                }
                if(bean.getCredentialsLevel()!=null){
                    WHERE("credentials_level=#{credentialsLevel}");
                }
                if(bean.getCredentialsDate()!=null){
                    WHERE("credentials_date=#{credentialsDate}");
                }
                if(bean.getName()!=null && !bean.getName().equals("%null%") && !bean.getName().trim().equals("")){
                    WHERE("name like #{name}");
                }
                if(bean.getPersonNo()!=null){
                    WHERE("person_no=#{personNo}");
                }
                if(bean.getCardNo()!=null){
                    WHERE("card_no=#{cardNo}");
                }
                if(bean.getWorkUnit()!=null && !bean.getWorkUnit().equals("%null%") && !bean.getWorkUnit().trim().equals("")){
                    WHERE("work_unit like #{workUnit}");
                }
                if(bean.getPersonPic()!=null){
                    WHERE("person_pic=#{personPic}");
                }
                if(bean.getTrainerType()!=null){
                    WHERE("trainer_type=#{trainerType}");
                }
                if(bean.getGmtCreate()!=null){
                    WHERE("gmt_create=#{gmtCreate}");
                }
                if(bean.getSort() != null){
                    ORDER_BY(bean.getSort());
                }
            }

        }}.toString();
    }


}