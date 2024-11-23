package com.coursemanagement.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanagement.app.entity.Student;
import com.coursemanagement.app.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        student.generatePassword(); // Generate the password based on studentId and courseId
        return studentRepository.save(student);
    }
}