package com.treinamento.crud.models.dto;

import com.treinamento.crud.models.table.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ClientNameDTO {
    private String name;
    
    public ClientNameDTO(Customer customer) {
        this.name = customer.getNome();
    }

}
