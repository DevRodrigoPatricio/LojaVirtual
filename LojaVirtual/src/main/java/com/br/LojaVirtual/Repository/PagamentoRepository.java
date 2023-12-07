package com.br.LojaVirtual.Repository;



import com.br.LojaVirtual.Domain.Entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}