package com.br.LojaVirtual.Domain.Dtos;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {
    @Schema(description = "", readOnly = true)
    private Integer id;
    private String nome;
    private Integer codigoProduto;
    private BigDecimal valorUnitario;
    private Integer quantidade;

}
