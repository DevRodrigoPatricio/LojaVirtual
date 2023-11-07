package com.br.LojaVirtual.Domain.Entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name =  "LocalDeArmazenamento")
public class LocalDeArmazenamento implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private String endereco;

    @Getter
    @Setter
    private Integer capacidadeMaxima;

    @OneToMany(mappedBy = "localArmazenamento")
    @Getter
    private List<Estoque> itensEstoque;

    
}
