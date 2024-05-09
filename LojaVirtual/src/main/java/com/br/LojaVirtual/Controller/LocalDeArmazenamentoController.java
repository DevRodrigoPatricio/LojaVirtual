package com.br.LojaVirtual.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.br.LojaVirtual.Assembler.LocalDeArmazenamentoAssembler;
import com.br.LojaVirtual.Domain.Dtos.LocalDeArmazenamentoDTO;
import com.br.LojaVirtual.Domain.Entities.LocalDeArmazenamento;
import com.br.LojaVirtual.Services.LocalDeArmazenamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("Local de Armazenamento")
public class LocalDeArmazenamentoController {

  @Autowired
  private LocalDeArmazenamentoService localService;

  @Autowired
  private LocalDeArmazenamentoAssembler localAssembler;

  @GetMapping
  @Operation(summary = "Retorna Lista com todos os Locais de Armazenamento.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Lista de locais retornada com sucesso"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<List<LocalDeArmazenamentoDTO>> listarLocais() {
    return ResponseEntity.ok(localAssembler.paraDtoColecao(localService.findAll()));
  }

  @Operation(summary = "Retorna local de armazenamento por id.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Local retornado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  @GetMapping(value = "/{id}")
  public ResponseEntity<LocalDeArmazenamentoDTO> listarLocalID(@PathVariable Integer id) {
    return ResponseEntity.ok(localAssembler.modeladorDto(localService.findById(id)));
  }

  @PostMapping
  @Operation(summary = "Criar Local de Armazenamento.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Local criado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<LocalDeArmazenamentoDTO> create(@Valid @RequestBody LocalDeArmazenamentoDTO local) {
    return ResponseEntity.ok(localAssembler.modeladorDto(localService.create(local)));
  }

  @PutMapping(value = "/{id}")
  @Operation(summary = "Atualizar Local.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Local atualizado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })

  public ResponseEntity<LocalDeArmazenamentoDTO> update(@PathVariable Integer id,
      @Valid @RequestBody LocalDeArmazenamentoDTO local) {
    LocalDeArmazenamento localAtualizado = localService.update(id, local);
    return ResponseEntity.ok().body(localAssembler.modeladorDto(localAtualizado));
  }

  @DeleteMapping(value = "/{id}")
  @Operation(summary = "Deletar Local de armazenamento.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Local deletado com sucesso!"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
  })
  public ResponseEntity<LocalDeArmazenamentoDTO> deletarEstoque(@PathVariable Integer id) {
    localService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
