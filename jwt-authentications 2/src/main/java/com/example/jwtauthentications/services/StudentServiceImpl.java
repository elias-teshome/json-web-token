package com.example.jwtauthentications.services;

import com.example.jwtauthentications.model.Student;
import com.example.jwtauthentications.repository.StudentRepository;
import com.example.jwtauthentications.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentServices{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(int id) {
      studentRepository.deleteById(id);
    }
}
