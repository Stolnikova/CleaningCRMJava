package com.example.cleaningcrmjava.entities;

import com.example.cleaningcrmjava.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String login = "";

    @Column(nullable = false)
    private String passwordHash = "";

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;
}