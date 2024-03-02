package com.br.LojaVirtual.Controller;

import com.br.LojaVirtual.Assembler.PedidoAssembler;
import com.br.LojaVirtual.Domain.Dtos.PedidoDTO;
import com.br.LojaVirtual.Domain.Entities.Pedido;
import com.br.LojaVirtual.Services.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Pedido")
public class PedidoController {

  @Autowired
  private PedidoService pedidoService;

  @Autowired
  private PedidoAssembler pedidoAssembler;

  @GetMapping
  @Operation(summary = "Retorna Lista com todos os pedidos.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Lista de pedidos retornada com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<List<PedidoDTO>> listarPedidos() {
    return ResponseEntity.ok(pedidoAssembler.paraDtoColecao(pedidoService.findAll()));
  }

  @Operation(summary = "Retorna pedido por id.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Pedido retornado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  @GetMapping(value = "/{id}")
  public ResponseEntity<PedidoDTO> listarPedidoPorID(@PathVariable Integer id) {
    return ResponseEntity.ok(pedidoAssembler.modeladorDto(pedidoService.findById(id)));
  }

  @PostMapping
  @Operation(summary = "Criar Pedido.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Pedido criado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<PedidoDTO> create(@Valid @RequestBody PedidoDTO pedido) {
    return ResponseEntity.ok(pedidoAssembler.modeladorDto(pedidoService.create(pedido)));
  }

  @PutMapping(value = "/{id}")
  @Operation(summary = "Atualizar pedido.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Pedido atualizado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<PedidoDTO> update(@PathVariable Integer id, @Valid @RequestBody PedidoDTO pedidoDTO) {
    Pedido pedidoAtualizado = pedidoService.update(id, pedidoDTO);
    return ResponseEntity.ok().body(pedidoAssembler.modeladorDto(pedidoAtualizado));
  }

  @DeleteMapping(value = "/{id}")
  @Operation(summary = "Deletar pedido.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Pedido deletado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<PedidoDTO> deletarPedido(@PathVariable Integer id) {
    pedidoService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
