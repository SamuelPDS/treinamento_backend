package com.treinamento.crud.service;

import com.treinamento.crud.models.dto.AllData;
import com.treinamento.crud.models.dto.ClientPutDTO;
import com.treinamento.crud.models.dto.CustomerDto;
import com.treinamento.crud.models.table.Customer;
import com.treinamento.crud.models.table.Endereco;
import com.treinamento.crud.repository.CustomerRepository;
import com.treinamento.crud.repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Customer customer = new Customer(allData);
        customerRepository.save(customer);
    }
    
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public void deleteClient(String cpf) {
        customerRepository.deleteByCpf(cpf);
    }

    public Customer find(Long id) {
        return customerRepository.getReferenceById(id);
    }

    public List<Customer> findAll(String name){
//        System.out.println(customerRepository.findAllByNome(name));
        return customerRepository.findAllByNome(name);
    }

    public List<Customer> findAllByName(AllData allData) {
        return customerRepository.findAllByNome(allData.getName());
    }

    public void update(CustomerDto customerDto) {
        Customer customer = customerRepository.getReferenceById(customerDto.getId());
        customer.atualizar(customerDto);               
       Customer cpfCliente = customerRepository.findByCpf(customerDto.getCpf());
    }

    public void updateFrontend(String cpf, ClientPutDTO clientPutDTO){
        Customer customer = customerRepository.findByCpf(cpf);
        customer.atualizarFrontend(clientPutDTO);

        if(!customer.getEndereco().isEmpty()) {
            Endereco endereco = enderecoRepository.getReferenceById(customer.getEndereco().get(0).getId());
            endereco.update(clientPutDTO);
        }
    }
    

}

