package com.br.LojaVirtual.Domain.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name =  "CarrinhoCompras")

public class CarrinhoCompras implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Getter
    @Setter
    private List<Produto> Itens;

    @Getter
    @Setter
    private int quantidade;

    @Getter
    @Setter
    private BigDecimal total;

}
