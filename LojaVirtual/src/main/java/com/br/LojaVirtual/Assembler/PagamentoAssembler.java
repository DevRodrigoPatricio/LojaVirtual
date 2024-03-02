package com.br.LojaVirtual.Assembler;

import com.br.LojaVirtual.Domain.Dtos.PagamentoDTO;
import com.br.LojaVirtual.Domain.Entities.Pagamento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PagamentoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public PagamentoDTO modeladorDto(Pagamento pagamento) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(pagamento, PagamentoDTO.class);
    }

    public List<PagamentoDTO> paraDtoColecao(List<Pagamento> pagamento) {
        return pagamento.stream().map(this::modeladorDto).collect(Collectors.toList());
    }
}
