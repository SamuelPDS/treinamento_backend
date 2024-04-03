package com.treinamento.crud.controllers;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.crud.models.dto.AllData;
import com.treinamento.crud.models.dto.ClientNameDTO;
import com.treinamento.crud.models.dto.CustomerDto;
import com.treinamento.crud.models.table.Customer;
import com.treinamento.crud.service.CustomerService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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

    
    @CrossOrigin("http://localhost:4200/")
    @PostMapping("/AllDataCustomer")
    public ResponseEntity<AllData> enviarTodosDados(@Valid @RequestBody AllData allData) {
        System.out.println(allData);
        customerService.saveAll(allData);
        return ResponseEntity.ok(allData);
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

    //@GetMapping()
  //  public ResponseEntity<List<CustomerDto>> buscarClientes(@RequestBody CustomerDto customerDto) {
     // List<Customer> customerList = customerService.findAll(customerDto); 
    //  System.out.println(ResponseEntity.ok(customerList.stream().map(CustomerDto:: new).toList()));
    //  return ResponseEntity.ok(customerList.stream().map(CustomerDto:: new).toList());
   // }

    @GetMapping("/AllDataCustomer/{name}")
    @CrossOrigin
    public ResponseEntity<List<AllData>> buscarClientPeloNome(@PathVariable String name) {
      List<Customer> list = customerService.findAll(name);
      return ResponseEntity.ok(list.stream().map(AllData:: new).toList());
    }

    @PutMapping
    @Transactional
    public void atualizarCliente(@RequestBody CustomerDto customerDto) {
       customerService.update(customerDto);
       
    } 
}
