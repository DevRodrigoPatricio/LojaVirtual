package com.br.LojaVirtual.Repository;

import com.br.LojaVirtual.Domain.Entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}