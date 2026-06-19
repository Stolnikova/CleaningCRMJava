package com.example.cleaningcrmjava.mappers;

import com.example.cleaningcrmjava.dto.responses.ClientResponse;
import com.example.cleaningcrmjava.entities.Client;
import com.example.cleaningcrmjava.entities.Company;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ClientMapper {

    private final AddressMapper addressMapper;

    public ClientMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public ClientResponse toResponse(Client client) {
        List<Integer> companyIds = client.getCompanies()
                .stream()
                .map(Company::getId)
                .toList();

        return new ClientResponse(
                client.getId(),
                client.getFullName(),
                client.getPhone(),
                client.getEmail(),
                client.getNotes(),
                client.getCreatedAt(),
                companyIds,
                client.getAddresses().stream().map(addressMapper::toResponse).toList()
        );
    }
}