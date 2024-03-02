package com.br.LojaVirtual.Services;

import com.br.LojaVirtual.Assembler.CarrinhoDisassembler;
import com.br.LojaVirtual.Domain.Dtos.CarrinhoComprasDTO;
import com.br.LojaVirtual.Domain.Entities.CarrinhoCompras;
import com.br.LojaVirtual.Repository.CarrinhoComprasRepository;
import com.br.LojaVirtual.Services.execeptions.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoService {

  @Autowired
  private CarrinhoComprasRepository repository;

  @Autowired
  private CarrinhoDisassembler carrinhoDisassembler;

  public List<CarrinhoCompras> findAll() {
    return repository.findAll();
  }

  public CarrinhoCompras findById(Integer id) {
    Optional<CarrinhoCompras> obj = repository.findById(id);
    return obj.orElseThrow(() -> new ObjectnotFoundException("Carrinho não encontrado! ID: " + id));
  }

  public CarrinhoCompras create(CarrinhoComprasDTO carrinho) {
    return repository.save(carrinhoDisassembler.modeladorEntidade(carrinho));
  }

  public CarrinhoCompras update(Integer id, CarrinhoComprasDTO carrinhoDTO) {
    CarrinhoCompras carrinhoExistente = repository.findById(id)
        .orElseThrow(() -> new ObjectnotFoundException("Carrinho não encontrado com ID " + id));

    carrinhoDisassembler.copiaParaModelo(carrinhoDTO, carrinhoExistente);

    return repository.save(carrinhoExistente);
  }

  public void delete(Integer id) {
    repository.deleteById(id);
  }

}
