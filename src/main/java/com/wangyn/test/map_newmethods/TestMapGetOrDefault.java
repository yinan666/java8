package com.wangyn.test.map_newmethods;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/12/13
 * @time: 下午9:35
 * Copyright (C) 2018 Meituan
 * All rights reserved
 */
public class TestMapGetOrDefault {
    public static  void main(String[] args){
        test1();
    }

    public static void test1(){
        Map<String,String> map = new HashMap<>();
        map.put("1","wang");
        // 如果key映射不存在，则返回后面设定的默认值"lian"
        String str = map.getOrDefault("1","lian");
        System.out.println("key=1存在，不会使用默认值，返回结果为："+str);
        str = map.getOrDefault("2","lian");
        System.out.println("key=2不存在，会使用默认值："+str);

        // 如果key设置的值本身为null，则也不会使用默认值
        map.put("3",null);
        str = map.getOrDefault("3","lian");
        System.out.println("key=3存在，值为null,不会使用默认值，返回结果为："+str);


    }
}
