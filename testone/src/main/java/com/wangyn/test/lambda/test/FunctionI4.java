package com.wangyn.test.lambda.test;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/6/12
 * @time: 下午9:04
 * Copyright (C) 2018 Meituan
 * All rights reserved
 */
public interface FunctionI4<T, U, R> {
    public U build(T t, R r);
}
