package com.wangyn.test.map_newmethods;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/12/12
 * @time: 下午3:47
 * Copyright (C) 2018 Meituan
 * All rights reserved
 */
public class TestMapPutIfAbsent {
    Map<String,Integer> map;
    {
        map = new HashMap<>();
        map.put("first",1);
        map.put("second",2);
        map.put("thrid",3);
    }

    public static void main(String[] args){
        TestMapPutIfAbsent test = new TestMapPutIfAbsent();
        test.test4ReplaceAll();
    }

    /**
     * 传统的方式实现： key如果不存在，则设置指定的值
     *     如果key存在，不会设置指定的
     */
    public void normal(){
        String key = "xxxx";
        if (!map.containsKey(key)){
            map.put(key,222);
        }
    }

    private Integer getVal(){
        return 33;
    }


    /**
     * Java8中，实现 key如果不存在，则设置指定的值 使用map.putIfAbsent(key,4444);
     * 如果key存在，不会设置指定的值
     *
     */
    public void test4PutIfAbsent(){
        System.out.println(map);
        String key = "first";
        map.putIfAbsent(key,322);
        System.out.println(map);
        key = "xxx";
        map.putIfAbsent(key,4444);
        System.out.println(map);
    }

    /**
     * 如果 key的值等于指定的值（如2），则删除这个值，否则，不删除
     */
    public void test4Remove(){
        boolean bl = map.remove("first",2);
        System.out.println("删除结果为："+bl+"，map="+map);
        bl = map.remove("first",1);
        System.out.println("删除结果为："+bl+"，map="+map);
    }

    /**
     * 如果指定的key存在，并且值为oldvalue，则将oldvalue替换为新的值
     */
    public void test4Replace(){
        Integer oldvalue  = 2;
        Integer newValue = 33;
        System.out.println("替换前map="+map);
        map.replace("first",oldvalue,newValue);
        System.out.println("替换后map="+map);
        oldvalue = 1;
        map.replace("first",oldvalue,newValue);
        System.out.println("替换后map="+map);
        map.replace("xxx",oldvalue,newValue);
        System.out.println("替换后map="+map);

    }

    /**
     * 这个ReplaceAll，用于对map中所有的键值对，执行代码块中逻辑，并将key对应的值设置为代码块返回的值
     * 比如，下面的逻辑是遍历所有的键值对，如果key包含s，则将其val加10
     */
    public void test4ReplaceAll(){
        Integer oldvalue  = 2;
        Integer newValue = 33;
        System.out.println("替换前map="+map);
        map.replaceAll((k,v) -> {
            if (k.contains("s")){
                return v+10;
            }else {
                return  v;
            }

        });
        System.out.println("替换后map="+map);

    }

}
