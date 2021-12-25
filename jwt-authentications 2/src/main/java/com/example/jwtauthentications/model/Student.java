package com.example.jwtauthentications.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    @JsonProperty("gpa")
    private int GPA;
    private Long departemenId;

}
