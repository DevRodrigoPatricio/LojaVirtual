package com.br.LojaVirtual.Assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.br.LojaVirtual.Domain.Dtos.LocalDeArmazenamentoDTO;
import com.br.LojaVirtual.Domain.Entities.LocalDeArmazenamento;

@Component
public class LocalDearmazenamentoDiassembler {
    @Autowired
    private ModelMapper modelMapper;

    public LocalDeArmazenamento modeladorEntidade(LocalDeArmazenamentoDTO localRequisicao) {
        return modelMapper.map(localRequisicao, LocalDeArmazenamento.class);
    }

    public List<LocalDeArmazenamento> paraEntidadeColecao(List<LocalDeArmazenamentoDTO> localRequisicaoDtos) {
        return localRequisicaoDtos.stream().map(this::modeladorEntidade)
                .collect(Collectors.toList());
    }

    public void copiaParaModelo(LocalDeArmazenamentoDTO localDTO, LocalDeArmazenamento localExistente) {
        BeanUtils.copyProperties(localDTO, localExistente, "id");
    }
}
