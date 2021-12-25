package com.example.jwtauthentications.services;

import com.example.jwtauthentications.model.Student;

import java.util.List;

public interface StudentServices {

    Student createStudent(Student student);
    Student getStudentById(int id);
    List<Student> getAllStudent();
    void deleteStudent(int id);



}
