package cn.qweb.cms.front.biz.manager.bo.param;

/**
 * Created by xuebj on 2017/6/7.
 */
public class RestPwdPAR{

    private String mobile;

    private String new_passwd;

    private String code;

    public RestPwdPAR() {
    }

    public RestPwdPAR(String mobile, String new_passwd, String code) {
        this.mobile = mobile;
        this.new_passwd = new_passwd;
        this.code = code;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNew_passwd() {
        return new_passwd;
    }

    public void setNew_passwd(String new_passwd) {
        this.new_passwd = new_passwd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
