package com.br.LojaVirtual.Domain.Dtos;

import com.br.LojaVirtual.Domain.Entities.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueDTO {

    @Schema(description = "", readOnly = true)
    private Integer id;
    private Produto produto;
    private LocalDeArmazenamento localArmazenamento;
    private Integer quantidade;
}
