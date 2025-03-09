package com.example.demo.model;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
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
