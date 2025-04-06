package com.example.demo.database;

import com.example.demo.model.Student;

import java.util.*;

public class Data {
    public Student alex = new Student("Alex", "0e759ecc-2535-4ad2-986f-5c8d208d6462", 12);
    public Student slava = new Student("Alex", "17fab18f-9b17-4582-a8bb-b59c53d5f352", 12);
    public Student elya = new Student("Alex", "89826fd9-e00e-434c-9970-a99437e37671", 12);
    public Map<UUID, Student> hashMap = Map.of(UUID.fromString(elya.id()), elya, UUID.fromString(alex.id()), alex, UUID.fromString(slava.id()), slava);

    public Student finder(UUID id) {
        return hashMap.get(id);
    }

    public List<Student> allStudents() {
        return new ArrayList(hashMap.values());
    }
}