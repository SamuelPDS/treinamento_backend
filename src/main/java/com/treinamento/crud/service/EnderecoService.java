package com.treinamento.crud.service;

import org.springframework.stereotype.Service;

import com.treinamento.crud.models.dto.EnderecoDto;
import com.treinamento.crud.models.table.Customer;
import com.treinamento.crud.models.table.Endereco;
import com.treinamento.crud.repository.CustomerRepository;
import com.treinamento.crud.repository.EnderecoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnderecoService {
   final EnderecoRepository enderecoRepository;
   final CustomerRepository customerRepository;

    
    public void save(EnderecoDto enderecoDto) {
        Customer customer = customerRepository.getReferenceById(enderecoDto.getIdCliente());
        Endereco endereco = new Endereco(enderecoDto, customer);
        enderecoRepository.save(endereco);
        customer.getEndereco().add(endereco);
    }


    public void delete(Long id) {
        enderecoRepository.deleteById(id);
    }

    public Endereco find(Long id) {  
        return enderecoRepository.getReferenceById(id);
    }

    public void update(EnderecoDto enderecoDto) {
        Endereco endereco = enderecoRepository.getReferenceById(enderecoDto.getId());
        endereco.update(enderecoDto);
    }
}
