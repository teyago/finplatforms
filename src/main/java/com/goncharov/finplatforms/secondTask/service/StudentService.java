package com.goncharov.finplatforms.secondTask.service;

import com.goncharov.finplatforms.secondTask.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    void addStudent(Student student);

    void deleteStudent(long id);

    List<Student> findAll();
}