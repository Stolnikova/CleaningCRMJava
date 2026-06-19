package com.example.cleaningcrmjava.service.impl;

import com.example.cleaningcrmjava.dto.requests.CreateAddressRequest;
import com.example.cleaningcrmjava.dto.requests.UpdateAddressRequest;
import com.example.cleaningcrmjava.dto.responses.AddressResponse;
import com.example.cleaningcrmjava.entities.Address;
import com.example.cleaningcrmjava.entities.Client;
import com.example.cleaningcrmjava.mappers.AddressMapper;
import com.example.cleaningcrmjava.repositories.AddressRepository;
import com.example.cleaningcrmjava.repositories.ClientRepository;
import com.example.cleaningcrmjava.services.interfaces.IAddressService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {

    private final AddressRepository addressRepository;
    private final ClientRepository clientRepository;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressRepository addressRepository,
                              ClientRepository clientRepository,
                              AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.clientRepository = clientRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public List<AddressResponse> getByClientId(int clientId) {
        return addressRepository.findByClientId(clientId)
                .stream()
                .map(addressMapper::toResponse)
                .toList();
    }

    @Override
    public AddressResponse getById(int id) {
        Address address = findAddressOrThrow(id);
        return addressMapper.toResponse(address);
    }

    @Override
    public AddressResponse create(int clientId, CreateAddressRequest request) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + clientId));

        Address address = new Address();
        address.setLine(request.line());
        address.setNotes(request.notes());
        address.setClient(client);

        Address saved = addressRepository.save(address);
        return addressMapper.toResponse(saved);
    }

    @Override
    public AddressResponse update(int id, UpdateAddressRequest request) {
        Address address = findAddressOrThrow(id);
        address.setLine(request.line());
        address.setNotes(request.notes());

        Address saved = addressRepository.save(address);
        return addressMapper.toResponse(saved);
    }

    @Override
    public void delete(int id) {
        Address address = findAddressOrThrow(id);
        addressRepository.delete(address);
    }

    private Address findAddressOrThrow(int id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address not found with id: " + id));
    }
}