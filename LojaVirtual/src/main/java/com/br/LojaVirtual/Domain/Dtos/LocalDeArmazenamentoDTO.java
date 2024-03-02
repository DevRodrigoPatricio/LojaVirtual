package com.br.LojaVirtual.Domain.Dtos;

import java.util.List;

import com.br.LojaVirtual.Domain.Entities.Estoque;

import com.br.LojaVirtual.Domain.Entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalDeArmazenamentoDTO {
    
    private Long id;
    private String nome;
    private String endereco;
    private Integer capacidadeMaxima;

}
