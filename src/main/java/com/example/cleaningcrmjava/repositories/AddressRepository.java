package com.example.cleaningcrmjava.repositories;

import com.example.cleaningcrmjava.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByClientId(int clientId);
}