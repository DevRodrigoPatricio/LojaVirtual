package com.br.LojaVirtual.Domain.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "Pedido")
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Getter
    @Setter
    private List<Produto> produtos;

    @Getter
    @Setter
    private String status;


    @Getter
    @Setter
    private Pagamento pagamento;

    @Getter
    @Setter
    private String enderecoEntrega;
}
