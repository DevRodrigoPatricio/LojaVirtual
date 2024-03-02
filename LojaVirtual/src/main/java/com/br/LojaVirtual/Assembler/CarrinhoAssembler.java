package com.br.LojaVirtual.Assembler;

import com.br.LojaVirtual.Domain.Dtos.CarrinhoComprasDTO;
import com.br.LojaVirtual.Domain.Entities.CarrinhoCompras;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarrinhoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public CarrinhoComprasDTO modeladorDto(CarrinhoCompras carrinho) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(carrinho, CarrinhoComprasDTO.class);
    }

    public List<CarrinhoComprasDTO> paraDtoColecao(List<CarrinhoCompras> carrinhoCompras) {
        return carrinhoCompras.stream().map(this::modeladorDto).collect(Collectors.toList());
    }
}
