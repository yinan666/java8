package com.wangyn.test.lambda.test;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/6/12
 * @time: 下午9:03
 * Copyright (C) 2018 mine
 * All rights reserved
 */
public interface FunctionTR<T, R> {
    public R converTo(T t);
}
