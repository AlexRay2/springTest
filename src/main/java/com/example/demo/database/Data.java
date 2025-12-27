package com.example.demo.database;

import com.example.demo.model.Student;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class Data implements MapMethods {

    private final Map<UUID, Student> hashMap = new HashMap<>();

    public Data() {
        Student alex = new Student("Alex", UUID.fromString("0e759ecc-2535-4ad2-986f-5c8d208d6462"), 12);
        Student slava = new Student("Slava", UUID.fromString("17fab18f-9b17-4582-a8bb-b59c53d5f352"), 13);
        Student elya = new Student("Elya", UUID.fromString("89826fd9-e00e-434c-9970-a99437e37671"), 14);

        hashMap.put(alex.id(), alex);
        hashMap.put(slava.id(), slava);
        hashMap.put(elya.id(), elya);
    }

    public List<Student> allStudents() {
        return new ArrayList<>(hashMap.values());
    }

    public Student get(UUID uuid) {
        return hashMap.get(uuid);
    }

    public Student put(UUID key, Student student) {
        return hashMap.put(key, student);
    }

    public Student remove(UUID uuid) {
        return hashMap.remove(uuid);
    }

    public Boolean containsKey(UUID key) {
        return hashMap.containsKey(key);
    }
}
