package com.wangyn.test.stream.example;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/6/28
 * @time: 下午1:07
 * Copyright (C) 2018 mine
 * All rights reserved
 */
public class Trader {
    private String name;
    private String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
