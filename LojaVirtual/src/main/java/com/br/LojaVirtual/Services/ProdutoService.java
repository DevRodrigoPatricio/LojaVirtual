package com.br.LojaVirtual.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.br.LojaVirtual.Assembler.ProdutoDisassembler;
import com.br.LojaVirtual.Domain.Dtos.ProdutoDTO;
import com.br.LojaVirtual.Domain.Entities.Produto;
import com.br.LojaVirtual.Repository.ProdutoRepository;
import com.br.LojaVirtual.Services.execeptions.ObjectnotFoundException;

@Service
public class ProdutoService {

  @Autowired
  private ProdutoRepository repository;

  @Autowired
  private ProdutoDisassembler produtoDisassembler;

  public List<Produto> findAll() {
    return repository.findAll();
  }

  public Produto findById(Integer id) {
    Optional<Produto> obj = repository.findById(id);
    return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! ID: " + id));
  }

  public Produto create(ProdutoDTO produto) {
    return repository.save(produtoDisassembler.modeladorEntidade(produto));
  }

  public Produto update(Integer id, ProdutoDTO produtoDTO) {
    Produto produtoExistente = repository.findById(id)
        .orElseThrow(() -> new ObjectnotFoundException("Produto não encontrado com ID " + id));

    produtoDisassembler.copiaParaModelo(produtoDTO, produtoExistente);

    return repository.save(produtoExistente);
  }

  public void delete(Integer id) {
    repository.deleteById(id);
  }

}
