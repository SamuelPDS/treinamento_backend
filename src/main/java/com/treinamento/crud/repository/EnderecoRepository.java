package com.treinamento.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamento.crud.models.table.Endereco;

public interface EnderecoRepository extends JpaRepository <Endereco, Long> {
    
}
