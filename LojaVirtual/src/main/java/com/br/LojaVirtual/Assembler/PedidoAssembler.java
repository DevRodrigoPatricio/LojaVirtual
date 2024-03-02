package com.br.LojaVirtual.Assembler;

import com.br.LojaVirtual.Domain.Dtos.PedidoDTO;
import com.br.LojaVirtual.Domain.Entities.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public PedidoDTO modeladorDto(Pedido pedido) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(pedido, PedidoDTO.class);
    }

    public List<PedidoDTO> paraDtoColecao(List<Pedido> pedidos) {
        return pedidos.stream().map(this::modeladorDto).collect(Collectors.toList());
    }
}
