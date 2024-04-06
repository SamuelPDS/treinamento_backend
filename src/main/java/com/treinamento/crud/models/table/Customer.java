package com.treinamento.crud.models.table;


import java.util.ArrayList;
import java.util.List;

import com.treinamento.crud.models.dto.AllData;
import com.treinamento.crud.models.dto.ClientPutDTO;
import com.treinamento.crud.models.dto.CustomerDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="customers", uniqueConstraints = {@UniqueConstraint(columnNames = {"cpf"})})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 11, unique=true) //, unique=true
    private String cpf;

    @Column(length = 64)
    private String nome;

    @Column(length = 15)
    private String telefone;

    @Column(length = 24)
    private String email;

    @Column(length = 10)
    private String dataNascimento;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Endereco> endereco = new ArrayList<Endereco>();

    public Customer(CustomerDto dto){
        this.cpf = dto.getCpf();
        this.nome = dto.getNome();
        this.email = dto.getEmail();
        this.telefone = dto.getTelefone();
    }


    public Customer(AllData allData) {
        this.nome = allData.getName();
        this.cpf = allData.getCpf();
        this.email = allData.getEmail();
        this.dataNascimento = allData.getBornData(); 
        this.endereco.add(new Endereco(this, allData));
    }

    public void atualizarFrontend(ClientPutDTO clientPutDTO) {
        if(clientPutDTO.getNome() != ""){
            this.nome = clientPutDTO.getNome();
        }

        if(clientPutDTO.getEmail() != "") {
            this.email = clientPutDTO.getEmail();
        }

        if(clientPutDTO.getBornData() != "") {
            this.dataNascimento = clientPutDTO.getBornData();
        }

    }

    public void atualizar(CustomerDto customerDto) {
        if(customerDto.getNome() != null){
            this.nome = customerDto.getNome();
            System.out.println(this.nome);
        }
        
        if(customerDto.getCpf() != null) {
            this.cpf = customerDto.getCpf();
            System.out.println(this.cpf);
        }
    
        if(customerDto.getEmail() != null) {
            this.email = customerDto.getEmail();
            System.out.println(this.email);
        }

        if(customerDto.getTelefone() != null) {
            this.telefone = customerDto.getTelefone();
            System.out.println(this.telefone);
        }

    }
}
