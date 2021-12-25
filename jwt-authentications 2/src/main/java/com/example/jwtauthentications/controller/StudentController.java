package com.example.jwtauthentications.controller;


import com.example.jwtauthentications.model.Student;
import com.example.jwtauthentications.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class StudentController  {

    @Autowired
    private StudentServices studentServices;

    @PostMapping("/add")
    public Student createStudent(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentServices.createStudent(student))
                .getBody();
    }
    @GetMapping("/{id}")
    public Student getStudnetByid(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentServices.getStudentById(id))
                .getBody();
    }
    @GetMapping("/all")
    public List<Student> getAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentServices.getAllStudent())
                .getBody();
    }
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        studentServices.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("deleted id number "+ id)
                .getBody();
    }

}
