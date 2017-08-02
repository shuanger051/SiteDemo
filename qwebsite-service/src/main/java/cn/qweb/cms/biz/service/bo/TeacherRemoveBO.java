package cn.qweb.cms.biz.service.bo;
import java.io.Serializable;


/*
 *  Created by xuebj - 2017/04/06.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class TeacherRemoveBO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * @Fields real_name:姓名
     */
    private String realName;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "TeacherRemoveBO{" +
                "realName='" + realName + '\'' +
                '}';
    }
}


