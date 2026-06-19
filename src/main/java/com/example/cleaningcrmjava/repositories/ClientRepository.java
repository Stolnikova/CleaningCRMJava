package com.example.cleaningcrmjava.repositories;

import com.example.cleaningcrmjava.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>, JpaSpecificationExecutor<Client> {

    List<Client> findByCompaniesId(int companyId);
    List<Client> findByCompaniesIsEmpty();
}