package com.example.jwtauthentications.repository;

import com.example.jwtauthentications.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query(value = "select s from student s where gpa=:gpa",nativeQuery = true)
    Student getByGpa(@Param("gpa") int gpa);
}
