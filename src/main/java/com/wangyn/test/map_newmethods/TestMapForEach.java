package com.wangyn.test.map_newmethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/12/12
 * @time: 下午3:47
 * Copyright (C) 2018 mine
 * All rights reserved
 */
public class TestMapForEach {
    Map<String,Integer> map;
    {
        map = new HashMap<>();
        map.put("first",1);
        map.put("second",2);
        map.put("thrid",3);
    }

    public static void main(String[] args){
        TestMapForEach test = new TestMapForEach();
        test.testForEach();
    }

    /**
     * 遍历map中key,value, 传统的方式
     */
    public void normal(){
        for (Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    /**
     * 使用Java8中 map提供的forEach方法
     */
    public void testForEach(){
        map.forEach((key,val) -> {System.out.println(key+":"+val);});
    }
}
