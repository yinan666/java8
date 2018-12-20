package com.wangyn.test.defaultMethod;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/7/3
 * @time: 上午9:47
 * Copyright (C) 2018 Meituan
 * All rights reserved
 */
public interface TestInter {
    public int show(int a);

    default int test(int b) {
        return b + 2;
    }


}
