package com.br.LojaVirtual.Domain.Dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {
    private Integer id;
    private String nome;
    private Integer codigoProduto;
    private BigDecimal valorUnitario;

}
