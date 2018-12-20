package com.wangyn.test.lambda;

@FunctionalInterface
public interface FilterRule {
    public boolean filter(Apple apple);
}
