package cn.qweb.cms.front.biz.web.entity;

/**
 * Created by xuebj on 2017/3/20.
 */
public class SessionUser {

    /**
     * 用户名
     */
    private String userName;

    /**
     *@Fields password : 用户名
     */
    private String password;

    private String userId;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 手机号
     * @return
     */
    private String mobile;

    /**
     * 头像
     */
    private String avatarAddress;

    private String provinceId;

    private String cityId;

    private String districtId;

    /**
     * 总课程
     */
    private Long totalLesson;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAvatarAddress() {
        return avatarAddress;
    }

    public void setAvatarAddress(String avatarAddress) {
        this.avatarAddress = avatarAddress;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public Long getTotalLesson() {
        return totalLesson;
    }

    public void setTotalLesson(Long totalLesson) {
        this.totalLesson = totalLesson;
    }

    @Override
    public String toString() {
        return "SessionUser{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userId='" + userId + '\'' +
                ", realName='" + realName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", avatarAddress='" + avatarAddress + '\'' +
                ", provinceId='" + provinceId + '\'' +
                ", cityId='" + cityId + '\'' +
                ", districtId='" + districtId + '\'' +
                ", totalLesson=" + totalLesson +
                '}';
    }
}
