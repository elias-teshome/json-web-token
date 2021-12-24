package com.example.jwtauthentications.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_TBL")
public class User {

    @Id
    private int id;
    private String userName;
    private String password;
    private Long departementId;

}
