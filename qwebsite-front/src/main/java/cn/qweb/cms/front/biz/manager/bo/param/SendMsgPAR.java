package cn.qweb.cms.front.biz.manager.bo.param;

import cn.qweb.cms.core.validator.RegExpConstants;

import javax.validation.constraints.Pattern;

/**
 * Created by xuebj on 2017/6/7.
 */
public class SendMsgPAR {

    @Pattern(regexp = RegExpConstants.MOBILE,message = RegExpConstants.MOBILE_MESSAGE)
    private String login_id;

    private String type;

    public SendMsgPAR() {
    }

    public SendMsgPAR(String login_id, String type) {
        this.login_id = login_id;
        this.type = type;
    }

    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SendMsgPAR{" +
                "login_id='" + login_id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
