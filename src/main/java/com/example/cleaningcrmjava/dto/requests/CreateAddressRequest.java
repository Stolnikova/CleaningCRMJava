package com.example.cleaningcrmjava.dto.requests;

public record CreateAddressRequest(
        String line,
        String notes
) {}