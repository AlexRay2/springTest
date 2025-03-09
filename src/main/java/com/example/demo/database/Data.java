package com.example.demo.database;

import com.example.demo.model.Information;

import java.util.HashMap;
import java.util.UUID;

public class Data {
    public HashMap<UUID, Information> hashMap = new HashMap<>();
    public Information finder(UUID id){
        return hashMap.get(id);
    }
}