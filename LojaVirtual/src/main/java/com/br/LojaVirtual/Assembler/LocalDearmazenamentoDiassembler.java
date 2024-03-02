package com.br.LojaVirtual.Assembler;

import java.util.stream.Collectors;
import java.util.List;

import com.br.LojaVirtual.Domain.Dtos.LocalDeArmazenamentoDTO;
import com.br.LojaVirtual.Domain.Entities.LocalDeArmazenamento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LocalDearmazenamentoDiassembler {

    private final ModelMapper modelMapper;

    @Autowired
    public LocalDearmazenamentoDiassembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public LocalDeArmazenamento modeladorEntidade(LocalDeArmazenamentoDTO LocalRequisicao) {
        return modelMapper.map(LocalRequisicao, LocalDeArmazenamento.class);
    }

    public List<LocalDeArmazenamento> paraEntidadeColecao(List<LocalDeArmazenamentoDTO> localRequisicaoDTO) {
        return localRequisicaoDTO.stream().map(this::modeladorEntidade)
                .collect(Collectors.toList());
    }

    public void copiaParaModelo(LocalDeArmazenamentoDTO localDTO, LocalDeArmazenamento localExistente) {
        BeanUtils.copyProperties(localDTO, localExistente, "id");
    }
}

