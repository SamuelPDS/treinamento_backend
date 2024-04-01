package com.treinamento.crud.service;


import org.springframework.stereotype.Service;

import com.treinamento.crud.models.dto.AllData;
import com.treinamento.crud.models.dto.CustomerDto;
import com.treinamento.crud.models.table.Customer;
import com.treinamento.crud.models.table.Endereco;
import com.treinamento.crud.repository.CustomerRepository;
import com.treinamento.crud.repository.EnderecoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final EnderecoRepository enderecoRepository;

    public void save(CustomerDto dto){
        Customer customer = new Customer(dto);
        customerRepository.save(customer);
    }

    public void saveAll(AllData allData) {
        Endereco endereco = new Endereco(allData);
        Customer customer = new Customer(allData, endereco);
        customerRepository.save(customer);

    }
    
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer find(Long id) {
        return customerRepository.getReferenceById(id);
    }

    public void update(CustomerDto customerDto) {
        Customer customer = customerRepository.getReferenceById(customerDto.getId());
        customer.atualizar(customerDto);               
    
       Customer cpfCliente = customerRepository.findByCpf(customerDto.getCpf());
        System.out.println(cpfCliente.getCpf());
    }
    

}

