package com.treinamento.crud.models.dto;


import com.treinamento.crud.models.table.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CustomerDto {
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public CustomerDto(Customer customer){
        this.cpf = customer.getCpf();
        this.nome = customer.getNome();
        this.email = customer.getEmail();
        this.telefone = customer.getTelefone();
    }
}
