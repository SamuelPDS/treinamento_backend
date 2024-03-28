package com.treinamento.crud.controllers;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.crud.models.dto.CustomerDto;
import com.treinamento.crud.service.CustomerService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public void cadastrarCliente(@RequestBody CustomerDto customerDto){
        customerService.save(customerDto);
    }

    @DeleteMapping("{id}") 
        public void deletarCliente(@PathVariable Long id) {
            customerService.delete(id);
    }

    @GetMapping("{id}")
    public CustomerDto buscarCliente(@PathVariable Long id){
      var customer = customerService.find(id);
      return new CustomerDto(customer);
    }

    @PutMapping
    @Transactional
    public void atualizarCliente(@RequestBody CustomerDto customerDto) {
       customerService.update(customerDto);
       
    } 
}
