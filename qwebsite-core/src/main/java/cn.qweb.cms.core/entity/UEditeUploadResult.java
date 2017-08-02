package cn.qweb.cms.core.entity;

/**
 * Created by xuebj on 2017/3/30.
 */

public class UEditeUploadResult {

    /**
     * 成功时返回'SUCCESS'，错误时返回错误信息
     */
    private String state;

    private String url;

    private String title;

    private String original;

    public String getState() {
        return state;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginal() {
        return original;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    @Override
    public String toString() {
        return "UEditeUploadResult{" +
                "state='" + state + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", original='" + original + '\'' +
                '}';
    }
}
