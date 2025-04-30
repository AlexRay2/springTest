package com.example.demo.controller;

import com.example.demo.database.MapMethods;
import com.example.demo.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/info")
public class ControllerApplication {

    private final MapMethods data;

    public ControllerApplication(MapMethods data) {
        this.data = data;
    }

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

    @PutMapping("/user/{id}")
    public Student updateStudent(@PathVariable UUID id, @RequestBody Student student) {
        if (!data.containsKey(id)) {
              throw new RuntimeException();
        }
        return data.put(id, student);
    }

    @PostMapping("/user")
    public Student addStudent(@RequestBody Student student) {
        UUID id = UUID.randomUUID();
        Student newStudent = new Student(student.name(), id.toString(), student.age());
        return data.put(id, newStudent);
    }

    @DeleteMapping("/user/{id}")
    public Student deleteUser(@PathVariable UUID id) {
        return data.remove(id);
    }

}
