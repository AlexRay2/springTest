package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class StudentService {
    public final StudentDAO studentDAO;

    public Student findById(UUID id) {
        return studentDAO.findById(id);
    }

    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    public Student addStudent(Student student) {
        return studentDAO.addStudent(student);
    }

    public int deleteById(UUID id) {
        return studentDAO.deleteById(id);
    }

    public Student updateStudent(UUID id, Student student) {
        return studentDAO.updateStudent(id, student);
    }

}
