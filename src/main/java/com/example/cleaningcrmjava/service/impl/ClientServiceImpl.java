package com.example.cleaningcrmjava.service.impl;

import com.example.cleaningcrmjava.dto.requests.ClientSearchRequest;
import com.example.cleaningcrmjava.dto.requests.CreateClientRequest;
import com.example.cleaningcrmjava.dto.requests.UpdateClientRequest;
import com.example.cleaningcrmjava.dto.responses.ClientResponse;
import com.example.cleaningcrmjava.entities.Client;
import com.example.cleaningcrmjava.entities.Company;
import com.example.cleaningcrmjava.mappers.ClientMapper;
import com.example.cleaningcrmjava.repositories.ClientRepository;
import com.example.cleaningcrmjava.repositories.CompanyRepository;
import com.example.cleaningcrmjava.services.interfaces.IClientService;
import com.example.cleaningcrmjava.specifications.ClientSpecification;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {

    private final ClientRepository clientRepository;
    private final CompanyRepository companyRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository,
                             CompanyRepository companyRepository,
                             ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.companyRepository = companyRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public List<ClientResponse> getAll() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toResponse)
                .toList();
    }

    @Override
    public List<ClientResponse> getByCompanyId(int companyId) {
        return clientRepository.findByCompaniesId(companyId)
                .stream()
                .map(clientMapper::toResponse)
                .toList();
    }

    @Override
    public ClientResponse getById(int id) {
        Client client = findClientOrThrow(id);
        return clientMapper.toResponse(client);
    }

    @Override
    public ClientResponse create(CreateClientRequest request) {
        Client client = new Client();
        client.setFullName(request.fullName());
        client.setPhone(request.phone());
        client.setEmail(request.email());
        client.setNotes(request.notes());

        if (request.companyIds() != null) {
            List<Company> companies = companyRepository.findAllById(request.companyIds());
            client.setCompanies(companies);
        }

        Client saved = clientRepository.save(client);
        return clientMapper.toResponse(saved);
    }

    @Override
    public ClientResponse update(int id, UpdateClientRequest request) {
        Client client = findClientOrThrow(id);

        client.setFullName(request.fullName());
        client.setPhone(request.phone());
        client.setEmail(request.email());
        client.setNotes(request.notes());

        if (request.companyIds() != null) {
            List<Company> companies = companyRepository.findAllById(request.companyIds());
            client.setCompanies(companies);
        }

        Client saved = clientRepository.save(client);
        return clientMapper.toResponse(saved);
    }

    @Override
    public void delete(int id) {
        Client client = findClientOrThrow(id);
        clientRepository.delete(client);
    }

    @Override
    public List<ClientResponse> search(ClientSearchRequest request) {
        Specification<Client> spec = Specification
                .where(ClientSpecification.hasFullName(request.fullName()))
                .and(ClientSpecification.hasPhone(request.phone()))
                .and(ClientSpecification.hasEmail(request.email()))
                .and(ClientSpecification.hasCompanyName(request.companyName()))
                .and(ClientSpecification.hasAddress(request.address()));

        return clientRepository.findAll(spec)
                .stream()
                .map(clientMapper::toResponse)
                .toList();
    }

    private Client findClientOrThrow(int id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + id));
    }
}