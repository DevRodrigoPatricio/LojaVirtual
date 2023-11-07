package com.br.LojaVirtual.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.LojaVirtual.Domain.Entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}