package com.example.Practice.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "registration_event_log")
public class RegistrationEventLog {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "date_of_creation", nullable = false)
    private Date dateOfCreation;

    @Column(name = "phone", nullable = false, length = 12)
    private String phone;

    @Column(name = "was_done", nullable = false)
    private boolean wasDone;
}
