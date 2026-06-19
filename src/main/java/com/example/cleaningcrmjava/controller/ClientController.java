package com.example.cleaningcrmjava.controller;

import com.example.cleaningcrmjava.dto.requests.ClientSearchRequest;
import com.example.cleaningcrmjava.dto.requests.CreateClientRequest;
import com.example.cleaningcrmjava.dto.requests.UpdateClientRequest;
import com.example.cleaningcrmjava.dto.responses.ClientResponse;
import com.example.cleaningcrmjava.services.interfaces.IClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> getAll() {
        return ResponseEntity.ok(clientService.getAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<ClientResponse>> search(
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String companyName,
            @RequestParam(required = false) String address) {

        ClientSearchRequest request = new ClientSearchRequest(fullName, phone, email, companyName, address);
        return ResponseEntity.ok(clientService.search(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getById(@PathVariable int id) {
        return ResponseEntity.ok(clientService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ClientResponse> create(@RequestBody CreateClientRequest request) {
        return ResponseEntity.ok(clientService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponse> update(@PathVariable int id, @RequestBody UpdateClientRequest request) {
        return ResponseEntity.ok(clientService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}