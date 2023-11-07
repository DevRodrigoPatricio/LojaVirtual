package com.br.LojaVirtual.Domain.Entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name =  "Estoque")
public class Estoque implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    @OneToOne
    @JoinColumn(name = "idProduto", referencedColumnName = "id")
    @Getter
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "local_armazenamento_id")
    @Getter
    @Setter
    private LocalDeArmazenamento localArmazenamento;

    @Getter
    @Setter
    private Integer quantidade;

}
