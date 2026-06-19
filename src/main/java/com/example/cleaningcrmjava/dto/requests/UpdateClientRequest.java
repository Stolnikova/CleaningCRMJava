package com.example.cleaningcrmjava.dto.requests;

import java.util.List;

public record UpdateClientRequest(
        String fullName,
        String phone,
        String email,
        String notes,
        List<Integer> companyIds
) {}