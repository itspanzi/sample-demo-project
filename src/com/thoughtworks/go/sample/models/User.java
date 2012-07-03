package com.thoughtworks.go.sample.models;

public class User {

    private final long id = -1;
    private String name;
    private int age;

    User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
