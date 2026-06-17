package com.example.cleaningcrmjava.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String fullName = "";

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private boolean isActive = true;

    @ManyToMany(mappedBy = "employees")
    private List<Order> orders = new ArrayList<>();
}