package com.br.LojaVirtual.Assembler;

import com.br.LojaVirtual.Domain.Dtos.CarrinhoComprasDTO;
import com.br.LojaVirtual.Domain.Dtos.ClienteDTO;
import com.br.LojaVirtual.Domain.Entities.CarrinhoCompras;
import com.br.LojaVirtual.Domain.Entities.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ClienteDTO modeladorDto(Cliente cliente) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    public List<ClienteDTO> paraDtoColecao(List<Cliente> cliente) {
        return cliente.stream().map(this::modeladorDto).collect(Collectors.toList());
    }
}
