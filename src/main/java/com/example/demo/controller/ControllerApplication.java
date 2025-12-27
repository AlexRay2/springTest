package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.exceptions.StudentNotFoundException;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/info")
@RequiredArgsConstructor
public class ControllerApplication {

    private final StudentService studentService;


    @GetMapping("/user/db/{id}")
    public ResponseEntity<Student> getInfoFromDb(@PathVariable String id) {
        try {
            return ResponseEntity.ok(studentService.findById(UUID.fromString(id)));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (StudentNotFoundException e) {
            return ResponseEntity.status(422).body(null);
        }
    }


    @GetMapping("/users")
    public ResponseEntity<List<Student>> getAllFromDb() {
        return ResponseEntity.ok(studentService.findAll());
    }


    @PutMapping("/user/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable UUID id, @RequestBody Student student) {
        try {
            return ResponseEntity.ok(studentService.updateStudent(id, student));
        } catch (StudentNotFoundException e) {
            return ResponseEntity.status(422).build();
        }
    }
    
    @PostMapping("/user/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.addStudent(student));
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<Integer> deleteUser(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(studentService.deleteById(id));
        } catch (StudentNotFoundException e) {
            return ResponseEntity.status(422).build();
        }
    }
}
