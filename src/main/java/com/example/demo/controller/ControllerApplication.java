package com.example.demo.controller;

import com.example.demo.database.Data;
import com.example.demo.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/info")
public class ControllerApplication {

    Data data = new Data();

    @GetMapping("/user/{id}")
    public ResponseEntity<Student> getInfo(@PathVariable String id) {
        UUID search;
        try {
            search = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }

        if (!data.containsKey(UUID.fromString(id))) {
            return ResponseEntity.status(422).body(null);
        }

        return ResponseEntity.ok().body(data.get(search));
    }

    @GetMapping("/users")
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok().body(data.allStudents());
    }

    @PostMapping("/update/{id}")
    public Student updateStudent(@PathVariable UUID id, @RequestBody Student student) {
        return data.put(id, student);
    }

    @PutMapping("/put/{id}")
    public Student addStudent(@PathVariable UUID id, @RequestBody Student student) {
        return data.put(id, student);
    }

    @DeleteMapping("/delete/{id}")
    public Student deleteUser(@PathVariable UUID id) {
        return data.remove(id);
    }

}
