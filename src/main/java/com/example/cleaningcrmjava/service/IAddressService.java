package com.example.cleaningcrmjava.services.interfaces;

import com.example.cleaningcrmjava.dto.requests.CreateAddressRequest;
import com.example.cleaningcrmjava.dto.requests.UpdateAddressRequest;
import com.example.cleaningcrmjava.dto.responses.AddressResponse;
import java.util.List;

public interface IAddressService {
    List<AddressResponse> getByClientId(int clientId);
    AddressResponse getById(int id);
    AddressResponse create(int clientId, CreateAddressRequest request);
    AddressResponse update(int id, UpdateAddressRequest request);
    void delete(int id);
}