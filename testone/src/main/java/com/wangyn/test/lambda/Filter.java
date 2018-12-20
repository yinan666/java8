package com.wangyn.test.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Filter {
    /**
     * 传入一个filterRule对象
     */
    public static List<Apple> filter(List<Apple> list, Predicate<Apple> filterRule) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (filterRule.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}