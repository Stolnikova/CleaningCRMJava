package com.example.cleaningcrmjava.dto.requests;

public record UpdateAddressRequest(
        String line,
        String notes
) {}