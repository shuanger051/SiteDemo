package cn.qweb.cms.core.validator;

/**
 * Created by xuebj on 2017/3/21.
 */
public interface   RegExpConstants {

    String USERNAME = "^[a-zA-Z]\\w{5,17}$";

    String USERNAME_MESSAGE = "用户名格式错误";

    String REALNAME = "^([\\u4e00-\\u9fa5]+|([a-zA-Z]+\\s?)+)$";

    String REALNAME_MESSAGE = "真是姓名格式错误";

    String PASSWORD = "^(?![^a-zA-Z]+$)(?!\\D+$)(?![a-zA-Z0-9]+$).{6,16}$";

    String PASSWORD_MESSAGE = "密码格式错误";

    String QQ = "^\\d{5,12}$";

    String QQ_MESSAGE = "QQ格式错误";

    String PHONE = "^((\\d{3,4}-)|(\\d{3,4}-))?\\d{7,8}$";

    String PHONE_MESSAGE = "电话格式错误";

    String MOBILE = "^[1][3,4,5,7,8][0-9]{9}$";

    String MOBILE_MESSAGE = "手机号格式错误";

    String EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    String EMAIL_MESSAGE = "邮箱格式错误";

    String GENDER = "0|1|2";

    String GENDER_MESSAGE = "性别格式错误";

}
