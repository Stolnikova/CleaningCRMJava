package com.example.cleaningcrmjava.controllers;

import com.example.cleaningcrmjava.dto.requests.CreateAddressRequest;
import com.example.cleaningcrmjava.dto.requests.UpdateAddressRequest;
import com.example.cleaningcrmjava.dto.responses.AddressResponse;
import com.example.cleaningcrmjava.services.interfaces.IAddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AddressController {

    private final IAddressService addressService;

    public AddressController(IAddressService addressService) {
        this.addressService = addressService;
    }

    // адреси конкретного клієнта
    @GetMapping("/api/v1/clients/{clientId}/addresses")
    public ResponseEntity<List<AddressResponse>> getByClientId(@PathVariable int clientId) {
        return ResponseEntity.ok(addressService.getByClientId(clientId));
    }

    // створення адреси для клієнта
    @PostMapping("/api/v1/clients/{clientId}/addresses")
    public ResponseEntity<AddressResponse> create(
            @PathVariable int clientId,
            @RequestBody CreateAddressRequest request) {
        return ResponseEntity.ok(addressService.create(clientId, request));
    }

    // окрема адреса за id
    @GetMapping("/api/v1/addresses/{id}")
    public ResponseEntity<AddressResponse> getById(@PathVariable int id) {
        return ResponseEntity.ok(addressService.getById(id));
    }

    @PutMapping("/api/v1/addresses/{id}")
    public ResponseEntity<AddressResponse> update(
            @PathVariable int id,
            @RequestBody UpdateAddressRequest request) {
        return ResponseEntity.ok(addressService.update(id, request));
    }

    @DeleteMapping("/api/v1/addresses/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        addressService.delete(id);
        return ResponseEntity.noContent().build();
    }
}