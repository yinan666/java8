package com.wangyn.test.exception;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/6/6
 * @time: 下午5:24
 * Copyright (C) 2018 Meituan
 * All rights reserved{
 */
public class TestStream {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
//        list1.add("1111");
//        list1.add("2222");
        list1.add("33323");

//        list1.add("aaaa");
        List<String> list2 = new ArrayList<String>();
        list2.add("11112");
        list2.add("2222");
        list2.add("3333");


        System.out.println(Collections.disjoint(list1, list2));

    }
}
