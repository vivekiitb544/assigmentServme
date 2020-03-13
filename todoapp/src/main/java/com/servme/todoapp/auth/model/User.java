package com.servme.todoapp.auth.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    //Todo: Need to define in proper format
    private String mobileNumber;

    //Todo: change it to boolean from String
    private String gender;

    //Todo: need to change in date format
    private String birthDay;

    @Transient
    private String passwordConfirm;

    @ManyToMany
    private Set<Role> roles;
}
