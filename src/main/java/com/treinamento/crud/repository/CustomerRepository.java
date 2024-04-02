package com.treinamento.crud.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.treinamento.crud.models.table.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Customer.List<Customer> findById(Long id);
    @Query
    Customer findByCpf(String cpf);

   
    List<Customer> findAllByNome(String nome);

}
