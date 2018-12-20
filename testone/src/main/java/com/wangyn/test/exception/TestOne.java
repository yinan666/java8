package com.wangyn.test.exception;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/6/5
 * @time: 下午7:12
 * Copyright (C) 2018 Meituan
 * All rights reserved
 */
public class TestOne {
    public static void main(String[] args) throws Exception {
        test();
    }

    public static void test() throws Exception {
        Exception ex = null;
        try {
            test2(4);
        } catch (Exception e) {
            ex = e;
            throw ex;
        } finally {
            try {
                test2(5);
            } catch (Exception e) {
                if (ex != null) {
                    ex.addSuppressed(e);
                }
            }
        }


    }

    public static void test2(int a) throws Exception {
        if (a < 10) {
            throw new Exception("你传入的值为：" + a + ",不能小于10");
        }
    }
}
