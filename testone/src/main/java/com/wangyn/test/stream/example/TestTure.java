package com.wangyn.test.stream.example;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/10/7
 * @time: 下午10:50
 * Copyright (C) 2018 Meituan
 * All rights reserved
 */
public class TestTure {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "ss"));
        Map<Integer, List<User>> usermap = users.stream().collect(Collectors.groupingBy(User::getId));
        System.out.println(usermap);
        LinkedHashMap<String, User> map = null;
//        map.put();
    }

}

class User {
    private int id;
    private String username;

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
