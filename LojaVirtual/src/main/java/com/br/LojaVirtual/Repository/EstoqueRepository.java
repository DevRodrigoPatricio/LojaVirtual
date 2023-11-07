package com.br.LojaVirtual.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.br.LojaVirtual.Domain.Entities.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {

}