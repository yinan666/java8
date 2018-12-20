package com.wangyn.test.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/9/10
 * @time: 下午4:27
 * Copyright (C) 2018 Meituan
 * All rights reserved
 */
public class Test2222 {
    public static void main(String[] args) {
        List<String> sl = Arrays.asList("1", "2", "3");
        List<Long> s2 = Arrays.asList(1L, 2L);
        sl.removeAll(s2);
        System.out.println(sl);
    }
}
