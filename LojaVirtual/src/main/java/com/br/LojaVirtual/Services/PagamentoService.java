package com.br.LojaVirtual.Services;

import com.br.LojaVirtual.Assembler.PagamentoDisassembler;
import com.br.LojaVirtual.Domain.Dtos.PagamentoDTO;
import com.br.LojaVirtual.Domain.Entities.Pagamento;
import com.br.LojaVirtual.Repository.PagamentoRepository;
import com.br.LojaVirtual.Services.execeptions.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

  @Autowired
  private PagamentoRepository repository;

  @Autowired
  private PagamentoDisassembler pagamentoDisassembler;

  public List<Pagamento> findAll() {
    return repository.findAll();
  }

  public Pagamento findById(Integer id) {
    Optional<Pagamento> obj = repository.findById(id);
    return obj.orElseThrow(() -> new ObjectnotFoundException("Pagamento não encontrado! ID: " + id));
  }

  public Pagamento create(PagamentoDTO pagamento) {
    return repository.save(pagamentoDisassembler.modeladorEntidade(pagamento));
  }

  public Pagamento update(Integer id, PagamentoDTO pagamentoDTO) {
    Pagamento pagamentoExistente = repository.findById(id)
        .orElseThrow(() -> new ObjectnotFoundException("Pagamento não encontrado com ID " + id));

    pagamentoDisassembler.copiaParaModelo(pagamentoDTO,pagamentoExistente);

    return repository.save(pagamentoExistente);
  }

  public void delete(Integer id) {
    repository.deleteById(id);
  }

}
