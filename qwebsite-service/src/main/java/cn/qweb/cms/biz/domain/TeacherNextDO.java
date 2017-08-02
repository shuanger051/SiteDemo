package cn.qweb.cms.biz.domain;

import cn.qweb.cms.core.base.BaseQueryEntity;

/**
 * Created by xuebj on 2017/4/20.
 */
public class TeacherNextDO extends BaseQueryEntity {
    private Long id;

    private Boolean next;

    private String type;

    private Integer level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getNext() {
        return next;
    }

    public void setNext(Boolean next) {
        this.next = next;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "TeacherNextDO{" +
                "id=" + id +
                ", next=" + next +
                ", type='" + type + '\'' +
                ", level=" + level +
                '}';
    }
}
