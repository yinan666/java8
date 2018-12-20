package com.wangyn.test.stream;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/6/14
 * @time: 上午11:57
 * Copyright (C) 2018 mine
 * All rights reserved
 */
public class Dish {
    private String name;
    private int calories;
    private DishType dishType;

    public Dish(String name, int calories, DishType dishType) {
        this.name = name;
        this.calories = calories;
        this.dishType = dishType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public DishType getDishType() {
        return dishType;
    }

    public void setDishType(DishType dishType) {
        this.dishType = dishType;
    }
}
