package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentNotFoundException;
import com.example.demo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/info")
public class ControllerApplication {

    private final StudentService studentService;

    public ControllerApplication(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Student> getInfo(@PathVariable String id) {
        try {
            return ResponseEntity.ok(studentService.getInfo(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (StudentNotFoundException e) {
            return ResponseEntity.status(422).body(null);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable UUID id, @RequestBody Student student) {
        try {
            return ResponseEntity.ok(studentService.updateStudent(id, student));
        } catch (StudentNotFoundException e) {
            return ResponseEntity.status(422).build();
        }
    }

    @PostMapping("/user")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.addStudent(student));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Student> deleteUser(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(studentService.deleteUser(id));
        } catch (StudentNotFoundException e) {
            return ResponseEntity.status(422).build();
        }
    }
}
