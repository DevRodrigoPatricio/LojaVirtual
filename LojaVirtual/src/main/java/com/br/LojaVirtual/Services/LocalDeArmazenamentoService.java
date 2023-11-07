package com.br.LojaVirtual.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.br.LojaVirtual.Assembler.LocalDearmazenamentoDiassembler;
import com.br.LojaVirtual.Domain.Dtos.LocalDeArmazenamentoDTO;
import com.br.LojaVirtual.Domain.Entities.LocalDeArmazenamento;
import com.br.LojaVirtual.Repository.LocalDeArmazenamentoRepository;
import com.br.LojaVirtual.Services.execeptions.ObjectnotFoundException;

@Service
public class LocalDeArmazenamentoService {

  @Autowired
  private LocalDeArmazenamentoRepository repository;

  @Autowired
  private LocalDearmazenamentoDiassembler localDeArmazenamentoDisassembler;

  public List<LocalDeArmazenamento> findAll() {
    return repository.findAll();
  }

  public LocalDeArmazenamento findById(Integer id) {
    Optional<LocalDeArmazenamento> obj = repository.findById(id);
    return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! ID: " + id));
  }

  public LocalDeArmazenamento create(LocalDeArmazenamentoDTO local) {
    return repository.save(localDeArmazenamentoDisassembler.modeladorEntidade(local));
  }

  public LocalDeArmazenamento update(Integer id, LocalDeArmazenamentoDTO localDTO) {
    LocalDeArmazenamento localExistente = repository.findById(id)
        .orElseThrow(() -> new ObjectnotFoundException("Produto não encontrado com ID " + id));

    localDeArmazenamentoDisassembler.copiaParaModelo(localDTO, localExistente);

    return repository.save(localExistente);
  }

  public void delete(Integer id) {
    repository.deleteById(id);
  }

}
