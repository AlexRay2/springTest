package com.example.demo.service;

import com.example.demo.database.MapMethods;
import com.example.demo.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final MapMethods data;

    public Student getInfo(String id) {
        UUID search = UUID.fromString(id);
        if (!data.containsKey(search)) {
            throw new StudentNotFoundException();
        }

        return data.get(search);
    }

    public List<Student> getAll() {
        return data.allStudents();
    }

    public Student updateStudent(UUID id, Student student) {
        if (!data.containsKey(id)) {
            throw new StudentNotFoundException();
        }
        return data.put(id, student);
    }

    public Student addStudent(Student student) {
        UUID id = UUID.randomUUID();
        Student newStudent = new Student(student.name(), id.toString(), student.age());
        return data.put(id, newStudent);
    }

    public Student deleteUser(UUID id) {
        Student student = data.remove(id);
        if (student == null) {
            throw new StudentNotFoundException();
        }
        return student;
    }
}
