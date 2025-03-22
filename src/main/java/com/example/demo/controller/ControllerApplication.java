package com.example.demo.controller;

import com.example.demo.database.Data;
import com.example.demo.model.Information;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/info")
public class ControllerApplication {

    Data data = new Data();

    @GetMapping("/user/{id}")
    public ResponseEntity<Information> getInfo(@PathVariable String id) {
        UUID search;
        try {
            search = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Information.builder().age(null).name(null).id(null).build());
        }

        if (!data.hashMap.containsKey(search)) {
            return ResponseEntity.status(422).body(Information.builder().age(null).name(null).id(null).build());
        }

        return ResponseEntity.ok().body(data.hashMap.get(search));
    }

    @GetMapping("/users")
    public ResponseEntity<List<Information>> getAll() {
        return ResponseEntity.ok().body(data.allStudents());
    }
}
