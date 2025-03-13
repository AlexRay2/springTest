package com.example.demo.controller;

import com.example.demo.database.Data;
import com.example.demo.model.Information;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/info")
public class ControllerApplication {
    Data data = new Data();
    @GetMapping(value = "/user")
    public ResponseEntity<Information> getInfo() {
        data.hashMap.put(data.id1, data.Alex);
        data.hashMap.put(data.id2, data.Elya);
        data.hashMap.put(data.id3, data.Slava);
        return ResponseEntity.ok().body(data.finder(data.id2));
    }
    @GetMapping(value = "/users")
    public ResponseEntity<List> getAll(){
        return ResponseEntity.ok().body(data.allStudents());
    }
}