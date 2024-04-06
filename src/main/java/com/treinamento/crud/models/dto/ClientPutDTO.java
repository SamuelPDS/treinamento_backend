package com.treinamento.crud.models.dto;

import com.treinamento.crud.models.table.Customer;
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
public class ClientPutDTO {

    private String nome;

    private String cpf;

    private String email;

    private String bornData;

    private String cep;

    private String street;

    private int streetNum;

    private String bairro;

    private String complemento;

    public void ClientPutDTO(Customer customer) {
        this.nome = customer.getNome();
        this.email = customer.getEmail();
        this.bornData = customer.getDataNascimento();
        if(!customer.getEndereco().isEmpty()) {
            this.cep = customer.getEndereco().get(0).getCep();
            this.street = customer.getEndereco().get(0).getNomeRua();
            this.streetNum = customer.getEndereco().get(0).getNumero();
            this.bairro = customer.getEndereco().get(0).getNomeBairro();
            this.complemento = customer.getEndereco().get(0).getComplemento();
        }
    }
}
