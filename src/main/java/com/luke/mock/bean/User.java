package com.luke.mock.bean;

/**
 * @author 廖水生
 * @date 2021/3/20 22:10
 */
public class User {
    private int age;
    private String name;

    public User() {
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
