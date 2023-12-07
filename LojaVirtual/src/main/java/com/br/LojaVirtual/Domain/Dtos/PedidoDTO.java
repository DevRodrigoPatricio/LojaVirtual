package com.br.LojaVirtual.Domain.Dtos;

import com.br.LojaVirtual.Domain.Entities.Pagamento;
import com.br.LojaVirtual.Domain.Entities.Produto;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private  int id;
    private List<Produto> produtos;
    private  String Status;
    private Pagamento pagamento;
    private String EnderecoEntrega;
}
