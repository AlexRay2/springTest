package com.example.demo.database;

import com.example.demo.model.Information;
import org.apache.catalina.LifecycleState;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Data {
    public Information Alex = Information.builder().name("Alex").age(12).build();
    public Information Elya = Information.builder().name("Elya").age(12).build();
    public Information Slava = Information.builder().name("Slava").age(15).build();
    public UUID id1 = UUID.randomUUID();
    public UUID id2 = UUID.randomUUID();
    public UUID id3 = UUID.randomUUID();
    public HashMap<UUID, Information> hashMap = new HashMap<>();

    public Information finder(UUID id) {
        return hashMap.get(id);
    }

    public List<Information> allStudents() {
        return List.of(
                Alex,
                Elya,
                Slava
        );
    }
}