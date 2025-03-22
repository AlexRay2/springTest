package com.example.demo.database;

import com.example.demo.model.Information;

import java.util.*;

public class Data {
    public Information alex = Information.builder().name("Alex").age(12).id(UUID.fromString("0e759ecc-2535-4ad2-986f-5c8d208d6462")).build();
    public Information slava = Information.builder().name("Slava").age(15).id(UUID.fromString("17fab18f-9b17-4582-a8bb-b59c53d5f352")).build();
    public Information elya = Information.builder().name("Elya").age(12).id(UUID.fromString("89826fd9-e00e-434c-9970-a99437e37671")).build();
    public Map<UUID, Information> hashMap = (Map<UUID, Information>) Map.of(elya.getId(), elya, alex.getId() , alex , slava.getId(), slava);

    public Information finder(UUID id) {
        return hashMap.get(id);
    }

    public List<Information> allStudents() {
        return new ArrayList(hashMap.values());
    }
}