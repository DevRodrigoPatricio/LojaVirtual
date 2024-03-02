package com.br.LojaVirtual.Assembler;

import com.br.LojaVirtual.Domain.Dtos.ClienteDTO;
import com.br.LojaVirtual.Domain.Entities.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Cliente modeladorEntidade(ClienteDTO clienteRequisicao) {
        return modelMapper.map(clienteRequisicao, Cliente.class);
    }

    public List<Cliente> paraEntidadeColecao(List<ClienteDTO> clienteRequisicaoDTO) {
        return clienteRequisicaoDTO.stream().map(this::modeladorEntidade)
                .collect(Collectors.toList());
    }

    public void copiaParaModelo(ClienteDTO clienteDTO, Cliente clienteExistente) {
        BeanUtils.copyProperties(clienteDTO, clienteExistente, "id");
    }
}

