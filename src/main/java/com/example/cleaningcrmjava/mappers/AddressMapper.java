package com.example.cleaningcrmjava.mappers;

import com.example.cleaningcrmjava.dto.responses.AddressResponse;
import com.example.cleaningcrmjava.entities.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressResponse toResponse(Address address) {
        return new AddressResponse(
                address.getId(),
                address.getLine(),
                address.getNotes(),
                address.getClient().getId()
        );
    }
}