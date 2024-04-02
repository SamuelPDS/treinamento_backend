package com.treinamento.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.treinamento.crud.models.dto.AllData;
import com.treinamento.crud.models.dto.CustomerDto;
import com.treinamento.crud.models.table.Customer;
import com.treinamento.crud.models.table.Endereco;
import com.treinamento.crud.repository.CustomerRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
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

    public List<Customer> findAll(CustomerDto customerDto){
        System.out.println(customerRepository.findAllByNome(customerDto.getNome()));
        return customerRepository.findAllByNome(customerDto.getNome());
    }

    public void update(CustomerDto customerDto) {
        Customer customer = customerRepository.getReferenceById(customerDto.getId());
        customer.atualizar(customerDto);               
    
       Customer cpfCliente = customerRepository.findByCpf(customerDto.getCpf());
    }
    

}

