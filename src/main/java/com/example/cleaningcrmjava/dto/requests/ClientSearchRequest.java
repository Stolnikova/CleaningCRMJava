package com.example.cleaningcrmjava.dto.requests;

public record ClientSearchRequest(
        String fullName,
        String phone,
        String email,
        String companyName,
        String address
) {}