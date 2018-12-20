package com.wangyn.test.jmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/9/20
 * @time: 上午11:22
 * Copyright (C) 2018 Meituan
 * All rights reserved
 */
public class TestOne {
    private static Map<Long, UserDto> map = new HashMap<Long, UserDto>();

    public static void main(String[] args) throws Exception {
        TestOne testOne = new TestOne();
        for (int i = 0; i < 10000; i++) {
            UserDto userDto = testOne.createUser();
            map.put(userDto.getSno(), userDto);
            Thread.sleep(10);
        }

        for (Map.Entry<Long, UserDto> entry : map.entrySet()) {
            System.out.println(entry.getValue().getSno());
        }

    }

    public UserDto createUser() {
        UserDto userDto = new UserDto();
        userDto.setAge(createRandomInteger());
        userDto.setSno(createRandomLong());
        userDto.setUserId("sg" + createRandomLong());
        userDto.setUserName("hello boy");
        return userDto;
    }


    private Long createRandomLong() {
        Double aDouble = Math.random() * 99999999999L + 1;
        return Long.valueOf(aDouble.longValue());
    }

    private Integer createRandomInteger() {
        Double aDouble = Math.random() * 99L + 1;
        return aDouble.intValue();
    }


//    private void desc(){
//        // 先decr
//       int val = redis.decrBy(id,n);
//       if (val >= 0){
//           //  进行数据库明细扣减
//       }else{
//           redis.incrBy(id,n);
//       }
//    }
}
