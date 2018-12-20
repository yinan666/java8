package com.wangyn.test.map_newmethods;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/12/12
 * @time: 下午3:47
 * Copyright (C) 2018 mine
 * All rights reserved
 */
public class TestMapCompute {
    Map<String,Integer> map;
    {
        map = new HashMap<>();
        map.put("first",1);
        map.put("second",2);
        map.put("thrid",3);
    }

    public static void main(String[] args){
        TestMapCompute test = new TestMapCompute();
        test.testComputeIfPresent();
    }

    /**
     * 如果包括key，并且执行逻辑得到的结果不为null,则设置新的val，如果返回结果为null,则删除key
     * 如果不包括key,并且执行逻辑得到的结果不为null，则为新的key，添加val
     * 如果使用java8,实现下面的逻辑就简单很多，比如testForCompute
     */
    public void normal(){
        String key = "xxxx";
        Integer val = getVal();
        if (map.containsKey(key)){
           if (val == null){
               map.remove(key);
           }else{
               map.put(key,val);
           }
        }else{
            if (val!=null){
                map.put(key,val);
            }
        }

    }

    private Integer getVal(){
        return 33;
    }

    /**
     * 使用Java8中
     * 如果 map存在指定的key，并且代码块中返回结果不为null，则将key对应的值设置为返回的值，如果为null,则remove掉这个key.
     * 如果 key 不存在，并且代码块中返回结果不为null，则添加 key 和对应的值(比如33)。
     * 无论key是否存在，都是执行里面的代码块逻辑
     */
    public void testForCompute(){
        String key = "first";
        map.compute(key,(k,v) ->{
            System.out.println(k+":"+v);
            return 33;
        });
        System.out.println(map);
    }

    /**
     * computeIfAbsent和Compute方法不同之处在于，
     * 只有当指定的key不存在时，才处理代码块中的内容，并设置返回的值(比如返回的值为22。 如果返回值为null,不会设置)。
     * 如果key已经存在则不会执行代码块中的内容，也不会重新设置key的值。
     *
     */
    public void testComputeIfAbsent(){
        String key = "first";
        // 由于first存在，所以代码块内容不会执行
        map.computeIfAbsent(key,(k) ->{
            System.out.println(k+":");
            return 22;
        });
        System.out.println(map);
    }

    /**
     * computeIfPresent 和 computeIfAbsent正好相反，当指定的key存在时，才处理代码块中的内容，并设置返回的值(比如返回的值为22。 如果返回值为null,不会设置)。
     *      如果key不存在则不会执行代码块中的内容，也不会重新设置key的值。
     */
    public void testComputeIfPresent(){
        String key = "xxx";
        map.computeIfPresent(key,(k,v) ->{
            System.out.println(k+":");
            return 22;
        });
        System.out.println(map);
    }
}
