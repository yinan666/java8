package com.wangyn.test.lambda;

import java.util.List;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/6/13
 * @time: 下午4:50
 * Copyright (C) 2018 Meituan
 * All rights reserved
 */
public class TestStack {

    public static void logDebug(String msg, Object obj) {
        StackTraceElement stack[] = Thread.currentThread().getStackTrace();
        StackTraceElement preTrace = stack[2];

        for (int i = 0; i < stack.length; i++) {

            System.out.print(stack[i].getClassName() + " 。" + stack[i].getMethodName() + "-----");
        }

//        if (obj instanceof String || obj instanceof List) {
//
//        }
    }
}
