package com.example.cleaningcrmjava.services.interfaces;

import com.example.cleaningcrmjava.dto.requests.ClientSearchRequest;
import com.example.cleaningcrmjava.dto.requests.CreateClientRequest;
import com.example.cleaningcrmjava.dto.requests.UpdateClientRequest;
import com.example.cleaningcrmjava.dto.responses.ClientResponse;
import java.util.List;

public interface IClientService {
    List<ClientResponse> getAll();
    List<ClientResponse> getByCompanyId(int companyId);
    ClientResponse getById(int id);
    ClientResponse create(CreateClientRequest request);
    ClientResponse update(int id, UpdateClientRequest request);
    void delete(int id);
    List<ClientResponse> search(ClientSearchRequest request);
}