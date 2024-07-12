package com.example.Practice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "outbox")
public class Outbox {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "date_of_creation", nullable = false)
    private Date dateOfCreation;
}
