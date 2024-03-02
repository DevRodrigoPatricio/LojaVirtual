package com.br.LojaVirtual.Controller;

import com.br.LojaVirtual.Assembler.ClienteAssembler;
import com.br.LojaVirtual.Domain.Dtos.ClienteDTO;
import com.br.LojaVirtual.Domain.Entities.Cliente;
import com.br.LojaVirtual.Services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Cliente")
public class ClienteController {

  @Autowired
  private ClienteService clienteService;

  @Autowired
  private ClienteAssembler clienteAssembler;

  @GetMapping
  @Operation(summary = "Retorna Lista com todos os clientes.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Lista de clientes retornada com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<List<ClienteDTO>> listarClientes() {
    return ResponseEntity.ok(clienteAssembler.paraDtoColecao(clienteService.findAll()));
  }

  @Operation(summary = "Retorna cliente por id.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Cliente retornado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  @GetMapping(value = "/{id}")
  public ResponseEntity<ClienteDTO> listarClientePorID(@PathVariable Integer id) {
    return ResponseEntity.ok(clienteAssembler.modeladorDto(clienteService.findById(id)));
  }

  @PostMapping
  @Operation(summary = "Criar Cliente.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Cliente criado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO cliente) {
    return ResponseEntity.ok(clienteAssembler.modeladorDto(clienteService.create(cliente)));
  }

  @PutMapping(value = "/{id}")
  @Operation(summary = "Atualizar cliente.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<ClienteDTO> update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO cliente) {
    Cliente clienteAtualizado = clienteService.update(id, cliente);
    return ResponseEntity.ok().body(clienteAssembler.modeladorDto(clienteAtualizado));
  }

  @DeleteMapping(value = "/{id}")
  @Operation(summary = "Deletar cliente.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Cliente deletado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<ClienteDTO> deletarCliente(@PathVariable Integer id) {
    clienteService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
