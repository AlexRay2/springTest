package com.example.demo.repository;

import com.example.demo.exceptions.StudentNotFoundException;
import com.example.demo.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class StudentDAO {
    private final JdbcTemplate jdbcTemplate;

    public Student findById(UUID id) {
        var student = jdbcTemplate.queryForObject("select * from students where id = ?", new RowMapper<Student>() {
                    @Override
                    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                        String id1 = rs.getString("id");
                        String name = rs.getString("name");
                        String age = rs.getString("age");
                        return new Student(
                                name,
                                UUID.fromString(id1),
                                Integer.parseInt(age)
                        );
                    }
                },
                id
        );
        return student;
    }

    public List<Student> findAll() {
        return jdbcTemplate.query("select * from students", new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String age = rs.getString("age");
                return new Student(
                        name,
                        UUID.fromString(id),
                        Integer.parseInt(age)
                );
            }
        });
    }

    public Student addStudent(Student student){
        var result = jdbcTemplate.update("INSERT INTO students (name, id, age) VALUES (?, ?, ?)", student.name(), student.id(), student.age());
        return findById(student.id());
    }

    public int deleteById(UUID uuid){
        var result = jdbcTemplate.update("delete from students where id = ?", uuid);
        if (result == 0) throw new StudentNotFoundException(uuid);
        return result;
    }


    public Student updateStudent(UUID uuid, Student student){
        var result = jdbcTemplate.update("UPDATE students SET name = ?, age = ?, id = ? WHERE id = ?", student.name(), student.age(), student.id(), uuid);
        return findById(uuid);
    }
}
