package com.example.cleaningcrmjava.dto.responses;

public record AddressResponse(
        int id,
        String line,
        String notes,
        int clientId
) {}

