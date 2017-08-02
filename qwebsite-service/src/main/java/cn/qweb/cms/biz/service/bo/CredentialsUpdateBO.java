package cn.qweb.cms.biz.service.bo;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
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

public class CredentialsUpdateBO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields id:主键ID
     */
    @NotNull(message = "唯一键不能为空")
    private Long id;
    /**
     *@Fields credentials_id:证书编号
     */
    private String credentialsId;
    /**
     *@Fields credentials_type:证书类型
     */
    private String credentialsType;
    /**
     *@Fields credentials_level:证书等级
     */
    private String credentialsLevel;
    /**
     *@Fields credentials_date:发证日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date credentialsDate;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCredentialsId() {
        return credentialsId;
    }

    public void setCredentialsId(String credentialsId) {
        this.credentialsId = credentialsId;
    }

    public String getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(String credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsLevel() {
        return credentialsLevel;
    }

    public void setCredentialsLevel(String credentialsLevel) {
        this.credentialsLevel = credentialsLevel;
    }

    public Date getCredentialsDate() {
        return credentialsDate;
    }

    public void setCredentialsDate(Date credentialsDate) {
        this.credentialsDate = credentialsDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonNo() {
        return personNo;
    }

    public void setPersonNo(String personNo) {
        this.personNo = personNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getPersonPic() {
        return personPic;
    }

    public void setPersonPic(String personPic) {
        this.personPic = personPic;
    }

    public String getTrainerType() {
        return trainerType;
    }

    public void setTrainerType(String trainerType) {
        this.trainerType = trainerType;
    }

    @Override
    public String toString() {
        return "CredentialsUpdateBO{" +
                "id=" + id +
                ", credentialsId=" + credentialsId +
                ", credentialsType='" + credentialsType + '\'' +
                ", credentialsLevel='" + credentialsLevel + '\'' +
                ", credentialsDate=" + credentialsDate +
                ", name='" + name + '\'' +
                ", personNo='" + personNo + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", workUnit='" + workUnit + '\'' +
                ", personPic='" + personPic + '\'' +
                ", trainerType='" + trainerType + '\'' +
                '}';
    }
}