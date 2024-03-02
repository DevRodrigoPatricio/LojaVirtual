package com.br.LojaVirtual.Assembler;

import com.br.LojaVirtual.Domain.Dtos.PagamentoDTO;
import com.br.LojaVirtual.Domain.Entities.Pagamento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PagamentoDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Pagamento modeladorEntidade(PagamentoDTO pagamentoRequisicao) {
        return modelMapper.map(pagamentoRequisicao, Pagamento.class);
    }

    public List<Pagamento> paraEntidadeColecao(List<PagamentoDTO> pagamentoRequisicaoDTO) {
        return pagamentoRequisicaoDTO.stream().map(this::modeladorEntidade)
                .collect(Collectors.toList());
    }

    public void copiaParaModelo(PagamentoDTO pagamentoDTO, Pagamento pagamentoExistente) {
        BeanUtils.copyProperties(pagamentoDTO, pagamentoExistente, "id");
    }
}

