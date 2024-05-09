package com.br.LojaVirtual.Domain.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalDeArmazenamentoDTO {

    @Schema(description = "", readOnly = true)
    private Long id;
    private String nome;
    private String endereco;
    private Integer capacidadeMaxima;

}
