package com.treinamento.crud.models.dto;

import com.treinamento.crud.models.table.Endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnderecoDto {
    private Long id;
    private String nomeRua;
    private int numero;
    private String nomeBairro;
    private Long idCliente;
    
    public EnderecoDto(Endereco endereco) {
        this.nomeRua = endereco.getNomeRua();
        this.numero = endereco.getNumero();
        this.nomeBairro = endereco.getNomeBairro();
    }
}
