package com.br.LojaVirtual.Assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.LojaVirtual.Domain.Dtos.EstoqueDTO;
import com.br.LojaVirtual.Domain.Entities.Estoque;

@Component
public class EstoqueDiassembler {
      @Autowired
    private ModelMapper modelMapper;

    public Estoque modeladorEntidade(EstoqueDTO estoqueRequisicao) {
        return modelMapper.map(estoqueRequisicao, Estoque.class);
    }

    public List<Estoque> paraEntidadeColecao(List<EstoqueDTO> estoqueRquisicaoDtos) {
        return estoqueRquisicaoDtos.stream().map(this::modeladorEntidade)
                .collect(Collectors.toList());
    }

    public void copiaParaModelo(EstoqueDTO estoqueDTO, Estoque estoqueExistente) {
        BeanUtils.copyProperties(estoqueDTO, estoqueExistente, "id");
    }
}
