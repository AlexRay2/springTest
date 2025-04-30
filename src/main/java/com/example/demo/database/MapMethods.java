package com.example.demo.database;

import com.example.demo.model.Student;

import java.util.List;
import java.util.UUID;

public interface MapMethods {
    Student get(UUID uuid);

    Student put(UUID key, Student student);

    Student remove(UUID uuid);

    Boolean containsKey(UUID key);

    List<Student> allStudents();
}
