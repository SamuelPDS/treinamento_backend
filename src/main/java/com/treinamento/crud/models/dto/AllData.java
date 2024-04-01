package com.treinamento.crud.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AllData {
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String bornData;
    private String cep;
    private String street;
    private int streetNum;
    private String bairro;
    private String complemento;
    
}
