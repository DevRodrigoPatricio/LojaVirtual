package com.br.LojaVirtual.Services;

import com.br.LojaVirtual.Assembler.ClienteDisassembler;
import com.br.LojaVirtual.Domain.Dtos.ClienteDTO;
import com.br.LojaVirtual.Domain.Entities.Cliente;
import com.br.LojaVirtual.Repository.ClienteRepository;
import com.br.LojaVirtual.Services.execeptions.DataIntegrityViolationException;
import com.br.LojaVirtual.Services.execeptions.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

  @Autowired
  private ClienteRepository repository;

  @Autowired
  private ClienteDisassembler clienteDisassembler;


  public List<Cliente> findAll() {
    return repository.findAll();
  }

  public Cliente findById(Integer id) {
    Optional<Cliente> obj = repository.findById(id);
    return obj.orElseThrow(() -> new ObjectnotFoundException("Cliente não encontrado! ID: " + id));
  }

  public Cliente create(ClienteDTO clienteDTO) {
    clienteDTO.setId(0);
    //clienteDTO.setSenha(encoder.encode(clienteDTO.getSenha()));
    validaPorCpfEEmail(clienteDTO);
    Cliente newCliente = clienteDisassembler.modeladorEntidade(clienteDTO);
    return repository.save(newCliente);
  }
  public Cliente update(Integer id, ClienteDTO clienteDTO) {
    Cliente clienteExistente = repository.findById(id)
        .orElseThrow(() -> new ObjectnotFoundException("Cliente não encontrado com ID " + id));

    clienteDisassembler.copiaParaModelo(clienteDTO,clienteExistente);

    return repository.save(clienteExistente);
  }

  public void delete(Integer id) {
    repository.deleteById(id);
  }

  private void validaPorCpfEEmail(ClienteDTO objDTO) {
    Optional<Cliente> obj = repository.findByCpf(objDTO.getCpf());
    if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
      throw new DataIntegrityViolationException("cpf já cadastrado no sistema!");
    }
    obj = repository.findByEmail(objDTO.getEmail());
    if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
      throw new DataIntegrityViolationException("Email já cadastrado no sistema!");
    }

  }

}
