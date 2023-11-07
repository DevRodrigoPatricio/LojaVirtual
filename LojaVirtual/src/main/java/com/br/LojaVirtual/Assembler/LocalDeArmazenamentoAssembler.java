package com.br.LojaVirtual.Assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.br.LojaVirtual.Domain.Dtos.LocalDeArmazenamentoDTO;
import com.br.LojaVirtual.Domain.Entities.LocalDeArmazenamento;

@Component
public class LocalDeArmazenamentoAssembler {

    private ModelMapper modelMapper;

    public LocalDeArmazenamentoDTO modeladorDto(LocalDeArmazenamento local) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(local, LocalDeArmazenamentoDTO.class);
    }

    public List<LocalDeArmazenamentoDTO> paraDtoColecao(List<LocalDeArmazenamento> locais) {
        return locais.stream().map(this::modeladorDto).collect(Collectors.toList());
    }
}
