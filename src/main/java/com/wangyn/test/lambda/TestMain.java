package com.wangyn.test.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/6/10
 * @time: 下午11:33
 * Copyright (C) 2018 mine
 * All rights reserved
 */
public class TestMain {

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<Apple>();
        appleList.add(new Apple("red", 11, 1));
        appleList.add(new Apple("red", 20, 2));
        appleList.add(new Apple("blue", 20, 3));
        appleList.add(new Apple("blue", 15, 4));
        List<Integer> idList = coverntTo(appleList, Apple::getId);
        idList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

//        idList.sort( (o1,o2) -> o1 - o2  );

    }

    public static <T, R> List<R> coverntTo(List<T> list, Function<T, R> function) {
        StackTraceElement stack[] = Thread.currentThread().getStackTrace();

        TestStack.logDebug("coverntTo测试", list);

        List<R> result = new ArrayList<R>();
        for (T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }


    /**
     * 匿名类的方法
     *
     * @param appleList
     */
    public static void test1(List<Apple> appleList) {

        List<Apple> list = Filter.filter(appleList, new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return "blue".equals(apple.getColor());
            }
        });

        System.out.println(list);
    }


    /**
     * 使用Java8 lambda
     *
     * @param appleList
     */
    public static void test2(List<Apple> appleList) {
        String color = "blue";
        List<Apple> list = Filter.filter(appleList, a -> color.equals(a.getColor()) && a.getWeight() > 1);
        System.out.println(list);
    }
}
