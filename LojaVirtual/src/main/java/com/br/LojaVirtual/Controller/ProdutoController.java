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
import com.br.LojaVirtual.Assembler.ProdutoAssembler;
import com.br.LojaVirtual.Domain.Dtos.ProdutoDTO;
import com.br.LojaVirtual.Domain.Entities.Produto;
import com.br.LojaVirtual.Services.ProdutoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("Produtos")
public class ProdutoController {

  @Autowired
  private ProdutoService produtoService;

  @Autowired
  private ProdutoAssembler produtoAssembler;

  @GetMapping
  @Operation(summary = "Retorna Lista com todos os Produtos.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Lista de produtos retornada com sucesso"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
    return ResponseEntity.ok(produtoAssembler.paraDtoColecao(produtoService.findAll()));
  }

  @Operation(summary = "Retorna produto por id.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Produto retornado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  @GetMapping(value = "/{id}")
  public ResponseEntity<ProdutoDTO> listarProdutoID(@PathVariable Integer id) {
    return ResponseEntity.ok(produtoAssembler.modeladorDto(produtoService.findById(id)));
  }

  @PostMapping
  @Operation(summary = "Criar Produto.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Produto criado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<ProdutoDTO> create(@Valid @RequestBody ProdutoDTO produto) {
    return ResponseEntity.ok(produtoAssembler.modeladorDto(produtoService.create(produto)));
  }

  @PutMapping(value = "/{id}")
  @Operation(summary = "Atualizar Produto.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<ProdutoDTO> update(@PathVariable Integer id, @Valid @RequestBody ProdutoDTO produto) {
    Produto produtoAtualizado = produtoService.update(id, produto);
    return ResponseEntity.ok().body(produtoAssembler.modeladorDto(produtoAtualizado));
  }

  @DeleteMapping(value = "/{id}")
  @Operation(summary = "Deletar Produto.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Produto deletado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<ProdutoDTO> deletarProduto(@PathVariable Integer id) {
    produtoService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
