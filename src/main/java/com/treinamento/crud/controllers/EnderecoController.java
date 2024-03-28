package com.treinamento.crud.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.crud.models.dto.EnderecoDto;
import com.treinamento.crud.models.table.Endereco;
import com.treinamento.crud.service.EnderecoService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("endereco")
public class EnderecoController {
    final EnderecoService enderecoService;

    @PostMapping
    public void criarEndereco(@RequestBody EnderecoDto enderecoDto){
        enderecoService.save(enderecoDto);
    }

    @DeleteMapping("{id}")
    public void excluirEndereco(@PathVariable Long id) {
        enderecoService.delete(id);
    }

    @GetMapping("{id}") 
    public EnderecoDto buscarEndereco(@PathVariable Long id) {
        Endereco endereco = enderecoService.find(id);
        return new EnderecoDto(endereco);
    }

    @PutMapping
    @Transactional
        public void atualizarEndereco(@RequestBody EnderecoDto enderecoDto) {
            enderecoService.update(enderecoDto);
        }


    }


