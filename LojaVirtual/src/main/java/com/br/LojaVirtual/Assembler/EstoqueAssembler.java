package com.br.LojaVirtual.Assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.br.LojaVirtual.Domain.Dtos.EstoqueDTO;
import com.br.LojaVirtual.Domain.Entities.Estoque;

@Component
public class EstoqueAssembler {

    private ModelMapper modelMapper;

    public EstoqueDTO modeladorDto(Estoque estoque) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(estoque, EstoqueDTO.class);
    }

    public List<EstoqueDTO> paraDtoColecao(List<Estoque> estoques) {
        return estoques.stream().map(this::modeladorDto).collect(Collectors.toList());
    }
}
