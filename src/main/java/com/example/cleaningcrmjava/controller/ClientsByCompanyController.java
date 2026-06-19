package com.example.cleaningcrmjava.controller;

import com.example.cleaningcrmjava.dto.responses.ClientResponse;
import com.example.cleaningcrmjava.services.interfaces.IClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/companies/{companyId}/clients")
public class ClientsByCompanyController {

    private final IClientService clientService;

    public ClientsByCompanyController(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> getByCompanyId(@PathVariable int companyId) {
        return ResponseEntity.ok(clientService.getByCompanyId(companyId));
    }
}