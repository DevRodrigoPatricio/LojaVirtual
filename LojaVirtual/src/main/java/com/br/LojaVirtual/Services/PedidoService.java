package com.br.LojaVirtual.Services;

import com.br.LojaVirtual.Assembler.PedidoDisassembler;
import com.br.LojaVirtual.Domain.Dtos.PedidoDTO;
import com.br.LojaVirtual.Domain.Entities.Pedido;
import com.br.LojaVirtual.Repository.PedidoRepository;
import com.br.LojaVirtual.Services.execeptions.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

  @Autowired
  private PedidoRepository repository;

  @Autowired
  private PedidoDisassembler pedidoDisassembler;

  public List<Pedido> findAll() {
    return repository.findAll();
  }

  public Pedido findById(Integer id) {
    Optional<Pedido> obj = repository.findById(id);
    return obj.orElseThrow(() -> new ObjectnotFoundException("Pedido não encontrado! ID: " + id));
  }

  public Pedido create(PedidoDTO pedido) {
    return repository.save(pedidoDisassembler.modeladorEntidade(pedido));
  }

  public Pedido update(Integer id, PedidoDTO pedidoDTO) {
    Pedido pedidoExistente = repository.findById(id)
        .orElseThrow(() -> new ObjectnotFoundException("Pedido não encontrado com ID " + id));

    pedidoDisassembler.copiaParaModelo(pedidoDTO,pedidoExistente);

    return repository.save(pedidoExistente);
  }

  public void delete(Integer id) {
    repository.deleteById(id);
  }

}
