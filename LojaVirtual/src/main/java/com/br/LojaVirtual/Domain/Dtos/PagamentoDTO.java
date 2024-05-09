package com.br.LojaVirtual.Domain.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDTO {

    @Schema(description = "", readOnly = true)
    private int id;
    private String nomePagamento;
}
