package com.br.LojaVirtual.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.br.LojaVirtual.Assembler.EstoqueDiassembler;
import com.br.LojaVirtual.Domain.Dtos.EstoqueDTO;
import com.br.LojaVirtual.Domain.Entities.Estoque;
import com.br.LojaVirtual.Repository.EstoqueRepository;
import com.br.LojaVirtual.Services.execeptions.ObjectnotFoundException;

@Service
public class EstoqueService {

  @Autowired
  private EstoqueRepository repository;

  @Autowired
  private EstoqueDiassembler estoqueDisassembler;

  public List<Estoque> findAll() {
    return repository.findAll();
  }

  public Estoque findById(Integer id) {
    Optional<Estoque> obj = repository.findById(id);
    return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! ID: " + id));
  }

  public Estoque create(EstoqueDTO estoque) {
    return repository.save(estoqueDisassembler.modeladorEntidade(estoque));
  }

  public Estoque update(Integer id, EstoqueDTO estoqueDTO) {
    Estoque estoqueExistente = repository.findById(id)
        .orElseThrow(() -> new ObjectnotFoundException("Produto não encontrado com ID " + id));

    estoqueDisassembler.copiaParaModelo(estoqueDTO, estoqueExistente);

    return repository.save(estoqueExistente);
  }

  public void delete(Integer id) {
    repository.deleteById(id);
  }

}
