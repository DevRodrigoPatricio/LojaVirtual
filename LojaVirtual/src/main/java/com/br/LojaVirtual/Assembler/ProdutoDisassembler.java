package com.br.LojaVirtual.Assembler;

import java.util.stream.Collectors;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.LojaVirtual.Domain.Dtos.ProdutoDTO;
import com.br.LojaVirtual.Domain.Entities.Produto;

@Component
public class ProdutoDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Produto modeladorEntidade(ProdutoDTO produtoRequisicao) {
        return modelMapper.map(produtoRequisicao, Produto.class);
    }

    public List<Produto> paraEntidadeColecao(List<ProdutoDTO> produtosRequisicaoDTO) {
        return produtosRequisicaoDTO.stream().map(this::modeladorEntidade)
                .collect(Collectors.toList());
    }

    public void copiaParaModelo(ProdutoDTO produtoDTO, Produto produtoExistente) {
        BeanUtils.copyProperties(produtoDTO, produtoExistente, "id");
    }
}

