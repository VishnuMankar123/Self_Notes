package com.example.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "email_tracking")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email_id", nullable = false, length = 255)
    private String emailId;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "user", nullable = false)
    private String user;


}