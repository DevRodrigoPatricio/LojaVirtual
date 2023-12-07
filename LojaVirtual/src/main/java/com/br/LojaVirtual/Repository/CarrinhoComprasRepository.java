package com.br.LojaVirtual.Repository;


import com.br.LojaVirtual.Domain.Entities.CarrinhoCompras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoComprasRepository extends JpaRepository<CarrinhoCompras, Integer> {

}