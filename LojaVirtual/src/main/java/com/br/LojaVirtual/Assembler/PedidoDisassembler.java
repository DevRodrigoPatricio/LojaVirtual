package com.br.LojaVirtual.Assembler;

import com.br.LojaVirtual.Domain.Dtos.PedidoDTO;
import com.br.LojaVirtual.Domain.Entities.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Pedido modeladorEntidade(PedidoDTO pedidoRequisicao) {
        return modelMapper.map(pedidoRequisicao, Pedido.class);
    }

    public List<Pedido> paraEntidadeColecao(List<PedidoDTO> pedidoRequisicaoDTO) {
        return pedidoRequisicaoDTO.stream().map(this::modeladorEntidade)
                .collect(Collectors.toList());
    }

    public void copiaParaModelo(PedidoDTO pedidoDTO, Pedido pedidoExistente) {
        BeanUtils.copyProperties(pedidoDTO, pedidoExistente, "id");
    }
}

