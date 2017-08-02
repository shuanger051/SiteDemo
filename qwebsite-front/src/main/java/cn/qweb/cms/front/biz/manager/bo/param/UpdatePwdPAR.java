package cn.qweb.cms.front.biz.manager.bo.param;

/**
 * Created by xuebj on 2017/5/9.
 */
public class UpdatePwdPAR {

    private String old_passwd;

    private String new_passwd;

    public String getOld_passwd() {
        return old_passwd;
    }

    public void setOld_passwd(String old_passwd) {
        this.old_passwd = old_passwd;
    }

    public String getNew_passwd() {
        return new_passwd;
    }

    public void setNew_passwd(String new_passwd) {
        this.new_passwd = new_passwd;
    }

    @Override
    public String toString() {
        return "UpdatePwdPAR{" +
                "old_passwd='" + old_passwd + '\'' +
                ", new_passwd='" + new_passwd + '\'' +
                '}';
    }
}
