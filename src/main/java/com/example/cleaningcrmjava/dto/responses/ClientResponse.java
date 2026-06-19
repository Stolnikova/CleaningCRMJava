package com.example.cleaningcrmjava.dto.responses;

import java.time.LocalDateTime;
import java.util.List;

public record ClientResponse(
        int id,
        String fullName,
        String phone,
        String email,
        String notes,
        LocalDateTime createdAt,
        List<Integer> companyIds,
        List<AddressResponse> addresses
) {}