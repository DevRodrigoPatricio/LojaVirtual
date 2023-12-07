package com.br.LojaVirtual.Domain.Dtos;

import com.br.LojaVirtual.Domain.Entities.Produto;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private int Id;
    private String nome;
    private String email;
    private String senha;
    private String endereco;
    private String cpf;
}
