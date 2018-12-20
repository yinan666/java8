package com.wangyn.test.map_newmethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/12/12
 * @time: 下午3:47
 * Copyright (C) 2018 mine
 * All rights reserved
 */
public class TestMapMerge {
    List<Student> studentList = new ArrayList<>();

    {
        studentList.add(new Student(1,"a",10,20,10));
        studentList.add(new Student(2,"b",10,10,10));
        studentList.add(new Student(3,"c",10,20,10));
        studentList.add(new Student(1,"a",10,5,10));
        studentList.add(new Student(2,"b",10,20,10));
        studentList.add(new Student(4,"d",10,20,10));
        studentList.add(new Student(3,"c",10,20,10));
    }

    public static void main(String[] args){
        TestMapMerge test = new TestMapMerge();
//        test.testMerge();
//        test.testMerge2();
        test.testMerge3();
    }

    /**
     * 使用传统的方式，完成所有id相同的学生 成绩和money相加的功能
     * 再对比下面的testMerge，会发现新的Java8方式简单了很多
     */
    public void normal(){
        Map<Integer,Student> studentMap = new HashMap<>();
        for (Student newStu : studentList){
            Student student = studentMap.get(newStu.getId());
            if (student!=null){
                student.setScore(student.getScore()+newStu.getScore());
                student.setMoney(student.getMoney()+newStu.getMoney());
            }else {
                studentMap.put(newStu.getId(),newStu);
            }
        }
        System.out.println(studentMap);
    }


    /**
     * 测试map#merge方法，所有id相同的学生 成绩和money相加
     * map#merge方法，有3个参数
     * merge(K key, V value，BiFunction<? super V, ? super V, ? extends V> remappingFunction)
     * 第一个是key， 第二个参数是新放入的key, 第三个参数是一个函数式接口，用于返回操作的值，比如下面例子中
     * 相同id的对象，年龄、moeny相加。
     * 这就相当于判断map中当前是否有id为某个值的student，如果有，就对年龄和moeny相加，如果没有，就设置新的值。
     * 会发现，比传统normal的方式简单了很多！！！
     */
    public  void testMerge(){
        Map<Integer,Student> studentMap = new HashMap<>();
        studentList.stream().forEach( student -> studentMap.merge(student.getId(),student,(s1,s2)-> {
            s1.setScore(s1.getScore()+s2.getScore());
            s1.setMoney(s1.getMoney()+s2.getMoney());
            return s1;
        }));
        System.out.println(studentMap);
    }

    /**
     * 测试map#merge方法，所有id相同的学生 的成绩
     */
    public void testMerge2(){
        Map<Integer,Integer> studentMap = new HashMap<>();
        studentList.stream().forEach( student -> studentMap.merge(student.getId(),student.getScore(),(s1,s2)-> s1 + s2));
        System.out.println(studentMap);
    }

    /**
     * 测试map#merge方法，所有id+name相同的学生 的成绩
     */
    public void testMerge3(){
        Map<String,Integer> studentMap = new HashMap<>();
        studentList.stream().forEach( student -> studentMap.merge(student.getId()+student.getName(),student.getScore(),(s1,s2)-> s1 + s2));
        System.out.println(studentMap);
    }

    class Student{
        private int id;
        private String name;
        private int age;
        private int score;
        private int money;

        public Student(int id, String name, int age, int score, int money) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.score = score;
            this.money = money;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", score=" + score +
                    ", money=" + money +
                    '}';
        }
    }
}
