package com.treinamento.crud.models.dto;


import com.treinamento.crud.models.table.Customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CustomerDto {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String nome;

    @NotBlank(message = "CPF is mandatory")
    private String cpf;

    private String telefone;
    @Email
    private String email;

    public CustomerDto(Customer customer){
        this.cpf = customer.getCpf();
        this.nome = customer.getNome();
        this.email = customer.getEmail();
        this.telefone = customer.getTelefone();
    }
}
