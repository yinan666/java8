package com.wangyn.test.lambda;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/6/10
 * @time: 下午11:32
 * Copyright (C) 2018 Meituan
 * All rights reserved
 */
public class Apple {
    private String color;
    private int weight;
    private int id;

    public Apple(String color, int weight, int id) {
        this.color = color;
        this.weight = weight;
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
