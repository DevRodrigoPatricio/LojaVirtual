package com.br.LojaVirtual.Controller;

import com.br.LojaVirtual.Assembler.CarrinhoAssembler;
import com.br.LojaVirtual.Domain.Dtos.CarrinhoComprasDTO;
import com.br.LojaVirtual.Domain.Dtos.ProdutoDTO;
import com.br.LojaVirtual.Domain.Entities.CarrinhoCompras;
import com.br.LojaVirtual.Services.CarrinhoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Carrinho")
public class CarrinhoController {

  @Autowired
  private CarrinhoService carrinhoService;

  @Autowired
  private CarrinhoAssembler carrinhoAssembler;

  @GetMapping
  @Operation(summary = "Retorna Lista com todos os Carrinhos.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Lista de carrinhos retornada com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<List<CarrinhoComprasDTO>> listarCarrinhos() {
    return ResponseEntity.ok(carrinhoAssembler.paraDtoColecao(carrinhoService.findAll()));
  }

  @Operation(summary = "Retorna carrinho por id.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Carrinho retornado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  @GetMapping(value = "/{id}")
  public ResponseEntity<CarrinhoComprasDTO> listarCarrinhoPorID(@PathVariable Integer id) {
    return ResponseEntity.ok(carrinhoAssembler.modeladorDto(carrinhoService.findById(id)));
  }

  @PostMapping
  @Operation(summary = "Criar Carrinho.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Carrinnho criado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<CarrinhoComprasDTO> create(@Valid @RequestBody CarrinhoComprasDTO carrinho) {
    return ResponseEntity.ok(carrinhoAssembler.modeladorDto(carrinhoService.create(carrinho)));
  }

  @PutMapping(value = "/{id}")
  @Operation(summary = "Atualizar carrinho.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Carrinho atualizado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<CarrinhoComprasDTO> update(@PathVariable Integer id, @Valid @RequestBody CarrinhoComprasDTO carrinho) {
    CarrinhoCompras carrinhoAtualizado = carrinhoService.update(id, carrinho);
    return ResponseEntity.ok().body(carrinhoAssembler.modeladorDto(carrinhoAtualizado));
  }

  @DeleteMapping(value = "/{id}")
  @Operation(summary = "Deletar Carrinho.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Carrinho deletado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<ProdutoDTO> deletarCarrinho(@PathVariable Integer id) {
    carrinhoService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
