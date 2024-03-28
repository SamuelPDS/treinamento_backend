package com.treinamento.crud.models.table;

import com.treinamento.crud.models.dto.EnderecoDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "endereco")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64)
    private String nomeRua;

    @Column(length = 6)
    private int numero;
    
    @Column(length = 64) 
    private String nomeBairro;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Customer customer;


    public Endereco(EnderecoDto enderecoDto) {
        this.nomeRua = enderecoDto.getNomeRua();
        this.numero = enderecoDto.getNumero();
        this.nomeBairro = enderecoDto.getNomeBairro();
    }

    public Endereco(EnderecoDto enderecoDto, Customer customer) {
        this.nomeRua = enderecoDto.getNomeRua();
        this.numero = enderecoDto.getNumero();
        this.nomeBairro = enderecoDto.getNomeBairro();
        this.customer = customer;
    }


    public void update(EnderecoDto enderecoDto) {
        if(enderecoDto.getNomeRua() != null)
        this.nomeRua = enderecoDto.getNomeRua();
        
        if(enderecoDto.getNumero() >= 0)
        this.numero = enderecoDto.getNumero();
        
        if(enderecoDto.getNomeBairro() != null)
        this.nomeBairro = enderecoDto.getNomeBairro();
    }
}
