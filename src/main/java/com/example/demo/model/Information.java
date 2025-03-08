package com.example.demo.model;

public class Information {
    private final String name;
    private final int age;

    public Information(String name, int age) {
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
