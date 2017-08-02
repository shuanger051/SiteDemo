package cn.qweb.cms.biz.service.bo;
import cn.qweb.cms.core.validator.RegExpConstants;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/*
 *  Created by xuebj - 2017/05/24.
 */
/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class CompetitionApplySaveBO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields content_id:赛事ID
     */
    @NotNull(message = "赛事编号不能为空")
    private Long contentId;

    /**
     *@Fields division:赛区
     */
    @NotEmpty(message = "参赛赛区不能为空")
    private String division;

    /**
     *@Fields real_name:真实姓名
     */
    @Pattern(regexp = RegExpConstants.REALNAME,message = RegExpConstants.REALNAME_MESSAGE)
    private String realName;

    /**
     *@Fields team_name:战队名称
     */
    @NotEmpty(message = "参赛队名不能为空")
    private String teamName;

    /**
     *@Fields project_kind:项目种类
     */
    @NotEmpty(message = "项目种类不能为空")
    private String projectKind;

    /**
     *@Fields mobile:联系方式
     */
    @Pattern(regexp = RegExpConstants.MOBILE,message = RegExpConstants.MOBILE_MESSAGE)
    private String mobile;

    /**
     *@Fields email:邮箱
     */
    @Pattern(regexp = RegExpConstants.EMAIL,message = RegExpConstants.EMAIL_MESSAGE)
    private String email;

    /**
     *@Fields address:详细地址
     */
    @NotEmpty(message = "联系地址不能为空")
    private String address;

    /**
     * @Fields team_type 队名
     */
    private String teamType;

    /**
     * @Fields captain_name 队长名称
     */
    private String captainName;


    public void setContentId(Long contentId){
        this.contentId = contentId;
    }
    public Long getContentId(){
        return contentId;
    }
    public void setDivision(String division){
        this.division = division;
    }
    public String getDivision(){
        return division;
    }
    public void setRealName(String realName){
        this.realName = realName;
    }
    public String getRealName(){
        return realName;
    }
    public void setTeamName(String teamName){
        this.teamName = teamName;
    }
    public String getTeamName(){
        return teamName;
    }
    public void setProjectKind(String projectKind){
        this.projectKind = projectKind;
    }
    public String getProjectKind(){
        return projectKind;
    }
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    public String getMobile(){
        return mobile;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }

    public String getTeamType() {
        return teamType;
    }

    public void setTeamType(String teamType) {
        this.teamType = teamType;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    @Override
    public String toString() {
        return "CompetitionApplySaveBO{" +
                "contentId=" + contentId +
                ", division='" + division + '\'' +
                ", realName='" + realName + '\'' +
                ", teamName='" + teamName + '\'' +
                ", projectKind='" + projectKind + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", teamType='" + teamType + '\'' +
                ", captainName='" + captainName + '\'' +
                '}';
    }
}