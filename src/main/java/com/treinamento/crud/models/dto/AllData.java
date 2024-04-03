package com.treinamento.crud.models.dto;

import com.treinamento.crud.models.table.Customer;
import com.treinamento.crud.models.table.Endereco;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AllData {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String nome;

    @NotBlank(message = "cpf is mandatory")
    private String cpf;

    @Email(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Born Data is mandatory")
    private String bornData;

    @NotBlank(message = "CEP is mandatory")
    private String cep;

    @NotBlank(message = "Street Name is mandatory")
    private String street;

    @NotNull(message = "Street Num is mandatory")
    @Min(1)
    private int streetNum;

    @NotBlank(message = "Neighborhood is mandatory")
    private String bairro;

    private String complemento;
    

        public AllData(Customer customer, Endereco endereco){
        this.nome = customer.getNome();
        this.cpf = customer.getCpf();
        this.email = customer.getEmail();
        this.bornData = customer.getDataNascimento();
        this.cep = endereco.getCep();
        this.street = endereco.getNomeRua();
        this.streetNum = endereco.getNumeroRua();
        this.bairro = endereco.getNomeBairro();
        this.complemento = endereco.getComplemento();
    }
}
