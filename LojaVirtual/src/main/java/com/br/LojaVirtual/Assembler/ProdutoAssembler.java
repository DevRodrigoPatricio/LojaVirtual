package com.br.LojaVirtual.Assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

import com.br.LojaVirtual.Domain.Dtos.ProdutoDTO;
import com.br.LojaVirtual.Domain.Entities.Produto;

@Component
public class ProdutoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ProdutoDTO modeladorDto(Produto produto) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(produto, ProdutoDTO.class);
    }

    public List<ProdutoDTO> paraDtoColecao(List<Produto> produtos) {
        return produtos.stream().map(this::modeladorDto).collect(Collectors.toList());
    }
}
