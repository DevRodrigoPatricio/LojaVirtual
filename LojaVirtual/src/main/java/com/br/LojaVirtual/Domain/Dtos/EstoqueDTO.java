package com.br.LojaVirtual.Domain.Dtos;

import com.br.LojaVirtual.Domain.Entities.LocalDeArmazenamento;
import com.br.LojaVirtual.Domain.Entities.Produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueDTO {
    
    private Integer id;
    private Produto produto;
    private LocalDeArmazenamento localArmazenamento;
    private Integer quantidade;
}
