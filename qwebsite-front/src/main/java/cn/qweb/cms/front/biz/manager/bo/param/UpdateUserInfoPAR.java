package cn.qweb.cms.front.biz.manager.bo.param;

/**
 * Created by xuebj on 2017/5/9.
 */
public class UpdateUserInfoPAR {

    private String gender;

    private String nick_name;

    private String name;

    private String province_id;

    private String city_id;

    private String district_id;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
    }

    @Override
    public String toString() {
        return "UpdateUserInfoPAR{" +
                "gender='" + gender + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", name='" + name + '\'' +
                ", province_id='" + province_id + '\'' +
                ", city_id='" + city_id + '\'' +
                ", district_id='" + district_id + '\'' +
                '}';
    }
}
