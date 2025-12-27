package com.example.demo.model;

import java.util.UUID;

public record Student(
        String name,
        UUID id,
        Integer age) {
}