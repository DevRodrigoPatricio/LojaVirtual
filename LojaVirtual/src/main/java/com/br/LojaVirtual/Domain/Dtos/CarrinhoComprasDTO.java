package com.br.LojaVirtual.Domain.Dtos;

import com.br.LojaVirtual.Domain.Entities.LocalDeArmazenamento;
import com.br.LojaVirtual.Domain.Entities.Produto;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarrinhoComprasDTO {
    
    private int id;
    private List<Produto> Itens;
    private BigDecimal total;
}
