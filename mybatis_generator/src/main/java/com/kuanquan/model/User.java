package com.kuanquan.model;

import java.util.Date;

public class User {
    private Integer userId;

    private String name;

    private Integer age;

    private Integer sex;

    private Date createTime;

    private Date timestamp;

    public User(Integer userId, String name, Integer age, Integer sex, Date createTime, Date timestamp) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.createTime = createTime;
        this.timestamp = timestamp;
    }

    public User() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}