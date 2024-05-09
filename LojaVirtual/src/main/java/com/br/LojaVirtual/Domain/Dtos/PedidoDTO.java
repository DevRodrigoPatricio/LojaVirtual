package com.br.LojaVirtual.Domain.Dtos;

import com.br.LojaVirtual.Domain.Entities.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    @Schema(description = "", readOnly = true)
    private  int id;
    private List<Produto> produtos;
    private  String Status;
    private Pagamento pagamento;
    private String EnderecoEntrega;
}
