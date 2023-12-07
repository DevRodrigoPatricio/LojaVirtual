package com.br.LojaVirtual.Repository;



import com.br.LojaVirtual.Domain.Entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}