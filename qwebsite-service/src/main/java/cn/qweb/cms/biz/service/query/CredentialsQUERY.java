package cn.qweb.cms.biz.service.query;
import cn.qweb.cms.core.base.BaseQueryEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/*
 *  Created by xuebj - 2017/05/05.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class CredentialsQUERY extends BaseQueryEntity implements Serializable{
    private static final long serialVersionUID = 1L;


    /**
     *@Fields credentials_id:证书编号
     */
    private Long credentialsId;

    /**
     *@Fields credentials_type:证书类型
     */
    private String credentialsType;

    /**
     *@Fields credentials_level:证书等级
     */
    private String credentialsLevel;

    /**
     *@Fields name:姓名
     */
    private String name;

    /**
     *@Fields person_no:人员编号
     */
    private String personNo;

    /**
     *@Fields card_no:身份证号
     */
    private String cardNo;

    /**
     *@Fields work_unit:工作单位
     */
    private String workUnit;

    /**
     *@Fields person_pic:人员照片
     */
    private String personPic;

    /**
     *@Fields trainer_type:人员类型
     */
    private String trainerType;

    /**
     *@Fields credentials_date:发证日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date credentialsDate;


    public void setCredentialsId(Long credentialsId){
        this.credentialsId = credentialsId;
    }
    public Long getCredentialsId(){
        return credentialsId;
    }
    public void setCredentialsType(String credentialsType){
        this.credentialsType = credentialsType;
    }
    public String getCredentialsType(){
        return credentialsType;
    }
    public void setCredentialsLevel(String credentialsLevel){
        this.credentialsLevel = credentialsLevel;
    }
    public String getCredentialsLevel(){
        return credentialsLevel;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setPersonNo(String personNo){
        this.personNo = personNo;
    }
    public String getPersonNo(){
        return personNo;
    }
    public void setCardNo(String cardNo){
        this.cardNo = cardNo;
    }
    public String getCardNo(){
        return cardNo;
    }
    public void setWorkUnit(String workUnit){
        this.workUnit = workUnit;
    }
    public String getWorkUnit(){
        return workUnit;
    }
    public void setPersonPic(String personPic){
        this.personPic = personPic;
    }
    public String getPersonPic(){
        return personPic;
    }
    public void setTrainerType(String trainerType){
        this.trainerType = trainerType;
    }
    public String getTrainerType(){
        return trainerType;
    }

    public Date getCredentialsDate() {
        return credentialsDate;
    }

    public void setCredentialsDate(Date credentialsDate) {
        this.credentialsDate = credentialsDate;
    }

    @Override
    public String toString() {
        return "CredentialsQUERY{" +
                "credentialsId=" + credentialsId +
                ", credentialsType='" + credentialsType + '\'' +
                ", credentialsLevel='" + credentialsLevel + '\'' +
                ", name='" + name + '\'' +
                ", personNo='" + personNo + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", workUnit='" + workUnit + '\'' +
                ", personPic='" + personPic + '\'' +
                ", trainerType='" + trainerType + '\'' +
                ", credentialsDate=" + credentialsDate +
                '}';
    }
}