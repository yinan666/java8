package com.wangyn.test.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/6/5
 * @time: 下午8:10
 * Copyright (C) 2018 mine
 * All rights reserved
 */
public class TestTryResources {
    public static void main(String[] args) throws IOException {
        String path = "~/1.txt";
        String str = readFile(path);
    }

    public static String readFile(String path) throws IOException {
        // 使用了jdk7之后提供的 try with resources语句，不再需要catch finally
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        }
    }
}
