package com.example.Practice.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @Column(name = "date_of_creation")
    private Date dateOfCreation;

    @Column(name = "privilege_level")
    private String privilegeLevel;

    @Column(name = "locked")
    private Boolean locked;

}
