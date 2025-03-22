package com.example.demo.model;


import lombok.Builder;
import lombok.Getter;

import java.util.UUID;


@Getter
@Builder
public class Information {
    private String name;
    private UUID id;
    private Integer age;
}