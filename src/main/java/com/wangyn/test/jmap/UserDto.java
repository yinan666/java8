package com.wangyn.test.jmap;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/9/20
 * @time: 上午11:21
 * Copyright (C) 2018 mine
 * All rights reserved
 */
public class UserDto {
    private String userId;
    private String userName;
    private Integer age;
    private Long sno;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getSno() {
        return sno;
    }

    public void setSno(Long sno) {
        this.sno = sno;
    }
}
