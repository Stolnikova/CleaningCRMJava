package com.example.cleaningcrmjava.dto.requests;

import java.util.List;

public record CreateClientRequest(
        String fullName,
        String phone,
        String email,
        String notes,
        List<Integer> companyIds
) {}