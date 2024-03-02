package com.br.LojaVirtual.Controller;

import com.br.LojaVirtual.Assembler.PagamentoAssembler;
import com.br.LojaVirtual.Domain.Dtos.ClienteDTO;
import com.br.LojaVirtual.Domain.Dtos.PagamentoDTO;
import com.br.LojaVirtual.Domain.Entities.Pagamento;
import com.br.LojaVirtual.Services.PagamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Pagamento")
public class PagamentoController {

  @Autowired
  private PagamentoService pagamentoService;

  @Autowired
  private PagamentoAssembler pagamentoAssembler;

  @GetMapping
  @Operation(summary = "Retorna Lista com todos os tipo de pagamentos.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Lista de  tipo de pagamentos retornada com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<List<PagamentoDTO>> listartipoPagamento() {
    return ResponseEntity.ok(pagamentoAssembler.paraDtoColecao(pagamentoService.findAll()));
  }

  @Operation(summary = "Retorna pagamento por id.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Pagamento retornado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  @GetMapping(value = "/{id}")
  public ResponseEntity<PagamentoDTO> listarPagamentoPorID(@PathVariable Integer id) {
    return ResponseEntity.ok(pagamentoAssembler.modeladorDto(pagamentoService.findById(id)));
  }

  @PostMapping
  @Operation(summary = "Criar Tipo de pagamento.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Tipo de pagamento criado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<PagamentoDTO> create(@Valid @RequestBody PagamentoDTO pagamento) {
    return ResponseEntity.ok(pagamentoAssembler.modeladorDto(pagamentoService.create(pagamento)));
  }

  @PutMapping(value = "/{id}")
  @Operation(summary = "Atualizar Tipo de pagamento.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Pagamento atualizado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<PagamentoDTO> update(@PathVariable Integer id, @Valid @RequestBody PagamentoDTO pagamentoDTO) {
    Pagamento pagamentoAtualizado = pagamentoService.update(id, pagamentoDTO);
    return ResponseEntity.ok().body(pagamentoAssembler.modeladorDto(pagamentoAtualizado));
  }

  @DeleteMapping(value = "/{id}")
  @Operation(summary = "Deletar Tipo de pagamento.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Pagamernto deletado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<ClienteDTO> deletarPagamento(@PathVariable Integer id) {
    pagamentoService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
