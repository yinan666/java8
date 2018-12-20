package com.wangyn.test.map_newmethods;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/12/13
 * @time: 下午3:22
 * Copyright (C) 2018 mine
 * All rights reserved
 */
public class Test22 {
    long a = 2222222L;
}

/***
 *      ┌─┐       ┌─┐
 *   ┌──┘ ┴───────┘ ┴──┐
 *   │                 │
 *   │       ───       │
 *   │  ─┬┘       └┬─  │
 *   │                 │
 *   │       ─┴─       │
 *   │                 │
 *   └───┐         ┌───┘
 *       │         │
 *       │         │
 *       │         │
 *       │         └──────────────┐
 *       │                        │
 *       │                        ├─┐
 *       │                        ┌─┘
 *       │                        │
 *       └─┐  ┐  ┌───────┬──┐  ┌──┘
 *         │ ─┤ ─┤       │ ─┤ ─┤
 *         └──┴──┘       └──┴──┘
 *                神兽保佑
 *               代码无BUG!
 */

class lianxi1 {
    {
        int i = 1, j = 2;
        float f1 = 0.1f;
        float f2 = 123;
        long l1 = 123456;
        long l2 = 888888888L;
        j = j + 10;
        i = (int) (i * 0.1);
        char c1 = 'a';
        float f3 = f1 + f2;
        float f4 = f1 + (float) (f2 * 0.1);
    }
}