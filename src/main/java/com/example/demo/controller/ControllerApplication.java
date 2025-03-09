package com.example.demo.controller;

import com.example.demo.database.Data;
import com.example.demo.model.Information;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/info")
public class ControllerApplication {

    @GetMapping(value = "/user")
    public ResponseEntity<Information> getInfo() {
        Data data = new Data();
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        UUID id3 = UUID.randomUUID();
        data.hashMap.put(id1, Information.builder().name("Alex").age(12).build());
        data.hashMap.put(id2, Information.builder().name("Elya").age(12).build());
        data.hashMap.put(id3, Information.builder().name("Slava").age(12).build());
        return ResponseEntity.ok().body(data.finder(id2));
    }
}