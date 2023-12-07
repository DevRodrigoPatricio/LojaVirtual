package com.br.LojaVirtual.Domain.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;

import java.io.Serializable;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name =  "Cliente")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int Id;

    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String senha;
    @Getter
    @Setter
    private String endereco;
    @Getter
    @Setter
    private String cpf;


}
