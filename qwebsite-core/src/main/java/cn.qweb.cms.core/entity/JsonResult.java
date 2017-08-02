package cn.qweb.cms.core.entity;

/**
 * Created by xuebj on 2017/2/20.
 */
public class JsonResult {
    /**
     * 标示请求结果为成功
     */
    private Boolean success = Boolean.TRUE;

    /**
     * controller 方法返回数据对象
     */
    private Object data;

    public JsonResult(Object data) {
        this.data = data;
    }

    public JsonResult(Boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
