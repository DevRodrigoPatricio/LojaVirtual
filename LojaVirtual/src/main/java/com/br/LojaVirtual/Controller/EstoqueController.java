package com.br.LojaVirtual.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.LojaVirtual.Assembler.EstoqueAssembler;
import com.br.LojaVirtual.Domain.Dtos.EstoqueDTO;
import com.br.LojaVirtual.Domain.Entities.Estoque;
import com.br.LojaVirtual.Services.EstoqueService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("Estoque")
public class EstoqueController {

  @Autowired
  private EstoqueService estoqueService;

  @Autowired
  private EstoqueAssembler estoqueAssembler;

  @GetMapping
  @Operation(summary = "Retorna Lista com todos os Estoque.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Lista de estoques retornada com sucesso"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<List<EstoqueDTO>> listarEstoques() {
    return ResponseEntity.ok(estoqueAssembler.paraDtoColecao(estoqueService.findAll()));
  }

  @Operation(summary = "Retorna estoque por id.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Estoque retornado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  @GetMapping(value = "/{id}")
  public ResponseEntity<EstoqueDTO> listarEstoqueID(@PathVariable Integer id) {
    return ResponseEntity.ok(estoqueAssembler.modeladorDto(estoqueService.findById(id)));
  }

  @PostMapping
  @Operation(summary = "Criar Estoque.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Estoque criado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<EstoqueDTO> create(@Valid @RequestBody EstoqueDTO estoque) {
    return ResponseEntity.ok(estoqueAssembler.modeladorDto(estoqueService.create(estoque)));
  }

  @PutMapping(value = "/{id}")
  @Operation(summary = "Atualizar Estoque.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Estoque atualizado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })

  public ResponseEntity<EstoqueDTO> update(@PathVariable Integer id, @Valid @RequestBody EstoqueDTO estoque) {
    Estoque estoqueAtualizado = estoqueService.update(id, estoque);
    return ResponseEntity.ok().body(estoqueAssembler.modeladorDto(estoqueAtualizado));
  }

  @DeleteMapping(value = "/{id}")
  @Operation(summary = "Deletar Estoque.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Estoque deletado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<EstoqueDTO> deletarEstoque(@PathVariable Integer id) {
    estoqueService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
