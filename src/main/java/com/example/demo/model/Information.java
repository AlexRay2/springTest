package com.example.demo.model;


import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class Information {
    private String name;
    private int age;
}
