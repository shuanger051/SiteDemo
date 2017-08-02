package cn.qweb.cms.front.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by xuebj on 2017/2/8.
 */
@Component
@ConfigurationProperties(prefix = "jwt")
public class Audience {
    private int expiresSecond;

    private String md5String;

    private String account;

    private String password;

    private String type;

    private Boolean enable;

    public int getExpiresSecond() {
        return expiresSecond;
    }

    public void setExpiresSecond(int expiresSecond) {
        this.expiresSecond = expiresSecond;
    }

    public String getMd5String() {
        return md5String;
    }

    public void setMd5String(String md5String) {
        this.md5String = md5String;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "Audience{" +
                "expiresSecond=" + expiresSecond +
                ", md5String='" + md5String + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", enable=" + enable +
                '}';
    }
}
